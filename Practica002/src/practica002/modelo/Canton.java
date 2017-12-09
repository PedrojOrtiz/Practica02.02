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
public class Canton 
{
    private String nombre;;
    private Provincia provincia;

    public Canton(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "|Canton|" + nombre + "\t |" + provincia ;
    }
    
   
}
