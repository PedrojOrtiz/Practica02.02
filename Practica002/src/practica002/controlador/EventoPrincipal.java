/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import practica002.vista.VentanaCanton;
import practica002.vista.VentanaPais;
import practica002.vista.VentanaParroquia;
import practica002.vista.VentanaPrincipal;
import practica002.vista.VentanaProvincia;

/**
 *
 * @author johne
 */
public class EventoPrincipal implements ActionListener {

    private VentanaPrincipal VentPrincipal;

    public EventoPrincipal(VentanaPrincipal VentPrincipal) {
        this.VentPrincipal = VentPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        File carpeta = new File("C:\\carpetaPractica02");
        if(carpeta.exists() == false) {
            carpeta.mkdir();
        }
        
        if (e.getSource().equals(this.VentPrincipal.getMenuItemList().get(0))) {
            System.err.println("Ventana Pais");
            VentanaPais VentPais = new VentanaPais(this.VentPrincipal.getGestionDato());
            VentPais.setVisible(true);
            this.VentPrincipal.getEscritorio().add(VentPais);
        }

        if (e.getSource().equals(this.VentPrincipal.getMenuItemList().get(1))) {
            System.err.println("Ventana Provincia");
            VentanaProvincia VentProv = new VentanaProvincia(this.VentPrincipal.getGestionDato());
            VentProv.setVisible(true);
            this.VentPrincipal.getEscritorio().add(VentProv);
        }

        if (e.getSource().equals(this.VentPrincipal.getMenuItemList().get(2))) {
            System.err.println("Ventana Canton");
            VentanaCanton VentCant = new VentanaCanton(this.VentPrincipal.getGestionDato());
            VentCant.setVisible(true);
            this.VentPrincipal.getEscritorio().add(VentCant);
        }

        if (e.getSource().equals(this.VentPrincipal.getMenuItemList().get(3))) {
            VentanaParroquia vP = new VentanaParroquia(this.VentPrincipal.getGestionDato());
            vP.setVisible(true);
            this.VentPrincipal.getEscritorio().add(vP);
        }
    }

    public VentanaPrincipal getVentPrincipal() {
        return VentPrincipal;
    }

    public void setVentPrincipal(VentanaPrincipal VentPrincipal) {
        this.VentPrincipal = VentPrincipal;
    }

}
