package DAO;

import Utilities.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Producto;


public class ProductoDAO extends DAO {
    
    public void registrarProducto(Producto prod) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO PRODUCTO(NOMBRE,PRECIO,FOTO,ID_CATEGORIA) values(?,?,?,?)");
            st.setString(1, prod.getNOMBRE());
            st.setInt(2, prod.getPRECIO());
            st.setString(3, prod.getFOTO());
            st.setInt(4, prod.getID_CATEGORIA());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }



    public Producto leerIDproducto(Producto prodt) throws Exception {
        Producto prd = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT ID_PRODUCTO,NOMBRE,PRECIO,ID_CATEGORIA FROM PRODUCTO WHERE ID_PRODUCTO=?");
            st.setInt(1, prodt.getID_PRODUCTO());
            rs = st.executeQuery();
            while (rs.next()) {
                prd = new Producto();
                prd.setID_PRODUCTO(rs.getInt("ID_PRODUCTO"));
                prd.setNOMBRE(rs.getString("NOMBRE"));
                prd.setPRECIO(rs.getInt("PRECIO"));
                prd.setID_CATEGORIA(rs.getInt("ID_CATEGORIA"));                               
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return prd;
    }

    public void modificarProducto(Producto prd) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("UPDATE PRODUCTO SET NOMBRE= ?,PRECIO= ?,FOTO= ?,ID_CATEGORIA= ? WHERE ID_PRODUCTO= ? ");
            st.setString(1, prd.getNOMBRE());
            st.setInt(2, prd.getPRECIO());
            st.setString(3, prd.getFOTO());           
            st.setInt(4, prd.getID_CATEGORIA());
            st.setInt(5, prd.getID_PRODUCTO());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

   

    public void eliminar(Producto prd) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM PRODUCTO WHERE ID_PRODUCTO= ? ");
            st.setInt(1, prd.getID_PRODUCTO());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
}
