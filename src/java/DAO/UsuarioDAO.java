package DAO;

import Utilities.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO extends DAO {
    
    private Usuario usuario = new Usuario();

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

    public Usuario obtenerUsuario(String mail) throws Exception {
        Usuario usr = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT ID_USUARIO,TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO FROM USUARIO WHERE MAIL=?");
             st.setString(1, mail);
            rs = st.executeQuery();
            
            while (rs.next()) {
                usr = new Usuario();
                usr.setID_USUARIO(rs.getInt("ID_USUARIO"));
                usr.setTIPO_DOCUMENTO(rs.getString("TIPO_DOCUMENTO"));
                usr.setPRIMERNOMBRE(rs.getString("PRIMER_NOMBRE"));
                usr.setSEGUNDONOMBRE(rs.getString("SEGUNDO_NOMBRE"));
                usr.setPRIMERAPELLIDO(rs.getString("PRIMER_APELLIDO"));
                usr.setSEGUNDOAPELLIDO(rs.getString("SEGUNDO_APELLIDO"));
                usr.setNUMERO_DOCUMENTO(rs.getString("NUMERO_DOCUMENTO"));
                usr.setMAIL(rs.getString("MAIL"));
                usr.setCONTRASENA(rs.getString("CONTRASENA"));
                usr.setTELEFONOFIJO(rs.getString("TELEFONO_FIJO"));
                usr.setCELULAR(rs.getString("TELEFONO_CELULAR"));
                usr.setID_TIPO_USUARIO(rs.getInt("ID_TIPO_USUARIO"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return usr;
    }

    public void registrar(Usuario usr) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO USUARIO (TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO) values(?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, usr.getTIPO_DOCUMENTO());
            st.setString(2, usr.getPRIMERNOMBRE());
            st.setString(3, usr.getSEGUNDONOMBRE());
            st.setString(4, usr.getPRIMERAPELLIDO());
            st.setString(5, usr.getSEGUNDOAPELLIDO());
            st.setString(6, usr.getNUMERO_DOCUMENTO());
            st.setString(7, usr.getMAIL());
            st.setString(8, usr.getCONTRASENA());
            st.setString(9, usr.getTELEFONOFIJO());
            st.setString(10, usr.getCELULAR());
            st.setInt(11, usr.getID_TIPO_USUARIO());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public List<Usuario> listar() throws Exception {
        List<Usuario> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareCall("SELECT ID_USUARIO,TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO FROM USUARIO");
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Usuario usr = new Usuario();
                usr.setID_USUARIO(rs.getInt("ID_USUARIO"));
                usr.setTIPO_DOCUMENTO(rs.getString("TIPO_DOCUMENTO"));
                usr.setPRIMERNOMBRE(rs.getString("PRIMER_NOMBRE"));
                usr.setSEGUNDONOMBRE(rs.getString("SEGUNDO_NOMBRE"));
                usr.setPRIMERAPELLIDO(rs.getString("PRIMER_APELLIDO"));
                usr.setSEGUNDOAPELLIDO(rs.getString("SEGUNDO_APELLIDO"));
                usr.setNUMERO_DOCUMENTO(rs.getString("NUMERO_DOCUMENTO"));
                usr.setMAIL(rs.getString("MAIL"));
                usr.setCONTRASENA(rs.getString("CONTRASENA"));
                usr.setTELEFONOFIJO(rs.getString("TELEFONO_FIJO"));
                usr.setCELULAR(rs.getString("TELEFONO_CELULAR"));
                usr.setID_TIPO_USUARIO(rs.getInt("ID_TIPO_USUARIO"));
                lista.add(usr);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }
    
    
    public List<Usuario> listarProp() throws Exception {
        List<Usuario> listaprop;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareCall("SELECT ID_USUARIO,TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO FROM USUARIO WHERE ID_TIPO_USUARIO=3");
            rs = st.executeQuery();
            listaprop = new ArrayList();
            while (rs.next()) {
                Usuario prop = new Usuario();
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
    

    public void modificar(Usuario usuario) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("UPDATE USUARIO SET TIPO_DOCUMENTO= ?,PRIMER_NOMBRE= ?,SEGUNDO_NOMBRE= ?,PRIMER_APELLIDO= ?,SEGUNDO_APELLIDO= ?,NUMERO_DOCUMENTO= ?,MAIL= ?,CONTRASENA= ?,TELEFONO_FIJO= ?,TELEFONO_CELULAR= ?,ID_TIPO_USUARIO= ? WHERE ID_USUARIO= ? ");
            st.setString(1, usuario.getTIPO_DOCUMENTO());
            st.setString(2, usuario.getPRIMERNOMBRE());
            st.setString(3, usuario.getSEGUNDONOMBRE());
            st.setString(4, usuario.getPRIMERAPELLIDO());
            st.setString(5, usuario.getSEGUNDOAPELLIDO());
            st.setString(6, usuario.getNUMERO_DOCUMENTO());
            st.setString(7, usuario.getMAIL());
            st.setString(8, usuario.getCONTRASENA());
            st.setString(9, usuario.getTELEFONOFIJO());
            st.setString(10, usuario.getCELULAR());
            st.setInt(11, usuario.getID_TIPO_USUARIO());
            st.setInt(12, usuario.getID_USUARIO());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    


    public void eliminar(Usuario usr) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE FROM USUARIO WHERE ID_USUARIO= ? ");
            st.setInt(1, usr.getID_USUARIO());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
    
        public Usuario leerID(Usuario user) throws Exception {
        Usuario usr = null;
        ResultSet rs;

        try {
            this.Conectar();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT ID_USUARIO,TIPO_DOCUMENTO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,NUMERO_DOCUMENTO,MAIL,CONTRASENA,TELEFONO_FIJO,TELEFONO_CELULAR,ID_TIPO_USUARIO FROM USUARIO WHERE ID_USUARIO=?");
            st.setInt(1, user.getID_USUARIO());
            rs = st.executeQuery();
            while (rs.next()) {
                usr = new Usuario();
                usr.setID_USUARIO(rs.getInt("ID_USUARIO"));
                usr.setTIPO_DOCUMENTO(rs.getString("TIPO_DOCUMENTO"));
                usr.setPRIMERNOMBRE(rs.getString("PRIMER_NOMBRE"));
                usr.setSEGUNDONOMBRE(rs.getString("SEGUNDO_NOMBRE"));
                usr.setPRIMERAPELLIDO(rs.getString("PRIMER_APELLIDO"));
                usr.setSEGUNDOAPELLIDO(rs.getString("SEGUNDO_APELLIDO"));
                usr.setNUMERO_DOCUMENTO(rs.getString("NUMERO_DOCUMENTO"));
                usr.setMAIL(rs.getString("MAIL"));
                usr.setCONTRASENA(rs.getString("CONTRASENA"));
                usr.setTELEFONOFIJO(rs.getString("TELEFONO_FIJO"));
                usr.setCELULAR(rs.getString("TELEFONO_CELULAR"));
                usr.setID_TIPO_USUARIO(rs.getInt("ID_TIPO_USUARIO"));                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return usr;
    }

}
