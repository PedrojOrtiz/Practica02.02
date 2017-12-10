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

                int i = 0;

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

                    i++;

                }

                if (bandera == true) {

                    this.ventanaProvincia.getGestionDato().addProvincia(p);

                }
                
                Object[][] datoProvincia = this.ventanaProvincia.cargarDatosTabla(this.ventanaProvincia.getGestionDato().getProvinciaList().size(), 2);
                this.ventanaProvincia.setDatos(datoProvincia);
                this.ventanaProvincia.getModeloTabla().setDataVector(this.ventanaProvincia.getDatos(), this.ventanaProvincia.getEncabezado());


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

    public boolean escribirProvincia(List<Provincia> provinciaList) throws IOException {
        try {

            FileWriter ae = new FileWriter("C:\\carpetaPractica02\\Provincia.txt", false);
            BufferedWriter bf = new BufferedWriter(ae);

            for (Provincia p : provinciaList) {
                bf.append(p.toString());
                bf.newLine();
            }
            bf.close();

            return true;
        } catch (IOException ae) {
            return false;
        }
    }

    public List leerProvincia(List<Provincia> provinciaList) {
        try {
            FileReader ae = new FileReader("C:\\carpetaPractica02\\Provincia.txt");
            BufferedReader bf = new BufferedReader(ae);

            String leer = bf.readLine();
            while (true) {
                return provinciaList;
            }

        } catch (IOException e2) {
            return null;
        }
    }

}
