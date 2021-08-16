package com.damianarp.poointerfaces.modelo;

public class ClientePremium extends Cliente implements Comparable<ClientePremium> {

    // Sobreescribimos el segundo constructor de Cliente.
    public ClientePremium(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public int compareTo(ClientePremium o) {
        return 0;
    }
}
