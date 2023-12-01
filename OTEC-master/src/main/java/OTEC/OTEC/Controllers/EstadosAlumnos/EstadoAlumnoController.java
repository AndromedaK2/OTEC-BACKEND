package OTEC.OTEC.Controllers.EstadosAlumnos;

import OTEC.OTEC.Services.EstadosAlumnos.EstadoAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadoalumno")
public class EstadoAlumnoController {
    @Autowired
    private EstadoAlumnoService estadoAlumnoService;
}
