package com.damianarp.poointerfaces.modelo;

import java.util.Objects;

public class BaseEntidad {

    protected Integer id;
    private static int ultimoId; // Sirve para auto-incrementar el id.

    public BaseEntidad() {
        this.id = ++ultimoId; // Auto-incrementamos el id en el constructor vacío.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Método equals para comparar el id que se pasa como parámetro con el de la lista de objetos.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si los objetos son iguales, retorna true y se sale.
        if (o == null || getClass() != o.getClass()) return false; // Si el objeto es nulo, o la clase es distinta a la del objeto, retorna false y se sale.
        // Si se cumple esto, compara los objetos.
        BaseEntidad base = (BaseEntidad) o;
        // Se compara el id pasado por parámetro con el id del objeto de tipo BaseEntidad con el método equals().
        return Objects.equals(id, base.id); // Esto es igual a return this.id != null && this.id.equals(base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
