package BEAN;

import DAO.UsuarioDAO;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import model.Usuario;


public class LoginBean{

    
    private Usuario usuario;

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
                System.out.println(usuario.getPRIMERNOMBRE());
                String tipo = usD.obtTipoUsuario(email);
                switch (tipo) {
                    case "1":
                        {
                            FacesContext fc = FacesContext.getCurrentInstance();
                            fc.getExternalContext().redirect("/CVSFACES_-_copia/faces/home.xhtml");
                            break;
                        }
                    case "2":
                        {
                            FacesContext fc = FacesContext.getCurrentInstance();
                            fc.getExternalContext().redirect("/CVSFACES_-_copia/faces/crearProducto.xhtml");
                            break;
                        }
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Credenciales incorrectas", "Credenciales incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No puede acceder"));
        }
        return usuario;
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
            ctx.redirect(ctxPath + "/faces/index.xhtml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
