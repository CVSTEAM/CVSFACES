package BEAN;


import DAO.ProductoDAO;
import DAO.UsuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Producto;



@ManagedBean
@ViewScoped


public class ProductoBean {
    
    private Producto producto = new Producto();
    private String accion;

    
    
    
    public void Registrar() throws Exception{
      
        ProductoDAO dao;
        try{
            dao = new ProductoDAO();
            dao.registrarProducto(producto);
            
        }catch (Exception e){
            throw e;
        }
    }
  
    
    public void leerID(Producto prd) throws Exception{
        ProductoDAO dao;
        Producto temp;
        
        try{
            dao = new ProductoDAO();
            temp = dao.leerIDproducto(prd);
            
            if (temp != null) {
                this.producto = temp;
            }         
        }catch (Exception e){
            throw e;
        }
    }
    
    
    public void modificar() throws Exception{
        ProductoDAO dao;
        try{
            dao = new ProductoDAO();
            dao.modificarProducto(producto);
            
        }catch (Exception e){
            throw e;
        }
    }
    
    public void eliminar(Producto prd) throws Exception{
        ProductoDAO dao;
        try{
            dao = new ProductoDAO();
            dao.eliminar(prd);
           
        }catch (Exception e){
            throw e;
        }
    }
    
    
    
    
    
    
    
}
