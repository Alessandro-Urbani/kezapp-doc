package it.sirfin.kezapp.dto;

import it.sirfin.kezapp.model.Chat;
import it.sirfin.kezapp.model.Messaggio;
import java.util.ArrayList;
import java.util.List;

public class RegistrazioneDto {

    private List<Chat> contatti = new ArrayList<>();
    private List<Messaggio> messaggi = new ArrayList<>();
    private String sessione = "";

    public RegistrazioneDto() {
    }

    public RegistrazioneDto(List<Chat> contatti, List<Messaggio> messaggi, String sessione) {
        this.contatti = contatti;
        this.messaggi = messaggi;
        this.sessione = sessione;
    }

    public List<Chat> getContatti() {
        return contatti;
    }

    public void setContatti(List<Chat> contatti) {
        this.contatti = contatti;
    }

    public List<Messaggio> getMessaggi() {
        return messaggi;
    }

    public void setMessaggi(List<Messaggio> messaggi) {
        this.messaggi = messaggi;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    @Override
    public String toString() {
        return "RegistrazioneDto{" + "contatti=" + contatti + ", messaggi=" + messaggi + ", sessione=" + sessione + '}';
    }

}
