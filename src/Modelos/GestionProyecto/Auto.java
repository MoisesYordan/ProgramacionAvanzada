/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import java.io.Serializable; //asd
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
    private String costo;
    private String stock;
    private String total;//dudas
    private String año;
    private String marca;
       
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
  public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
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
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
 
    public String getTotal() {
        return total;
    }

    public void setTotal(String costo) {
        this.total = costo;
    }
    
    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Auto() {
    
    }

    public Auto(long id, int codigo, Modelo modelo, String marca,  String año, String costo, String total, String stock) {
        this.id =id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca=marca;
        this.año = año;
        this.costo=costo;
        this.total=total;
        this.stock=stock;
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
