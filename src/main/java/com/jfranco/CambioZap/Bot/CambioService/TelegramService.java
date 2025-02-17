package com.jfranco.CambioZap.Bot.CambioService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramService {

    @Value("${telegram.bot.token}")
    private String botToken;

    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot%s/sendMessage";

    public void sendMessageTelegram(String chatId, String mensagem) {
        String url = String.format(TELEGRAM_API_URL, botToken);

        String body = String.format("{\"chat_id\":\"%s\", \"text\":\"%s\"}", chatId, mensagem);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.postForObject(url, body, String.class);
    }
}
