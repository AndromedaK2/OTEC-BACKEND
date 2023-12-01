package OTEC.OTEC.Services.AlumnosEstados;

import OTEC.OTEC.Models.AlumnosEstados.AlumnoEstado;
import OTEC.OTEC.Repositories.AlumnosEstados.IAlumnoEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoEstadoService implements IAlumnoEstadoService<AlumnoEstado>{
    @Autowired
    private IAlumnoEstadoRepository iAlumnoEstadoRepository;
    @Override
    public List<AlumnoEstado> findAll() {
        return iAlumnoEstadoRepository.findAll();
    }

    @Override
    public Optional<AlumnoEstado> findById(Integer id) {
        return iAlumnoEstadoRepository.findById(id);
    }

    @Override
    public AlumnoEstado create(AlumnoEstado alumnoEstado) {
        return iAlumnoEstadoRepository.save(alumnoEstado);
    }

    @Override
    public AlumnoEstado update(AlumnoEstado alumnoEstado) {
        return iAlumnoEstadoRepository.save(alumnoEstado);
    }

    @Override
    public void delete(Integer id) {
        iAlumnoEstadoRepository.deleteById(id);

    }
}
