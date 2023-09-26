package com.mycompany.listaperritos;

import java.io.Serializable;

public class Perros implements Serializable {
    // Declarar variables
    private String nombre; // Nombre del perro
    private String raza;   // Raza del perro
    private String foto;   // Foto del perro
    private int puntos;    // Puntos de los perros
    private int edad;      // Edad de los perros

    // Constructor para inicializar los atributos
    public Perros(String nombre, String raza, String foto, int puntos, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.foto = foto;
        this.puntos = puntos;
        this.edad = edad;
    }

    // Métodos get para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public String getFoto() {
        return foto;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getEdad() {
        return edad;
    }

    // Métodos set para actualizar los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
