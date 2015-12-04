/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Local {

    private int ID_LOCAL;

  

    private String Nombre;

    private String Numero;
    
    private int ID_USUARIO;

  

    public int getID_LOCAL() {
        return ID_LOCAL;
    }

    public void setID_LOCAL(int ID_LOCAL) {
        this.ID_LOCAL = ID_LOCAL;
    }

 

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }
    
      public int getID_USUARIO() {
        return ID_USUARIO;
    }

    public void setID_USUARIO(int ID_USUARIO) {
        this.ID_USUARIO = ID_USUARIO;
    }

}
