package com.ale.clientes.Client;

import com.ale.clientes.wsdl.Linhas;
import com.ale.clientes.wsdl.ObjectFactory;
import com.ale.clientes.wsdl.ParametrosBuscarListaLinhasPorCPFCNPJ;
import jakarta.xml.bind.JAXBElement;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LinhaClient extends WebServiceGatewaySupport {

    public Linhas buscarLinhas(String documento) {
        ObjectFactory factory = new ObjectFactory();
        ParametrosBuscarListaLinhasPorCPFCNPJ params = factory.createParametrosBuscarListaLinhasPorCPFCNPJ();
        params.setNumeroCPFCNPJ(documento);

        JAXBElement<ParametrosBuscarListaLinhasPorCPFCNPJ> request =
                factory.createBuscarListaLinhasPorCPFCNPJRequest(params);

        Object response = getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(), request);

        if (response instanceof JAXBElement) {
            return (Linhas) ((JAXBElement<?>) response).getValue();
        }
        return (Linhas) response;
    }
}