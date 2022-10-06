/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import FRM.FrmVentas;
import static Hibernate.HibernateUtil.getSession;
import Vistas.FrmPrincipal;
import Vistas.GestorVista;
import Vistas.GestorVistaPrincipal;
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
 * @author Mois�s Yord�n
 */
public class GestorVistaVentas extends GestorVista  {
    private FrmVentas form;
    private Ventas model;
    private GestorVistaAuto gestorAuto = new GestorVistaAuto();
    private GestorVistaCliente gestorCliente = new GestorVistaCliente();
    private GestorVistaEmpleado gestorEmpleado = new GestorVistaEmpleado();

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
  
    public GestorVistaAuto getGestorAuto() {
        return gestorAuto;
    }
    public void setGestorAuto(GestorVistaAuto gestorAuto) {
        this.gestorAuto = gestorAuto;
    }
    
    public GestorVistaEmpleado getGestorEmpleado() {
        return gestorEmpleado;
    }
    public void setGestorEmpleado(GestorVistaEmpleado gestorEmpleado) {
        this.gestorEmpleado = gestorEmpleado;
    }    
    
    public GestorVistaCliente getGestorCliente() {
        return gestorCliente;
    }
    public void setGestorCliente(GestorVistaCliente gestorCliente) {
        this.gestorCliente = gestorCliente;
    }
    
    @Override
    public void newModel() {
        this.setModel(new Ventas());
        this.setModoNuevo();
    }
     
    public void setModelAuto(JComboBox cmb) {
        cmb.setModel(getComboModelTipoProyecto());
    }
    public DefaultComboBoxModel getComboModelTipoProyecto() {
        return this.getGestorAuto().getComboModelAuto();
    }
    
    public void setModelCliente(JComboBox cmb) {
        cmb.setModel(getComboModelTipoProyecto1());
    }
    public DefaultComboBoxModel getComboModelTipoProyecto1() {
        return this.getGestorCliente().getComboModelCliente();
    }
    
    public void setModelEmpleado(JComboBox cmb) {
        cmb.setModel(getComboModelTipoProyecto2());
    }
    public DefaultComboBoxModel getComboModelTipoProyecto2() {
        return this.getGestorEmpleado().getComboModelEmpleado();
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

        }

    }
   
    public void eliminar(){
        this.getModel().asEliminado();
        this.actualizarObjeto(this.getModel());
    }
    
    @Override
    public int setModel() {
        if (this.isDatosValidos()) {
            this.getModel().setAuto((Auto) this.getForm().getCmbAuto().getModel().getSelectedItem());
            this.getModel().setPais(this.getForm().getTxtPais().getText());
            this.getModel().setMarca(this.getForm().getTxtMarca().getText());
            this.getModel().setA�o(this.getForm().getTxtA�o().getText());
            
            this.getModel().setCantidad(this.getForm().getTxtCantidad().getText());
            this.getModel().setImpuesto(this.getForm().getTxtImpuesto().getText());
            this.getModel().setTotal(this.getForm().getTxtTotal().getText());
            
            this.getModel().setObvservaciones(this.getForm().getTxtObvservaciones().getText());
            this.getModel().setFechaDeVenta(this.getForm().getTxtFechaDeVenta().getText());
            
            this.getModel().setEmpleado((Empleado) this.getForm().getCmbEmpleado().getModel().getSelectedItem());
            this.getModel().setCliente((Cliente) this.getForm().getCmbCliente().getModel().getSelectedItem());
            
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {

         if (this.isEmpty(this.getForm().getTxtCantidad())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente la cantidad");
            this.getForm().getTxtCantidad().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getCmbAuto())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el Auto");
            this.getForm().getCmbAuto().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getCmbEmpleado())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el Empleado");
            this.getForm().getCmbEmpleado().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getCmbCliente())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar el Cliente");
            this.getForm().getCmbCliente().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getTxtObvservaciones())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente las Obvservaciones");
            this.getForm().getTxtObvservaciones().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getTxtFechaDeVenta())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente la FechaDeVenta, Ejemplo: 05102022");
            this.getForm().getTxtFechaDeVenta().grabFocus();
            return false;
        }

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
        this.setForm(new FrmVentas(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }

    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmVentas(this));
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
    public List <Ventas> listarVentas(){   
        return this.listarClase(Ventas.class,"auto");
    }

//    public DefaultComboBoxModel getComboModelVentas() {      
//        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
//        auxModel.addElement("");
//        for (Ventas auxTipo : this.listarVentas()) {
//            auxModel.addElement(auxTipo);
//        }
//         return auxModel;
//    }
   
    public int getUltimoCodigo() {
        try {
            Ventas auxModel = (Ventas) this.listarUltimo(Ventas.class).get(0);
            return auxModel.getCodigo();
        } catch (Exception e) {
            return 0;
        }

    }
    
     public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo={"","C�d.","Modelo","marca","Pais","a�o","Cliente","Empleado","cantidad","total","impuesto","fechaDeVenta"};//CAMBIARRRRRRRRRRR
        String[] ancho ={"5","20","90","90","90","90","90","90","90","90","90","90"};
        this.newModelTable(tbl,titulo,ancho);
    }
     
    @Override
    public void getView() {
       this.getForm().getCmbAuto().setSelectedItem(this.getModel().getAuto());
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getTxtMarca().setText(this.getModel().getMarca());
        this.getForm().getTxtPais().setText(this.getModel().getPais());
        this.getForm().getTxtA�o().setText(this.getModel().getA�o());

        this.getForm().getTxtCantidad().setText(this.getModel().getCantidad());
        this.getForm().getTxtImpuesto().setText(this.getModel().getImpuesto());
        this.getForm().getTxtTotal().setText(this.getModel().getTotal());
        
        this.getForm().getTxtObvservaciones().setText(this.getModel().getObvservaciones());
        this.getForm().getTxtFechaDeVenta().setText(this.getModel().getFechaDeVenta());
       this.getForm().getCmbEmpleado().setSelectedItem(this.getModel().getEmpleado());
       this.getForm().getCmbCliente().setSelectedItem(this.getModel().getCliente());
    }
    
    public void setBusqueda() {
        Boolean error=false;
        this.initializeTablaBusqueda(this.getForm().getTblDatos());

        if (!error) {
      
            this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),""));
        }
        else{
            JOptionPane.showMessageDialog(null, "Falta ingresar datos para la b�squeda","Validaci�n de Datos",JOptionPane.WARNING_MESSAGE);
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
                    this.setModel((Ventas)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                    this.getForm().clearView();
                    this.getForm().viewActualizar(); 
                }
            }
        }
        else{
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                this.setModel((Ventas)this.getItemTablaSelected(this.getForm().getTblDatos()));  
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
            Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getModelo(),
            auxModel.getPais(),auxModel.getMarca(),auxModel.getA�o(),
            auxModel.getCantidad(),auxModel.getImpuesto(),auxModel.getTotal(), auxModel.getObvservaciones(),auxModel.getFechaDeVenta(),
            auxModel.getEmpleado(),auxModel.getCliente()
            }; 
            auxModelTabla.addRow(fila); 
        }
        return auxModelTabla;
    }
     public List<Ventas> listar(String text,int ord) {
        Criteria crit = getSession().createCriteria(Cliente.class)
             .add( Restrictions.eq("estado", 0));
             crit.add( Restrictions.like("modelo", text.toUpperCase()+'%'));
        return crit.list();
    }  
//    public void  abrirCliente(){
//        GestorVistaCliente.getInstancia().openFormulario(FrmPrincipal.escritorio);
//        GestorVistaCliente.getInstancia().nuevoItem();
//          GestorVistaPrincipal.abrirCliente(escritorio);
//    }
}