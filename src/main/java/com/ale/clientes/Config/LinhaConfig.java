package com.ale.clientes.Config;

import com.ale.clientes.Client.LinhaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class LinhaConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.ale.clientes.wsdl");
        return marshaller;
    }

    @Bean
    public LinhaClient linhaClient(Jaxb2Marshaller marshaller) {
        LinhaClient client = new LinhaClient();
        client.setDefaultUri("http://alsb3-soa/Linha");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
