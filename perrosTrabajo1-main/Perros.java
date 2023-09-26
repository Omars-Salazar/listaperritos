/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listaperritos;
import java.io.Serializable;
/**
 *
 * @author cuati
 */
   
public class Perros implements Serializable{
    //declarar variables 
    private String nombre; //nombre del perro
    private String raza;  //raza del perro
    private String foto; //foto del perro
    private int puntos; //puntos de los perros
    private int edad; //edad de los perros

// contructor predeterminado
public Perros(){   
}

    //constructor para inicializar los atributos 
    public Perros(String nombre, String raza, String foto, int puntos, int edad){
        this.nombre =nombre;
        this.raza = raza;
        this.foto=foto;
        this.puntos=puntos;
        this.edad=edad;
    }
    //get para acceder a los atributos
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
    
    //set para acceder a los atributos 
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





      