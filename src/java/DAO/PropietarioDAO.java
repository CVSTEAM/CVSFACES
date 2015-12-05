
package DAO;

import Utilities.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Propietario;
import model.Usuario;

public class PropietarioDAO extends DAO{
        
    private Usuario propietario = new Usuario();

    public boolean iniciarSesion(String email, String pass) throws Exception {
        this.Conectar();
        String consulta;

        try {
            consulta = "SELECT * FROM Usuario u WHERE u.MAIL = ? and u.CONTRASENA = ?";
            PreparedStatement st = getConnection().prepareStatement(consulta);
            st.setString(1, email);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
     public String obtTipoUsuario(String Mail) throws Exception {
        this.Conectar();
        String consulta;

        try {
            consulta = "SELECT * FROM Usuario u WHERE u.MAIL = ?";
            PreparedStatement st = getConnection().prepareStatement(consulta);
            st.setString(1, Mail);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("ID_TIPO_USUARIO");
            } else {
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }
     
     public Propietario obtenerUsuario(String mail) throws Exception {
        Propietario prt = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT ID_USUARIO,TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO FROM USUARIO WHERE MAIL=?");
             st.setString(1, mail);
            rs = st.executeQuery();
            
            while (rs.next()) {
                prt = new Propietario();
                prt.setID_USUARIO(rs.getInt("ID_USUARIO"));
                prt.setTIPO_DOCUMENTO(rs.getString("TIPO_DOCUMENTO"));
                prt.setPRIMERNOMBRE(rs.getString("PRIMER_NOMBRE"));
                prt.setSEGUNDONOMBRE(rs.getString("SEGUNDO_NOMBRE"));
                prt.setPRIMERAPELLIDO(rs.getString("PRIMER_APELLIDO"));
                prt.setSEGUNDOAPELLIDO(rs.getString("SEGUNDO_APELLIDO"));
                prt.setNUMERO_DOCUMENTO(rs.getString("NUMERO_DOCUMENTO"));
                prt.setMAIL(rs.getString("MAIL"));
                prt.setCONTRASENA(rs.getString("CONTRASENA"));
                prt.setTELEFONOFIJO(rs.getString("TELEFONO_FIJO"));
                prt.setCELULAR(rs.getString("TELEFONO_CELULAR"));
                prt.setID_TIPO_USUARIO(rs.getInt("ID_TIPO_USUARIO"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return prt;
    }
     
       public void registrar(Propietario prt) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO USUARIO (TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO) values(?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, prt.getTIPO_DOCUMENTO());
            st.setString(2, prt.getPRIMERNOMBRE());
            st.setString(3, prt.getSEGUNDONOMBRE());
            st.setString(4, prt.getPRIMERAPELLIDO());
            st.setString(5, prt.getSEGUNDOAPELLIDO());
            st.setString(6, prt.getNUMERO_DOCUMENTO());
            st.setString(7, prt.getMAIL());
            st.setString(8, prt.getCONTRASENA());
            st.setString(9, prt.getTELEFONOFIJO());
            st.setString(10, prt.getCELULAR());
            st.setInt(11, prt.getID_TIPO_USUARIO());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
       
       
    public List<Propietario> listar() throws Exception {
        List<Propietario> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareCall("SELECT ID_USUARIO,TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO FROM USUARIO");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Propietario prt = new Propietario();
                prt.setID_USUARIO(rs.getInt("ID_USUARIO"));
                prt.setTIPO_DOCUMENTO(rs.getString("TIPO_DOCUMENTO"));
                prt.setPRIMERNOMBRE(rs.getString("PRIMER_NOMBRE"));
                prt.setSEGUNDONOMBRE(rs.getString("SEGUNDO_NOMBRE"));
                prt.setPRIMERAPELLIDO(rs.getString("PRIMER_APELLIDO"));
                prt.setSEGUNDOAPELLIDO(rs.getString("SEGUNDO_APELLIDO"));
                prt.setNUMERO_DOCUMENTO(rs.getString("NUMERO_DOCUMENTO"));
                prt.setMAIL(rs.getString("MAIL"));
                prt.setCONTRASENA(rs.getString("CONTRASENA"));
                prt.setTELEFONOFIJO(rs.getString("TELEFONO_FIJO"));
                prt.setCELULAR(rs.getString("TELEFONO_CELULAR"));
                prt.setID_TIPO_USUARIO(rs.getInt("ID_TIPO_USUARIO"));
                lista.add(prt);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
        public List<Propietario> listarProp() throws Exception {
        List<Propietario> listaprop;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareCall("SELECT ID_USUARIO,TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO FROM USUARIO WHERE ID_TIPO_USUARIO=3");
            rs = st.executeQuery();
            listaprop = new ArrayList();
            while (rs.next()) {
                Propietario prop = new Propietario();
                prop.setID_USUARIO(rs.getInt("ID_USUARIO"));
                prop.setTIPO_DOCUMENTO(rs.getString("TIPO_DOCUMENTO"));
                prop.setPRIMERNOMBRE(rs.getString("PRIMER_NOMBRE"));
                prop.setSEGUNDONOMBRE(rs.getString("SEGUNDO_NOMBRE"));
                prop.setPRIMERAPELLIDO(rs.getString("PRIMER_APELLIDO"));
                prop.setSEGUNDOAPELLIDO(rs.getString("SEGUNDO_APELLIDO"));
                prop.setNUMERO_DOCUMENTO(rs.getString("NUMERO_DOCUMENTO"));
                prop.setMAIL(rs.getString("MAIL"));
                prop.setCONTRASENA(rs.getString("CONTRASENA"));
                prop.setTELEFONOFIJO(rs.getString("TELEFONO_FIJO"));
                prop.setCELULAR(rs.getString("TELEFONO_CELULAR"));
                prop.setID_TIPO_USUARIO(rs.getInt("ID_TIPO_USUARIO"));
                listaprop.add(prop);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listaprop;
    }
    
        public void modificar(Propietario propietario) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("UPDATE USUARIO SET TIPO_DOCUMENTO= ?,PRIMER_NOMBRE= ?,SEGUNDO_NOMBRE= ?,PRIMER_APELLIDO= ?,SEGUNDO_APELLIDO= ?,NUMERO_DOCUMENTO= ?,MAIL= ?,CONTRASENA= ?,TELEFONO_FIJO= ?,TELEFONO_CELULAR= ?,ID_TIPO_USUARIO= ? WHERE ID_USUARIO= ? ");
            st.setString(1, propietario.getTIPO_DOCUMENTO());
            st.setString(2, propietario.getPRIMERNOMBRE());
            st.setString(3, propietario.getSEGUNDONOMBRE());
            st.setString(4, propietario.getPRIMERAPELLIDO());
            st.setString(5, propietario.getSEGUNDOAPELLIDO());
            st.setString(6, propietario.getNUMERO_DOCUMENTO());
            st.setString(7, propietario.getMAIL());
            st.setString(8, propietario.getCONTRASENA());
            st.setString(9, propietario.getTELEFONOFIJO());
            st.setString(10, propietario.getCELULAR());
            st.setInt(11, propietario.getID_TIPO_USUARIO());
            st.setInt(12, propietario.getID_USUARIO());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    


    public void eliminar(Propietario prt) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM USUARIO WHERE ID_USUARIO= ? ");
            st.setInt(1, prt.getID_USUARIO());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
        public Propietario leerID(Propietario prop) throws Exception {
        Propietario prt = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT ID_USUARIO,TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO FROM USUARIO WHERE ID_USUARIO=?");
            st.setInt(1, prop.getID_USUARIO());
            rs = st.executeQuery();
            while (rs.next()) {
                prt = new Propietario();
                prt.setID_USUARIO(rs.getInt("ID_USUARIO"));
                prt.setTIPO_DOCUMENTO(rs.getString("TIPO_DOCUMENTO"));
                prt.setPRIMERNOMBRE(rs.getString("PRIMER_NOMBRE"));
                prt.setSEGUNDONOMBRE(rs.getString("SEGUNDO_NOMBRE"));
                prt.setPRIMERAPELLIDO(rs.getString("PRIMER_APELLIDO"));
                prt.setSEGUNDOAPELLIDO(rs.getString("SEGUNDO_APELLIDO"));
                prt.setNUMERO_DOCUMENTO(rs.getString("NUMERO_DOCUMENTO"));
                prt.setMAIL(rs.getString("MAIL"));
                prt.setCONTRASENA(rs.getString("CONTRASENA"));
                prt.setTELEFONOFIJO(rs.getString("TELEFONO_FIJO"));
                prt.setCELULAR(rs.getString("TELEFONO_CELULAR"));
                prt.setID_TIPO_USUARIO(rs.getInt("ID_TIPO_USUARIO"));                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return prt;
    }

    
}
