import { Messaggio } from './messaggio';
import { Chat } from './chat';
export class RegistrazioneDto {
    contatti: Chat[] = [];
    messaggi: Messaggio[] = [];
    sessione = "";
}