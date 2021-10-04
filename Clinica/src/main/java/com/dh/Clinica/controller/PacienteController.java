package com.dh.Clinica.controller;

import com.dh.Clinica.exceptions.ResourceNotFoundException;
import com.dh.Clinica.model.Paciente;
import com.dh.Clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {

        return ResponseEntity.ok(pacienteService.crearPaciente(paciente));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
        Paciente paciente = pacienteService.buscarPaciente(id).orElse(null);

        return ResponseEntity.ok(paciente);
    }

    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        ResponseEntity<Paciente> response = null;

        if (paciente.getId() != null && pacienteService.buscarPaciente(paciente.getId()).isPresent())
            response = ResponseEntity.ok(pacienteService.modificarPaciente(paciente));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {

        pacienteService.eliminarPaciente(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
}
