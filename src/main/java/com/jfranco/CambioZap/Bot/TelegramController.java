package com.jfranco.CambioZap.Bot;

import com.jfranco.CambioZap.Cambio.Service.CambioAppService;
import com.jfranco.CambioZap.Bot.CambioService.TelegramService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telegram")
public class TelegramController {

    private final TelegramService telegramService;
    private final CambioAppService cambioService;
    @Value("${telegram.bot.token}")
    private String botToken;
    @Value("${telegram.chat.id}")
    private String chatId;

    public TelegramController(TelegramService telegramService, CambioAppService cambioService) {
        this.telegramService = telegramService;
        this.cambioService = cambioService;
    }


    @PostMapping("/currency")
    public void botMessage(@RequestBody String mensagem) {
        String resultConvert = cambioService.processConversion(mensagem);

        telegramService.sendMessageTelegram(chatId, resultConvert);
    }
}
