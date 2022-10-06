package Modelos.GestionProyecto;

import FRM.FrmAuto;
import static Hibernate.HibernateUtil.getSession;
import Vistas.GestorVista;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Moisés Yordán
 */
public class GestorVistaAuto extends GestorVista  {
    private FrmAuto form;
    private Auto model;
    private GestorVistaModelo gestorModelo = new GestorVistaModelo();

   
    public FrmAuto getForm() {
        return form;
    }

    public void setForm(FrmAuto form) {
        this.form = form;
    }

    public Auto getModel() {
        return model;
    }

    public void setModel(Auto model) {
        this.model = model;
    }

    public GestorVistaModelo getGestorModelo() {
        return gestorModelo;
    }

    public void setGestorModelo(GestorVistaModelo gestorModelo) {
        this.gestorModelo = gestorModelo;
    }

    @Override
    public void newModel() {
        this.setModel(new Auto());
        this.setModoNuevo();
    }

    public void setModelModelo(JComboBox cmb) {
        cmb.setModel(getComboModelTipoProyecto());
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
    public void eliminar(){
        this.getModel().asEliminado();
        this.actualizarObjeto(this.getModel());
    }
    @Override
    public int setModel() {
        if (this.isDatosValidos()) {
            this.getModel().setModelo((Modelo) this.getForm().getCmbModelo().getModel().getSelectedItem());
            this.getModel().setMarca(this.getForm().getTxtMarca().getText());
            this.getModel().setAño(this.getForm().getTxtAño().getText());
            this.getModel().setCosto(this.getForm().getTxtCosto().getText());
            this.getModel().setTotal(this.getForm().getTxtTotal().getText());
            this.getModel().setStock(this.getForm().getTxtStock().getText());
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
         if (this.isEmpty(this.getForm().getCmbModelo())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el Modelo");
            this.getForm().getCmbModelo().grabFocus();
            return false;
        }
         if (this.isEmpty(this.getForm().getTxtAño())|| !validarNumerosAño(this.getForm().getTxtAño().getText().trim())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar bien el año");
            this.getForm().getTxtAño().grabFocus();
            return false;
        } 
        if (this.isEmpty(this.getForm().getTxtCosto())|| !validarNumeros(this.getForm().getTxtCosto().getText().trim())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el costo");
            this.getForm().getTxtCosto().grabFocus();
            return false;
        }
         if (this.isEmpty(this.getForm().getTxtStock())|| !validarNumeros(this.getForm().getTxtStock().getText().trim())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el stock");
            this.getForm().getTxtStock().grabFocus();
            return false;
        }

        return true;
    }
    //Validacion para que solo ingrese numeros para Año, Costo, Stock
    public static boolean validarNumerosAño(String datos){
        return datos.matches("[0-9]{4,4}");
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
        this.setForm(new FrmAuto(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }

    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmAuto(this));
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
    public List <Auto> listarAutos(){   
        return this.listarClase(Auto.class,"modelo");
    }
    public DefaultComboBoxModel getComboModelTipoProyecto() {
        return this.getGestorModelo().getComboModelModelo();
        
    }

    public DefaultComboBoxModel getComboModelAuto() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Auto auxTipo : this.listarAutos()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }

    public int getUltimoCodigo() {
        try {
            Auto auxModel = (Auto) this.listarUltimo(Auto.class).get(0);
            return auxModel.getCodigo();
        } catch (Exception e) {
            return 0;
        }

    }
    
     public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo={"","Cód.","MODELO","MARCA","Año","Costo","Total","Stock"};
        String[] ancho ={"10","30","100","111","40","100","100","40"};
        this.newModelTable(tbl,titulo,ancho);
    }
     @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getCmbModelo().setSelectedItem(this.getModel().getModelo().getMarca());
        this.getForm().getCmbModelo().setSelectedItem(this.getModel().getModelo());
        this.getForm().getTxtAño().setText(this.getModel().getAño());
        
        this.getForm().getTxtCosto().setText(this.getModel().getCosto());
        this.getForm().getTxtTotal().setText(this.getModel().getTotal());
        this.getForm().getTxtStock().setText(this.getModel().getStock());

    }

public void setBusqueda(String valor,int ord, String text){ //quizas agregar un argumento string para realizar un if q me traiga lo q diga ese string txtBusqueda
        this.initializeTablaBusqueda(this.getForm().getTblDatos());

        if("".equals(valor)){
           this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),""));
        }

        else {
            this.getForm().getTblDatos().setModel(this.listarDatos2((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),this.getForm().getTxtBuscar().getText(),""));
            if(this.listar2(text,ord,valor).size()==0){
                JOptionPane.showMessageDialog(null, "error","Validación de Datos",JOptionPane.WARNING_MESSAGE);
        }
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
                    this.setModel((Auto)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                    this.getForm().clearView();
                    this.getForm().viewActualizar(); 
                }
            }
        }
        else{
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                this.setModel((Auto)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                this.getForm().clearView();
                this.getForm().viewActualizar();
            }     
        }
    }

public DefaultTableModel listarDatos(DefaultTableModel auxModelTabla, int ordenamiento, String text) { 
        TreeSet<Auto> lista= new TreeSet();
        List<Auto> list= this.listar(text,ordenamiento); 
        Auto  auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Auto) it.next(); 
            lista.add(auxModel);
         }

        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =(Auto) it2.next();
            Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getModelo(),auxModel.getMarca(),auxModel.getAño(),auxModel.getCosto(),auxModel.getTotal(),auxModel.getStock()}; 
            auxModelTabla.addRow(fila); 
        }
        return auxModelTabla;
    }
    
    public DefaultTableModel listarDatos2(DefaultTableModel auxModelTabla, int ordenamiento, String valor, String text) { 
        TreeSet<Auto> lista = new TreeSet(); 
        List<Auto> list= this.listar2(text,ordenamiento,valor); 
        Auto  auxModel;
        Iterator it = (Iterator) list.iterator();
        while (it.hasNext())  {
            auxModel =(Auto) it.next(); 
            lista.add(auxModel);
         }

        Iterator it2 = (Iterator) lista.iterator();
        while (it2.hasNext())  {
            auxModel =( Auto ) it2.next();
            Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getModelo(),auxModel.getMarca(),auxModel.getAño(),auxModel.getCosto(),auxModel.getTotal(),auxModel.getStock()}; 
            auxModelTabla.addRow(fila); 
        }
        return auxModelTabla;
    }
    
    public List<Auto> listar(String text,int ord) {
        Criteria crit = getSession().createCriteria(Auto.class)
             .add( Restrictions.eq("Estado", 0));  // esto no lo habia entendido hasta ahoera comprobar si mi combobox trae marcas con estado 1
             crit.add( Restrictions.like("marca",'%'+ text.toUpperCase()+'%'));
        return crit.list();
    }
     public List<Auto> listar2(String text,int ord,String valor) { 
        Criteria crit = getSession().createCriteria(Auto.class)
             .add( Restrictions.eq("Estado", 0));  // esto no lo habia entendido hasta ahoera comprobar si mi combobox trae marcas con estado 1
             crit.add( Restrictions.eq("marca", valor));
             //crit.add( Restrictions.like("marca",'%'+ text.toUpperCase()+'%'));
        return crit.list();
    }
}
