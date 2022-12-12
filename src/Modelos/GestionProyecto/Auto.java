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
public class Auto implements Comparable<Auto> ,Serializable{

       @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private int codigo; 
    @OneToOne (targetEntity = Modelo.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Modelo modelo;
    private int estado;
    private int costo;
    private int stock;
    private int total;
    private String año;
    private String marca;
    private int ganancia;
    @OneToOne (targetEntity = Pais.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Pais pais; //----> para mi deberia ser un objeto pais de tipo pais  

    public int getGanancia() {
        return ganancia;
    }

    public void setGanancia(int ganancia) {
        this.ganancia = ganancia;
    }
    
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
    
    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    public String convertirAStringCosto(){
        String i = String.valueOf(getCosto());
        return i;
    }
    public int getTotal() {
        return total;
    }

    public void setTotal(int costo) {
        this.total = costo;
    }
    public String convertirAStringTotal(){
        String i = String.valueOf(getTotal());
        return i;
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public String convertirAStringStock(){
        String i = String.valueOf(getStock());
        return i;
    }
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Auto() {
    
    }

    public Auto(long id, int codigo, Modelo modelo, String marca,  String año, int costo, int total, int stock, Pais pais, int ganancia) {
        this.id =id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca=marca;
        this.año = año;
        this.costo=costo;
        this.total=total;
        this.stock=stock;
        this.pais = pais;
        this.ganancia=ganancia;
    }
    
    @Override
    public String toString() {
        return 
                "Modelo: "+getModelo()+"\n"+"    "+
                "Año:  "+ getAño()+"\n"+"    "+
                "Pais: "+ getPais();
    }
    
    @Override
    public int compareTo(Auto o) {
        int salida;
        if(o.getMarca().compareToIgnoreCase(this.marca)==0){
            if(o.getAño().compareToIgnoreCase(this.año)>0){
                salida = -1;
            }
            else if(o.getAño().compareToIgnoreCase(this.año)<0){
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
