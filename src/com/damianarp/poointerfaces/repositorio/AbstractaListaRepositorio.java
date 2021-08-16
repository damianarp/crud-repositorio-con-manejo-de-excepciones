package com.damianarp.poointerfaces.repositorio;

import com.damianarp.poointerfaces.modelo.BaseEntidad;
import com.damianarp.poointerfaces.repositorio.excepciones.*;

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

    // Método para obtener el id. Al lanzar una LecturaAccesoDatoException, debemos propagarla en la firma del método.
    @Override
    public T obtenerPorId(Integer id) throws LecturaAccesoDatoException {
        // Validamos si el id es nulo o es menor o igual a cero, y en ese caso lanzamos la excepción LecturaAccesoDatoException.
        if (id == null || id <= 0) {
            throw new LecturaAccesoDatoException("Id inválido. Debe ser mayor que 0.");
        }
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
        // Si el resultado no se encuentra, lanzamos la excepción LecturaAccesoDatoException.
        if (resultado == null) {
            throw new LecturaAccesoDatoException("No existe el registro con el id: " + id);
        }
        return resultado;
    }

    // Método para crear un elemento. Al lanzar una EscrituraAccesoDatoException, debemos propagarla en la firma del método.
    @Override
    public void crear(T t) throws EscrituraAccesoDatoException {
        // Si el objeto es null se lanza la EscrituraAccesoDatoException.
        if(t == null) {
            throw new EscrituraAccesoDatoException("Error al insertar un objeto null.");
        }
        // Comprobamos si la lista ya contiene al objeto (para que no lo duplique). Si lo contiene se lanza una EscrituraAccesoDatoException.
        if (this.dataSource.contains(t)) {
            throw new RegistroDuplicadoAccesoDatoException("Error! El registro con id: " + t.getId() + " ya existe en el repositorio.");
        }
        this.dataSource.add(t);
    }

    // Método para eliminar por el id. Al lanzar una LecturaAccesoDatoException, debemos propagarla en la firma del método.
    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {
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
