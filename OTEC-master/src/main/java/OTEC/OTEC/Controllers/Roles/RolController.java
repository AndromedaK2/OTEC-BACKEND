package OTEC.OTEC.Controllers.Roles;

import OTEC.OTEC.Models.Roles.Rol;
import OTEC.OTEC.Services.Roles.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable("id") Integer idRol){
        Rol rol = rolService.findById(idRol);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @GetMapping(value = "/descripcion/{descripcion}")
    public ResponseEntity<Rol> obtenerRolPorDescripcion(@PathVariable("descripcion") String descripcion){
        Rol rol = rolService.findByDescription(descripcion);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }


    @GetMapping()
    public ResponseEntity<List<Rol>> obtenerRoles(){
        List<Rol> roles = rolService.findAll();
        return new ResponseEntity<>(roles,HttpStatus.OK);
    }

}
