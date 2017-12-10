/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.vista;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import practica002.controlador.EventoProvincia;
import practica002.controlador.GestionDato;
import practica002.modelo.Pais;
import practica002.modelo.Provincia;

/**
 *
 * @author pedro
 */
public class VentanaProvincia extends JInternalFrame {

    private GestionDato gestionDato;
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private List<JButton> botonList;
    private JPanel panel;
    private JComboBox comboPais;
    private JScrollPane scroll;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private Object[] encabezado;
    private Object[][] datos;
    
    public VentanaProvincia(GestionDato gestionDato){
        
        super("Ventana Provincia",true,true,true,true);
        this.gestionDato = gestionDato;
        this.setSize(600,500);
        this.iniciaComponente();
    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JComboBox getComboPais() {
        return comboPais;
    }

    public void setComboPais(JComboBox comboPais) {
        this.comboPais = comboPais;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }
    
    public void iniciaComponente(){
        
        this.etiList = new ArrayList<JLabel>();
        this.txtList = new ArrayList<JTextField>();
        this.botonList = new ArrayList<JButton>();
        this.comboPais = new JComboBox(this.cargarCombo());
        JPanel panel = new JPanel(new FlowLayout());
        
        this.etiList.add(new JLabel("Pais"));
        this.etiList.add(new JLabel("Provincia"));
        
        this.txtList.add(new JTextField(15));
        
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        
        this.encabezado = new Object[2];
        this.encabezado[0] = "Pais";
        this.encabezado[1] = "Provincia";
        
        this.datos = cargarDatosTabla(this.gestionDato.getParroquiaList().size(),2);
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);        
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        
        panel.add(this.etiList.get(0));
        panel.add(this.comboPais);
        panel.add(this.etiList.get(1));
        panel.add(this.txtList.get(0));
        panel.add(this.botonList.get(0));
        panel.add(this.botonList.get(1));
        panel.add(this.scroll);
        
       this.botonList.get(0).addActionListener(new EventoProvincia(this));
       this.botonList.get(1).addActionListener(new EventoProvincia(this));
        
        this.add(panel);
        
        
        
        
    }
    
    public String[] cargarCombo() 
    {       
        String[] retorno = new String[this.gestionDato.getPaisList().size()];
        int i=0;
        for(Pais p: this.gestionDato.getPaisList()) 
        {
            retorno[i] = this.getGestionDato().getPaisList().get(i).getNombre();
            i++;
        }
        return retorno;
    }
    
    public Object[][] cargarDatosTabla(int m, int n) 
    {
        Object[][] retorno = new Object[m][n];
        int i=0;
        for(Provincia p:this.gestionDato.getProvinciaList()) 
        {
            retorno[i][0] = p.getPais();
            retorno[i][1] = p.getNombre();
            i++;
        }        
        return retorno;
    }
    

}

    


