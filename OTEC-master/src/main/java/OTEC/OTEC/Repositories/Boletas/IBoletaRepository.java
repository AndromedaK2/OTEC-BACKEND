package OTEC.OTEC.Repositories.Boletas;

import OTEC.OTEC.Models.Boletas.Boleta;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBoletaRepository extends JpaRepository<Boleta, Integer> {
}
