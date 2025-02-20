package com.jfranco.CambioTelegram.Cambio.Converter;

import com.jfranco.CambioTelegram.Cambio.Converter.Response.CurrencyResponse;
import com.jfranco.CambioTelegram.Cambio.Exceptions.InvalidConversionRateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
public class Converter {

    @Value("${api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    public Converter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double getConversionRate(String currencyOrigin) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .pathSegment(currencyOrigin)
                .toUriString();
        CurrencyResponse[] response = restTemplate.getForObject(url, CurrencyResponse[].class);
        validateResponse(response);
        return Double.parseDouble(response[0].getAsk());
    }

    private void validateResponse(CurrencyResponse[] response) {
        Optional.ofNullable(response)
                .filter(r -> r.length > 0 && r[0].getAsk() != null)
                .map(r -> Double.parseDouble(r[0].getAsk()))
                .filter(rate -> rate > 0)
                .orElseThrow(() -> new InvalidConversionRateException("Taxa de conversão inválida ou não encontrada."));
    }

}