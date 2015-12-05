package BEAN;

import DAO.ProductoDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Producto;

@ManagedBean
@ViewScoped

public class ProductoBean {

    private Producto producto = new Producto();
    private String accion;
    private List<Producto> lstProductos;

    public ProductoBean() throws Exception {
        listar();
        setAccion("Registrar");
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Producto> getLstProductos() {
        return lstProductos;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProductos = lstProductos;
    }

    private boolean isPostBack() {
        boolean rpta;
        rpta = FacesContext.getCurrentInstance().isPostback();
        return rpta;
    }

    public void listarr(String Valor) throws Exception {
        ProductoDAO dao;
        try {
            if (Valor.equals("F")) {
                if (isPostBack() == false) {
                    dao = new ProductoDAO();
                    lstProductos = dao.listar();
                } else {
                    dao = new ProductoDAO();
                    lstProductos = dao.listar();
                }

            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            lstProductos = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void Registrar() throws Exception {

        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            dao.registrarProducto(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Registrado", "Producto Registrado con exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void leerID(Producto prd) throws Exception {
        ProductoDAO dao;
        Producto temp;

        try {
            dao = new ProductoDAO();
            temp = dao.leerIDproducto(prd);

            if (temp != null) {
                this.producto = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            dao.modificarProducto(producto);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Modificado", "Producto modificado con exito"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminar(Producto prd) throws Exception {
        ProductoDAO dao;
        try {
            dao = new ProductoDAO();
            dao.eliminar(prd);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Eliminado", "Producto Eliminado con exito"));
            FacesContext fc = FacesContext.getCurrentInstance();
                        fc.getExternalContext().redirect("/CVSFACES_-_copia/crearProducto.cvs");
        } catch (Exception e) {
            throw e;
        }
    }
    
    

}
