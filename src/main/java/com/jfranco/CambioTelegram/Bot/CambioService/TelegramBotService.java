package com.jfranco.CambioTelegram.Bot.CambioService;

import com.jfranco.CambioTelegram.Cambio.model.CurrencyRequest;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramBotService {

    private final TelegramBot bot;
    private final RestTemplate restTemplate;

    @Autowired
    public TelegramBotService(RestTemplate restTemplate, @Value("${telegram.bot.token}") String token) {
        this.bot = new TelegramBot(token);
        this.restTemplate = restTemplate;

        this.bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                if (update.message() != null && update.message().text() != null) {
                    Long chatId = update.message().chat().id();
                    String message = update.message().text();

                    CurrencyRequest request = new CurrencyRequest();
                    request.setMessage(message);

                    ResponseEntity<String> response = restTemplate.postForEntity(
                            "http://localhost:8080/currency",
                            request,
                            String.class
                    );

                    bot.execute(new SendMessage(chatId, response.getBody()));
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }
}
