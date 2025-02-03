package com.jfranco.CambioZap.Service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WhatsAppService {

    private final double currencyConverter;

    public WhatsAppService(double currencyConverter) {
        this.currencyConverter = currencyConverter;
    }

    public static String getCurrencyOrigin(String message) {
        String currencyOrigin = extractCurrencyOrigin(message);

        return "";

    }

    private static String extractCurrencyOrigin(String message) {
        Pattern pattern = Pattern.compile("#(\\w+)");
        Matcher matcher = pattern.matcher(message.toLowerCase());

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "Formato inválido";
        }
    }


}
