package com.dh.Clinica.controller;

        import com.dh.Clinica.exceptions.BadRequestException;
        import com.dh.Clinica.exceptions.ResourceNotFoundException;
        import com.dh.Clinica.model.Odontologo;
        import com.dh.Clinica.model.Paciente;
        import com.dh.Clinica.model.Turno;
        import com.dh.Clinica.service.OdontologoService;
        import com.dh.Clinica.service.PacienteService;
        import com.dh.Clinica.service.TurnoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.Collection;
        import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private TurnoService turnoService;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) throws BadRequestException {
        ResponseEntity<Turno> response;

        Paciente paciente = pacienteService.buscarPaciente(turno.getPaciente().getId()).orElse(null);
        Odontologo odongotologo = odontologoService.buscarOdontologo(turno.getOdontologo().getId()).orElse(null);

        turno.setOdontologo(odongotologo);
        turno.setPaciente(paciente);

        response = ResponseEntity.ok(turnoService.crearTurno(turno));


        return response;

    }

    @GetMapping
    public ResponseEntity<Collection<Turno>> listar() {
        return ResponseEntity.ok(turnoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Long id) {
        Turno turno = turnoService.buscarTurno(id).orElse(null);

        return ResponseEntity.ok(turno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {

        turnoService.eliminarTurno(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");

    }


    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
