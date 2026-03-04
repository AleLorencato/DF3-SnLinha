package com.ale.clientes.Service;

import com.ale.clientes.Client.LinhaClient;
import com.ale.clientes.Dto.LinhaDTO;
import com.ale.clientes.wsdl.*;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        dto.setNumeroLinha(soapLinha.getNumeroLinha());

        StatusAssinatura status = unwrap(soapLinha.getStatusAssinatura());
        if (status != null) {
            dto.setStatusLinha(unwrapStr(status.getDescricao()));
        }

        TipoAssinatura tipo = unwrap(soapLinha.getTipoAssinatura());
        if (tipo != null) {
            Plataforma plataforma = tipo.getPlataforma();
            if (plataforma != null) {
                dto.setTipoLinha(unwrapStr(plataforma.getNome()).trim());
            }
        }

        Sistema2 sistema = unwrap(soapLinha.getSistemaOrigem());
        if (sistema != null) {
            dto.setOrigemLinha(unwrapStr(sistema.getSigla()));
        }

        return dto;
    }

    private <T> T unwrap(JAXBElement<T> element) {
        return (element != null) ? element.getValue() : null;
    }

    private String unwrapStr(JAXBElement<String> element) {
        return (element != null && element.getValue() != null) ? element.getValue() : "";
    }
}
