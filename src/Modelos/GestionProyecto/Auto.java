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
 * @author Mois�s Yord�n
 */
@Entity
public class Auto implements Comparable<Auto> ,Serializable{

       @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private int codigo; 
    @OneToOne (targetEntity = Modelo.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Modelo modelo;
    private int estado;
    private String costo;
    private String stock;
    private String total;
    private String a�o;
    private String marca;
    private String pais;   
    
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
    
    public String getA�o() {
        return a�o;
    }

    public void setA�o(String a�o) {
        this.a�o = a�o;
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
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Auto() {
    
    }

    public Auto(long id, int codigo, Modelo modelo, String marca,  String a�o, String costo, String total, String stock, String pais) {
        this.id =id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca=marca;
        this.a�o = a�o;
        this.costo=costo;
        this.total=total;
        this.stock=stock;
        this.pais = pais;
    }
    
    @Override
    public String toString() {
        return 
                "Modelo: "+getModelo()+"\n"+"    "+
                "Marca:  "+ getMarca()+"\n"+"    "+
                "A�o:  "+ getA�o();
    }
    
    @Override
    public int compareTo(Auto o) {
        int salida;
        if(o.getMarca().compareToIgnoreCase(this.marca)==0){
            if(o.getA�o().compareToIgnoreCase(this.a�o)>0){
                salida = -1;
            }
            else if(o.getA�o().compareToIgnoreCase(this.a�o)<0){
                salida = 1;
            }
            else{
                salida=0;
            }
        }
        else if(o.getMarca().compareToIgnoreCase(this.marca)>0){
            salida= -1;
        }
        else{
            salida =1;
        }
        return salida;
    }
    
    public String getCodigoS() {
        return this.getCodigo()+"";
    }
    public void asEliminado() {
        this.setEstado(1);
    }
    
}
