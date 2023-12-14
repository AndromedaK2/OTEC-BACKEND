package OTEC.OTEC.Services.Usuarios;


import OTEC.OTEC.Models.Usuarios.Register;
import OTEC.OTEC.Models.Usuarios.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService<T> {
    List<Usuario> findAll();

    Usuario findById(Integer id);

    Usuario register(Register register);

    Usuario login(String nombre, String password);

    Usuario update(Usuario usuario);

    void delete(Integer id);
}
