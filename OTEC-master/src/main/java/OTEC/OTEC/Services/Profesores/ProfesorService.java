package OTEC.OTEC.Services.Profesores;

import OTEC.OTEC.Models.Profesores.Profesor;
import OTEC.OTEC.Repositories.Profesores.IProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService implements IProfesorService<Profesor> {
    @Autowired
    private IProfesorRepository iProfesorRepository;

    @Override
    public List<Profesor> findAll() {
        return iProfesorRepository.findAll();
    }

    @Override
    public Optional<Profesor> findById(Integer id) {
        return iProfesorRepository.findById(id);
    }

    @Override
    public Profesor create(Profesor profesor) {
        return iProfesorRepository.save(profesor);
    }

    @Override
    public Profesor update(Profesor profesor) {
        return iProfesorRepository.save(profesor);
    }

    @Override
    public void delete(Integer id) {
        iProfesorRepository.deleteById(id);

    }
}
