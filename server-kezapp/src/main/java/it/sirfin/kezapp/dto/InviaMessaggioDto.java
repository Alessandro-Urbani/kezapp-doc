package it.sirfin.kezapp.dto;

public class InviaMessaggioDto {
    private String messaggio;
    private String sessione;
    private String destinatario;

    public InviaMessaggioDto() {
    }

    public InviaMessaggioDto(String messaggio, String sessione, String destinatario) {
        this.messaggio = messaggio;
        this.sessione = sessione;
        this.destinatario = destinatario;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getSessione() {
        return sessione;
    }

    public void setSessione(String sessione) {
        this.sessione = sessione;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "InviaMessaggioDto{" + "messaggio=" + messaggio + ", sessione=" + sessione + ", destinatario=" + destinatario + '}';
    }
}
