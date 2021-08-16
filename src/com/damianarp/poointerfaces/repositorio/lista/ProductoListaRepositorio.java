package com.damianarp.poointerfaces.repositorio.lista;


import com.damianarp.poointerfaces.modelo.Producto;
import com.damianarp.poointerfaces.repositorio.AbstractaListaRepositorio;
import com.damianarp.poointerfaces.repositorio.Direccion;

import java.util.*;

// Clase ProductoListaRepositorio que hereda de la clase abstracta AbstractaListaRepositorio con parámetro del tipo Producto.
public class ProductoListaRepositorio extends AbstractaListaRepositorio<Producto> {

    @Override
    public void editar(Producto producto) {
        // Primero debemos seleccionar el producto, lo buscamos con el método obtenerPorId().
        Producto p = obtenerPorId(producto.getId());
        // Luego modificamos los datos con el producto que recibimos por argumento.
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource); // Creamos una nueva lista a partir del dataSource para no modificar el dataSource original.
        // Ordenamos la lista, mediante la implementación lambda de la interface funcional Comparator.
        listaOrdenada.sort((a, b) -> { // a y b son del tipo Cliente

            // Ordenamos según la dirección.
            int resultado = 0; // Inicializamos el resultado en 0.
            // ORDEN ASCENDENTE
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, a, b);
                // ORDEN DESCENDENTE
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, b, a);
            }
            return resultado;
        });
        // Retorna la lista ordenada.
        return listaOrdenada;
    }

    // Método para ordenar los productos.
    public static int ordenar(String campo, Producto a, Producto b) {
        // Ordenamos según la dirección.
        int resultado = 0; // Inicializamos el resultado en 0.
        // Usamos un switch para ordenar según id, descripción o precio.
        switch (campo) {
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "descripcion" ->
                    resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" ->
                    resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
