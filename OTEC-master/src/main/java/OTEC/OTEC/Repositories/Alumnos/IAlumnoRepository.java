package OTEC.OTEC.Repositories.Alumnos;

import OTEC.OTEC.Models.Alumnos.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno,Integer> {
}
