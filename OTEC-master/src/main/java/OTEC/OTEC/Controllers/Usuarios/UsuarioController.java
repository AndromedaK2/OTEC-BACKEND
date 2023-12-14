package OTEC.OTEC.Controllers.Usuarios;

import OTEC.OTEC.Models.Usuarios.Usuario;
import OTEC.OTEC.Services.Usuarios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Usuario> obtenerRolPorId(@PathVariable("id") Integer idUsuario){
        Usuario rol = usuarioService.findById(idUsuario);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios( ){
        List<Usuario> usuarios = usuarioService.findAll();
        return new ResponseEntity<>(usuarios,HttpStatus.OK);
    }


    @PostMapping(value = "/register")
    public ResponseEntity<Usuario>  registrar(@RequestBody Usuario usuario) {
        Usuario usuarioCreado = usuarioService.register(usuario);
        return new ResponseEntity<>(usuarioCreado,HttpStatus.CREATED);
    }



    @PostMapping("/login/{nombre}/{pass}")
    public ResponseEntity<Usuario> login(@PathVariable("nombre") String nombre, @PathVariable("pass") String pass){
        Usuario usuario =  usuarioService.login(nombre,pass);
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }


    @PutMapping(value = "/actualizar")
    public ResponseEntity<Usuario> actualizar(@RequestBody Usuario usuario){
        Usuario user = usuarioService.update(usuario);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @DeleteMapping("/id/{id}")
    public ResponseEntity eliminarUsuarioPorId(@PathVariable("id") Integer idUser){
        usuarioService.delete(idUser);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



}
