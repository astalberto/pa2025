/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import Clases.Provincia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alber
 */
public class BDProvincias {

    Conexiones BLcon = new Conexiones();

    public int insertarProvincia(Provincia objProvincia) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Provincia (nombre) VALUES (?)";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setString(1, objProvincia.getNombre());
        return ps.executeUpdate();
    }

    public ResultSet obtenerProvincias() throws ClassNotFoundException, SQLException {
        String sql = "SELECT id_provincia,nombre,estado FROM Provincia";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        return ps.executeQuery();
    }

    public ResultSet buscarIdProvincia(String nombreProvincia) throws ClassNotFoundException, SQLException {
        String sql = "SELECT id_provincia FROM Provincia WHERE nombre = ? AND estado = 1";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setString(1, nombreProvincia);
        return ps.executeQuery();
    }

    public int cambiarEstadoProvincia(String nombreProvincia, boolean estado) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Provincia SET estado = ? WHERE nombre = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setBoolean(1, estado);
        ps.setString(2, nombreProvincia);

        return ps.executeUpdate();
    }

    public int modificarNombreProvincia(String nombreActual, String nuevoNombre) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Provincia SET nombre = ? WHERE nombre = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setString(1, nuevoNombre);
        ps.setString(2, nombreActual);
        return ps.executeUpdate();
    }
}
