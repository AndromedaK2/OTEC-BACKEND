package OTEC.OTEC.Services.EstadosAlumnos;

import OTEC.OTEC.Models.EstadosAlumnos.EstadosAlumno;
import OTEC.OTEC.Repositories.EstadosAlumnos.IEstadoAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoAlumnoService implements IEstadoAlumnoService<EstadosAlumno> {

    @Autowired
    private IEstadoAlumnoRepository iEstadoAlumnoRepository;
    @Override
    public List<EstadosAlumno> findAll() {
        return iEstadoAlumnoRepository.findAll();
    }

    @Override
    public Optional<EstadosAlumno> findById(Integer id) {
        return iEstadoAlumnoRepository.findById(id);
    }

    @Override
    public EstadosAlumno create(EstadosAlumno estadosAlumno) {
        return iEstadoAlumnoRepository.save(estadosAlumno);
    }

    @Override
    public EstadosAlumno update(EstadosAlumno estadosAlumno) {
        return iEstadoAlumnoRepository.save(estadosAlumno);
    }

    @Override
    public void delete(Integer id) {
        iEstadoAlumnoRepository.deleteById(id);

    }
}
