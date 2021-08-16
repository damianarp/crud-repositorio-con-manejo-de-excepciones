package com.damianarp.genericsclass;

public class Maquinaria {
    private String tipo;

    public Maquinaria(String tipo) {
        this.tipo = tipo;
    }

    // Solo usamos el getter, ya que el tipo lo estamos pasando por el constructor.
    public String getTipo() {
        return tipo;
    }
}
