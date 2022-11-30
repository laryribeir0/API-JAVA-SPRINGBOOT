package com.desafio.service;

import com.desafio.entities.Patient;
import com.desafio.exception.EntityNotFoundException;
import com.desafio.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient salvarPaciente(Patient patient){
        return patientRepository.save(patient);
    }

    public Page<Patient> listarTodosOsPacientes(Pageable pageable){
        return patientRepository.findAll(pageable);
    }

    public Patient buscarPatient(Long id) {
        Optional<Patient> optional = patientRepository.findById(id);
        return optional.orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
    }


    public Patient atualizarPaciente(Patient patient, Long id) {
        Patient pacienteOriginal = this.buscarPatient(id);
        patient.setId(pacienteOriginal.getId());
        return patientRepository.save(patient);

    }

    public void excluirPaciente(Long id) {
        Patient pacienteOriginal = this.buscarPatient(id);
        patientRepository.delete(pacienteOriginal);

    }




}
