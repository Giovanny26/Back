package com.dh.Clinica.service;

import com.dh.Clinica.model.Odontologo;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {

    Optional<Odontologo> buscarOdontologo (Long id);
    Odontologo crearOdontologo(Odontologo odontologo);
    Odontologo modificarOdontologo(Odontologo odontologo);
    String eliminarOdontologo(Long id);
    List<Odontologo> buscarTodos();


}
