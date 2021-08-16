package com.damianarp.poointerfaces;

import com.damianarp.poointerfaces.modelo.Cliente;
import com.damianarp.poointerfaces.repositorio.*;
import com.damianarp.poointerfaces.repositorio.excepciones.AccesoDatoException;
import com.damianarp.poointerfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import com.damianarp.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import com.damianarp.poointerfaces.repositorio.lista.ClienteListaRepositorio;

import java.util.List;

public class RepositorioCliente {
    public static void main(String[] args) {

        // Encerramos el código completo en un try-catch, ya que vamos a manejar excepciones.
        try {
            // Creamos una instancia de ClienteListaRepositorio por medio de la interface genérica OrdenablePaginableContableCrudRepositorio y pasamos el tipo de dato Cliente.
            OrdenablePaginableContableCrudRepositorio<Cliente> repo = new ClienteListaRepositorio();

            // Insertamos nuevos registros.
            repo.crear(new Cliente("Úrsula", "Mendez"));
            repo.crear(new Cliente("Marisa", "Gutierrez"));
            repo.crear(new Cliente("Pedro", "Arancibia"));
            repo.crear(new Cliente("Ramiro", "Suárez"));
            repo.crear(null);

            // Listamos a los clientes.
            List<Cliente> clientes = repo.listar();

            // Salto de línea
            System.out.println("Lista completa de clientes");

            // Iteramos la lista de clientes
            clientes.forEach(System.out::println); // System.out::println es igual a c -> System.out.println(c)

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Clientes paginados");

            // Paginamos para obtener un subconjunto de clientes.
            List<Cliente> paginable = repo.listar(1, 3); // El 1 se incluye, el 3 no se incluye.

            // Iteramos la lista de clientes paginados.
            paginable.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Clientes ordenados por nombre ascendente");

            // Orden ascendente por nombre
            List<Cliente> ordenAscNom = repo.listar("nombre", Direccion.ASC);

            // Iteramos la lista de clientes ordenados por nombre de manera ascendente.
            ordenAscNom.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Clientes ordenados por apellido ascendente");

            // Orden ascendente por apellido
            List<Cliente> ordenAscApe = repo.listar("apellido", Direccion.ASC);

            // Iteramos la lista de clientes ordenados por apellido de manera ascendente.
            ordenAscApe.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Clientes ordenados por id descendiente");

            // Orden ascendente por id
            List<Cliente> ordenDescId = repo.listar("id", Direccion.DESC);

            // Iteramos la lista de clientes ordenados por id de manera descendiente.
            ordenDescId.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Clientes ordenados por nombre descendiente");

            // Orden descendiente por nombre
            List<Cliente> ordenDescNom = repo.listar("nombre", Direccion.DESC);

            // Iteramos la lista de clientes ordenados por nombre de manera descendiente.
            ordenDescNom.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Clientes ordenados por apellido descendiente");

            // Orden descendiente por apellido
            List<Cliente> ordenDescApe = repo.listar("apellido", Direccion.DESC);

            // Iteramos la lista de clientes ordenados por apellido de manera descendiente.
            ordenDescApe.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Clientes ordenados por id ascendente");

            // Orden descendiente por id
            List<Cliente> ordenAscId = repo.listar("id", Direccion.ASC);

            // Iteramos la lista de clientes ordenados por id de manera ascendente.
            ordenAscId.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Cliente editado");

            // Actualizamos el apellido del id 1.
            Cliente ursulaActualizar = new Cliente("Úrsula", "Dominguez");
            ursulaActualizar.setId(1);

            // Editamos el apellido.
            repo.editar(ursulaActualizar);

            // Buscamos el id del cliente editado.
            Cliente ursula = repo.obtenerPorId(1);

            // Mostramos el cliente editado
            System.out.println(ursula);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Cliente eliminado");

            // Eliminamos el cliente con id 3.
            repo.eliminar(3);

            // Iteramos la lista de clientes.
            repo.listar().forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Total de clientes registrados");

            // Mostramos la cantidad de clientes registrados.
            System.out.println(repo.total());

        // Atrapamos la excepción que puedan lanzar los métodos obtenerPorId(), editar() y eliminar() al intentar leer un registro.
        } catch (LecturaAccesoDatoException e) { // Siempre se atrapan primero las excepciones hijas.
            System.out.println("Excepción de Lectura -> " + e.getMessage()); // Imprimimos el mensaje de la excepción.
            e.printStackTrace(System.out); // Mostramos por consola el registro del stack donde se ha iniciado la excepción.

        // Atrapamos la excepción que pueda lanzar el método crear() al intentar escribir un registro.
        } catch (EscrituraAccesoDatoException e) { // Siempre se atrapan primero las excepciones hijas.
            System.out.println("Excepción de Escritura -> " + e.getMessage()); // Imprimimos el mensaje de la excepción.
            e.printStackTrace(System.out); // Mostramos por consola el registro del stack donde se ha iniciado la excepción.

        // Atrapamos cualquier otra excepción más genérica.
        } catch (AccesoDatoException e) { // Por último se atrapa la clase padre.
            System.out.println("Excepción genérica -> " + e.getMessage()); // Imprimimos el mensaje de la excepción.
            e.printStackTrace(System.out); // Mostramos por consola el registro del stack donde se ha iniciado la excepción.
        }
    }
}
