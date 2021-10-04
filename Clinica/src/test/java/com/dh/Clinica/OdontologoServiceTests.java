package com.dh.Clinica;

import com.dh.Clinica.model.Odontologo;
import com.dh.Clinica.service.OdontologoService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTests {
    @Autowired
    private OdontologoService odontologoService;


    public void cargarDataSet() {
        this.odontologoService.crearOdontologo(new Odontologo("Santiago", "Paz", 3455647));


    }

    @Test
    public void agregarOdontologo() {
        this.cargarDataSet();
        Odontologo odontologo = odontologoService.crearOdontologo(new Odontologo("Juan", "Ramirez", 348971960));
        Assert.assertTrue(odontologo.getId() != null);

    }

    @Test
    public void eliminarOdontologoTest() {
        Odontologo odontologo = odontologoService.crearOdontologo(new Odontologo("Juan", "Ramirez", 348971960));
        odontologoService.eliminarOdontologo(odontologo.getId());
        Assert.assertTrue(odontologoService.buscarOdontologo(odontologo.getId()).isEmpty());

    }



}
