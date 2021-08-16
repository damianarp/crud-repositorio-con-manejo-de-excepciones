package com.damianarp.poointerfaces.repositorio;

import com.damianarp.poointerfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;

// Interface CrudRepositorio con parámetro genérico T.
public interface CrudRepositorio<T> {
    // Debemos propagar la excepción más genérica que utiliza cada método.
    // El método utiliza LecturaAccesoDatoException que hereda de AccesoDatoException (la más genérica).

    // Método para listar todos los elementos de la lista.
    List<T> listar();

    // Método para obtener el detalle de un elemento por el id.
    T obtenerPorId(Integer id) throws AccesoDatoException;

    // Método para crear un elemento.
    void crear(T t) throws AccesoDatoException;

    // Método para editar un elemento.
    void editar(T t) throws AccesoDatoException;

    // Método para eliminar un elemento por su id.
    void eliminar(Integer id) throws AccesoDatoException;
}
