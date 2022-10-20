/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import FRM.FrmPais;
import static Hibernate.HibernateUtil.getSession;
import Vistas.GestorVista;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class GestorVistaPais extends GestorVista{
    private Pais model;
    private FrmPais form;
    
    public Pais getModel() {
        return model;
    }
    public void setModel(Pais model) {
        this.model = model;
    }
    
    public FrmPais getForm() {
        return form;
    }
    public void setForm(FrmPais form) {
        this.form = form;
    }
    
    @Override
    public void newModel() {
        this.setModel(new Pais());
        this.setModoNuevo();
    }

    @Override
    public void saveView() {
        int err;
        err = this.setModel();
        if (err == 0) {
            this.saveModel(this.getOpcABM());
            this.actualizarView();
        }
    }

    @Override
    public void actualizarView() {
        this.getForm().viewGuardar();
        if (this.getOpcABM() == 0) {
            this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
//            this..setItems(this.getForm().getTbl());
        }

    }
    
    @Override
    public int setModel() {
        if (this.isDatosValidos()) {
            this.getModel().setNombrepais(this.getForm().getTxtPais().getText());
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getTxtImpuesto())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el impuesto");
            this.getForm().getTxtImpuesto().grabFocus();
            return false;
        }
        return true;
    }
    public static boolean validarNumeros(String datos){
        return datos.matches("[0-9]*");
    } 
    
    public void saveModel(int opcABM) {
        switch (opcABM) {
            case 0:
                this.guardarObjeto();
                break;

            case 1:
                this.actualizarObjeto();
                break;

            case 2:
               // this.eliminar();
                break;

        }
    }

    private void newCodigo() {
        this.getModel().setCodigopais(this.getUltimoCodigo() + 1);
    }

    public void guardarObjeto() {
        this.newCodigo();
        this.guardarObjeto(this.getModel());
    }

    public void actualizarObjeto() {
        this.actualizarObjeto(this.getModel());
    }

    @Override
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmPais(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }

    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmPais(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);
    }

    public DefaultComboBoxModel getComboModelPais() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Pais auxTipo : this.listarPaises()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
    
    public List <Pais> listarPaises(){   //creo q deberiamos listar un objeto pais q contenga todos sus atributo nosolo su nombre
        return this.listarClase(Pais.class,"nombrepais");
    }
    
    public int getUltimoCodigo() {
        try {
            Pais auxModel = (Pais) this.listarUltimo(Pais.class).get(0);
            return auxModel.getCodigopais();
        } catch (Exception e) {
            return 0;
        }
    }
        public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo={"","Cód.","Nombre","Impuesto"};
        String[] ancho ={"10","30","150","150"};
        this.newModelTable(tbl,titulo,ancho);
    }
     
    @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getTxtPais().setText(this.getModel().getNombrepais());
        this.getForm().getTxtImpuesto().setText(this.getModel().getImpuesto());
    
    }
    
    public void setBusqueda(String dato,int ord, String text, String quebuscar,int b){ 
            this.initializeTablaBusqueda(this.getForm().getTblDatos());

            if(!"".equals(dato)){
               if(b==0){//b=>0 es una cadena alfanumerica     1= es una cadena numerica

                    this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),dato,quebuscar,b,""));
                    int d=Integer.parseInt(dato);
                    if(this.listar3(text,ord,d,quebuscar).size()==0){
                        JOptionPane.showMessageDialog(null, "error, se ingreso una letra","Validación de Datos",JOptionPane.WARNING_MESSAGE);
                    }
               }
               else{
                    this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),dato,quebuscar,b,""));
                    if(this.listar2(text,ord,dato,quebuscar).size()==0){
                        JOptionPane.showMessageDialog(null, "Tiene que ingresar un nombre, no! un numero","Validación de Datos",JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            else{
                b=3;
                this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),"","",b,"")); 
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
                    this.setModel((Pais)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                    this.getForm().clearView();
                    this.getForm().viewActualizar(); 
                }
            }
        }
        else{
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                this.setModel((Pais)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                this.getForm().clearView();
                this.getForm().viewActualizar();
            }     
        }
    }
    
    public Object getItemTablaSelected(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        return model.getValueAt(tbl.getSelectedRow(),0);
    }

    public DefaultTableModel listarDatos(DefaultTableModel auxModelTabla, int ordenamiento, String dato, String quebuscar , int b,String text) { 
        TreeSet<Pais> lista= new TreeSet();
        if(b==0){
            int d=Integer.parseInt(dato);
            List<Pais> list= this.listar3(text,ordenamiento,d,quebuscar);
            Pais  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Pais) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Pais ) it2.next();
                Object[] fila = {auxModel,auxModel.getCodigopais(),auxModel.getNombrepais(),auxModel.getImpuesto()};                 
                auxModelTabla.addRow(fila); 
            }
        }
        if(b==1){
            List<Pais> list= this.listar2(text,ordenamiento,dato,quebuscar);
            Pais  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Pais) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Pais ) it2.next();
                Object[] fila = {auxModel,auxModel.getCodigopais(),auxModel.getNombrepais(),auxModel.getImpuesto()};    
                auxModelTabla.addRow(fila); 
            }  
        }
        if(b==3){
            List<Pais> list= this.listar(text,ordenamiento);
            Pais  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Pais) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Pais ) it2.next();
                Object[] fila = {auxModel,auxModel.getCodigopais(),auxModel.getNombrepais(),auxModel.getImpuesto()};   
                auxModelTabla.addRow(fila); 
            } 
        }
    return auxModelTabla;
}

    public List<Pais> listar(String text,int ord) {
        Criteria crit = getSession().createCriteria(Pais.class)
             .add( Restrictions.eq("estado", 0)); 
             crit.add( Restrictions.like("nombrepais",'%'+ text.toUpperCase()+'%'));
        return crit.list();
    }
     public List<Pais> listar2(String text,int ord,String dato,String quebuscar) { 
        Criteria crit = getSession().createCriteria(Pais.class)
             .add( Restrictions.eq("estado", 0));  
             crit.add( Restrictions.eq(quebuscar, dato));
           //crit.add( Restrictions.like(quebuscar,'%'+ dato.toUpperCase()+'%'));

        return crit.list();
     }
     public List<Pais> listar3(String text,int ord,int d,String quebuscar) { 
        Criteria crit = getSession().createCriteria(Pais.class)
             .add( Restrictions.eq("estado", 0));  
             crit.add( Restrictions.eq(quebuscar, d));
           //crit.add( Restrictions.like(quebuscar,'%'+ dato.toUpperCase()+'%'));

        return crit.list();
     }
}
