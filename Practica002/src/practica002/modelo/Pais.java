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
public class Pais
{
 private String nombre;
 private String continente;
 private Canton capital;
 private int codigo;

    public Pais(String nombre, String continente, Canton capital, int codigo) {
        this.nombre = nombre;
        this.continente = continente;
        this.capital = capital;
        this.codigo = codigo;
    }

    public Pais(String nombre, String continente, int codigo) {
        this.nombre = nombre;
        this.continente = continente;
        this.codigo = codigo;
    }

 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public Canton getCapital() {
        return capital;
    }

    public void setCapital(Canton capital) {
        this.capital = capital;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return  nombre + "|" + continente + "|" + codigo ;
    }
    
   
}
