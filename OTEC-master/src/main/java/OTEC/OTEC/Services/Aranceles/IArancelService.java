package OTEC.OTEC.Services.Aranceles;


import OTEC.OTEC.Models.Aranceles.Arancel;

import java.util.List;
import java.util.Optional;

public interface IArancelService<T> {
    List<Arancel> findAll();

    Optional<Arancel> findById(Integer id);

    Arancel create(Arancel arancel);

    Arancel update(Arancel arancel);

    void delete(Integer id);
}
