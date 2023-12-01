package OTEC.OTEC.Services.Calificaciones;

import OTEC.OTEC.Models.Calificaciones.Calificacion;

import java.util.List;
import java.util.Optional;

public interface ICalificacionService<T> {
    List<Calificacion> findAll();

    Optional<Calificacion> findById(Integer id);

    Calificacion create(Calificacion calificacion);

    Calificacion update(Calificacion calificacion);

    void delete(Integer id);
}
