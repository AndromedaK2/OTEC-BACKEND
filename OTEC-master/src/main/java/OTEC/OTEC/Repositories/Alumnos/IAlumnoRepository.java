package OTEC.OTEC.Repositories.Alumnos;

import OTEC.OTEC.Models.Alumnos.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlumnoRepository extends JpaRepository<Alumno,Integer> {

    Optional<Alumno> findByNombres(String nombres);

    Optional<Alumno> findByRut(String rut);
}
