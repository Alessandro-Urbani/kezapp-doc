package it.sirfin.kezapp.service.impl;

import it.sirfin.kezapp.dto.InviaMessaggioDto;
import it.sirfin.kezapp.dto.RegistrazioneDto;
import it.sirfin.kezapp.dto.RichiediMessaggiDto;
import it.sirfin.kezapp.model.Chat;
import it.sirfin.kezapp.model.Messaggio;
import it.sirfin.kezapp.repository.ChatRepository;
import it.sirfin.kezapp.repository.MessaggioRepository;
import it.sirfin.kezapp.service.KezappService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KezappServiceImpl implements KezappService {

    @Autowired
    ChatRepository chatRepository;
    @Autowired
    MessaggioRepository messaggioRepository;

    @Override
    public RegistrazioneDto registrazione(String nickname) {
        // cerca se il nickname è già stato usato
        List<Chat> ch = chatRepository.findByNickname(nickname);

        // in caso positivo ritorna una risposta vuota
        if (ch != null && !ch.isEmpty()) {
            return new RegistrazioneDto();
        }

        // in caso negativo, salva su chat il nuovo nickname
        Chat cx = new Chat(nickname, "");
        cx = chatRepository.save(cx);

        // genera la sessione
        cx.setSessione(cx.getId().toString());
        cx = chatRepository.save(cx);

        // crea il dto di risposta
        return aggiorna(nickname);
    }

    @Override
    public RegistrazioneDto inviaTutti(InviaMessaggioDto dto) {
        // verifica che la sessione esista
        String sx = dto.getSessione();
        Chat cx = chatRepository.findBySessione(sx);

        // se non esiste la sessione ritorna un dto vuoto
        if (cx == null) {
            return new RegistrazioneDto();
        }

        // salva su DB un messaggio che ha destinatario null
        Messaggio mess = new Messaggio(dto.getMessaggio(), null, cx.getNickname());
        messaggioRepository.save(mess);

        // crea il dto di risposta
        return aggiorna(sx);
    }

    @Override
    public RegistrazioneDto inviaUno(InviaMessaggioDto dto) {
        // verifica che la sessione esista
        String sx = dto.getSessione();
        Chat cx = chatRepository.findBySessione(sx);

        // se non esiste la sessione ritorna un dto vuoto
        if (cx == null) {
            return new RegistrazioneDto();
        }

        // sarebbe opportuno verificare che il destinatario sia esistente
        // FIXME:
        // salva su DB un messaggio che ha destinatario corretto
        Messaggio mess = new Messaggio(dto.getMessaggio(), dto.getDestinatario(), cx.getNickname());
        messaggioRepository.save(mess);

        // crea il dto di risposta
        return aggiorna(sx);
    }

    @Override
    public RegistrazioneDto aggiorna(String sessione) {
        // recupero il nickname 
        Chat cx = chatRepository.findBySessione(sessione);

        // ritorno la risposta
        RegistrazioneDto risp = new RegistrazioneDto(
                chatRepository.findAll(),
                recuperaMessaggi(cx.getNickname()),
                sessione);
        return risp;
    }

    private List<Messaggio> recuperaMessaggi(String nickname) {
        // recupera i messaggi pubblici (destinatario == null)
        List<Messaggio> pubblici = messaggioRepository.findByAliasDestinatarioIsNull();
        if (pubblici == null) {
            pubblici = new ArrayList<>();
        }

        // recupera i messaggi miei (destinatario == mio nickname)
        List<Messaggio> privati = messaggioRepository.findByAliasDestinatario(nickname);
        if (privati == null) {
            privati = new ArrayList<>();
        }

        // unisco i due risultati
        pubblici.addAll(privati);

        // ritorno il risultato
        return pubblici;
    }

}
