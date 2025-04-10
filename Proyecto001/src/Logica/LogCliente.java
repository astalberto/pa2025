/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import BaseDatos.BDCliente;
import Clases.Cliente;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author djaramillo
 */
public class LogCliente {
    BDCliente objBDCliente = new BDCliente();
    public boolean ValidarCedula(Cliente objCliente) {
        if (objCliente.getCedula().length() == 4)
            return true; 
        return false;
        //return objCliente.getCedula().length();
    }
    public void Insertar(Cliente objCliente) 
            throws ClassNotFoundException, SQLException {
        objBDCliente.Insertar(objCliente);
    } 

    public void BuscarClienteCedula(Cliente objCliente) 
            throws ClassNotFoundException, SQLException {
            ResultSet rs = objBDCliente.BuscarClienteCedula(objCliente);
            while (rs.next()){
                //objCliente.setIdCli(rs.getInt(1)); // se setea el id al objeto cliente
                objCliente.setIdClie(rs.getInt(1));
                objCliente.setNombres(rs.getString(3));
                objCliente.setApellidos(rs.getString(4));
            }
            rs.close();
    }
    
        public Cliente BuscarMaxId(Cliente objCliente) 
            throws ClassNotFoundException, SQLException {
            ResultSet rs = objBDCliente.BuscarMaxIdCliente(objCliente);
            while (rs.next()){
                objCliente.setIdClie(rs.getInt(1));
                objCliente.setCedula(rs.getString(2));
                objCliente.setNombres(rs.getString(3));
                objCliente.setApellidos(rs.getString(4));
            }
            rs.close();
            return objCliente;
    }
}
