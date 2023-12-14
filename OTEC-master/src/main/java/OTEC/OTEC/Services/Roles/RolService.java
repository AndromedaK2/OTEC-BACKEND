package OTEC.OTEC.Services.Roles;

import OTEC.OTEC.Models.Roles.Rol;
import OTEC.OTEC.Repositories.Roles.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolService<Rol> {
    @Autowired
    private IRolRepository iRolRepository;

    @Override
    public List<Rol> findAll() {
        return iRolRepository.findAll();
    }

    @Override
    public Rol findById(Integer id) {
        Optional<Rol> rol =  iRolRepository.findById(id);
        if(rol.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Rol : %s no encontrado", rol));
        }
        return rol.get();
    }

    @Override
    public Rol findByDescription(String descripcion) {
        Optional<Rol> rol =  iRolRepository.findRolByDescripcion(descripcion);
        if(rol.isEmpty()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Rol : %s no encontrado", rol));
        }
        return rol.get();
    }

}
