package br.com.william.bankapi.service;


import br.com.william.bankapi.dto.ContaRespostaDTO;
import br.com.william.bankapi.dto.CriarContaDTO;
import br.com.william.bankapi.entity.Conta;
import br.com.william.bankapi.exception.ContaNaoEncontradaException;
import br.com.william.bankapi.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;

    private static final Logger logger = Logger.getLogger(ContaService.class.getName());

    public List<ContaRespostaDTO> listarContas() {
        logger.info("Listando todas as contas");
        return contaRepository.findAll().stream()
                .map(this::converterParaDTO)
                .toList();
    }

    public ContaRespostaDTO buscarContaPorId(Long id) {
        logger.info("Buscando conta com ID: " + id);
        return converterParaDTO(contaRepository.findById(id)
                .orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada com o ID: " + id)));
    }

    public ContaRespostaDTO criarConta(CriarContaDTO dadosConta) {
        logger.info("Criando nova conta");
        Conta conta = Conta.builder()
                .titular(dadosConta.titular())
                .numeroDaConta(dadosConta.numeroDaConta())
                .agencia(dadosConta.agencia())
                .saldo(dadosConta.saldo())
                .ativa(dadosConta.ativa())
                .build();
        return converterParaDTO(contaRepository.save(conta));
    }

    public ContaRespostaDTO atualizarConta(Long id, CriarContaDTO dadosAtualizados) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada com o ID: " + id));

        conta.setTitular(dadosAtualizados.titular());
        conta.setSaldo(dadosAtualizados.saldo());
        conta.setAgencia(dadosAtualizados.agencia());
        conta.setNumeroDaConta(dadosAtualizados.numeroDaConta());
        conta.setAtiva(dadosAtualizados.ativa());
        logger.info("Atualizando conta com ID: " + id);

        Conta contaAtualizada = contaRepository.save(conta);
        return converterParaDTO(contaAtualizada);
    }

    public void deletarConta(Long id) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada com o ID: " + id));
        // Verifica se a conta existe antes de deletar
        logger.info("Deletando conta com ID: " + id);
        contaRepository.delete(conta);
    }

    private ContaRespostaDTO converterParaDTO(Conta conta) {
        return new ContaRespostaDTO(
                conta.getId(),
                conta.getTitular(),
                conta.getNumeroDaConta(),
                conta.getAgencia(),
                conta.getSaldo(),
                conta.isAtiva()
        );
    }
}
