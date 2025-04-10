/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author djaramillo
 */
public class Cliente {
    int idClie;
    String Cedula;
    String Nombres;
    String Apellidos;

    public Cliente() {
    }

    public Cliente(String Cedula, String Nombres, String Apellidos) {
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
    }

    public Cliente(int idClie, String Cedula, String Nombres, String Apellidos) {
        this.idClie = idClie;
        this.Cedula = Cedula;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
    }

    public int getIdClie() {
        return idClie;
    }

    public String getCedula() {
        return Cedula;
    }

    public String getNombres() {
           return (Nombres != null) ? Nombres : "";
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setIdClie(int idClie) {
        this.idClie = idClie;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idClie=" + idClie + ", Cedula=" + Cedula + ", Nombres=" + Nombres + ", Apellidos=" + Apellidos + '}';
    }

    
    
    
}


