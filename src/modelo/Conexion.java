package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import utilidades.Mensaje;

public class Conexion {
    
    private Connection con;

    public Conexion() {
        String URL = "jdbc:mysql://localhost:3306/mercar_facil?serverTimezone=America/Bogota";
        String USUARIO = "root";
        String PASSWORD = "";
        
        try {
            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            con.createStatement();
        } catch (SQLException ex) {
            Mensaje.mensajeError("Error SQL", ex.getMessage());
        }        
    }

    public Connection getCon() {
        return con;
    }    
}
