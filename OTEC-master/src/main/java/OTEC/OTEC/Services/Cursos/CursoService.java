package OTEC.OTEC.Services.Cursos;

import OTEC.OTEC.Models.Cursos.Curso;
import OTEC.OTEC.Repositories.Cursos.ICursoRepository;
import OTEC.OTEC.Services.Alumnos.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService implements ICursoService<Curso> {
    @Autowired
    private ICursoRepository iCursoRepository;
    @Autowired
    private IAlumnoService iAlumnoService;

    @Override
    public List<Curso> findAll() {
        return iCursoRepository.findAll();
    }

    @Override
    public Optional<Curso> findById(Integer id) {
        return iCursoRepository.findById(id);
    }

    public Optional<Curso> findByIdEstudiante(Integer id) {
        return iCursoRepository.findById(id);
    }

    @Override
    public Curso create(Curso curso) {
        return iCursoRepository.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        return iCursoRepository.save(curso);
    }

    @Override
    public void delete(Integer id) {
        iCursoRepository.deleteById(id);

    }
}
