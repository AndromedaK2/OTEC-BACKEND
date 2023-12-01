package OTEC.OTEC.Services.Profesores;


import OTEC.OTEC.Models.Profesores.Profesor;

import java.util.List;
import java.util.Optional;

public interface IProfesorService<T> {
    List<Profesor> findAll();

    Optional<Profesor> findById(Integer id);

    Profesor create(Profesor profesor);

    Profesor update(Profesor profesor);

    void delete(Integer id);
}
