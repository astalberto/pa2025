/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import BaseDatos.BDCanton;
import BaseDatos.BDProvincias;
import Clases.Canton;
import Clases.Provincia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author alber
 */
public class LogCantones {

    BDCanton objBDCanton = new BDCanton();
    BDProvincias objBDProvincia = new BDProvincias();

    public ArrayList<Canton> obtenerCantonesDesdeTexto(String nombreProvincia) throws SQLException, ClassNotFoundException {

        ResultSet rsProvincia = objBDProvincia.buscarIdProvincia(nombreProvincia);

        int idProvincia;
        if (rsProvincia.next()) {
            idProvincia = rsProvincia.getInt("id_provincia");
        } else {
            throw new SQLException("Provincia no encontrada o inactiva.");
        }

        ResultSet rsCantones = objBDCanton.obtenerCanton(idProvincia);
        ArrayList<Canton> lista = new ArrayList<>();

        while (rsCantones.next()) {
            Canton c = new Canton();
            c.setId(rsCantones.getInt("id_canton"));
            c.setNombre(rsCantones.getString("nombre"));
            c.setEstado(rsCantones.getBoolean("estado"));
            lista.add(c);
        }

        return lista;
    }
}
