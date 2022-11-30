package com.desafio.dto.Patient;

import com.desafio.dto.Endereco.EnderecoMapper;
import com.desafio.entities.Patient;

public class PacienteMapper {

    public static Patient fromDTO(RegistroPacienteDTO dto) {
        return new Patient(null, dto.getName(),dto.getHealthInsuranceCardId(),
                EnderecoMapper.fromDTO(dto.getAddress()),dto.getCreatedAt());
    }

    public static ConsultaPacienteDTO fromEntity(Patient patient) {
        return new ConsultaPacienteDTO(patient.getId(), patient.getName(), patient.getHealthInsuranceCardId(),
                EnderecoMapper.fromEntity(patient.getAddress()),patient.getCreatedAt());
    }
}
