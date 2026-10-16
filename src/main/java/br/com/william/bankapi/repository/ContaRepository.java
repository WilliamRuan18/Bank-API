package br.com.william.bankapi.repository;

import br.com.william.bankapi.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
