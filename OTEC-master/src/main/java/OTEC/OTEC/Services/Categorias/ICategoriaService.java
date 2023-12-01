package OTEC.OTEC.Services.Categorias;


import OTEC.OTEC.Models.Categorias.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService<T> {
    List<Categoria> findAll();

    Optional<Categoria> findById(Integer id);

    Categoria create(Categoria categoria);

    Categoria update(Categoria categoria);

    void delete(Integer id);
}
