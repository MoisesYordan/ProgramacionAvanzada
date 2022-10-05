/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Marca implements Comparable, Serializable {
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private int codigo; 
    private String nombre; 

    @OneToOne (targetEntity = Pais.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Pais pais;
    private int estado;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
    public int getEstado() {
        return estado;
    }

    public void setEstado(int nombre) {
        this.estado = nombre;
    }

    public Marca() {
    }

    public Marca(long id, int codigo, String nombre, Pais pais) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    @Override
    public int compareTo(Object o) {
        Marca p = (Marca) o;
        return this.getNombre().compareTo(p.getNombre());
    }
    
    public String getCodigoS() {
        return this.getCodigo()+"";
    }
    public void asEliminado() {
        this.setEstado(1);
    }

}
