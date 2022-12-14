package Modelos.GestionProyecto;

import java.io.Serializable;
import java.util.Date;
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
public class Ventas implements Comparable, Serializable {
        @Id @GeneratedValue(strategy=javax.persistence.GenerationType.AUTO)
    private long id;
    private int codigo;
    private int estado;

    @OneToOne (targetEntity = Auto.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Auto auto;
    
    private String modelo;
    private String pais;
    private String marca;
    private String año;
    
    private int cantidad;
    private String impuesto;
    private int total;
    private int gananciatotal;
    
    private String obvservaciones;
    private String fechaDeVenta;
    
    @OneToOne (targetEntity = Empleado.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Empleado empleado;
    @OneToOne (targetEntity = Cliente.class, cascade= CascadeType.ALL,fetch=FetchType.LAZY)
    private Cliente cliente;

    public int getGananciatotal() {
        return gananciatotal;
    }

    public void setGananciatotal(int gananciatotal) {
        this.gananciatotal = gananciatotal;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String convertirAStringCantidad(){
        String i = String.valueOf(getTotal());
        return i;
    }
    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public String convertirAString(){
        String i = String.valueOf(getTotal());
        return i;
    }
//    public String convertirAStringFecha(){
//        String i = String.valueOf(getFechaDeVenta());
//        return i;
//    }
    public String getObvservaciones() {
        return obvservaciones;
    }

    public void setObvservaciones(String obvservaciones) {
        this.obvservaciones = obvservaciones;
    }

    public String getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(String fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   

    public Ventas() {
        
    }
    public Ventas(long id, int codigo, String modelo, String marca,String pais, String año,Empleado empleado, Cliente cliente, String fechaDeVenta, String obvservaciones, int total, int cantidad, String impuesto,int gananciatotal) {
        this.id = id;
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.pais = pais;
        this.año = año;
        this.empleado = empleado;
        this.cliente = cliente;
        this.fechaDeVenta = fechaDeVenta;
        this.obvservaciones = obvservaciones;
        this.total = total;
        this.cantidad = cantidad;
        this.impuesto = impuesto;
        this.gananciatotal=gananciatotal;
    }
     @Override
    public String toString() {
        return 
                "Modelo: "+getCliente()+"\n"+"    "+
                "Año:  "+ getAño()+"\n"+"    "+
                "Pais: "+ getPais();
    }
    
    @Override
    public int compareTo(Object o) {
        Ventas p = (Ventas) o;
        return this.getModelo().compareTo(p.getModelo());
    }
    
    public String getCodigoS() {
        return this.getCodigo()+"";
    }
    public void asEliminado() {
        this.setEstado(1);
    }
}