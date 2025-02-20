package com.jfranco.CambioTelegram.Cambio.Exceptions;

public class InvalidConversionRateException extends RuntimeException {
    public InvalidConversionRateException(String message) {
        super(message);
    }
}
