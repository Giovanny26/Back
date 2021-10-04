package com.dh.Clinica.service;

import com.dh.Clinica.model.Turno;
import com.dh.Clinica.repository.TurnoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoServiceImpl implements TurnoService{

    private final TurnoRepository turnoRepository;

    public TurnoServiceImpl(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public Optional<Turno> buscarTurno(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public Turno crearTurno(Turno turno) {
        if(turno != null){
            return turnoRepository.save(turno);
        }
        return new Turno();
    }


    @Override
    public String eliminarTurno(Long id) {
        if(turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
            return "Turno eliminado con id: " + id;
        }
        return "Turno con id " + id + "no existe. Revisa.";
    }

    @Override
    public Collection<Turno> listar() {
        Collection<Turno> turnos = turnoRepository.findAll();
        return turnos;
    }

}



