package br.com.william.bankapi.dto;

import java.math.BigDecimal;

public record ContaRespostaDTO(
        Long id,
        String titular,
        String numeroDaConta,
        String agencia,
        BigDecimal saldo,
        Boolean ativa
) {
}
