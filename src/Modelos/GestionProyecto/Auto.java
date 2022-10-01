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

/**
 *
 * @author Moisés Yordán
 */
@Entity
public class Auto implements Comparable, Serializable {
       @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private int codigo; 
    @OneToOne (targetEntity = Modelo.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Modelo modelo;
    private int Estado;
    private int costo;
    private int stock;
    private int total;//dudas
    private int año;
    
    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int costo) {
        this.total = (int) (costo+costo*0.2);
    }
    
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
//    public Modelo getMarca() {
//        return marca;
//    }
//
//    public void setMarca(Marca marca) {
//        this.marca = marca;
//    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
    
    public Auto() {
    }

    public Auto(long id, int codigo, Modelo modelo, int costo,int stock, Modelo marca, int año ) {
        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.año = año;
        this.costo=costo;
        this.stock=stock;
        this.modelo=marca;
        
    }
    
//    @Override
//    public String toString() {
//        return modelo;
//    }
    
    @Override
    public int compareTo(Object o) {
        Auto p = (Auto) o;
        return this.getModelo().compareTo(p.getModelo());
    }
    
    public String getCodigoS() {
        return this.getCodigo()+"";
    }
    public void asEliminado() {
        this.setEstado(1);
    }
    
    
}
