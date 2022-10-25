package Modelos.GestionProyecto;

import FRM.FrmModelo;
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


public class GestorVistaModelo extends GestorVista{
    
    private FrmModelo form;
    private Modelo model;
    private GestorVistaMarca gestorMarca = new GestorVistaMarca();
  
    public FrmModelo getForm() {
        return form;
    }

    public void setForm(FrmModelo form) {
        this.form = form;
    }

    public Modelo getModel() {
        return model;
    }

    public void setModel(Modelo model) {
        this.model = model;
    }
    
    public GestorVistaMarca getGestorMarca() {
        return gestorMarca;
    }
    public void setGestorMarca(GestorVistaMarca gestorMarca) {
        this.gestorMarca = gestorMarca;
    }
       
    @Override
    public void newModel() {
        this.setModel(new Modelo());
        this.setModoNuevo();
    }
    
    public void setModelMarca(JComboBox cmb) {
        cmb.setModel(getComboModelTipoProyecto());
    }
    public DefaultComboBoxModel getComboModelTipoProyecto() {
        return this.getGestorMarca().getComboModelMarca();
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
            this.getModel().setNombre(this.getForm().getTxtNombre().getText());
            this.getModel().setMarca((Marca) this.getForm().getCmbMarca().getModel().getSelectedItem());
            
            return 0;
        } else {
            return 1;
        }
    }
    @Override
     public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getTxtNombre())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el nombre");
            this.getForm().getTxtNombre().grabFocus();
            return false;
        }

        if (this.isEmpty(this.getForm().getCmbMarca())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar la marca");
            this.getForm().getCmbMarca().grabFocus();
            return false;
        }

        return true;
    }
    public static boolean validarNumeros(String datos){
        return datos.matches("[0-9]*");
    } 
    
    private void saveModel(int opcABM) {
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
        this.setForm(new FrmModelo(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }
     
    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmModelo(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);
    }
        
 // busquedas, iteradores y otras
    public List <Modelo> List(){   
        return getSession().createCriteria(Modelo.class).list();
    }

    public DefaultComboBoxModel getComboModelModelo() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Modelo auxTipo : this.List()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }

    public int getUltimoCodigo() {
        try {
            Modelo auxModel = (Modelo) this.listarUltimo(Modelo.class).get(0);
            return auxModel.getCodigo();
        } catch (Exception e) {
            return 0;
        }

    }
    
     public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo={"","Cód.","Nombre","Marca"};
        String[] ancho ={"10","30","145","145"};//cambiar
        this.newModelTable(tbl,titulo,ancho);
    }
     
          @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getTxtNombre().setText(this.getModel().getNombre());
        this.getForm().getCmbMarca().setSelectedItem(this.getModel().getMarca());
    }
    
    public void setBusqueda(String dato,int ord, String text, String quebuscar,int b){ 
            this.initializeTablaBusqueda(this.getForm().getTblDatos());

            if(!"".equals(dato)){
               if(b==0){//b=>0 es una cadena alfanumerica     1= es una cadena numerica

                    this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),dato,quebuscar,b,""));
                    int d=Integer.parseInt(dato);
                    if(this.listar3(text,ord,d,quebuscar).size()==0){
                        JOptionPane.showMessageDialog(null, "error","se ingreso una letra",JOptionPane.WARNING_MESSAGE);
                    }
               }
               else{
                    this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),dato,quebuscar,b,""));
                    if(this.listar2(text,ord,dato,quebuscar).size()==0){
                        JOptionPane.showMessageDialog(null, "error","Validación de Datos",JOptionPane.WARNING_MESSAGE);
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
                    this.setModel((Modelo)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                    this.getForm().clearView();
                    this.getForm().viewActualizar(); 
                }
            }
        }
        else{
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                this.setModel((Modelo)this.getItemTablaSelected(this.getForm().getTblDatos()));  
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
        TreeSet<Modelo> lista= new TreeSet();
        if(b==0){
            int d=Integer.parseInt(dato);
            List<Modelo> list= this.listar3(text,ordenamiento,d,quebuscar);
            Modelo  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Modelo) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Modelo ) it2.next();
                Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getNombre(),auxModel.getMarca()}; 
                auxModelTabla.addRow(fila); 
            }
        }
        if(b==1){
            List<Modelo> list= this.listar2(text,ordenamiento,dato,quebuscar);
            Modelo  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Modelo) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Modelo ) it2.next();
                Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getNombre(),auxModel.getMarca()}; 
                auxModelTabla.addRow(fila); 
            }  
        }
        if(b==3){
            List<Modelo> list= this.listar(text,ordenamiento);
            Modelo  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Modelo) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Modelo ) it2.next();
                Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getNombre(),auxModel.getMarca()}; 
                auxModelTabla.addRow(fila); 
            } 
        }
    return auxModelTabla;
}

    public List<Modelo> listar(String text,int ord) {
        Criteria crit = getSession().createCriteria(Modelo.class)
             .add( Restrictions.eq("estado", 0));  
             crit.add( Restrictions.like("nombre",'%'+ text.toUpperCase()+'%'));
        return crit.list();
    }
     public List<Modelo> listar2(String text,int ord,String dato,String quebuscar) { 
        Criteria crit = getSession().createCriteria(Modelo.class)
             .add( Restrictions.eq("estado", 0));  
             crit.add( Restrictions.eq(quebuscar, dato));
           //crit.add( Restrictions.like(quebuscar,'%'+ dato.toUpperCase()+'%'));
        return crit.list();
     }
     public List<Modelo> listar3(String text,int ord,int d,String quebuscar) { 
        Criteria crit = getSession().createCriteria(Modelo.class)
             .add( Restrictions.eq("estado", 0));  
             crit.add( Restrictions.eq(quebuscar, d));
           //crit.add( Restrictions.like(quebuscar,'%'+ dato.toUpperCase()+'%'));

        return crit.list();
     }
}
