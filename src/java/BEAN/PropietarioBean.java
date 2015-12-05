/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.ProductoDAO;
import DAO.UsuarioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Usuario;

@ManagedBean
@ViewScoped

public class PropietarioBean{

    private Usuario usuario = new Usuario();
    private List<Usuario> lstPropietarios;
    private String accion;

    public PropietarioBean() throws Exception {
        listar();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLstPropietarios() {
        return lstPropietarios;
    }

    public void setLstPropietarios(List<Usuario> lstPropietarios) {
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
        UsuarioDAO dao;
        try {
            if (Valor.equals("F")) {
                if (isPostBack() == false) {
                    dao = new UsuarioDAO();
                    lstPropietarios = dao.listarProp();
                } else {
                    dao = new UsuarioDAO();
                    lstPropietarios = dao.listarProp();
                }

            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrar() throws Exception {
        UsuarioDAO dao;
        try {
            dao = new UsuarioDAO();
            dao.registrar(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Propietario Registrado", "Propietario Registrado con exito"));            
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        UsuarioDAO dao;
        try {
            dao = new UsuarioDAO();
            lstPropietarios = dao.listarProp();
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Usuario usr) throws Exception {
        UsuarioDAO dao;
        Usuario temp;

        try {
            dao = new UsuarioDAO();
            temp = dao.leerID(usr);

            if (temp != null) {
                this.usuario = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
