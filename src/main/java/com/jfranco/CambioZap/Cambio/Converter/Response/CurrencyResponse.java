package com.jfranco.CambioZap.Cambio.Converter.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyResponse {

    private String code;
    private String name;
    private String high;
    private String low;
    private String ask;
}
