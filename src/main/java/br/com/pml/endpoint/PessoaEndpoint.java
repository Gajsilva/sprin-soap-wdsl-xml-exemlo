package br.com.pml.endpoint;

import br.com.pml.request.PessoaRequest;
import br.com.pml.response.PessoaResponse;
import br.com.pml.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.namespace.QName;

/**
 * Endpoint para manipulação de recursos relacionados a Pessoa utilizando SOAP.
 * Esta classe expõe um endpoint para buscar e retornar Pessoa em formato XML.
 */
@Endpoint
public class PessoaEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/wsdl/types";

    private final PessoaService pessoaService;

    /**
     * Construtor que injeta o serviço PessoaService.
     *
     * @param pessoaService O serviço PessoaService a ser injetado.
     */
    public PessoaEndpoint(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    /**
     * Endpoint para buscar Pessoa e retornar em formato XML.
     *
     * @param pessoaRequest O objeto PessoaRequest recebido na requisição SOAP.
     * @return Um objeto PessoaResponse a ser retornado na resposta SOAP.
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PessoaRequest")
    @ResponsePayload
    public PessoaResponse buscarCepRetonarPessoaXml(@RequestPayload PessoaRequest pessoaRequest) {
        return pessoaService.buscarCepViaWDSLRetornarPessoaEcep(pessoaRequest);
    }
}
