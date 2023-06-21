package com.example.appweb.model;

public class Usuario {
    private String nombre;
    private int edad;
    private String rut;

    public Usuario(String nombre, int edad, String rut){
        setNombre(nombre);
        setEdad(edad);
        setRut(rut);
    }

    public String getNombre() {
        return nombre;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    private void setEdad(int edad) {
        this.edad = edad;
    }
    public String getRut() {
        return rut;
    }
    private void setRut(String rut) {
        this.rut = rut;
    }
}
