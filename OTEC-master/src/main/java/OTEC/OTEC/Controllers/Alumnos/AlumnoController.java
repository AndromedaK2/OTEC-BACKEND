package OTEC.OTEC.Controllers.Alumnos;


import OTEC.OTEC.Models.Alumnos.Alumno;
import OTEC.OTEC.Models.Alumnos.CrearAlumno;
import OTEC.OTEC.Services.Alumnos.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/nombre/{nombres}")
    public ResponseEntity<Alumno> findByNombres(@PathVariable("nombres")String nombres){
        return alumnoService.BuscarPornombre(nombres).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<Alumno> findByRut(@PathVariable("rut")String rut){
        return alumnoService.BuscarPorRut(rut).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alumno> create(@RequestBody CrearAlumno alumno){

        return new ResponseEntity<>(alumnoService.crearAlumno(alumno),HttpStatus.CREATED);
    }
}
