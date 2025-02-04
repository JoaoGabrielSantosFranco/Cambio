package com.jfranco.CambioZap.Service;

import com.jfranco.CambioZap.Converter.Converter;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WhatsAppService {

    private final Converter converter;

    public WhatsAppService(Converter converter) {
        this.converter = converter;
    }

    public String getCurrencyOrigin(String message) {
        String currencyOrigin = extractCurrencyOrigin(message);

        if ("Formato inválido".equals(currencyOrigin)) {
            return "Formato de moeda inválido. Use o formato #moeda.";
        }

        try {
            double conversionRate = converter.getConversionRate(currencyOrigin);
            return "Taxa de conversão de " + currencyOrigin + ": " + conversionRate;
        } catch (Exception e) {
            return "Não foi possível obter a taxa de conversão para " + currencyOrigin + ".";
        }
    }

    private String extractCurrencyOrigin(String message) {
        Pattern pattern = Pattern.compile("#(\\w+)");
        Matcher matcher = pattern.matcher(message.toLowerCase());

        if (matcher.find()) {
            return matcher.group(1).toUpperCase();
        } else {
            return "Formato inválido";
        }
    }
}
