package br.com.pml.service;

import br.com.pml.config.ViaCepConfig;
import br.com.pml.request.PessoaRequest;
import br.com.pml.response.PessoaResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Serviço para interagir com o serviço ViaCep, realizando requisições e manipulando respostas.
 */
@Service
public class PessoaService {

    /**
     * Realiza uma requisição para obter informações de CEP e retorna a resposta em formato JSON.
     *
     * @param pessoaRequest Dados da pessoa, incluindo o CEP.
     * @return PessoaResponse com informações da pessoa.
     */
    public PessoaResponse buscarCepRetonarPessoaJson(PessoaRequest pessoaRequest) {
        try {
            // Cria a URL usando a classe ViaCepConfig
            String url = ViaCepConfig.buildUrl(pessoaRequest.getCep());

            // Cria o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Cria a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Envia a requisição HTTP e obtém a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Desserializa a resposta JSON em um objeto PessoaResponse
            JAXBContext jaxbContext = JAXBContext.newInstance(PessoaResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            PessoaResponse pessoaResponse = (PessoaResponse) unmarshaller.unmarshal(new StringReader(response.body()));

            // Atualiza os valores de name e email com base nos dados fornecidos
            pessoaResponse.setName(pessoaRequest.getName());
            pessoaResponse.setEmail(pessoaRequest.getEmail());

            return pessoaResponse;

        } catch (Exception e) {
            // Lida com exceções, podendo ser mais específico conforme necessário
            throw new RuntimeException("Ocorreu um erro ao obter o CEP: " + e.getMessage());
        }
    }

    /**
     * Realiza uma requisição para obter informações de CEP e retorna a resposta em formato XML.
     *
     * @param pessoaRequest Dados da pessoa, incluindo o CEP.
     * @return String com a resposta XML contendo informações da pessoa.
     */
    public String buscarCepRetonarPessoaXml(PessoaRequest pessoaRequest) {
        try {
            // Cria a URL usando a classe ViaCepConfig
            String url = ViaCepConfig.buildUrl(pessoaRequest.getCep());

            // Cria o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Cria a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Envia a requisição HTTP e obtém a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Desserializa a resposta XML em um objeto PessoaResponse
            JAXBContext jaxbContext = JAXBContext.newInstance(PessoaResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            PessoaResponse pessoaResponse = (PessoaResponse) unmarshaller.unmarshal(new StringReader(response.body()));

            // Atualiza os valores de name e email com base nos dados fornecidos
            pessoaResponse.setName(pessoaRequest.getName());
            pessoaResponse.setEmail(pessoaRequest.getEmail());

            // Converte PessoaResponse de volta para XML
            StringWriter writer = new StringWriter();
            jaxbContext.createMarshaller().marshal(pessoaResponse, writer);

            // Retorna a resposta em formato XML
            return writer.toString();

        } catch (Exception e) {
            // Lida com exceções, podendo ser mais específico conforme necessário
            throw new RuntimeException("Ocorreu um erro ao obter o CEP: " + e.getMessage());
        }
    }

    /**
     * Realiza uma requisição para obter informações de CEP e retorna a resposta em formato XML.
     * Esta versão do método é assíncrona.
     *
     * @param pessoaRequest Dados da pessoa, incluindo o CEP.
     * @return PessoaResponse com informações da pessoa.
     */
    public PessoaResponse buscarCepViaWDSLRetornarPessoaEcep(PessoaRequest pessoaRequest) {
        try {
            // Cria a URL usando a classe ViaCepConfig
            String url = ViaCepConfig.buildUrl(pessoaRequest.getCep());

            // Cria o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Cria a requisição HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // Envia a requisição HTTP e obtém a resposta assincronamente
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica se o código de resposta é OK (200)
            if (response.statusCode() == 200) {
                // Desserializa a resposta XML em um objeto PessoaResponse
                JAXBContext jaxbContext = JAXBContext.newInstance(PessoaResponse.class);
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
                PessoaResponse pessoaResponse = (PessoaResponse) unmarshaller.unmarshal(new StringReader(response.body()));

                // Atualiza os valores de name e email com base nos dados fornecidos
                pessoaResponse.setName(pessoaRequest.getName());
                pessoaResponse.setEmail(pessoaRequest.getEmail());

                // Imprime no console o XML recebido
                System.out.println("XML recebido: " + pessoaResponse.toString());

                // Retorna o objeto PessoaResponse
                return pessoaResponse;

            } else {
                // Se o código de resposta não for OK, trata o erro
                throw new RuntimeException("Erro ao obter o CEP. Código de resposta: " + response.statusCode());
            }
        } catch (JAXBException e) {
            // Lida com JAXBException separadamente, indicando um problema com a desserialização XML
            throw new RuntimeException("Erro ao desserializar a resposta XML: " + e.getMessage(), e);
        } catch (IOException | InterruptedException e) {
            // Lida com exceções de I/O e interrupção de forma genérica
            throw new RuntimeException(e);
        }
    }
}
