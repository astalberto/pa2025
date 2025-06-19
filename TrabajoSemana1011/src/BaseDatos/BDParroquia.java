/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

/**
 *
 * @author alber
 */
import Clases.Parroquia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDParroquia {

    Conexiones BLcon = new Conexiones();

    public int insertarParroquia(Parroquia parroquia, int idCanton) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO Parroquia (nombre, id_canton, estado) VALUES (?, ?, ?)";

        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setString(1, parroquia.getNombre());
        ps.setInt(2, idCanton);
        ps.setBoolean(3, true);

        return ps.executeUpdate();
    }

    public int cambiarEstadoParroquia(String nombre, boolean estado) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE Parroquia SET estado = ? WHERE nombre = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setBoolean(1, estado);
        ps.setString(2, nombre);

        return ps.executeUpdate();
    }

    public ResultSet obtenerParroquiasPorCanton(int idCanton) throws ClassNotFoundException, SQLException {
        String sql = "SELECT id_parroquia, nombre, estado FROM Parroquia WHERE id_canton = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setInt(1, idCanton);
        return ps.executeQuery();
    }

    public int modificarNombreParroquia(String nombreActual, String nuevoNombre) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Parroquia SET nombre = ? WHERE nombre = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);
        ps.setString(1, nuevoNombre);
        ps.setString(2, nombreActual);
        return ps.executeUpdate();
    }
}
