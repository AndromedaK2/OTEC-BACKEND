package OTEC.OTEC.Services.Roles;

import OTEC.OTEC.Models.Roles.Rol;
import OTEC.OTEC.Repositories.Roles.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Optional<Rol> findById(Integer id) {
        return iRolRepository.findById(id);
    }

    @Override
    public Rol create(Rol rol) {
        return iRolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        return iRolRepository.save(rol);
    }

    @Override
    public void delete(Integer id) {
        iRolRepository.deleteById(id);

    }
}
