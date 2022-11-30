package com.desafio.dto.Endereco;

public class EnderecoDTO {

    private String logradouro;
    private String numero;

    public EnderecoDTO() {
    }

    public EnderecoDTO(String logradouro, String numero) {
        this.logradouro = logradouro;
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
