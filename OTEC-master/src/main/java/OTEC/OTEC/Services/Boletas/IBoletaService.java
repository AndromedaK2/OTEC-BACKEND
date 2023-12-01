package OTEC.OTEC.Services.Boletas;


import OTEC.OTEC.Models.Boletas.Boleta;

import java.util.List;
import java.util.Optional;

public interface IBoletaService<T> {
    List<Boleta> findAll();

    Optional<Boleta> findById(Integer id);

    Boleta create(Boleta boleta);

    Boleta update(Boleta boleta);

    void delete(Integer id);
}
