package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Gestion;
import modelo.Proveedor;

public class Controlador {
    private Gestion gestion;
    
    public DefaultTableModel listar(){
        DefaultTableModel modelo = new DefaultTableModel();
        gestion = new Gestion();
        List<Proveedor> proveedores = new ArrayList<>();
        modelo = new DefaultTableModel(){
          @Override
          public boolean isCellEditable(int row, int column){
              return false;
          }
        };
        modelo.addColumn("nit");
        modelo.addColumn("nombre");
        modelo.addColumn("direccion");
        modelo.addColumn("telefono");
       
        
        
        proveedores = gestion.consultar();
        String registros[] = new String[4];
        for(Proveedor us:proveedores){
            registros[0] = us.getNit();
            registros[1] = us.getNombre();
            registros[2] = us.getDireccion();
            registros[3] = us.getTelefono();
           
            modelo.addRow(registros);
        }
        return modelo;
    }
    
    public int agregar(Proveedor usuario){
        int resultado = 0;
        gestion = new Gestion();
        resultado = gestion.guardar(usuario);
        return resultado;
    }
    
    public boolean eliminar(String nit){
        boolean res = false;
        gestion = new Gestion();
        res = gestion.eliminarPorNit(nit);
        return res;
    }
    
    public boolean editar(String nit){
        boolean res = false;
        gestion = new Gestion();
        res = gestion.eliminarPorNit(nit);
        return res;
    }
    
 
 
}