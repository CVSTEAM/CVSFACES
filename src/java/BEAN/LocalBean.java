/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import DAO.LocalDAO;
import DAO.ProductoDAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Local;

@ManagedBean
@ViewScoped

public class LocalBean implements Serializable {

    private Local local = new Local();
    private List<Local> lstLocales;
    private String accion;

    public LocalBean() throws Exception{
        listar();
    }
    
    
    

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Local> getLstLocales() {
        return lstLocales;
    }

    public void setLstLocales(List<Local> lstLocales) {
        this.lstLocales = lstLocales;
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

    public void listar() throws Exception {
        LocalDAO dao;
        try {
            dao = new LocalDAO();
            lstLocales = dao.listar();
            System.out.println(lstLocales);
        } catch (Exception e) {
            throw e;
        }
    }

    public void listarr(String Valor) throws Exception {
        LocalDAO dao;
        try {
            if (Valor.equals("F")) {
                if (isPostBack() == false) {
                    dao = new LocalDAO();
                    lstLocales = dao.listar();
                } else {
                    dao = new LocalDAO();
                    lstLocales = dao.listar();
                }

            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrar() throws Exception {
        LocalDAO dao;
        try {
            dao = new LocalDAO();
            dao.registraLocal(local);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Local Registrado", "Local Registrado con exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Local loc) throws Exception {
        LocalDAO dao;
        Local temp;

        try {
            dao = new LocalDAO();
            temp = dao.leerIDLocal(loc);

            if (temp != null) {
                this.local = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
