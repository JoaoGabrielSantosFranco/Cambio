package com.jfranco.CambioZap.Service;

import com.jfranco.CambioZap.Converter.Converter;
import com.jfranco.CambioZap.Converter.CurrencyEnum;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppService {

    private final Converter converter;

    public WhatsAppService(Converter converter) {
        this.converter = converter;
    }

    public String processConversion(String message) {
        String currencyCode = CurrencyEnum.getApiCodeFromAlias(message.trim().toLowerCase());

        if (currencyCode == null) {
            return "Moeda não suportada ou formato inválido. Envie apenas o código da moeda, como 'usd' ou 'euro'.";
        }

        try {
            double conversionRate = converter.getConversionRate(currencyCode);
            return String.format("1 %s é aproximadamente %.2f BRL.", message.trim().toUpperCase(), conversionRate);
        } catch (Exception e) {
            return "Não foi possível obter a taxa de conversão para " + message.trim().toUpperCase() + ".";
        }
    }
}
