package com.dh.Clinica.service;

import com.dh.Clinica.model.Odontologo;
import com.dh.Clinica.model.Paciente;
import com.dh.Clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Optional<Paciente> buscarPaciente(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente crearPaciente(Paciente paciente) {
        if(paciente != null){
            return pacienteRepository.save(paciente);
        }
        return new Paciente();
    }

    @Override
    public Paciente modificarPaciente(Paciente paciente) {
        if(paciente != null){
            return pacienteRepository.save(paciente);
        }
        return new Paciente();
    }

    @Override
    public String eliminarPaciente(Long id) {
        if(pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return "Paciente eliminado con id: " + id;
        }
        return "Paciente con id " + id + "no existe. Revisa.";
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.findAll();
    }
}
