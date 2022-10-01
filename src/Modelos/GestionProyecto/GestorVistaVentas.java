/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import static Hibernate.HibernateUtil.getSession;
import Vistas.GestorVista;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Moisés Yordán
 */
public class GestorVistaVentas extends GestorVista  {
    private FrmVentas form;
    private Ventas model;
   
    public FrmVentas getForm() {
        return form;
    }

    public void setForm(FrmVentas form) {
        this.form = form;
    }

    public Ventas getModel() {
        return model;
    }

    public void setModel(Ventas model) {
        this.model = model;
    }

    @Override
    public void newModel() {
        this.setModel(new Ventas());
        this.setModoNuevo();
    }
     public void eliminar(){
        this.getModel().asEliminado();
        this.actualizarObjeto(this.getModel());
    }
     public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo={"","Cód.","NOMBRE","APELLIDO","DNI","FechaDeNacimiento","Telefono","Email","Direccion"};//CAMBIARRRRRRRRRRR
        String[] ancho ={"8","15","35","35","35","31","31","31","31"};
        this.newModelTable(tbl,titulo,ancho);
    }
         public void setBusqueda() {
        Boolean error=false;
        this.initializeTablaBusqueda(this.getForm().getTblDatos());

        if (!error) {
      
            this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),""));
        }
        else{
            JOptionPane.showMessageDialog(null, "Falta ingresar datos para la búsqueda","Validación de Datos",JOptionPane.WARNING_MESSAGE);
        } 
    }
  
    private int getOrdenamiento() {
        int ord=0;

        return ord;
    }
     public void setDatos() {
        if(this.getOpcABM()==1){
            int resp = JOptionPane.showConfirmDialog(null, "Usted va a perder los cambios realizados en el producto, porque no ha grabado.\nDesea continuar?","Modificar Producto",JOptionPane.YES_NO_OPTION);
            if(resp==JOptionPane.YES_OPTION){
                this.setOpcABM(-1);
                if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                    //this.setModel((Ventas)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                    this.getForm().clearView();
                    this.getForm().viewActualizar(); 
                }
            }
        }
        else{
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                //this.setModel((Ventas)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                this.getForm().clearView();
                this.getForm().viewActualizar();
            }     
        }
    }

    public DefaultTableModel listarDatos(DefaultTableModel auxModelTabla, int ordenamiento, String text) {
        TreeSet<Ventas> lista= new TreeSet();
        List<Ventas> list= this.listar(text,ordenamiento);
        Ventas  auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Ventas) it.next(); 
            lista.add(auxModel);
         }
       
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =( Ventas ) it2.next();
            Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getNombre(),auxModel.getApellido(),auxModel.getDni(),auxModel.getFechanacimiento(),auxModel.getTelefono(),auxModel.getEmail(),auxModel.getDireccion()}; //CAMBIARRRRRRRRRRRRRRRRRRRRRRRR
            auxModelTabla.addRow(fila); 
        }
        return auxModelTabla;
    }
     public List<Ventas> listar(String text,int ord) {
        Criteria crit = getSession().createCriteria(Empleado.class)
             .add( Restrictions.eq("estado", 0));
             crit.add( Restrictions.like("nombre",'%'+ text.toUpperCase()+'%'));
        return crit.list();
    }  
}
