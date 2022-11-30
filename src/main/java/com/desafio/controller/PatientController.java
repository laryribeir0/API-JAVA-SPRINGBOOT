package com.desafio.controller;

import com.desafio.dto.Patient.ConsultaPacienteDTO;
import com.desafio.dto.Patient.PacienteMapper;
import com.desafio.dto.Patient.RegistroPacienteDTO;
import com.desafio.entities.Patient;
import com.desafio.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/Pacientes")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping
    public ResponseEntity<Page<ConsultaPacienteDTO>> buscarTodosOsPacientes(@PageableDefault(size = 3) Pageable pageable) {
        return ResponseEntity.ok(patientService.listarTodosOsPacientes(pageable).map(PacienteMapper::fromEntity));
    }

    @PostMapping
    public ResponseEntity<ConsultaPacienteDTO> salvarPaciente(@RequestBody RegistroPacienteDTO dto) {
        Patient patient = patientService.salvarPaciente(PacienteMapper.fromDTO(dto));
        return ResponseEntity.ok(PacienteMapper.fromEntity(patient));
    }

    @GetMapping("{id}")
    public ResponseEntity<ConsultaPacienteDTO> buscarPaciente(@PathVariable Long id) {
        Patient patient = patientService.buscarPatient(id);
        return ResponseEntity.ok(PacienteMapper.fromEntity(patient));

    }

    @PutMapping("{id}")
    public ResponseEntity<ConsultaPacienteDTO> alterarPaciente(@RequestBody RegistroPacienteDTO dto, @PathVariable Long id) {

        try {
            Patient patient = patientService.atualizarPaciente(PacienteMapper.fromDTO(dto), id);
            return ResponseEntity.ok(PacienteMapper.fromEntity(patient));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ConsultaPacienteDTO> excluirPaciente(@PathVariable Long id) {

        try {
            patientService.excluirPaciente(id);

            return ResponseEntity.ok().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }

    }
}
