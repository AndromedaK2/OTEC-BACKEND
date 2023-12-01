package OTEC.OTEC.Controllers.AlumnosEstados;

import OTEC.OTEC.Services.AlumnosEstados.AlumnoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnosestado")
public class AlumnoEstadoController {
    @Autowired
    private AlumnoEstadoService alumnoEstadoService;
}
