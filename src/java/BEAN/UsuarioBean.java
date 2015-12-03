package BEAN;


import DAO.UsuarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Usuario;


@ManagedBean
@ViewScoped


public class UsuarioBean implements Serializable{
    
    private Usuario usuario = new Usuario();
    private List<Usuario> lstUsuarios;
    private String accion;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public List<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(List<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    public void listar() throws Exception{
        UsuarioDAO dao;
        try{
            dao = new UsuarioDAO();
            lstUsuarios = dao.listar();
        }catch (Exception e){
            throw e;
        }
    }
    
    
    public void registrar() throws Exception{
        UsuarioDAO dao;
        try{
            dao= new UsuarioDAO();
            dao.registrar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Registrado", "Usuario Registrado con exito"));
        }catch (Exception e){
            throw e;
        }
    }

    
    
    public void modificar() throws Exception{
        UsuarioDAO dao;
        try{
            dao = new UsuarioDAO();
            dao.modificar(usuario);
            this.listar();
        }catch (Exception e){
            throw e;
        }
    }
    
    public void eliminar(Usuario usr) throws Exception{
        UsuarioDAO dao;
        try{
            dao = new UsuarioDAO();
            dao.eliminar(usr);
            this.listar();
        }catch (Exception e){
            throw e;
        }
    }
    
    
    
    
    
    
    
}
