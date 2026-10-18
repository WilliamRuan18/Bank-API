package br.com.william.bankapi.exception;

public class TratarDadosInvalidosException extends RuntimeException {
    public TratarDadosInvalidosException(String message) {
        super(message);
    }
}
