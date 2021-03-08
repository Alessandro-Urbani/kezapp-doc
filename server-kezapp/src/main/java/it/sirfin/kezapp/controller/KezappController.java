package it.sirfin.kezapp.controller;

import it.sirfin.kezapp.dto.InviaMessaggioDto;
import it.sirfin.kezapp.dto.RegistrazioneDto;
import it.sirfin.kezapp.dto.RichiediMessaggiDto;
import it.sirfin.kezapp.dto.RichiediRegistrazioneDto;
import it.sirfin.kezapp.service.KezappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class KezappController {
    
    @Autowired
    KezappService kezappService;

    @RequestMapping("/registrazione")
    @ResponseBody
    public RegistrazioneDto registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping("/invia-tutti")
    @ResponseBody
    public RegistrazioneDto inviaTutti(@RequestBody InviaMessaggioDto dto) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping("/invia-uno")
    @ResponseBody
    public RegistrazioneDto inviaUno(@RequestBody InviaMessaggioDto dto) {
        throw new UnsupportedOperationException();
    }

    @RequestMapping("/aggiorna")
    @ResponseBody
    public RegistrazioneDto aggiorna(@RequestBody RichiediMessaggiDto dto) {
        throw new UnsupportedOperationException();
    }
}
