package br.com.pml.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 * Representa a requisição de Pessoa em formato XML.
 * Esta classe é usada para mapear os dados recebidos em requisições SOAP.
 */
@Data
@XmlRootElement(name = "PessoaRequest", namespace = "http://example.com/wsdl/types")
@XmlAccessorType(XmlAccessType.FIELD)
public class PessoaRequest {

    /**
     * Nome da pessoa.
     */
    @XmlElement(namespace = "http://example.com/wsdl/types")
    private String name;

    /**
     * E-mail da pessoa.
     */
    @XmlElement(namespace = "http://example.com/wsdl/types")
    private String email;

    /**
     * CEP da pessoa.
     */
    @XmlElement(namespace = "http://example.com/wsdl/types")
    private String cep;
}
