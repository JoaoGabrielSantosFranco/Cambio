package com.jfranco.CambioTelegram.Cambio.Controller;

import com.jfranco.CambioTelegram.Cambio.Service.CambioAppService;
import com.jfranco.CambioTelegram.Cambio.model.CurrencyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambioAppController {

    private final CambioAppService cambioAppService;

    @Autowired
    public CambioAppController(CambioAppService cambioAppService) {
        this.cambioAppService = cambioAppService;
    }

    @PostMapping("/currency")
    public ResponseEntity<String> receiveMessage(@RequestBody CurrencyRequest request) {
        String response = cambioAppService.processConversion(request.getMessage());
        return ResponseEntity.ok(response);
    }
}
