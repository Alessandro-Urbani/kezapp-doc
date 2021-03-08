import { RichiediMessaggiDto } from './richiedi-messaggi-dto';
import { InviaMessaggioDto } from './invia-messaggio-dto';
import { RegistrazioneDto } from './registrazione-dto';
import { RichiediRegistrazioneDto } from './richiedi-registrazione-dto';
import { Messaggio } from './messaggio';
import { Chat } from './chat';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  nicknameRegistrazione = "";
  messaggio = "";
  contatti: Chat[] = [];
  messaggi: Messaggio[] = [];

  // parametro sessione fornito dal server
  sessione = "";

  constructor(private http: HttpClient) { }

  registra() {
    // preparo dati
    let dto = new RichiediRegistrazioneDto();
    dto.nickname = this.nicknameRegistrazione;

    // chiamo servizio REST
    this.http.post<RegistrazioneDto>(
      "http://localhost:8080/registrazione",
      dto
    ).subscribe(
      r => {
        this.messaggi = r.messaggi;
        this.contatti = r.contatti;
        this.sessione = r.sessione;
      }
    );

  }

  inviaTutti() {
    // preparo dati
    let dto = new InviaMessaggioDto();
    dto.sessione = this.sessione;
    dto.messaggio = this.messaggio;
    dto.destinatario = null;

    // chiamo servizio REST
    this.http.post<RegistrazioneDto>(
      "http://localhost:8080/invia-tutti",
      dto
    ).subscribe(
      r => {
        this.messaggi = r.messaggi;
        this.contatti = r.contatti;
      }
    );
  }

  invia(c: Chat) {
    // preparo dati
    let dto = new InviaMessaggioDto();
    dto.sessione = this.sessione;
    dto.messaggio = this.messaggio;
    dto.destinatario = c.nickname;

    // chiamo servizio REST
    this.http.post<RegistrazioneDto>(
      "http://localhost:8080/invia-uno",
      dto
    ).subscribe(
      r => {
        this.messaggi = r.messaggi;
        this.contatti = r.contatti;
      }
    );
  }

  aggiorna() {
    let dto = new RichiediMessaggiDto();
    dto.sessione = this.sessione;

    // chiamo servizio REST
    this.http.post<RegistrazioneDto>(
      "http://localhost:8080/aggiorna",
      dto
    ).subscribe(
      r => {
        this.messaggi = r.messaggi;
        this.contatti = r.contatti;
      }
    );
  }
}
