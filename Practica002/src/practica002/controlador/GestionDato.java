/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica002.controlador;

import java.util.List;
import practica002.modelo.Canton;
import practica002.modelo.Pais;
import practica002.modelo.Parroquia;

/**
 *
 * @author pedro
 */
public class GestionDato {

    private List<Pais> paisList;
    private List<Canton> cantonList;
    private List<Parroquia> parroquiaList;

    public GestionDato(List<Pais> paisList, List<Canton> cantonList, List<Parroquia> parroquiaList) {
        this.paisList = paisList;
        this.cantonList = cantonList;
        this.parroquiaList = parroquiaList;
    }

    public boolean addPais(Pais as) {
        return this.paisList.add(as);
    }

    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    public List<Canton> getCantonList() {
        return cantonList;
    }

    public void setCantonList(List<Canton> cantonList) {
        this.cantonList = cantonList;
    }

    public boolean addCanton(Canton canton) {
        return this.cantonList.add(canton);
    }
    
    public boolean addParroquia(Parroquia parroquia) {
        return this.parroquiaList.add(parroquia);
    }

    public List<Parroquia> getParroquiaList() {
        return parroquiaList;
    }

    public void setParroquiaList(List<Parroquia> parroquiaList) {
        this.parroquiaList = parroquiaList;
    }
    
    

}
