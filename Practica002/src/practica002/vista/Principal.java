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
         List<Canton> can = new ArrayList<Canton>();
         GestionDato gD = new GestionDato(lB,can);
        VentanaPrincipal VentPri = new VentanaPrincipal(gD);
    }
    
}
