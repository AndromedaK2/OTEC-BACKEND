package OTEC.OTEC.Services.Categorias;

import OTEC.OTEC.Models.Calificaciones.Calificacion;
import OTEC.OTEC.Models.Categorias.Categoria;
import OTEC.OTEC.Repositories.Calificaciones.ICalificacionRepository;
import OTEC.OTEC.Services.Calificaciones.ICalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICalificacionService<Categoria> {

    @Autowired
    private ICalificacionRepository iCalificacionRepository;
    @Override
    public List<Calificacion> findAll() {
        return iCalificacionRepository.findAll();
    }

    @Override
    public Optional<Calificacion> findById(Integer id) {
        return iCalificacionRepository.findById(id);
    }

    @Override
    public Calificacion create(Calificacion calificacion) {
        return iCalificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion update(Calificacion calificacion) {
        return iCalificacionRepository.save(calificacion);
    }

    @Override
    public void delete(Integer id) {
        iCalificacionRepository.deleteById(id);

    }
}
