/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import practica002.controlador.EventoPrincipal;
import practica002.controlador.GestionDato;

/**
 *
 * @author johne
 */
public class VentanaPrincipal extends JFrame
{
      private GestionDato gestionDato;
    private JDesktopPane escritorio;
    private JMenuBar barraMenu;
    private java.util.List<JMenu> menuList;
    private ArrayList<JMenuItem> menuItemList;

    public VentanaPrincipal(GestionDato gestionDato)
    {
        super("Practica02.02");
        this.gestionDato = gestionDato;
        this.setSize(800, 600);
        this.setLocation(500,250);
        this.iniciaComponentes();
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
     private void iniciaComponentes() 
    {
       this.escritorio= new JDesktopPane();
        this.barraMenu= new JMenuBar();
        this.menuList=new ArrayList<JMenu>();// llamado al array
        this.menuList.add(new JMenu("Pais"));// ingreso de datos en el array
        /*this.menuList.add(new JMenu("Carpeta"));// ingreso de datos en el array
        this.menuList.add(new JMenu("Administar"));// ingreso de datos en el array
        this.menuList.add(new JMenu("Informacion"));// ingreso de datos en el array*/
        
        this.menuList.add(new JMenu("Provincia"));
        
        this.menuList.add(new JMenu("Canton"));
        
        this.menuList.add(new JMenu("Parroquia"));
        

        this.menuItemList= new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Agregar Pais"));
        
        /*this.menuItemList.add(new JMenuItem("Crear  Carpeta/SubCarpetas"));
        this.menuItemList.add(new JMenuItem("Modificar Carpeta/SubCarpetas"));
        this.menuItemList.add(new JMenuItem("Eliminar  Carpeta/SubCarpetas"));
        
        this.menuItemList.add(new JMenuItem("Crear Archivo"));
        this.menuItemList.add(new JMenuItem("Modificar Archivo"));
        this.menuItemList.add(new JMenuItem("Eliminar Archivo"));
        
        this.menuItemList.add(new JMenuItem("Directorio"));*/
        
        this.menuItemList.add(new JMenuItem("Agregar Provincia"));
        
        this.menuItemList.add(new JMenuItem("Agregar Canton"));
        
        this.menuItemList.add(new JMenuItem("Agregar Parroquia"));
        
        
        this.setContentPane(this.escritorio);
        this.setJMenuBar(barraMenu);
        
        this.barraMenu.add(this.menuList.get(0));
        this.menuList.get(0).add(this.menuItemList.get(0));
        
        /*this.barraMenu.add(this.menuList.get(1));
        this.menuList.get(1).add(this.menuItemList.get(1));
        this.menuList.get(1).add(this.menuItemList.get(2));
        this.menuList.get(1).add(this.menuItemList.get(3));
        */
        this.barraMenu.add(this.menuList.get(1));
        this.menuList.get(1).add(this.menuItemList.get(1));
        /*this.menuList.get(2).add(this.menuItemList.get(5));
        this.menuList.get(2).add(this.menuItemList.get(6));
        
        /*
        this.barraMenu.add(this.menuList.get(2));
        this.menuList.get(3).add(this.menuItemList.get(2));*/
        
        this.barraMenu.add(this.menuList.get(2));
        this.menuList.get(2).add(this.menuItemList.get(2));
        
        this.barraMenu.add(this.menuList.get(3));
        this.menuList.get(3).add(this.menuItemList.get(3));
        
        this.menuItemList.get(0).addActionListener(new EventoPrincipal(this));
      //this.menuItemList.get(1).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(1).addActionListener(new EventoPrincipal(this));
        
        this.menuItemList.get(2).addActionListener(new EventoPrincipal(this));
        
        this.menuItemList.get(3).addActionListener(new EventoPrincipal(this));
        /*this.menuItemList.get(3).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(4).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(5).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(6).addActionListener(new EventoVentanaPrincipal(this));
        this.menuItemList.get(7).addActionListener(new EventoVentanaPrincipal(this));*/

    }

    public GestionDato getGestionDato() {
        return gestionDato;
    }

    public void setGestionDato(GestionDato gestionDato) {
        this.gestionDato = gestionDato;
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public JMenuBar getBarraMenu() {
        return barraMenu;
    }

    public void setBarraMenu(JMenuBar barraMenu) {
        this.barraMenu = barraMenu;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public ArrayList<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(ArrayList<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }
     
    
    
}
