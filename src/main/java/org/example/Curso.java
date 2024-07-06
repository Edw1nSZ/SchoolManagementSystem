package org.example;

public class Curso {
    private int id;
    private String nombre;
    private String descripcion;
    private int Puntos;
    private String unidad;

    public Curso(int id, String nombre, String descripcion, int Puntos, String unidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.Puntos = Puntos;
        this.unidad = unidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroCreditos() {
        return Puntos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.Puntos = numeroCreditos;
    }

    public String getVersion() {
        return unidad;
    }

    public void setVersion(String version) {
        this.unidad = version;
    }
}
