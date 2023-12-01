package OTEC.OTEC.Services.EstadosAlumnos;


import OTEC.OTEC.Models.EstadosAlumnos.EstadosAlumno;

import java.util.List;
import java.util.Optional;

public interface IEstadoAlumnoService<T> {
    List<EstadosAlumno> findAll();

    Optional<EstadosAlumno> findById(Integer id);

    EstadosAlumno create(EstadosAlumno estadosAlumno);

    EstadosAlumno update(EstadosAlumno estadosAlumno);

    void delete(Integer id);
}
