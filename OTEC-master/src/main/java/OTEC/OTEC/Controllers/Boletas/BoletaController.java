package OTEC.OTEC.Controllers.Boletas;

import OTEC.OTEC.Models.Alumnos.Alumno;
import OTEC.OTEC.Models.Boletas.Boleta;
import OTEC.OTEC.Services.Boletas.BoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boleta")
public class BoletaController {
    @Autowired
    private BoletaService boletaService;

    @GetMapping("/all")
    public ResponseEntity<List<Boleta>> findAll(){
        List<Boleta> boletas = boletaService.findAll();
        return new ResponseEntity<>(boletas, HttpStatus.OK);
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<Optional<Boleta>> findbyId(@PathVariable int id){
        Optional<Boleta> boleta = boletaService.findById(id);
        return new ResponseEntity<>(boleta, HttpStatus.OK);
    }

    @GetMapping("/byidestudiante/{id}")
    public ResponseEntity<Boleta> findbyIdEstudiante(@PathVariable int id){
        Boleta boleta = boletaService.findByIdEstudiante(id);
        return new ResponseEntity<>(boleta, HttpStatus.OK);
    }

    @PostMapping("/save")
    public Boleta guardarBoleta(@RequestBody Boleta boleta) {
        return boletaService.create(boleta);
    }

    @PutMapping("/update")
    public Boleta actualizarBoleta(@RequestBody Boleta boleta) {
        return boletaService.update(boleta);
    }

    @DeleteMapping("/delete/{idBoleta}")
    public ResponseEntity<String> eliminarBoleta(@PathVariable int idBoleta) {
        boletaService.delete(idBoleta);
        return new ResponseEntity<>("Boleta con ID " + idBoleta + " eliminada exitosamente", HttpStatus.OK);
    }

}
