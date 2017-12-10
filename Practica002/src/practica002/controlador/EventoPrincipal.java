/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import practica002.vista.VentanaCanton;
import practica002.vista.VentanaPais;
import practica002.vista.VentanaPrincipal;

/**
 *
 * @author johne
 */
public class EventoPrincipal implements ActionListener
{
     private VentanaPrincipal VentPrincipal;

    public EventoPrincipal(VentanaPrincipal VentPrincipal) {
        this.VentPrincipal = VentPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       if (e.getSource().equals(this.VentPrincipal.getMenuItemList().get(0))) 
        {
            System.err.println("Ventana Pais"); 
            VentanaPais VentPais = new VentanaPais(this.VentPrincipal.getGestionDato());
            VentPais.setVisible(true);
            this.VentPrincipal.getEscritorio().add(VentPais);
        }
        if (e.getSource().equals(this.VentPrincipal.getMenuItemList().get(1))) 
        {
            System.err.println("Ventana Canton"); 
            VentanaCanton VentCant = new VentanaCanton(this.VentPrincipal.getGestionDato());
            VentCant.setVisible(true);
            this.VentPrincipal.getEscritorio().add(VentCant);
        }
    }

    public VentanaPrincipal getVentPrincipal() {
        return VentPrincipal;
    }

    public void setVentPrincipal(VentanaPrincipal VentPrincipal) {
        this.VentPrincipal = VentPrincipal;
    }
    
     
     
    
}
