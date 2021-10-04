package com.dh.Clinica;

import com.dh.Clinica.model.Domicilio;
import com.dh.Clinica.model.Paciente;
import com.dh.Clinica.service.PacienteService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;


    public void cargarDataSet() {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.crearPaciente(new Paciente("Santiago", "Paz", "88888888", "no date xd", domicilio));
        Domicilio domicilio1 = new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires");
        Paciente p1 = pacienteService.crearPaciente(new Paciente("Micaela", "Perez", "99999999", "199??", domicilio1));

    }

    @Test
    public void agregarYBuscarPacienteTest() {
        this.cargarDataSet();
        Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
        Paciente p = pacienteService.crearPaciente(new Paciente("Tomas", "Pereyra", "12345678", "otra fecha", domicilio));

        Assert.assertNotNull(pacienteService.buscarPaciente(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        Paciente p = pacienteService.crearPaciente(new Paciente("Tomas", "Pereyra", "12345678", "otra fecha", domicilio));
        pacienteService.eliminarPaciente(p.getId());
        Assert.assertTrue(pacienteService.buscarPaciente(p.getId()).isEmpty());

    }




}
