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
public class Modelo implements Comparable, Serializable{
    @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private int estado;
    private int codigo;
    private String nombre;
    @OneToOne (targetEntity = Marca.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Marca marca;
    
    
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
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
     public int getEstado() {
        return estado;
    }

    public void setEstado(int nombre) {
        this.estado = nombre;
    }
    public Modelo(long id, int codigo, String nombre, Marca marca) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca=marca;
    }

    public Modelo() {
    }

    @Override
    public String toString() {
        return 
//                "id: "+getId()+"\n"+" "+
//                "nombre:  "+
                getNombre();
    }
    @Override
    public int compareTo(Object o) {
        Modelo p = (Modelo) o;
        return this.getNombre().compareTo(p.getNombre());
    }
    public String getCodigoS() {
        return this.getCodigo()+"";
    }
    public void asEliminado() {
        this.setEstado(1);
    }
}
