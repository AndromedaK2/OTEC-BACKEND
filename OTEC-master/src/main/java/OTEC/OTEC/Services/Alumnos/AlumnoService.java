package OTEC.OTEC.Services.Alumnos;

import OTEC.OTEC.Models.Alumnos.Alumno;
import OTEC.OTEC.Repositories.Alumnos.IAlumnoRepository;
import OTEC.OTEC.Services.Alumnos.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AlumnoService implements IAlumnoService<Alumno> {

    @Autowired
    private IAlumnoRepository iAlumnoRepository;
    @Override
    public List<Alumno> findAll() {
        return iAlumnoRepository.findAll();
    }

    @Override
    public Optional<Alumno> findById(Integer id) {
        return iAlumnoRepository.findById(id);
    }

    @Override
    public Alumno create(Alumno alumno) {
        return iAlumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Alumno alumno) {
        return iAlumnoRepository.save(alumno);
    }

    @Override
    public void delete(Integer id) {
        iAlumnoRepository.deleteById(id);

    }
}
