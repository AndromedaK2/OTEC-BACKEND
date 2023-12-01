package OTEC.OTEC.Services.AlumnosEstados;


import OTEC.OTEC.Models.AlumnosEstados.AlumnoEstado;

import java.util.List;
import java.util.Optional;

public interface IAlumnoEstadoService<T> {

    List<AlumnoEstado> findAll();

    Optional<AlumnoEstado> findById(Integer id);

    AlumnoEstado create(AlumnoEstado alumnoEstado);

    AlumnoEstado update(AlumnoEstado alumnoEstado);

    void delete(Integer id);
}
