package model;

import java.io.Serializable;

public class Propietario implements Serializable {


    private int ID_USUARIO;
    private String TIPO_DOCUMENTO;
    private String PRIMERNOMBRE;
    private String SEGUNDONOMBRE;
    private String PRIMERAPELLIDO;
    private String SEGUNDOAPELLIDO;
    private String NUMERO_DOCUMENTO;
    private String MAIL;
    private String CONTRASENA;
    private String TELEFONOFIJO;
    private String CELULAR;
    private int ID_TIPO_USUARIO;

    public Propietario() {
    }

    public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

    public String getTIPO_DOCUMENTO() {
        return TIPO_DOCUMENTO;
    }

    public void setTIPO_DOCUMENTO(String TIPO_DOCUMENTO) {
        this.TIPO_DOCUMENTO = TIPO_DOCUMENTO;
    }

    public String getPRIMERNOMBRE() {
        return PRIMERNOMBRE;
    }

    public void setPRIMERNOMBRE(String PRIMERNOMBRE) {
        this.PRIMERNOMBRE = PRIMERNOMBRE;
    }

    public String getSEGUNDONOMBRE() {
        return SEGUNDONOMBRE;
    }

    public void setSEGUNDONOMBRE(String SEGUNDONOMBRE) {
        this.SEGUNDONOMBRE = SEGUNDONOMBRE;
    }

    public String getPRIMERAPELLIDO() {
        return PRIMERAPELLIDO;
    }

    public void setPRIMERAPELLIDO(String PRIMERAPELLIDO) {
        this.PRIMERAPELLIDO = PRIMERAPELLIDO;
    }

    public String getSEGUNDOAPELLIDO() {
        return SEGUNDOAPELLIDO;
    }

    public void setSEGUNDOAPELLIDO(String SEGUNDOAPELLIDO) {
        this.SEGUNDOAPELLIDO = SEGUNDOAPELLIDO;
    }

    public String getNUMERO_DOCUMENTO() {
        return NUMERO_DOCUMENTO;
    }

    public void setNUMERO_DOCUMENTO(String NUMERO_DOCUMENTO) {
        this.NUMERO_DOCUMENTO = NUMERO_DOCUMENTO;
    }

    public String getMAIL() {
        return MAIL;
    }

    public void setMAIL(String MAIL) {
        this.MAIL = MAIL;
    }

    public String getCONTRASENA() {
        return CONTRASENA;
    }

    public void setCONTRASENA(String CONTRASENA) {
        this.CONTRASENA = CONTRASENA;
    }

    public String getTELEFONOFIJO() {
        return TELEFONOFIJO;
    }

    public void setTELEFONOFIJO(String TELEFONOFIJO) {
        this.TELEFONOFIJO = TELEFONOFIJO;
    }

    public String getCELULAR() {
        return CELULAR;
    }

    public void setCELULAR(String CELULAR) {
        this.CELULAR = CELULAR;
    }

    public int getID_TIPO_USUARIO() {
        return ID_TIPO_USUARIO;
    }

    public void setID_TIPO_USUARIO(int ID_TIPO_USUARIO) {
        this.ID_TIPO_USUARIO = ID_TIPO_USUARIO;
    }

    

}
