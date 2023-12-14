package OTEC.OTEC.Services.Usuarios;

import OTEC.OTEC.Models.Usuarios.Register;
import OTEC.OTEC.Models.Usuarios.Usuario;
import OTEC.OTEC.Repositories.Usuarios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public Usuario findById(Integer id) {
        Optional<Usuario> usuario = iUsuarioRepository.findById(id);
        if(usuario.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Usuario : %s no encontrado", id));
        }
        return usuario.get();
    }

    @Override
    public Usuario register(Register register) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(register.nombre());
        usuario.setRut(register.rut());
        usuario.setPass(register.pass());
        usuario.setCorreo(register.correo());
        usuario.setTelefono(register.telefono());
        usuario.setIdRol(register.idRol());
        return iUsuarioRepository.save(usuario);
    }

    @Override
    public Usuario login(String nombre, String pass) {
        Optional<Usuario> usuario =  iUsuarioRepository.login(nombre, pass);
        if(usuario.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Usuario : %s no encontrado", nombre));
        }
        return usuario.get();
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
