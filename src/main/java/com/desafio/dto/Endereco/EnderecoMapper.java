package com.desafio.dto.Endereco;

import com.desafio.entities.Endereco;

public class EnderecoMapper {

    public static Endereco fromDTO(EnderecoDTO dto) {
        return new Endereco(dto.getLogradouro(), dto.getNumero());
    }

    //convertendo de uma entidade para um DTO
    public static EnderecoDTO fromEntity(Endereco endereco) {
        return new EnderecoDTO(endereco.getLogradouro(), endereco.getNumero());
    }

}
