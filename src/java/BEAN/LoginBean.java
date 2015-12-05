package BEAN;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import model.Usuario;

public class LoginBean {

    private Usuario usuario;

    
    private List<Usuario> lstDatosUsuario;

    public List<Usuario> getLstDatosUsuario() {
        return lstDatosUsuario;
    }

    public void setLstDatosUsuario(List<Usuario> lstDatosUsuario) {
        this.lstDatosUsuario = lstDatosUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario iniciarSesion(String email, String pass) {

        try {
            System.out.println(email);
            System.out.println(pass);

            UsuarioDAO usD = new UsuarioDAO();
//            us = EJBUsuario.iniciarSesion(usuario);
            if (usD.iniciarSesion(email, pass)) {
                System.out.println("LOGUEADOas");
                usuario = usD.obtenerUsuario(email);

                String tipo = usD.obtTipoUsuario(email);
                switch (tipo) {
                    case "1": {
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.getExternalContext().redirect("home.cvs");
                        break;
                    }
                    case "2": {
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.getExternalContext().redirect("/CVSFACES_-_copia/administracion.cvs");
                        break;
                    }
                    case "3": {
                        FacesContext fc = FacesContext.getCurrentInstance();
                        fc.getExternalContext().redirect("/CVSFACES_-_copia/crearProducto.cvs");
                        break;
                    }
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "correo incorrecto", "contraseña incorrecta"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No puede acceder"));
        }
        return usuario;
    }

    public void listar() throws Exception {
        UsuarioDAO dao;
        try {
            dao = new UsuarioDAO();
            lstDatosUsuario = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Usuario usr) throws Exception {
        UsuarioDAO dao;
        try {
            dao = new UsuarioDAO();
            dao.eliminar(usuario);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Eliminado", "Usuario Eliminado"));
            logout();
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        UsuarioDAO dao;
        try {
            dao = new UsuarioDAO();
            dao.modificar(usuario);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Modificado", "Usuario Modificado con Exito"));
            
            logout();
        } catch (Exception e) {
            throw e;
        }
    }

    public void logout() {
        ExternalContext ctx
                = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath
                = ((ServletContext) ctx.getContext()).getContextPath();

        try {
            // Usar el contexto de JSF para invalidar la sesión,
            // NO EL DE SERVLETS (nada de HttpServletRequest)
            ((HttpSession) ctx.getSession(false)).invalidate();

            // Redirección de nuevo con el contexto de JSF,
            // si se usa una HttpServletResponse fallará.
            // Sin embargo, como ya está fuera del ciclo de vida 
            // de JSF se debe usar la ruta completa -_-U
            ctx.redirect(ctxPath + "/home.cvs");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
