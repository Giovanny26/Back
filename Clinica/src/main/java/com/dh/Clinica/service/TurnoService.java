package com.dh.Clinica.service;

import com.dh.Clinica.model.Turno;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TurnoService {

    Optional<Turno> buscarTurno (Long id);
    Turno crearTurno(Turno turno);
    String eliminarTurno(Long id);
    Collection<Turno> listar();

}
