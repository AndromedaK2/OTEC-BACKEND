package OTEC.OTEC.Repositories.Usuarios;

import OTEC.OTEC.Models.Usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
}
