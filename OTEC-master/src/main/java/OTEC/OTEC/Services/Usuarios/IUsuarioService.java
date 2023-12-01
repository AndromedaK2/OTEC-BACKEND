package OTEC.OTEC.Services.Usuarios;


import OTEC.OTEC.Models.Usuarios.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService<T> {
    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);

    Usuario create(Usuario usuario);

    Usuario update(Usuario usuario);

    void delete(Integer id);
}
