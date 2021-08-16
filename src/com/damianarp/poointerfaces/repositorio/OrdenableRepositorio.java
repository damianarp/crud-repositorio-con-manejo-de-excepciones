package com.damianarp.poointerfaces.repositorio;

import java.util.List;

// Interface OrdenableRepositorio con parámetro genérico T.
public interface OrdenableRepositorio<T> {

    // Método para ordenar la lista de elementos a través de un campo y una dirección.
    List<T> listar(String campo, Direccion dir);
}
