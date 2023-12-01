package OTEC.OTEC.Services.Aranceles;


import OTEC.OTEC.Models.Aranceles.Arancel;
import OTEC.OTEC.Repositories.Aranceles.IArancelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArancelService  implements IArancelService<Arancel> {
    @Autowired
    private IArancelRepository iArancelRepository;

    @Override
    public List<Arancel> findAll() {
        return iArancelRepository.findAll();
    }

    @Override
    public Optional<Arancel> findById(Integer id) {
        return iArancelRepository.findById(id);
    }

    @Override
    public Arancel create(Arancel arancel) {
        return iArancelRepository.save(arancel);
    }

    @Override
    public Arancel update(Arancel arancel) {
        return iArancelRepository.save(arancel);
    }

    @Override
    public void delete(Integer id) {

        iArancelRepository.deleteById(id);
    }
}
