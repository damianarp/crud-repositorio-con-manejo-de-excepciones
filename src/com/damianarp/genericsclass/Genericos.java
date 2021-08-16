package com.damianarp.genericsclass;

public class Genericos {
    public static void main(String[] args) {

        // Creamos la instancia de Camion para transportar caballos y le indicamos el tipo de dato que va a contener.
        Camion<Animal> transporteCaballos = new Camion<>(5);

        // Agregamos los caballos.
        transporteCaballos.add(new Animal("Corazón Valiente", "Caballo"));
        transporteCaballos.add(new Animal("Galopante", "Caballo"));
        transporteCaballos.add(new Animal("Saeta", "Caballo"));
        transporteCaballos.add(new Animal("Pegaso", "Caballo"));
        transporteCaballos.add(new Animal("Pelopony", "Caballo"));

        // Separador
        System.out.println("Transporte de Caballos");

        // Iteramos con el método genérico imprimirCamion() para mostrar el nombre y tipo de animal.
        imprimirCamion(transporteCaballos);

        // Salto de línea
        System.out.println();

        // Creamos la instancia de Camion para transportar maquinaria y le indicamos el tipo de dato que va a contener.
        Camion<Maquinaria> transporteMaquinaria = new Camion<>(3);

        // Agregamos la maquinaria.
        transporteMaquinaria.add(new Maquinaria("Bulldozer"));
        transporteMaquinaria.add(new Maquinaria("Grúa Horquilla"));
        transporteMaquinaria.add(new Maquinaria("Perforadora"));

        // Separador
        System.out.println("Transporte de Maquinaria");

        // Iteramos con el método genérico imprimirCamion() para mostrar el tipo de maquinaria.
        imprimirCamion(transporteMaquinaria);

        // Salto de línea
        System.out.println();

        // Creamos la instancia de Camion para transportar automóviles y le indicamos el tipo de dato que va a contener.
        Camion<Automovil> transporteAutomovil = new Camion<>(4);

        // Agregamos la maquinaria.
        transporteAutomovil.add(new Automovil("Eco Sport"));
        transporteAutomovil.add(new Automovil("Siena"));
        transporteAutomovil.add(new Automovil("Duna"));
        transporteAutomovil.add(new Automovil("Twingo"));

        // Separador
        System.out.println("Transporte de Automóviles");

        // Iteramos con el método genérico imprimirCamion() para mostrar el tipo de Automovil.
        imprimirCamion(transporteAutomovil);
    }

    // Método genérico para imprimir los datos del camión.
    public static <T> void imprimirCamion(Camion<T> camion) {
        // Iteramos el objeto Camion (gracias a la interface Iterable) para mostrar los objetos que transporta el camión.
        for (T c : camion) {
            // Realizamos el cast al tipo de objeto que transporta el camión con una validación.
            if (c instanceof Animal) {
                System.out.println(((Animal)c).getNombre() + " - " + ((Animal)c).getTipo());
            } else if (c instanceof Maquinaria) {
                System.out.println(((Maquinaria)c).getTipo());
            } else if (c instanceof Automovil) {
                System.out.println(((Automovil)c).getMarca());
            }
        }
    }
}
