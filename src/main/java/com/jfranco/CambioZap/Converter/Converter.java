package com.jfranco.CambioZap.Converter;

import com.jfranco.CambioZap.Exceptions.InvalidConversionRateException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class Converter {

    private static final String API_URL = "https://economia.awesomeapi.com.br/json/daily/";

    private final RestTemplate restTemplate;

    public Converter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public double getConversionRate(String currencyOrigin) {
        String url = UriComponentsBuilder.fromHttpUrl(API_URL).pathSegment(currencyOrigin).toUriString();

        double response = restTemplate.getForObject(url, double.class);
        validateResponse(response);
        return response;
    }

    private void validateResponse(Double response) {
        if (response == null || response <= 0) {
            throw new InvalidConversionRateException("Taxa de conversão inválida ou não encontrada.");
        }
    }


}
