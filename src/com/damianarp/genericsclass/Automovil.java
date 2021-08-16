package com.damianarp.genericsclass;

public class Automovil {
    private String marca;

    public Automovil(String marca) {
        this.marca = marca;
    }

    // Solo usamos el getter, ya que la marca la estamos pasando por el constructor.
    public String getMarca() {
        return marca;
    }

}
