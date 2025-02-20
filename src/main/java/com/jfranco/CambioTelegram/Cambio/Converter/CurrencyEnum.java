package com.jfranco.CambioTelegram.Cambio.Converter;

import java.util.HashMap;
import java.util.Map;

public enum CurrencyEnum {
    USD("dolar", "USD-BRL"),
    EUR("euro", "EUR-BRL"),
    GBP("libra", "GBP-BRL"),
    JPY("iene", "JPY-BRL"),
    ARS("peso", "ARS-BRL");

    private final String alias;
    private final String apiCode;

    private static final Map<String, CurrencyEnum> lookup = new HashMap<>();

    static {
        for (CurrencyEnum currency : CurrencyEnum.values()) {
            lookup.put(currency.alias, currency);
        }
    }

    CurrencyEnum(String alias, String apiCode) {
        this.alias = alias;
        this.apiCode = apiCode;
    }

    public String getApiCode() {
        return apiCode;
    }

    public static String getApiCodeFromAlias(String alias) {
        CurrencyEnum currency = lookup.get(alias.toLowerCase());
        return (currency != null) ? currency.getApiCode() : null;
    }
}
