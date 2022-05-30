package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;
import modelo.Proveedor;
import utilidades.Mensaje;
import vista.FormularioPrincipal;

public class Gestion implements InterfaceGestion{

    private Conexion conn;
    private PreparedStatement pStm;
    
    @Override
    public List<Proveedor> consultar() {
        List<Proveedor> proveedor = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        conn = new Conexion();
        try {
            Statement st = conn.getCon().createStatement();
            ResultSet rS = st.executeQuery(sql);
            while(rS.next()){
                
                String nit = rS.getString("nit");
                String nombre = rS.getString("nombre");
                String direccion = rS.getString("direccion");
                String telefono = rS.getString("telefono");
                //String cargo = rS.getString("cargo");

                Proveedor usuario = new Proveedor(nit,nombre, direccion, telefono); //cargo);
                proveedor.add(usuario);
            }
            st.close();
            rS.close();
        } catch (SQLException ex) {
            Mensaje.mensajeError("Error", ex.getMessage());
        }
        return proveedor;
    }

    @Override
    public int guardar(Proveedor usuario) {
        int resultado = 0;
        conn = new Conexion();
        String sql = "INSERT INTO proveedor "
                + "(nit,nombre,direccion,telefono) " +
                "VALUES (?,?,?,?)";
        try {
            pStm = conn.getCon().prepareStatement(sql);
            pStm.setString(1, usuario.getNit());
            pStm.setString(2, usuario.getNombre());
            pStm.setString(3, usuario.getDireccion());
            pStm.setString(4, usuario.getTelefono());
            
            
            resultado = pStm.executeUpdate();
        } catch (SQLException ex) {
            Mensaje.mensajeError("Error", ex.getMessage());
        }
        return resultado;
    }
    
    @Override
    public boolean eliminarPorNit(String nit) {
         boolean resultado = false;
         conn = new Conexion();
        String sql = "DELETE FROM proveedor WHERE nit=?";         
        try {
            pStm = conn.getCon().prepareStatement(sql);
            pStm.setString(1, nit);
            pStm.executeUpdate();
            resultado = true;
        } catch (SQLException ex) {
            Mensaje.mensajeError("Error", ex.getMessage());
        }
         return resultado;
    }  
    
    public boolean editarPorNit(String nit) {
         boolean resultado = false;
         conn = new Conexion();
        String sql = "Update FROM proveedor WHERE nit=?";         
        try {
            pStm = conn.getCon().prepareStatement(sql);
            pStm.setString(1, nit);
            //pStm.executeUpdate();
            resultado = true;
        } catch (SQLException ex) {
            Mensaje.mensajeError("Error", ex.getMessage());
        }
         return resultado;
    }
    
    
}