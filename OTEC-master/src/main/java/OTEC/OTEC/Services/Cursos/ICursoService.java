package OTEC.OTEC.Services.Cursos;


import OTEC.OTEC.Models.Cursos.Curso;

import java.util.List;
import java.util.Optional;

public interface ICursoService<T> {
    List<Curso> findAll();

    Optional<Curso> findById(Integer id);

    Curso create(Curso curso);

    Curso update(Curso curso);

    void delete(Integer id);
}
