package com.damianarp.poointerfaces.repositorio.excepciones;

// Excepción padre genérica que únicamente se usará en la interface y en cada implementación de la interface (en la firma de cada método).
public class AccesoDatoException extends Exception {
    public AccesoDatoException(String message) {
        super(message);
    }
}
