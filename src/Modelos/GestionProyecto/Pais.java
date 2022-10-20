/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Pais implements Comparable, Serializable {

    @Id
    @Column(columnDefinition = "SERIAL")
    private long id;
    private int estado;
    private int codigopais;
    private String nombrepais;
    private String impuesto;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    public int getCodigopais() {
        return codigopais;
    }

    public void setCodigopais(int codigopais) {
        this.codigopais = codigopais;
    }

    public String getNombrepais() {
        return nombrepais;
    }

    public void setNombrepais(String nombrepais) {
        this.nombrepais = nombrepais;
    }
    
    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    /**
     *
     * @return
     */


    public Pais() {
    }

    public Pais(long id, int codigopais, String nombrepais, String impuesto) {
        this.id = id;
        this.codigopais = codigopais;
        this.nombrepais = nombrepais;
        this.impuesto = impuesto;
    }
    
    @Override
    public String toString() {
        return nombrepais;
    }
    
    public int compareTo(Object o) {
        Pais p = (Pais) o;
        return this.getNombrepais().compareTo(p.getNombrepais());
    }
    
    public String getCodigoS() {
        return this.getCodigopais()+"";
    }

}
