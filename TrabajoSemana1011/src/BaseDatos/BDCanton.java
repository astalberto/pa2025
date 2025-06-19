/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BaseDatos;

import Clases.Canton;
import Clases.Provincia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alber
 */
public class BDCanton {

    Conexiones BLcon = new Conexiones();

    public int insertarCanton(Provincia objProvincia) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Canton (nombre, id_provincia, estado) VALUES (?, ?, ?)";

        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setString(1, objProvincia.getCantones().get(0).getNombre());
        ps.setInt(2, objProvincia.getId());
        ps.setBoolean(3, true); // activo

        return ps.executeUpdate();
    }

    public ResultSet obtenerCanton(int id) throws ClassNotFoundException, SQLException {
        String sql = "Select id_canton, nombre, id_provincia,estado From Canton Where id_provincia = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeQuery();
    }

    public int cambiarEstadoCanton(String nombre, boolean estado) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Canton SET estado = ? WHERE nombre = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setBoolean(1, estado);
        ps.setString(2, nombre);
        return ps.executeUpdate();
    }

    public ResultSet buscarIdCanton(String nombreCanton) throws ClassNotFoundException, SQLException {
        String sql = "SELECT id_canton FROM Canton WHERE nombre = ? AND estado = 1";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setString(1, nombreCanton);
        return ps.executeQuery();
    }

    public int modificarNombreCanton(String nombreActual, String nuevoNombre) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Canton SET nombre = ? WHERE nombre = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setString(1, nuevoNombre);
        ps.setString(2, nombreActual);
        return ps.executeUpdate();
    }

}
