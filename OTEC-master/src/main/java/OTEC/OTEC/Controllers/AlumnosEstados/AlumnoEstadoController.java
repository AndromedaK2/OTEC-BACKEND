package OTEC.OTEC.Controllers.AlumnosEstados;

import OTEC.OTEC.Models.Alumnos.Alumno;
import OTEC.OTEC.Services.AlumnosEstados.AlumnoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alumnosestado")
public class AlumnoEstadoController {
    @Autowired
    private AlumnoEstadoService alumnoEstadoService;
}
