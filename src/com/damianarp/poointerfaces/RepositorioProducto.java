package com.damianarp.poointerfaces;

import com.damianarp.poointerfaces.modelo.Producto;
import com.damianarp.poointerfaces.repositorio.Direccion;
import com.damianarp.poointerfaces.repositorio.OrdenablePaginableContableCrudRepositorio;
import com.damianarp.poointerfaces.repositorio.excepciones.*;
import com.damianarp.poointerfaces.repositorio.lista.ProductoListaRepositorio;

import java.util.List;

public class RepositorioProducto {
    public static void main(String[] args) {

        // Encerramos el código completo en un try-catch, ya que vamos a manejar excepciones.
        try {
            // Creamos una instancia de ProductoListaRepositorio por medio de la interface genérica OrdenablePaginableContableCrudRepositorio
            // y pasamos el tipo de dato Producto.
            OrdenablePaginableContableCrudRepositorio<Producto> repo = new ProductoListaRepositorio();

            // Insertamos nuevos registros.
            repo.crear(new Producto("Silla Gamer", 35000.0));
            repo.crear(new Producto("Escritorio", 23000.0));
            repo.crear(new Producto("Monitor", 57000.0));
            repo.crear(new Producto("Laptop", 157000.0));
            repo.crear(new Producto("Teclado", 1500.0));
            repo.crear(new Producto("Mouse", 500.0));

            // Listamos a los productos.
            List<Producto> productos = repo.listar();

            // Salto de línea.
            System.out.println("Lista completa de productos");

            // Iteramos la lista de productos.
            productos.forEach(System.out::println); // System.out::println es igual a p -> System.out.println(p)

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Productos paginados");

            // Paginamos para obtener un subconjunto de productos.
            List<Producto> paginable =  repo.listar(1,3); // El 1 se incluye, el 3 no se incluye.

            // Iteramos la lista de productos paginados.
            paginable.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Productos ordenados por descripción ascendente");

            // Orden ascendente por descripción
            List<Producto> ordenAscDescrip = repo.listar("descripcion", Direccion.ASC);

            // Iteramos la lista de productos ordenados por descripción de manera ascendente.
            ordenAscDescrip.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Productos ordenados por precio ascendente");

            // Orden ascendente por precio
            List<Producto> ordenAscPre = repo.listar("precio", Direccion.ASC);

            // Iteramos la lista de productos ordenados por precio de manera ascendente.
            ordenAscPre.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Productos ordenados por id descendiente");

            // Orden ascendente por id
            List<Producto> ordenDescId = repo.listar("id", Direccion.DESC);

            // Iteramos la lista de productos ordenados por id de manera descendiente.
            ordenDescId.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Productos ordenados por descripción descendiente");

            // Orden descendiente por nombre
            List<Producto> ordenDescDescrip = repo.listar("descripcion", Direccion.DESC);

            // Iteramos la lista de productos ordenados por descripción de manera descendiente.
            ordenDescDescrip.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Productos ordenados por precio descendiente");

            // Orden descendiente por precio
            List<Producto> ordenDescPre = repo.listar("precio", Direccion.DESC);

            // Iteramos la lista de productos ordenados por precio de manera descendiente.
            ordenDescPre.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Productos ordenados por id ascendente");

            // Orden descendiente por id
            List<Producto> ordenAscId = repo.listar("id", Direccion.ASC);

            // Iteramos la lista de productos ordenados por id de manera ascendente.
            ordenAscId.forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Producto editado");

            // Actualizamos el precio del id 1.
            Producto sillaGamerActualizar = new Producto("Silla Gamer" , 45000.0);
            sillaGamerActualizar.setId(1);

            // Editamos el precio.
            repo.editar(sillaGamerActualizar);

            // Buscamos el id del producto editado
            Producto sillaGamer = repo.obtenerPorId(1);

            // Mostramos el producto editado
            System.out.println(sillaGamer);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Producto eliminado");

            // Eliminamos el producto con id 3.
            repo.eliminar(3);

            // Iteramos la lista de productos.
            repo.listar().forEach(System.out::println);

            // Salto de línea
            System.out.println();

            // Separador
            System.out.println("Total de productos insertados");

            // Mostramos la cantidad de productos insertados.
            System.out.println(repo.total());

        // Atrapamos la excepción que pueda lanzar el método crear() al intentar escribir un registro duplicado.
        } catch (RegistroDuplicadoAccesoDatoException e) { // Siempre se atrapan primero las excepciones hijas.
            System.out.println("Excepción de Registro Duplicado -> " + e.getMessage()); // Imprimimos el mensaje de la excepción.
            e.printStackTrace(System.out); // Mostramos por consola el registro del stack donde se ha iniciado la excepción.

        // Atrapamos la excepción que pueda lanzar el método crear() al intentar escribir un registro.
        } catch (EscrituraAccesoDatoException e) { // Siempre se atrapan primero las excepciones hijas.
            System.out.println("Excepción de Escritura -> " + e.getMessage()); // Imprimimos el mensaje de la excepción.
            e.printStackTrace(System.out); // Mostramos por consola el registro del stack donde se ha iniciado la excepción.

        // Atrapamos la excepción que puedan lanzar los métodos obtenerPorId(), editar() y eliminar() al intentar leer un registro.
        } catch (LecturaAccesoDatoException e) { // Siempre se atrapan primero las excepciones hijas.
            System.out.println("Excepción de Lectura -> " + e.getMessage()); // Imprimimos el mensaje de la excepción.
            e.printStackTrace(System.out); // Mostramos por consola el registro del stack donde se ha iniciado la excepción.

        // Atrapamos cualquier otra excepción más genérica.
        } catch (AccesoDatoException e) { // Por último se atrapa la clase padre.
            System.out.println("Excepción genérica -> " + e.getMessage()); // Imprimimos el mensaje de la excepción.
            e.printStackTrace(System.out); // Mostramos por consola el registro del stack donde se ha iniciado la excepción.
        }
    }
}
