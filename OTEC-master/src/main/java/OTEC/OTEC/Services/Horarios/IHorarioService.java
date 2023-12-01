package OTEC.OTEC.Services.Horarios;


import OTEC.OTEC.Models.Horarios.Horario;

import java.util.List;
import java.util.Optional;

public interface IHorarioService<T> {
    List<Horario> findAll();

    Optional<Horario> findById(Integer id);

    Horario create(Horario horario);

    Horario update(Horario horario);

    void delete(Integer id);
}
