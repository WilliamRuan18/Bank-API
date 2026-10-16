package br.com.william.bankapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O titular da conta não pode ser nulo ou vazio")
    private String titular;

    @NotBlank(message = "O número da conta não pode ser nulo ou vazio")
    private String numeroDaConta;

    @NotBlank(message = "A agência não pode ser nula ou vazia")
    private String agencia;

    @NotNull(message = "O saldo não pode ser nulo ou vazio")
    private BigDecimal saldo;

    private boolean ativa;
}
