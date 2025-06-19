/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import BaseDatos.BDProvincias;
import Clases.Provincia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class LogProvincias {

       public ArrayList<Provincia> obtenerListaProvincias() throws ClassNotFoundException, SQLException {
        BDProvincias db = new BDProvincias();
        ResultSet rs = db.obtenerProvincias();
        ArrayList<Provincia> lista = new ArrayList<>();

        while (rs.next()) {
            Provincia p = new Provincia();
            p.setId(rs.getInt("id_provincia"));
            p.setNombre(rs.getString("nombre"));
            p.setEstado(rs.getBoolean("estado"));
            lista.add(p);
        }

        return lista;
    }
}
