package com.jfranco.CambioZap.Controller;

import com.jfranco.CambioZap.Service.WhatsAppService;
import com.jfranco.CambioZap.model.CurrencyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatsAppController {

    private final WhatsAppService whatsAppService;

    @Autowired
    public WhatsAppController(WhatsAppService whatsAppService) {
        this.whatsAppService = whatsAppService;
    }

    @PostMapping("/currency")
    public ResponseEntity<String> receiveMessage(@RequestBody CurrencyRequest request) {
        String response = whatsAppService.processConversion(request.getMessage());
        return ResponseEntity.ok(response);
    }
}
