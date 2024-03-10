# sprin-soap-wdsl-xml-exemlo - Spring Boot Web e Serviço SOAP

É uma aplicação Spring Boot que oferece serviços web RESTful e SOAP para gerenciar informações de pessoas. Inclui funcionalidades para salvar e recuperar dados de pessoa em formatos JSON e XML, além de interagir com o serviço ViaCep para obter informações de endereço com base no CEP (Código de Endereçamento Postal).

## Como Começar

### Pré-requisitos

- Java 17 ou posterior
- Maven
- [Chave de API do ViaCep](https://viacep.com.br/)


## Uso

### Endpoints RESTful

- **Salvar Pessoa (JSON):**
  - Endpoint: `POST /pessoa/json`
  - Corpo da Requisição: Representação JSON das informações da pessoa.
  - Resposta: Representação JSON das informações da pessoa salva.

- **Recuperar Pessoa (XML):**
  - Endpoint: `POST /pessoa/xml`
  - Corpo da Requisição: Representação XML das informações da pessoa.
  - Resposta: Representação XML das informações da pessoa.

### Ponto de Extremidade SOAP

- **Serviço Web SOAP:**
  - Localização do WSDL: [http://localhost:8080/ws/pessoa.wsdl](http://localhost:8080/ws/pessoa.wsdl)
  - Ponto de Extremidade SOAP: [http://localhost:8080/ws](http://localhost:8080/ws)
  - Requisição: Representação XML de `PessoaRequest`.
  - Resposta: Representação XML de `PessoaResponse`.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir problemas ou enviar solicitações de pull para melhorar a aplicação.

## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para obter detalhes.

## Reconhecimentos

- Este projeto foi construído com Spring Boot, Spring Web Services e integração com o serviço ViaCep.
- Um agradecimento especial à equipe do ViaCep por fornecer uma API confiável para informações de endereço com base no CEP.

**Feliz codificação!**
