package OTEC.OTEC.Services.AlumnosCursos;

import OTEC.OTEC.Models.AlumnosCursos.AlumnoCurso;

import OTEC.OTEC.Repositories.AlumnosCursos.IAlumnoCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoCursoService implements IAlumnoCursoService<AlumnoCurso> {
    @Autowired
    private IAlumnoCursoRepository iAlumnoCursoRepository;

    @Override
    public List<AlumnoCurso> findAll() {
        return iAlumnoCursoRepository.findAll();
    }

    @Override
    public Optional<AlumnoCurso> findById(Integer id) {
        return iAlumnoCursoRepository.findById(id);
    }

    @Override
    public AlumnoCurso create(AlumnoCurso alumnoCurso) {
        return iAlumnoCursoRepository.save(alumnoCurso);
    }

    @Override
    public AlumnoCurso update(AlumnoCurso alumnoCurso) {
        return iAlumnoCursoRepository.save(alumnoCurso);
    }

    @Override
    public void delete(Integer id) {
        iAlumnoCursoRepository.deleteById(id);

    }
}
