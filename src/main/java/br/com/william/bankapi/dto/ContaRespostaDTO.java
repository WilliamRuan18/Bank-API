package br.com.william.bankapi.dto;

public record ContaRespostaDTO(
        Long id,
        String titular,
        String numeroDaConta,
        String agencia,
        java.math.BigDecimal saldo,
        Boolean ativa
) {
}
