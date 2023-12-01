package OTEC.OTEC.Services.Roles;

import OTEC.OTEC.Models.Roles.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService<T> {
    List<Rol> findAll();

    Optional<Rol> findById(Integer id);

    Rol create(Rol rol);

    Rol update(Rol rol);

    void delete(Integer id);
}
