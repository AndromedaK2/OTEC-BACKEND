package OTEC.OTEC.Services.Horarios;

import OTEC.OTEC.Models.Horarios.Horario;
import OTEC.OTEC.Repositories.Horarios.IHorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService implements IHorarioService<Horario> {

    @Autowired
    private IHorarioRepository iHorarioRepository;
    @Override
    public List<Horario> findAll() {
        return iHorarioRepository.findAll();
    }

    @Override
    public Optional<Horario> findById(Integer id) {
        return iHorarioRepository.findById(id);
    }

    @Override
    public Horario create(Horario horario) {
        return iHorarioRepository.save(horario);
    }

    @Override
    public Horario update(Horario horario) {
        return iHorarioRepository.save(horario);
    }

    @Override
    public void delete(Integer id) {
        iHorarioRepository.deleteById(id);

    }
}
