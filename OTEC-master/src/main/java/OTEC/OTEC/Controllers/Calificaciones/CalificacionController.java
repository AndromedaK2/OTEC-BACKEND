package OTEC.OTEC.Controllers.Calificaciones;

import OTEC.OTEC.Models.Alumnos.Alumno;
import OTEC.OTEC.Models.Alumnos.CrearAlumno;
import OTEC.OTEC.Models.Alumnos.ModificarAlumno;
import OTEC.OTEC.Models.Calificaciones.Calificacion;
import OTEC.OTEC.Models.Calificaciones.CrearCalificacion;
import OTEC.OTEC.Models.Calificaciones.ModificarCalificacion;
import OTEC.OTEC.Services.Calificaciones.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {
    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/all")
    public ResponseEntity<List<Calificacion>> findAll(){
        List<Calificacion>calificacions = calificacionService.findAll();
        return new ResponseEntity<>(calificacions, HttpStatus.OK);

    }
    @GetMapping("/nombre/{nombres}")
    public ResponseEntity<Calificacion> findByNombres(@PathVariable("nombres")String nombres){
        if(calificacionService.BuscarCalificacionPorNombre(nombres)==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
        return calificacionService.BuscarCalificacionPorNombre(nombres).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<Calificacion> findByRut(@PathVariable("rut")String rut){
        if(calificacionService.BuscarCalificacionPorRut(rut)==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return calificacionService.BuscarCalificacionPorRut(rut).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}
    }

    @PostMapping
    public ResponseEntity<Calificacion> create(@RequestBody CrearCalificacion calificacion){

        return new ResponseEntity<>(calificacionService.crearCalificacion(calificacion),HttpStatus.CREATED);
    }

    @PutMapping("/calificacionmodificar")
    public ResponseEntity<Calificacion> update(@RequestBody ModificarCalificacion modificarCalificacion){

        return new ResponseEntity<> (calificacionService.Modificarcalificacion(modificarCalificacion),HttpStatus.OK);

    }

}
