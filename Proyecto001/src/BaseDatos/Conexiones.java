package BaseDatos;

/*
 * @author djaramillo
 * 12 de abril del 2025
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiones {

    //Conectarse a la BDD
    public Connection con;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver"; //cj
        String url = "jdbc:mysql://localhost:3306/pa2025B";
        Class.forName(driver);
        return DriverManager.getConnection(url, "root", "UTPL");
    }

    public Connection AbrirConexion() throws ClassNotFoundException, SQLException {
        con = getConnection();
        return con;
    }

    public void CerrarConexion() throws SQLException {
        con.close();
    }
}
