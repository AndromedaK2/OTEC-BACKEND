package OTEC.OTEC.Controllers.Cursos;

import OTEC.OTEC.Models.Categorias.Categoria;
import OTEC.OTEC.Models.Cursos.Curso;
import OTEC.OTEC.Services.Cursos.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/all")
    public ResponseEntity<List<Curso>> findAll(){
        List<Curso> cursos = cursoService.findAll();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<Optional<Curso>> findbyId(@PathVariable int id){
        Optional<Curso> curso = cursoService.findById(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @GetMapping("/byIdEstudiante/{id}")
    public ResponseEntity<Optional<Curso>> findbyIdEstudiante(@PathVariable int id){
        Optional<Curso> curso = cursoService.findByIdEstudiante(id);
        return new ResponseEntity<>(curso, HttpStatus.OK);
    }

    @PostMapping("/save")
    public Curso create(@RequestBody Curso curso){
        return cursoService.create(curso);
    }

    @PutMapping("/update")
    public Curso update(@RequestBody Curso curso){
        return cursoService.update(curso);
    }

    @DeleteMapping("/delete/{idCurso}")
    public ResponseEntity<String> delete(@PathVariable int idCurso){
        cursoService.delete(idCurso);
        return new ResponseEntity<>("Curso con ID " + idCurso + " eliminado exitosamente", HttpStatus.OK);
    }
}
