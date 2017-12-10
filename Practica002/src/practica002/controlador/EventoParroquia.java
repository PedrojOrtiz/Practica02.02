/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import practica002.vista.VentanaParroquia;

/**
 *
 * @author pedro
 */
public class EventoParroquia implements ActionListener {

    private VentanaParroquia ventanaParroquia;

    public EventoParroquia(VentanaParroquia ventanaParroquia) {
        this.ventanaParroquia = ventanaParroquia;
    }

    public VentanaParroquia getVentanaParroquia() {
        return ventanaParroquia;
    }

    public void setVentanaParroquia(VentanaParroquia ventanaParroquia) {
        this.ventanaParroquia = ventanaParroquia;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        
    }
    
}
