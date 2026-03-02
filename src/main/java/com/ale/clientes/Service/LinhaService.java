package com.ale.clientes.Service;

import com.ale.clientes.Client.LinhaClient;
import com.ale.clientes.Dto.LinhaDTO;
import com.ale.clientes.wsdl.Linha;
import com.ale.clientes.wsdl.Linhas;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class LinhaService {

    @Autowired
    private LinhaClient linhaClient;

    public List<LinhaDTO> buscarLinhasFiltradas(String documento, String statusFiltro) {

        Linhas linhasSoap = linhaClient.buscarLinhas(documento);

        return linhasSoap.getLinha().stream()
                .map(this::mapToDTO)
                .filter(dto -> statusFiltro == null ||
                        dto.getStatusLinha().equalsIgnoreCase(statusFiltro))
                .collect(Collectors.toList());
    }

    private LinhaDTO mapToDTO(Linha soapLinha) {
        LinhaDTO dto = new LinhaDTO();

        dto.setNumeroLinha(soapLinha.getNumeroLinha().toString());
        dto.setStatusLinha(soapLinha.getStatusAssinatura().getValue().toString());
        dto.setTipoLinha(soapLinha.getTipoAssinatura().getValue().toString());
        dto.setOrigemLinha(soapLinha.getSistemaOrigem().getValue().toString());

        return dto;
    }
}
