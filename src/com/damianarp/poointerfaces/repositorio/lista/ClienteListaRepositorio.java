package com.damianarp.poointerfaces.repositorio.lista;

import com.damianarp.poointerfaces.modelo.Cliente;
import com.damianarp.poointerfaces.repositorio.AbstractaListaRepositorio;
import com.damianarp.poointerfaces.repositorio.Direccion;

import java.util.*;

// Clase ClienteListRepositorio que hereda de la clase abstracta AbstractaListaRepositorio con parámetro del tipo Cliente.
public class ClienteListaRepositorio extends AbstractaListaRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) {
        // Primero debemos seleccionar al cliente, lo buscamos con el método obtenerPorId().
        Cliente cli = this.obtenerPorId(cliente.getId());
        // Luego modificamos los datos con el cliente que recibimos por argumento.
        cli.setNombre(cliente.getNombre());
        cli.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource); // Creamos una nueva lista a partir del dataSource para no modificar el dataSource original.
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

    // Método para ordenar los clientes
    public static int ordenar(String campo, Cliente a, Cliente b) {
        // Ordenamos según la dirección.
        int resultado = 0; // Inicializamos el resultado en 0.
        // Usamos un switch para ordenar según id, nombre o apellido.
        switch (campo) {
            case "id" ->
                    resultado = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }
}
