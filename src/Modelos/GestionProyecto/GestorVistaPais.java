/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import Vistas.GestorVista;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class GestorVistaPais extends GestorVista{
     private Pais model;

    public Pais getModel() {
        return model;
    }

    public void setModel(Pais model) {
        this.model = model;
    }
    
    
    
    
    public DefaultComboBoxModel getComboModelPais() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Pais auxTipo : this.listarPaises()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
    
    public List <Pais> listarPaises(){   
        return this.listarClase(Pais.class,"nombrepais");
    }
     
}
