/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.controlador;

import java.util.List;
import practica002.modelo.Pais;

/**
 *
 * @author pedro
 */
public class GestionDato 
{
     private List<Pais> paisList;

    public GestionDato(List<Pais> paisList) {
        this.paisList = paisList;
    }
     
      public boolean addPais(Pais as)
    {
        return this.paisList.add(as);
    } 

    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }
      
    
}
