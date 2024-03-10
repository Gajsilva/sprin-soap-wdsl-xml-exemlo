package br.com.pml.config;

import org.springframework.context.annotation.Configuration;

/**
 * Configuração para construir URLs do serviço ViaCep.
 * Esta classe fornece métodos para construir URLs formatadas para consulta de CEP no serviço ViaCep.
 */
@Configuration
public class ViaCepConfig {

    // URL base do serviço ViaCep
    private static final String BASE_URL = "https://viacep.com.br/ws/";

    // Formato desejado para a resposta (XML neste caso)
    private static final String FORMAT = "/xml/";

    /**
     * Constrói a URL completa para consultar informações de um CEP específico.
     *
     * @param cep O CEP para o qual a URL será construída.
     * @return Uma string contendo a URL completa para consulta no serviço ViaCep.
     */
    public static String buildUrl(String cep) {
        return BASE_URL + cep + FORMAT;
    }
}
