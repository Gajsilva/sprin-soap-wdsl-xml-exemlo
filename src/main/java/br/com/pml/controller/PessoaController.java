package br.com.pml.controller;

import br.com.pml.request.PessoaRequest;
import br.com.pml.response.PessoaResponse;
import br.com.pml.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para manipulação de recursos relacionados a Pessoa.
 * Esta classe expõe endpoints para salvar Pessoa em formato JSON e buscar Pessoa em formato XML.
 */
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService; // Supondo que você tenha um serviço para lidar com a lógica de negócios

    /**
     * Construtor que injeta o serviço PessoaService.
     *
     * @param pessoaService O serviço PessoaService a ser injetado.
     */
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    /**
     * Endpoint para salvar Pessoa em formato JSON.
     *
     * @param pessoaRequest O objeto PessoaRequest recebido na requisição.
     * @return Um objeto ResponseEntity contendo a PessoaResponse e o status HTTP OK.
     */
    @PostMapping("/json")
    public ResponseEntity<PessoaResponse> salvar(@RequestBody PessoaRequest pessoaRequest) {
        return ResponseEntity.ok(pessoaService.buscarCepRetonarPessoaJson(pessoaRequest));
    }

    /**
     * Endpoint para buscar Pessoa em formato XML.
     *
     * @param pessoaRequest O objeto PessoaRequest recebido na requisição.
     * @return Uma string contendo a resposta em formato XML.
     */
    @PostMapping(value = "/xml")
    public String buscarCepRetonarPessoaXml(@RequestBody PessoaRequest pessoaRequest) {
        return pessoaService.buscarCepRetonarPessoaXml(pessoaRequest);
    }
}
