package com.desafio.dto.Patient;

import com.desafio.dto.Endereco.EnderecoDTO;
import java.util.Date;
import java.util.UUID;

public class ConsultaPacienteDTO {

    private Long id;
    private String name;
    private Integer healthInsuranceCardId;
    private EnderecoDTO address;
    private Date createdAt;

    public ConsultaPacienteDTO() {
    }

    public ConsultaPacienteDTO(Long id, String name, Integer healthInsuranceCardId, EnderecoDTO address, Date createdAt) {
        this.id = id;
        this.name = name;
        this.healthInsuranceCardId = healthInsuranceCardId;
        this.address = address;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealthInsuranceCardId() {
        return healthInsuranceCardId;
    }

    public void setHealthInsuranceCardId(Integer healthInsuranceCardId) {
        this.healthInsuranceCardId = healthInsuranceCardId;
    }

    public EnderecoDTO getAddress() {
        return address;
    }

    public void setAddress(EnderecoDTO address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
