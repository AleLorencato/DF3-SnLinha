package com.ale.clientes.Controller;

import com.ale.clientes.Dto.LinhaDTO;
import com.ale.clientes.Service.LinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/linhas")
public class LinhaController {

    @Autowired
    private LinhaService linhaService;

    @GetMapping
    public ResponseEntity<List<LinhaDTO>> getLinhas(
            @RequestParam String documento,
            @RequestParam(required = false) String status) {

        List<LinhaDTO> resultado = linhaService.buscarLinhasFiltradas(documento, status);
        return ResponseEntity.ok(resultado);
    }
}
