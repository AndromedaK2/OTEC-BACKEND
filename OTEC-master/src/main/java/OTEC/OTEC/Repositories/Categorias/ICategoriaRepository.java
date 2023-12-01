package OTEC.OTEC.Repositories.Categorias;

import OTEC.OTEC.Models.Categorias.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria,Integer> {
}
