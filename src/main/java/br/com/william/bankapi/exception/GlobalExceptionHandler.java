package br.com.william.bankapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ContaNaoEncontradaException.class)
    public ResponseEntity<Map<String, String>> tratarContaNaoEncontradaException(ContaNaoEncontradaException ex) {

        Map<String, String> resposta = Map.of("error", ex.getMessage());

        return ResponseEntity
                .status(404)
                .body(resposta);
    }
}
