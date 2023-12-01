package OTEC.OTEC.Services.Usuarios;

import OTEC.OTEC.Models.Usuarios.Usuario;
import OTEC.OTEC.Repositories.Usuarios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService<Usuario> {
    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Override
    public List<Usuario> findAll() {
        return iUsuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return iUsuarioRepository.findById(id);
    }

    @Override
    public Usuario create(Usuario usuario) {
        return iUsuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return iUsuarioRepository.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        iUsuarioRepository.deleteById(id);

    }
}
