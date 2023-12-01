package OTEC.OTEC.Services.Alumnos;

import OTEC.OTEC.Models.Alumnos.Alumno;

import java.util.List;
import java.util.Optional;

public interface IAlumnoService<T>{
    List<Alumno> findAll();

    Optional<Alumno> findById(Integer id);

    Alumno create(Alumno alumno);

    Alumno update(Alumno alumno);

    void delete(Integer id);

}
