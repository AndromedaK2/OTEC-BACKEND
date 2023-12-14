package OTEC.OTEC.Services.Categorias;

import OTEC.OTEC.Models.Calificaciones.Calificacion;
import OTEC.OTEC.Models.Categorias.Categoria;
import OTEC.OTEC.Repositories.Calificaciones.ICalificacionRepository;
import OTEC.OTEC.Repositories.Categorias.ICategoriaRepository;
import OTEC.OTEC.Services.Calificaciones.ICalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService<Categoria> {

    @Autowired
    private ICategoriaRepository iCategoriaRepository;
    @Override
    public List<Categoria> findAll() {
        return iCategoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Integer id) {
        return iCategoriaRepository.findById(id);
    }

    @Override
    public Categoria create(Categoria categoria) {
        return iCategoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(Categoria categoria) {
        Categoria categoria1 = iCategoriaRepository.getById(categoria.getIdCategoria());
        categoria1.setDescripcion(categoria.getDescripcion());
        categoria1.setNombre(categoria.getNombre());
        return iCategoriaRepository.save(categoria1);
    }

    @Override
    public void delete(Integer id) {
        iCategoriaRepository.deleteById(id);

    }
}
