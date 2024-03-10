package br.com.pml.response;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

/**
 * Representa a resposta de Pessoa em formato XML.
 * Esta classe é usada para mapear os dados que serão enviados em respostas SOAP.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PessoaResponse", propOrder = {
        "name",
        "email",
        "cep",
        "localidade",
        "uf",
        "ddd"
})
@XmlRootElement(name = "xmlcep")
public class PessoaResponse {

    /**
     * Nome da pessoa.
     */
    @XmlElement()
    private String name;

    /**
     * E-mail da pessoa.
     */
    @XmlElement()
    private String email;

    /**
     * CEP da pessoa.
     */
    @XmlElement()
    private String cep;

    /**
     * Localidade da pessoa.
     */
    @XmlElement()
    private String localidade;

    /**
     * UF (Unidade Federativa) da pessoa.
     */
    @XmlElement()
    private String uf;

    /**
     * DDD (Código de Discagem Direta) da pessoa.
     */
    @XmlElement()
    private String ddd;

}
