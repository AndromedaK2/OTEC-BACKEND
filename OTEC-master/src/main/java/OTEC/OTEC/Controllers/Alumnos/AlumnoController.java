package OTEC.OTEC.Controllers.Alumnos;


import OTEC.OTEC.Models.Alumnos.Alumno;
import OTEC.OTEC.Services.Alumnos.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;


    @GetMapping("/all")
    public ResponseEntity<List<Alumno>> findAll(){
        List<Alumno>alumnos = alumnoService.findAll();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);

    }
}
