package OTEC.OTEC.Services.AlumnosCursos;


import OTEC.OTEC.Models.AlumnosCursos.AlumnoCurso;

import java.util.List;
import java.util.Optional;

public interface IAlumnoCursoService<T> {

    List<AlumnoCurso> findAll();

    Optional<AlumnoCurso> findById(Integer id);

    AlumnoCurso create(AlumnoCurso alumnoCurso);

    AlumnoCurso update(AlumnoCurso alumnoCurso);

    void delete(Integer id);
}
