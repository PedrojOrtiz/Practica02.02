/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import practica002.modelo.Canton;
import practica002.modelo.Pais;
import practica002.modelo.Provincia;
import practica002.vista.VentanaProvincia;

/**
 *
 * @author pedro
 */
public class EventoProvincia implements ActionListener {

    private VentanaProvincia ventanaProvincia;
    private Pais pais;

    public EventoProvincia(VentanaProvincia ventanaProvincia) {
        this.ventanaProvincia = ventanaProvincia;
    }

    public VentanaProvincia getVentanaProvincia() {
        return ventanaProvincia;
    }

    public void setVentanaProvincia(VentanaProvincia ventanaProvincia) {
        this.ventanaProvincia = ventanaProvincia;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource().equals(this.ventanaProvincia.getBotonList().get(0))) {
                int num = this.ventanaProvincia.getComboPais().getSelectedIndex();
                this.pais = this.ventanaProvincia.getGestionDato().getPaisList().get(num);
                String nombre = this.ventanaProvincia.getTxtList().get(0).getText();
                Provincia p = new Provincia(this.pais, nombre);

                boolean bandera = true;

                for (Provincia prov : this.ventanaProvincia.getGestionDato().getProvinciaList()) {

                    if (p.equals(prov)) {

                        bandera = false;
                        JDialog d = new JDialog();
                        d.setTitle("Error");
                        d.getContentPane().add(new JLabel("Esta provincia ya existe"));
                        d.setSize(120, 100);
                        d.setLocation(830, 400);
                        d.setVisible(true);
                        break;
                    }

                }

                if (bandera == true) {

                    this.ventanaProvincia.getGestionDato().addProvincia(p);

                }

                Object[][] datoProvincia = this.ventanaProvincia.cargarDatosTabla(this.ventanaProvincia.getGestionDato().getProvinciaList().size(), 2);
                this.ventanaProvincia.setDatos(datoProvincia);
                this.ventanaProvincia.getModeloTabla().setDataVector(this.ventanaProvincia.getDatos(), this.ventanaProvincia.getEncabezado());

                //Agregar Archivo Ubicacion
                File ficheroProvincia = new File("C:\\carpetaPractica02\\Provincia.txt");
                if (ficheroProvincia.exists() == false) {

                    try {

                        ficheroProvincia.createNewFile();

                    } catch (Exception ae) {

                        ae.printStackTrace();

                    }
                    
                }

                    try {

                        FileWriter escritura = new FileWriter(ficheroProvincia, true);
                        BufferedWriter buffEscritura = new BufferedWriter(escritura);
                        buffEscritura.write(p.toString());
                        buffEscritura.close();

                    } catch (Exception ae) {

                        ae.printStackTrace();

                    }
            }

            if (e.getSource().equals(this.ventanaProvincia.getBotonList().get(1))) {

                this.ventanaProvincia.getTxtList().get(0).setText("");

            }

        } catch (NumberFormatException ae) {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("Llene correctamente los casilleros"));
            d.setSize(120, 100);
            d.setLocation(830, 400);
            d.setVisible(true);
        } catch (ArrayIndexOutOfBoundsException ae2) {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("NO se han encontrado Paises"));
            d.setSize(320, 100);
            d.setLocation(830, 400);
            d.setVisible(true);
        }

    }
}
