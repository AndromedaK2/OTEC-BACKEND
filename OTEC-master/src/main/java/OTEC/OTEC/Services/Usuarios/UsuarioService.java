package OTEC.OTEC.Services.Usuarios;

import OTEC.OTEC.Models.Usuarios.Register;
import OTEC.OTEC.Models.Usuarios.Usuario;
import OTEC.OTEC.Repositories.Usuarios.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Usuario : %s no encontrado", id));
        }
        return usuario.get();
    }

    @Override
    public Usuario register(Register register) {
        Usuario usuario = new Usuario();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String passEncrypted =  bCryptPasswordEncoder.encode(register.pass());
        usuario.setNombreUsuario(register.nombre());
        usuario.setRut(register.rut());
        usuario.setPass(passEncrypted);
        usuario.setNombreUsuario(register.nombre());
        usuario.setRut(register.rut());
        usuario.setCorreo(register.correo());
        usuario.setTelefono(register.telefono());
        usuario.setIdRol(register.idRol());
        return iUsuarioRepository.save(usuario);
    }

    @Override
    public Usuario login(String nombre, String pass) {

        Optional<Usuario> usuario = iUsuarioRepository.findByNombreUsuario(nombre);
        if(usuario.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Usuario : %s no encontrado", nombre));
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(!bCryptPasswordEncoder.matches( pass,usuario.get().getPass())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Usuario : credenciales incorrectas"));
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
