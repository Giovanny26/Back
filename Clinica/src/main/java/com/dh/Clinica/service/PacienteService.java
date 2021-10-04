package com.dh.Clinica.service;

import com.dh.Clinica.model.Odontologo;
import com.dh.Clinica.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    Optional<Paciente> buscarPaciente (Long id);
    Paciente crearPaciente(Paciente paciente);
    Paciente modificarPaciente(Paciente paciente);
    String eliminarPaciente(Long id);
    List<Paciente> buscarTodos();

}
