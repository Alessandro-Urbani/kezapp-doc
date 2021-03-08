package it.sirfin.kezapp.controller;

import it.sirfin.kezapp.dto.InviaMessaggioDto;
import it.sirfin.kezapp.dto.RegistrazioneDto;
import it.sirfin.kezapp.dto.RichiediMessaggiDto;
import it.sirfin.kezapp.dto.RichiediRegistrazioneDto;
import it.sirfin.kezapp.service.KezappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class KezappController {

    @Autowired
    KezappService kezappService;

    @RequestMapping("/registrazione")
    @ResponseBody
    public RegistrazioneDto registrazione(@RequestBody RichiediRegistrazioneDto dto) {
        return kezappService.registrazione(dto.getNickname());
    }

    @RequestMapping("/invia-tutti")
    @ResponseBody
    public RegistrazioneDto inviaTutti(@RequestBody InviaMessaggioDto dto) {
        return kezappService.inviaTutti(dto);
    }

    @RequestMapping("/invia-uno")
    @ResponseBody
    public RegistrazioneDto inviaUno(@RequestBody InviaMessaggioDto dto) {
        return kezappService.inviaUno(dto);
    }

    @RequestMapping("/aggiorna")
    @ResponseBody
    public RegistrazioneDto aggiorna(@RequestBody RichiediMessaggiDto dto) {
        return kezappService.aggiorna(dto.getSessione());
    }
}
