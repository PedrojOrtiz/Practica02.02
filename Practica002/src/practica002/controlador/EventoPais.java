/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import practica002.modelo.Pais;
import practica002.vista.VentanaPais;



/**
 *
 * @author pedro
 */
public class EventoPais  implements ActionListener
{
  private VentanaPais ventanaPais;

    public EventoPais(VentanaPais ventanaPais) {
        this.ventanaPais = ventanaPais;
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       try{
        String nombre = this.ventanaPais.getTxtList().get(0).getText();
       String continente = this.ventanaPais.getTxtList().get(1).getText();
       int codigo = Integer.parseInt(this.ventanaPais.getTxtList().get(2).getText());
       
        Pais pais = new Pais(nombre,continente,codigo);
        
        boolean bandera = true;

            int i = 0;

            for (Pais a : this.ventanaPais.getGestionDato().getPaisList()) {

                if (pais.getCodigo() == this.ventanaPais.getGestionDato().getPaisList().get(i).getCodigo()) {

                    JOptionPane.showMessageDialog(null, "Datos ya existentes");
                    bandera = false;
                    break;
                }
                i++;
            }
             if (bandera == true) {

                this.ventanaPais.getGestionDato().addPais(pais);

            }
       }
       catch (NumberFormatException a) {

            JOptionPane.showMessageDialog(null, "Llene correctamente los datos");

        }
       this.ventanaPais.getTxtList().get(0).setText("");
        this.ventanaPais.getTxtList().get(1).setText("");
        this.ventanaPais.getTxtList().get(2).setText("");
       
        Object[][] datoAsistente = this.ventanaPais.cargaDatosTabla(this.ventanaPais.getGestionDato().getPaisList().size(), 3);
        this.ventanaPais.setDatos(datoAsistente);
        this.ventanaPais.getModeloTabla().setDataVector(this.ventanaPais.getDatos(), this.ventanaPais.getEncabezado());
         
    }

    public VentanaPais getVentanaPais() {
        return ventanaPais;
    }

    public void setVentanaPais(VentanaPais ventanaPais) {
        this.ventanaPais = ventanaPais;
    }
    

 
}
