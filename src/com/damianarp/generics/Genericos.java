package com.damianarp.generics;

import com.damianarp.poointerfaces.modelo.Cliente;
import com.damianarp.poointerfaces.modelo.ClientePremium;

import java.util.*;

public class Genericos {
    public static void main(String[] args) {

        // Creamos una lista genérica de clientes.
        List<Cliente> clientes = new ArrayList<>();

        // Agregamos nuevos clientes.
        clientes.add(new Cliente("Andrés", "Guzmán"));

        // Obtenemos el cliente.
        Cliente andres = clientes.get(0);

        // También podemos obtener el cliente de esta forma.
        // Cliente andres = clientes.iterator().next(); // Obtenemos el primer elemento.

        // Creamos un arreglo de clientes.
        Cliente[] clientesArreglo = {new Cliente("Andrés", "Guzmán"),
                                    new Cliente("Marcela", "Zabaleta")};

        // Creamos un arreglo de enteros.
        Integer[] enterosArreglo = {1, 2, 3};

        // Creamos una lista de clientes para que haga la conversión de arreglo a lista y le pasamos el arreglo de clientes.
        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);

        // Creamos una lista de enteros para que haga la conversión de arreglo a lista y le pasamos el arreglo de enteros.
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);

        // Separador
        System.out.println("Lista de nombres");

        // Creamos una lista de nombres para que haga la conversión de arreglo a lista y le pasamos un arreglo de nombres al vuelo.
        // Pero además, le pasamos como segundo parámetro, el arreglo de enteros.
        // Primero se va a imprimir la lista de enteros.
        List<String> nombresLista = fromArrayToList(new String[]{"Pamela", "David", "Mario"}, enterosArreglo);

        // Luego se imprime la lista de nombres.
        nombresLista.forEach(System.out::println);

        // Salto de línea
        System.out.println();

        // Separador
        System.out.println("Lista de clientes Premium");

        // Creamos una lista de clientes premium para que haga la conversión de arreglo a lista.
        List<ClientePremium> clientesPremiumLista = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Pedro", "Aznar")});

        // Luego se imprime la lista de clientes premium.
        clientesPremiumLista.forEach(System.out::println);

        // Salto de línea
        System.out.println();

        // Separador
        System.out.println("Lista de clientes");

        // Imprimimos la lista de clientes.
        clientesLista.forEach(System.out::println);

        // Salto de línea
        System.out.println();

        // Separador
        System.out.println("Lista de enteros");

        // Imprimimos la lista de enteros.
        enterosLista.forEach(System.out::println);

        // Salto de línea
        System.out.println();

        // Separador
        System.out.println("Lista de clientes con método imprimirClientes");

        // Imprimimos los clientes con el método imprimirClientes().
        imprimirClientes(clientes);

        // Salto de línea
        System.out.println();

        // Imprimimos otra lista de clientes con el método imprimirClientes().
        imprimirClientes(clientesLista);

        // Salto de línea
        System.out.println();

        // Imprimimos la lista de clientes Premium con el método imprimirClientes().
        imprimirClientes(clientesPremiumLista);

        // Salto de línea
        System.out.println();

        // Separador
        System.out.println("Máximo de 1, 9, 4 es:");

        // Imprimimos el máximo.
        System.out.println(maximo(1, 9, 4));

        // Salto de línea
        System.out.println();

        // Separador
        System.out.println("Máximo de 3.9, 9.2, 5.4 es:");

        // Imprimimos el máximo.
        System.out.println(maximo(3.9, 9.2, 5.4));

        // Salto de línea
        System.out.println();

        // Separador
        System.out.println("Máximo de \"zanahoria\", \"tomate\", \"batata\" es [según el orden alfabético en la tabla Unicode]:");

        // Imprimimos el máximo.
        System.out.println(maximo("zanahoria", "tomate", "batata"));
    }

    // Método estático genérico para convertir un arreglo en un tipo List<T>.
    // T hace referencia a un tipo de dato genérico.
    // Pasamos como argumento un arreglo genérico T.
    // Antes del retorno, indicamos el tipo de dato genérico con <T>.
    public static <T> List<T> fromArrayToList(T[] t) {
        return Arrays.asList(t); // Utilizamos la clase helper Arrays con el método asList() y le pasamos el arreglo c.
    }

    // Sobrecargamos el método para que solo acepte parámetros del tipo Number (int, float, etc).
    public static <T extends Number> List<T> fromArrayToList(T[] t) {
        return Arrays.asList(t); // Utilizamos la clase helper Arrays con el método asList() y le pasamos el arreglo c.
    }

    // Sobrecargamos el método para que solo acepte parámetros del tipo Cliente y además implemente la interface comparable.
    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] t) {
        return Arrays.asList(t); // Utilizamos la clase helper Arrays con el método asList() y le pasamos el arreglo c.
    }

    // Sobrecargamos el método con más parámetros genéricos.
    public static <T, G> List<T> fromArrayToList(T[] t, G[] g) {
        // Iteramos el arreglo g, imprimimos cada elemento del arreglo.
        for (G elemento : g) {
            System.out.println(elemento);
        }
        return Arrays.asList(t); // Utilizamos la clase helper Arrays con el método asList() y le pasamos el arreglo c.
    }

    // Método para usar comodines (solo se pueden usar en listas) que imprime clientes,
    // recibe como parámetro una lista de clientes y cualquier tipo de lista de Cliente, ya sean clientes comunes o Premium.
    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    // Método para calcular el mayor de 3 objetos de cualquier tipo que extienda de la interface Comparable.
    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        // Comparamos a, b y c y retornamos el mayor.
        T max = a; // Por defecto, indicamos que 'a' sea el mayor.
        // Si 'b' es mayor que máximo, entonces 'b' es el máximo.
        if (b.compareTo(max) > 0) {
            max = b;
        }
        // Si 'c' es mayor que máximo, entonces 'c' es el máximo.
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

}
