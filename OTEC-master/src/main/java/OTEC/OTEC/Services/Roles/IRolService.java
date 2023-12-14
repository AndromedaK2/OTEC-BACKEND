package OTEC.OTEC.Services.Roles;

import OTEC.OTEC.Models.Roles.Rol;

import java.util.List;
import java.util.Optional;

public interface IRolService<T> {
    List<Rol> findAll();

    Rol findById(Integer id);

    Rol findByDescription(String descripcion);

}
