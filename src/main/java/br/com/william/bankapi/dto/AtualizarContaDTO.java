package br.com.william.bankapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record AtualizarContaDTO(
        @NotBlank(message = "O titular da conta não pode ser nulo ou vazio")
        String titular,

        @NotBlank(message = "O número da conta não pode ser nulo ou vazio")
        String numeroDaConta,

        @NotBlank(message = "A agência não pode ser nula ou vazia")
        String agencia,

        @NotNull(message = "O saldo não pode ser nulo")
        BigDecimal saldo,

        @NotNull(message = "O status da conta não pode ser nulo ou vazio")
        Boolean ativa
) {
}
