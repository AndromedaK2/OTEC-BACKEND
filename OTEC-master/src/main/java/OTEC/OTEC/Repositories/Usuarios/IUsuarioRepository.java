package OTEC.OTEC.Repositories.Usuarios;

import OTEC.OTEC.Models.Usuarios.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

    @Query(value = "SELECT u FROM Usuario u WHERE LOWER(u.nombreUsuario) = LOWER(:nombreUsuario) and LOWER(u.pass) = LOWER(:pass)")
    Optional<Usuario> login(@Param("nombreUsuario") String nombreUsuario, @Param("pass") String pass);

}
