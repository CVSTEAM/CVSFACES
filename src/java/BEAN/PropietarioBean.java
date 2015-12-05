/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.PropietarioDAO;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import model.Propietario;
import model.Usuario;

@ManagedBean
@ViewScoped

public class PropietarioBean {

    private Propietario propietario = new Propietario();
    private List<Propietario> lstPropietarios;
    private String accion;

    public PropietarioBean() throws Exception {
        listar();
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public List<Propietario> getLstPropietarios() {
        return lstPropietarios;
    }

    public void setLstPropietarios(List<Propietario> lstPropietarios) {
        this.lstPropietarios = lstPropietarios;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    private boolean isPostBack() {
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }

    public void listarr(String Valor) throws Exception {
        PropietarioDAO dao;
        try {
            if (Valor.equals("F")) {
                if (isPostBack() == false) {
                    dao = new PropietarioDAO();
                    lstPropietarios = dao.listarProp();
                } else {
                    dao = new PropietarioDAO();
                    lstPropietarios = dao.listarProp();
                }

            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarProp() throws Exception {
        PropietarioDAO dao;
        try {
            dao = new PropietarioDAO();
            dao.modificar(propietario);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Propietario Modificado", "Usuario Modificado con Exito"));

        } catch (Exception e) {
            throw e;
        }
    }
    

    public void eliminar(Propietario prt) throws Exception {
        PropietarioDAO dao;
        try {
            dao = new PropietarioDAO();
            dao.eliminar(propietario);
            this.listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Eliminado", "Usuario Eliminado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrar() throws Exception {
        PropietarioDAO dao;
        try {
            dao = new PropietarioDAO();
            dao.registrar(propietario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Propietario Registrado", "Propietario Registrado con exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        PropietarioDAO dao;
        try {
            dao = new PropietarioDAO();
            lstPropietarios = dao.listarProp();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Propietario prt) throws Exception {
        PropietarioDAO dao;
        Propietario temp;

        try {
            dao = new PropietarioDAO();
            temp = dao.leerID(prt);

            if (temp != null) {
                this.propietario = temp;
            }
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
