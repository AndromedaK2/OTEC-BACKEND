package OTEC.OTEC.Repositories.Calificaciones;

import OTEC.OTEC.Models.Calificaciones.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICalificacionRepository extends JpaRepository<Calificacion,Integer> {

    Optional<Calificacion> findByIdAlumno(Integer id);
}
