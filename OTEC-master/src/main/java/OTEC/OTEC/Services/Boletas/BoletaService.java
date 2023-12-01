package OTEC.OTEC.Services.Boletas;

import OTEC.OTEC.Models.Boletas.Boleta;
import OTEC.OTEC.Repositories.Boletas.IBoletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoletaService implements IBoletaService<Boleta> {
    @Autowired
    private IBoletaRepository iBoletaRepository;
    @Override
    public List<Boleta> findAll() {
        return iBoletaRepository.findAll();
    }

    @Override
    public Optional<Boleta> findById(Integer id) {
        return iBoletaRepository.findById(id);
    }

    @Override
    public Boleta create(Boleta boleta) {
        return iBoletaRepository.save(boleta);
    }

    @Override
    public Boleta update(Boleta boleta) {
        return iBoletaRepository.save(boleta);
    }

    @Override
    public void delete(Integer id) {
        iBoletaRepository.deleteById(id);

    }
}
