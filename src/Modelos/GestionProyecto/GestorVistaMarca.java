/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import FRM.FrmMarca;
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

public class GestorVistaMarca extends GestorVista {

    private FrmMarca form;
    private Marca model;
//    private GestorVistaPais gestorPais = new GestorVistaPais();

   
    public FrmMarca getForm() {
        return form;
    }

    public void setForm(FrmMarca form) {
        this.form = form;
    }

    public Marca getModel() {
        return model;
    }

    public void setModel(Marca model) {
        this.model = model;
    }

//    public GestorVistaPais getGestorPais() {
//        return gestorPais;
//    }
//
//    public void setGestorPais(GestorVistaPais gestorPais) {
//        this.gestorPais = gestorPais;
//    }

    @Override
    public void newModel() {
        this.setModel(new Marca());
        this.setModoNuevo();
    }

//    public void setModelPais(JComboBox cmb) {
//        cmb.setModel(getComboModelTipoProyecto());
//    }
  
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
    
    public void eliminar(){
        this.getModel().asEliminado();
        this.actualizarObjeto(this.getModel());
    }
    @Override
    public int setModel() {
        if (this.isDatosValidos()) {
            this.getModel().setNombre(this.getForm().getTxtNombre().getText());
//            this.getModel().setPais((Pais) this.getForm().getCmbPais().getModel().getSelectedItem());

            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getTxtNombre())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la marca");
            this.getForm().getTxtNombre().grabFocus();
            return false;
        }

//        if (this.isEmpty(this.getForm().getCmbPais())) {
//            JOptionPane.showMessageDialog(null, "Falta ingresar el item de Proyecto");
//            this.getForm().getCmbPais().grabFocus();
//            return false;
//        }

        return true;
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
                this.eliminar();
                break;

        }
    }

    private void newCodigo() {
        this.getModel().setCodigo(this.getUltimoCodigo() + 1);
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
        this.setForm(new FrmMarca(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }

    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmMarca(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);
    }
    public Object getItemTablaSelected(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        return model.getValueAt(tbl.getSelectedRow(),0);
    }
    
   // busquedas, iteradores y otras 
    public List <Marca> listarMarcas(){   //
        return this.listarClase(Marca.class,"nombre");
    }
//    public DefaultComboBoxModel getComboModelTipoProyecto() {
//        return this.getGestorPais().getComboModelPais();
//    }
    
    public DefaultComboBoxModel getComboModelMarca() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Marca auxTipo : this.listarMarcas()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
   
    public int getUltimoCodigo() {
        try {
            Marca auxModel = (Marca) this.listarUltimo(Marca.class).get(0);
            return auxModel.getCodigo();
        } catch (Exception e) {
            return 0;
        }

    }
    
     public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo={"","Cód.","NOMBRE","PAIS"};
        String[] ancho ={"10","30","135","135"};
        this.newModelTable(tbl,titulo,ancho);
    }
         @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getTxtNombre().setText(this.getModel().getNombre());
//        this.getForm().getCmbPais().setSelectedItem(this.getModel().getPais());
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
//    public Object getItemTablaSelected(JTable tbl) {
//        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
//        return model.getValueAt(tbl.getSelectedRow(),0);
//    }
    public void setDatos() {
        if(this.getOpcABM()==1){
            int resp = JOptionPane.showConfirmDialog(null, "Usted va a perder los cambios realizados en el producto, porque no ha grabado.\nDesea continuar?","Modificar Producto",JOptionPane.YES_NO_OPTION);
            if(resp==JOptionPane.YES_OPTION){
                this.setOpcABM(-1);
                if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                    this.setModel((Marca)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                    this.getForm().clearView();
                    this.getForm().viewActualizar(); 
                }
            }
        }
        else{
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                this.setModel((Marca)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                this.getForm().clearView();
                this.getForm().viewActualizar();
            }     
        }
    }

    public DefaultTableModel listarDatos(DefaultTableModel auxModelTabla, int ordenamiento, String text) {
        TreeSet<Marca> lista= new TreeSet();
        List<Marca> list= this.listar(text,ordenamiento);
        Marca  auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Marca) it.next(); 
            lista.add(auxModel);
         }
       
        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =( Marca ) it2.next();
            Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getNombre()}; 
            auxModelTabla.addRow(fila); 
        }
        return auxModelTabla;
    }
     public List<Marca> listar(String text,int ord) {
        Criteria crit = getSession().createCriteria(Marca.class)
             .add( Restrictions.eq("Estado", 0));
             crit.add( Restrictions.like("nombre",'%'+ text.toUpperCase()+'%'));
        return crit.list();
    }  
}
