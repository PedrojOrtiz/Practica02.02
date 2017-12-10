/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.modelo;

/**
 *
 * @author pedro
 */
public class Parroquia {

    private String nombre;
    private Canton canton;

    public Parroquia(String nombre, Canton canton) {
        this.nombre = nombre;
        this.canton = canton;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    @Override
    public String toString() {
        return nombre + "|" + canton;
    }
    
 
}
