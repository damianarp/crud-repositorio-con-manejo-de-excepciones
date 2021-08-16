package com.damianarp.poointerfaces.repositorio;

import java.util.List;

// Interface PaginableRepositorio con parámetro genérico T.
public interface PaginableRepositorio<T> {

    // Método para paginar la lista de elementos.
    List<T> listar(int desde, int hasta);
}
