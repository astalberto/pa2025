/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class Canton {

    private int id;
    private String nombre;
    ArrayList<Parroquia> parroquias;
    private boolean estado;

    public Canton(int id, String nombre, ArrayList<Parroquia> parroquias, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.parroquias = parroquias;
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Canton(int id, String nombre, ArrayList<Parroquia> parroquias) {
        this.id = id;
        this.nombre = nombre;
        this.parroquias = parroquias;
    }

    public Canton() {
    }

    // Getters y Setters
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

    public ArrayList<Parroquia> getParroquias() {
        return parroquias;
    }

    public void setParroquias(ArrayList<Parroquia> parroquias) {
        this.parroquias = parroquias;
    }

    @Override
    public String toString() {
        return "Canton{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
