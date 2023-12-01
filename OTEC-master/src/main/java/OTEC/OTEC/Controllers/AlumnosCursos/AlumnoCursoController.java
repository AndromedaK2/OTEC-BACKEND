package OTEC.OTEC.Controllers.AlumnosCursos;

import OTEC.OTEC.Services.AlumnosCursos.AlumnoCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnoscurso")
public class AlumnoCursoController {
@Autowired
    private AlumnoCursoService alumnoCursoService;



}
