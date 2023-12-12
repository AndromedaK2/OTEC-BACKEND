package OTEC.OTEC.Controllers.Categorias;

import OTEC.OTEC.Models.Categorias.Categoria;
import OTEC.OTEC.Services.Categorias.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/all")
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categorias = categoriaService.findAll();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<Optional<Categoria>> findbyId(@PathVariable int id){
        Optional<Categoria> categoria = categoriaService.findById(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    @PostMapping("/save")
    public Categoria create(@RequestBody Categoria categoria){
        return categoriaService.create(categoria);
    }

    @PutMapping("/update")
    public Categoria update(@RequestBody Categoria categoria){
        return categoriaService.update(categoria);
    }

    @DeleteMapping("/delete/{idCategoria}")
    public ResponseEntity<String> delete(@PathVariable int idCategoria){
        categoriaService.delete(idCategoria);
        return new ResponseEntity<>("Categoría con ID " + idCategoria + " eliminada exitosamente", HttpStatus.OK);
    }
}
