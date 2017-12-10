/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.vista;

import java.util.ArrayList;
import java.util.List;
import practica002.controlador.GestionDato;
import practica002.modelo.Canton;
import practica002.modelo.Pais;
import practica002.modelo.Parroquia;
import practica002.modelo.Provincia;

/**
 *
 * @author pedro
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
         List<Pais> lB = new ArrayList<Pais>();
         List<Provincia> prov = new ArrayList<Provincia>();
         List<Canton> can = new ArrayList<Canton>();
         List<Parroquia> lP = new ArrayList<Parroquia>();
         GestionDato gD = new GestionDato(lB,prov,can,lP);
        VentanaPrincipal VentPri = new VentanaPrincipal(gD);
    }
    
}
