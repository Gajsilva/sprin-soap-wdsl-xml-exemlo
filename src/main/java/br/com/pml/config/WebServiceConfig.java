package br.com.pml.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * Configuração do WebService SOAP.
 * Esta classe configura o WebService SOAP usando Spring Web Services.
 */
@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

    /**
     * Configura o servlet para manipular mensagens SOAP.
     *
     * @param applicationContext O contexto da aplicação.
     * @return Um objeto ServletRegistrationBean configurado para o MessageDispatcherServlet.
     */
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    /**
     * Define as propriedades do WSDL para o serviço Pessoa.
     *
     * @param pessoaSchema O esquema XSD para o serviço Pessoa.
     * @return Um objeto DefaultWsdl11Definition configurado para o serviço Pessoa.
     */
    @Bean(name = "pessoa")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema pessoaSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PessoaEndpoint");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://example.com/wsdl/types");
        wsdl11Definition.setSchema(pessoaSchema);
        return wsdl11Definition;
    }

    /**
     * Define o esquema XSD para o serviço Pessoa.
     *
     * @return Um objeto SimpleXsdSchema configurado para o esquema XSD do serviço Pessoa.
     */
    @Bean
    public XsdSchema pessoaSchema() {
        return new SimpleXsdSchema(new ClassPathResource("pessoa.xsd"));
    }
}
