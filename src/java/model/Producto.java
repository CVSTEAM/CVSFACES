package model;

public class Producto {
    
    private Integer ID_PRODUCTO;
    private String NOMBRE;
    private int PRECIO;
    private String FOTO;
    private String DESCRIPCION;
    private int ID_CATEGORIA;

    public Integer getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(Integer ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }



    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(int PRECIO) {
        this.PRECIO = PRECIO;
    }

    public String getFOTO() {
        return FOTO;
    }

    public void setFOTO(String FOTO) {
        this.FOTO = FOTO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public int getID_CATEGORIA() {
        return ID_CATEGORIA;
    }

    public void setID_CATEGORIA(int ID_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
    }
    
    

    
    
}
