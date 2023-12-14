package OTEC.OTEC.Repositories.Roles;

import OTEC.OTEC.Models.Roles.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRolRepository extends JpaRepository<Rol,Integer> {

    Optional<Rol> findRolByDescripcion(String descripcion);
}
