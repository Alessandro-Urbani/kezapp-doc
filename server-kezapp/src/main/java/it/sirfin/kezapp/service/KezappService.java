package it.sirfin.kezapp.service;

import it.sirfin.kezapp.dto.InviaMessaggioDto;
import it.sirfin.kezapp.dto.RegistrazioneDto;
import it.sirfin.kezapp.dto.RichiediMessaggiDto;
import it.sirfin.kezapp.dto.RichiediRegistrazioneDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface KezappService {

    RegistrazioneDto registrazione(String nickname);

    RegistrazioneDto inviaTutti(InviaMessaggioDto dto);

    RegistrazioneDto inviaUno(InviaMessaggioDto dto);

    RegistrazioneDto aggiorna(String sessione);

}
