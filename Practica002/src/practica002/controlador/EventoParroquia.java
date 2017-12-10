/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import practica002.modelo.Canton;
import practica002.modelo.Parroquia;
import practica002.vista.VentanaParroquia;

/**
 *
 * @author pedro
 */
public class EventoParroquia implements ActionListener {

    private VentanaParroquia ventanaParroquia;
    private Canton canton;

    public EventoParroquia(VentanaParroquia ventanaParroquia) {
        this.ventanaParroquia = ventanaParroquia;
    }

    public VentanaParroquia getVentanaParroquia() {
        return ventanaParroquia;
    }

    public void setVentanaParroquia(VentanaParroquia ventanaParroquia) {
        this.ventanaParroquia = ventanaParroquia;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try {

            String nombre = this.ventanaParroquia.getTxtList().get(0).getText();
            int nC = this.ventanaParroquia.getComboCanton().getSelectedIndex();
            this.canton = this.ventanaParroquia.getGestionDato().getCantonList().get(nC);

            Parroquia pa = new Parroquia(nombre, this.canton);

            //control dato repetido
            boolean ban = true;
            for (Parroquia p : this.ventanaParroquia.getGestionDato().getParroquiaList()) {
                if (pa.equals(p) == true) {
                    ban = false;
                    JDialog d = new JDialog();
                    d.setTitle("Error");
                    d.getContentPane().add(new JLabel("       Esta Parroquia ya ha sido ingresada."));
                    d.setSize(320, 100);
                    d.setLocation(830, 400);
                    d.setVisible(true);
                    break;
                }
            }
            if (ban == true) {
                this.ventanaParroquia.getGestionDato().addParroquia(pa);
            }

            Object[][] datoParroquia = this.ventanaParroquia.cargaDatosTabla(this.ventanaParroquia.getGestionDato().getParroquiaList().size(), 2);
            this.ventanaParroquia.setDatos(datoParroquia);
            this.ventanaParroquia.getModeloTabla().setDataVector(this.ventanaParroquia.getDatos(), this.ventanaParroquia.getEncabezado());

            //Agregar Archivo Ubicacion
            File ficheroParroquia = new File("C:\\carpetaPractica02\\Parroquia.txt");
            if (ficheroParroquia.exists() == false) {
                
                try {
                    
                    ficheroParroquia.createNewFile();
                    
                } catch(Exception e) {
                    
                    e.printStackTrace();
                    
                }
                
                try {
                    
                    FileWriter escritura = new FileWriter(ficheroParroquia, true);
                    BufferedWriter buffEscritura = new BufferedWriter(escritura);
                    buffEscritura.write(pa.toString());
                    buffEscritura.close();
                    
                } catch(Exception e) {
                    
                    e.printStackTrace();
                    
                }
                
            }

        } catch (NumberFormatException e) {

            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("   Los casilleros NO se han llenado correctamente."));
            d.setSize(320, 100);
            d.setLocation(830, 400);
            d.setBackground(Color.RED);
            d.setVisible(true);

        } catch (ArrayIndexOutOfBoundsException e2) {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("              No se han encontrado Cantones."));
            d.setSize(320, 100);
            d.setLocation(830, 400);
            d.setBackground(Color.RED);
            d.setVisible(true);
        }

    }

}
