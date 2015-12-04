
package DAO;

import Utilities.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Local;



public class LocalDAO extends DAO{
    
     public void registraLocal(Local loc) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO LOCAL (NOMBRE,NUMERO,ID_USUARIO) values(?,?,?)");
            st.setString(1, loc.getNombre());
            st.setString(2, loc.getNumero());
            st.setInt(3, loc.getID_USUARIO());
           
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
 public Local leerIDLocal(Local loc) throws Exception {
        Local lo = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT NOMBRE,NUMERO,ID_USUARIO FROM LOCAL WHERE ID_LOCAL=?");
            st.setInt(1, loc.getID_LOCAL());
            rs = st.executeQuery();
            while (rs.next()) {
                lo = new Local();
                lo.setNombre(rs.getString("NOMBRE"));
                lo.setNumero(rs.getString("NUMERO"));
                lo.setID_USUARIO(rs.getInt("ID_UDSUARIO"));
                                            
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lo;
    }
    public List<Local> listar() throws Exception {
        List<Local> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareCall("SELECT NOMBRE,NUMERO,ID_USUARIO FROM LOCAL");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Local lo = new Local();
                lo.setNombre(rs.getString("NOMBRE"));
                lo.setNumero(rs.getString("NUMERO"));
                lo.setID_USUARIO(rs.getInt("ID_USUARIO"));
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public void modificar(Local local) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("UPDATE LOCAL SET NOMBRE= ?,NUMERO= ?,NUMERO,ID_USUARIO= ? WHERE ID_LOCAL= ? ");
            st.setString(1, local.getNombre());
            st.setString(2, local.getNumero());
            st.setInt(3, local.getID_USUARIO());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
     public void eliminar(Local lo) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM LOCAL WHERE ID_LOCAL= ? ");
            st.setInt(1, lo.getID_USUARIO());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
