
package Controller;

import DAO.UsuarioDAO;
import java.io.Serializable;
import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import model.Usuario;

@Named
@ViewScoped
public class UsuarioController implements Serializable{

//    @EJB
//    private UsuarioFacadeLocal EJBUsuario;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}

