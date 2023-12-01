package OTEC.OTEC.Repositories.Cursos;

import OTEC.OTEC.Models.Cursos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso,Integer> {
}
