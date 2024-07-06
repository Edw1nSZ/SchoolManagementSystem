package org.example;

public class CursoNoExisteException extends Exception {
    public CursoNoExisteException(String mensaje) {
        super(mensaje);
    }
}
