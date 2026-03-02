package com.ale.clientes.Dto;

import lombok.Data;

@Data
public class LinhaDTO {
    private String numeroLinha;
    private String statusLinha;
    private String tipoLinha;
    private String origemLinha;

    public LinhaDTO(String numeroLinha, String statusLinha, String tipoLinha, String origemLinha) {
        this.numeroLinha = numeroLinha;
        this.statusLinha = statusLinha;
        this.tipoLinha = tipoLinha;
        this.origemLinha = origemLinha;
    }



    public LinhaDTO() {

    }

    public String getNumeroLinha() {
        return numeroLinha;
    }

    public void setNumeroLinha(String numeroLinha) {
        this.numeroLinha = numeroLinha;
    }

    public String getStatusLinha() {
        return statusLinha;
    }

    public void setStatusLinha(String statusLinha) {
        this.statusLinha = statusLinha;
    }

    public String getTipoLinha() {
        return tipoLinha;
    }

    public void setTipoLinha(String tipoLinha) {
        this.tipoLinha = tipoLinha;
    }

    public String getOrigemLinha() {
        return origemLinha;
    }

    public void setOrigemLinha(String origemLinha) {
        this.origemLinha = origemLinha;
    }
}
