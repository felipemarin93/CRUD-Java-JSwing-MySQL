package modelo;

import java.util.List;

public interface InterfaceGestion {
    
    public List<Proveedor> consultar();
    
    public int guardar(Proveedor usuario);
    
    public boolean eliminarPorNit(String nit);
    
    public boolean editarPorNit(String nit);
    
 
}