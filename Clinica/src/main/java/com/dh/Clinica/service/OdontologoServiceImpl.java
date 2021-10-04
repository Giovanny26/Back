package com.dh.Clinica.service;

import com.dh.Clinica.model.Odontologo;
import com.dh.Clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements OdontologoService {

    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Optional<Odontologo> buscarOdontologo(Long id) {
        return odontologoRepository.findById(id);
    }

    @Override
    public Odontologo crearOdontologo(Odontologo odontologo) {
        if(odontologo != null){
            return odontologoRepository.save(odontologo);
        }
        return new Odontologo();
    }

    @Override
    public Odontologo modificarOdontologo(Odontologo odontologo) {
        if(odontologo != null){
            return odontologoRepository.save(odontologo);
        }
        return new Odontologo();
    }

    @Override
    public String eliminarOdontologo(Long id) {
        if(odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
            return "Odontologo eliminado con id: " + id;
        }
        return "Odontologo con id " + id + "no existe. Revisa.";
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologoRepository.findAll();
    }

}
