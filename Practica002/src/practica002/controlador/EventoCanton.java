package practica002.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import practica002.modelo.Canton;
import practica002.modelo.Provincia;
import practica002.vista.VentanaCanton;

public class EventoCanton implements ActionListener 
{

    private VentanaCanton ventanaCanton;
    private Provincia provincia;

    public EventoCanton(VentanaCanton ventanaCanton) {
        this.ventanaCanton = ventanaCanton;
    }

    public VentanaCanton getVentanaCanton() {
        return ventanaCanton;
    }
    public void setVentanaCanton(VentanaCanton ventanaCanton) {
        this.ventanaCanton = ventanaCanton;
    }
    public Provincia getProvincia() {
        return provincia;
    }
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            if (e.getSource().equals(this.ventanaCanton.getBotonList().get(0))) 
            {
                String nombre = this.ventanaCanton.getTxtList().get(0).getText();
                int nump = this.ventanaCanton.getComboProvincia().getSelectedIndex();
                this.provincia = this.ventanaCanton.getGestionDato().getProvinciaList().get(nump);

                Canton c = new Canton(nombre, this.provincia);

                int i = 0;
                boolean ban = true;
                for (Canton ca : this.ventanaCanton.getGestionDato().getCantonList()) 
                {
                    if(c.getNombre().equals(this.ventanaCanton.getGestionDato().getCantonList().get(i).getNombre()) == true && c.getProvincia().getNombre().equals(this.ventanaCanton.getGestionDato().getCantonList().get(i).getProvincia().getNombre()) == true) 
                    {
                        ban = false;
                        JDialog d = new JDialog();
                        d.setTitle("Error");
                        d.getContentPane().add(new JLabel("Ya exsiste"));
                        d.setSize(120, 100);
                        d.setLocation(830, 400);
                        d.setVisible(true);
                        break;
                    }
                    i++;
                }

                if (ban == true) 
                {
                    this.ventanaCanton.getGestionDato().addCanton(c);
                }

                Object[][] datoCanton = this.ventanaCanton.cargaDatosTabla(this.ventanaCanton.getGestionDato().getCantonList().size(), 2);
                this.ventanaCanton.setDatos(datoCanton);
                this.ventanaCanton.getModeloTabla().setDataVector(this.ventanaCanton.getDatos(), this.ventanaCanton.getEncabezado());
                
                File ficheroCanton = new File("C:\\carpetaPractica02\\Canton.txt");
                if (ficheroCanton.exists() == false)
                {
                try 
                {
                    ficheroCanton.createNewFile();

                } 
                catch(Exception ae) 
                {
                    ae.printStackTrace();
                }
                    
                }
                try
                {
                    FileWriter fw = new FileWriter("C:\\carpetaPractica02\\Canton.txt", false);
                    BufferedWriter bf = new BufferedWriter(fw);
                    bf.write(c.toString());
                    bf.close();
                }
                catch (Exception ae) 
                {
                    ae.printStackTrace();

                }

            } 
            else if (e.getSource().equals(this.ventanaCanton.getBotonList().get(1))) 
            {
                this.ventanaCanton.getTxtList().get(0).setText("");
                this.ventanaCanton.getTxtList().get(1).setText("");
            }
        }
        catch (NumberFormatException ae) 
        {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("Casilleros incorrectos"));
            d.setSize(120, 100);
            d.setLocation(830, 400);
            d.setVisible(true);
        } 
        catch (ArrayIndexOutOfBoundsException ae2) 
        {
            JDialog d = new JDialog();
            d.setTitle("Error");
            d.getContentPane().add(new JLabel("NO se han encontrado PROVINCIAS"));
            d.setSize(320, 100);
            d.setLocation(830, 400);
            d.setVisible(true);
        }

    }

}
