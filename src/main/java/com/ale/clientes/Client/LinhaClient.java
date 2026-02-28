package com.ale.clientes.Client;

import com.ale.clientes.wsdl.ObjectFactory;
import com.ale.clientes.wsdl.ParametrosBuscarListaLinhasPorCPFCNPJ;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LinhaClient extends WebServiceGatewaySupport {

    public Object buscarLinhas(String documento) {
        ObjectFactory factory = new ObjectFactory();

        ParametrosBuscarListaLinhasPorCPFCNPJ params = factory.createParametrosBuscarListaLinhasPorCPFCNPJ();
        params.setNumeroCPFCNPJ(documento);

        JAXBElement<ParametrosBuscarListaLinhasPorCPFCNPJ> request =
                factory.createBuscarListaLinhasPorCPFCNPJRequest(params);

        return getWebServiceTemplate()
                .marshalSendAndReceive(getDefaultUri(), request);
    }
}