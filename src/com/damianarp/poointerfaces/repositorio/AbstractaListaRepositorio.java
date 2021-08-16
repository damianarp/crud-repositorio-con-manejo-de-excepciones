package com.damianarp.poointerfaces.repositorio;

import com.damianarp.poointerfaces.modelo.BaseEntidad;

import java.util.*;

// Clase abstracta AbstractaListaRepositorio con parámetro genérico T que hereda de BaseEntidad
// e implementa la interface OrdenablePaginableContableCrudRepositorio con parámetro genérico T.
public abstract class AbstractaListaRepositorio<T extends BaseEntidad> implements OrdenablePaginableContableCrudRepositorio<T> {

    protected List<T> dataSource; // Lista donde se van a almacenar los elementos.

    public AbstractaListaRepositorio() {
        this.dataSource = new ArrayList<>(); // Inicializamos la lista en el constructor vacío.
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T obtenerPorId(Integer id) {
        T resultado = null; // Inicializamos el resultado de la búsqueda del id como nulo por defecto.
        // Iteramos la lista de elementos para obtener el id.
        for(T t : this.dataSource) {
            // Si el id del elemento de la lista no es nulo y es igual al id introducido como parámetro en el método,
            // significa que el resultado es igual a 't', hacemos un break para salirnos del bucle y retornamos el resultado.
            if(t.getId() != null && t.getId().equals(id)){
                resultado = t;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
        // Al método remove() aplicado a la lista, le pasamos como argumento el cliente (id obtenido con el método obtenerPorId), para eliminar el registro.
        this.dataSource.remove(this.obtenerPorId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde,hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
