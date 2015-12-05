package DAO;

import Utilities.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Producto;


public class ProductoDAO extends DAO {
    
    public void registrarProducto(Producto prod) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO PRODUCTO(NOMBRE,PRECIO,DESCRIPCION,ID_CATEGORIA) values(?,?,?,?)");
            st.setString(1, prod.getNOMBRE());
            st.setInt(2, prod.getPRECIO());
            st.setString(3, prod.getDESCRIPCION());
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
            PreparedStatement st = this.getConnection().prepareStatement("SELECT ID_PRODUCTO,NOMBRE,PRECIO,DESCRIPCION,ID_CATEGORIA FROM PRODUCTO WHERE ID_PRODUCTO=?");
            st.setInt(1, prodt.getID_PRODUCTO());
            rs = st.executeQuery();
            while (rs.next()) {
                prd = new Producto();
                prd.setID_PRODUCTO(rs.getInt("ID_PRODUCTO"));
                prd.setNOMBRE(rs.getString("NOMBRE"));
                prd.setPRECIO(rs.getInt("PRECIO"));
                prd.setDESCRIPCION(rs.getString("DESCRIPCION"));
                prd.setID_CATEGORIA(rs.getInt("ID_CATEGORIA"));                               
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return prd;
    }
    
    public List<Producto> listar() throws Exception {
        List<Producto> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareCall("SELECT ID_PRODUCTO,NOMBRE,PRECIO,DESCRIPCION,ID_CATEGORIA FROM PRODUCTO");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Producto prd = new Producto();
                prd.setID_PRODUCTO(rs.getInt("ID_PRODUCTO"));
                prd.setNOMBRE(rs.getString("NOMBRE"));
                prd.setPRECIO(rs.getInt("PRECIO"));
                prd.setDESCRIPCION(rs.getString("DESCRIPCION"));
                prd.setID_CATEGORIA(rs.getInt("ID_CATEGORIA"));
                lista.add(prd);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public void modificarProducto(Producto prd) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("UPDATE PRODUCTO SET NOMBRE= ?,PRECIO= ?,DESCRIPCION= ?,ID_CATEGORIA= ? WHERE ID_PRODUCTO= ? ");
            st.setString(1, prd.getNOMBRE());
            st.setInt(2, prd.getPRECIO());
            st.setString(3, prd.getDESCRIPCION());
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
