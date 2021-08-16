package com.damianarp.poointerfaces.repositorio;

import java.util.List;

// Interface CrudRepositorio con parámetro genérico T.
public interface CrudRepositorio<T> {

    // Método para listar todos los elementos de la lista.
    List<T> listar();

    // Método para obtener el detalle de un elemento por el id.
    T obtenerPorId(Integer id);

    // Método para crear un elemento.
    void crear(T t);

    // Método para editar un elemento.
    void editar(T t);

    // Método para eliminar un elemento por su id.
    void eliminar(Integer id);
}
