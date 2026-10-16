package br.com.william.bankapi.controller;

import br.com.william.bankapi.dto.ContaRespostaDTO;
import br.com.william.bankapi.dto.CriarContaDTO;
import br.com.william.bankapi.entity.Conta;
import br.com.william.bankapi.service.ContaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;


    @GetMapping
    public List<ContaRespostaDTO> listarContas() {
        return contaService.listarContas();
    }

    @GetMapping("/{id}")
    public ContaRespostaDTO buscarContaPorId(@PathVariable Long id) {
        return contaService.buscarContaPorId(id);
    }

    @PostMapping
    public ContaRespostaDTO criarConta(@Valid @RequestBody CriarContaDTO dadosDaConta) {
        return contaService.criarConta(dadosDaConta);
    }

    @PutMapping("/{id}")
    public ContaRespostaDTO atualizarConta(@PathVariable Long id, @Valid @RequestBody CriarContaDTO dadosDaConta) {
        return contaService.atualizarConta(id, dadosDaConta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarConta(@PathVariable Long id) {
        contaService.deletarConta(id);
    }
}
