/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import BaseDatos.BDCanton;
import BaseDatos.BDParroquia;
import Clases.Parroquia;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alber
 */
public class LogParroquia {

    BDParroquia objBDParroquia = new BDParroquia();
    BDCanton objBDCanton = new BDCanton();

    public ArrayList<Parroquia> obtenerParroquiasDesdeTexto(String nombreCanton) throws SQLException, ClassNotFoundException {
        ResultSet rsCanton = objBDCanton.buscarIdCanton(nombreCanton);
        int idCanton = -1;
        if (rsCanton.next()) {
            idCanton = rsCanton.getInt("id_canton");
        }

        ResultSet rs = objBDParroquia.obtenerParroquiasPorCanton(idCanton);
        ArrayList<Parroquia> lista = new ArrayList<>();
        while (rs.next()) {
            Parroquia p = new Parroquia();
            p.setId(rs.getInt("id_parroquia"));
            p.setNombre(rs.getString("nombre"));
            p.setEstado(rs.getBoolean("estado"));
            lista.add(p);
        }
        return lista;
    }

}
