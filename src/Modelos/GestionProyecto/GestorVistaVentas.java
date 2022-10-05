/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.GestionProyecto;

import FRM.FrmVentas;
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
   
    @Override
    public int setModel() {
        if (this.isDatosValidos()) {
//            this.getModel().setNombre(this.getForm().getTxtNombre().getText());
//            this.getModel().setApellido(this.getForm().getTxtApellido().getText());
//            this.getModel().setDni(this.getForm().getTxtDni().getText());
//            this.getModel().setFechanacimiento(this.getForm().getTxtFechaDeNacimiento().getText());
//            this.getModel().setTelefono(this.getForm().getTxtTelefono().getText());
//            this.getModel().setEmail(this.getForm().getTxtEmail().getText());
//            this.getModel().setDireccion(this.getForm().getTxtDireccion().getText());

            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
//        if (this.isEmpty(this.getForm().getTxtNombre())) {
//            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente el nombre");
//            this.getForm().getTxtNombre().grabFocus();
//            return false;
//        }
//        if (this.isEmpty(this.getForm().getTxtApellido())) {
//            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente el apellido");
//            this.getForm().getTxtApellido().grabFocus();
//            return false;
//        }
//        if (this.isEmpty(this.getForm().getTxtDni())|| !validarNumerosDNI(this.getForm().getTxtDni().getText().trim())) {
//            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente el DNI");
//            this.getForm().getTxtDni().grabFocus();
//            return false;
//        }
//        if (this.isEmpty(this.getForm().getTxtFechaDeNacimiento())|| !validarNumerosFN(this.getForm().getTxtFechaDeNacimiento().getText().trim())) {
//            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente la fecha de nacimiento, Ejemplo 11021999");
//            this.getForm().getTxtFechaDeNacimiento().grabFocus();
//            return false;
//        }
//         if (this.isEmpty(this.getForm().getTxtTelefono())|| !validarNumeros(this.getForm().getTxtTelefono().getText().trim())) {
//            JOptionPane.showMessageDialog(null, "Falta ingresarcorrectamente el telefono");
//            this.getForm().getTxtTelefono().grabFocus();
//            return false;
//        }
//         if (this.isEmpty(this.getForm().getTxtEmail())) {
//            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente el email, Ejemplo: argentina@gmail.com");
//            this.getForm().getTxtEmail().grabFocus();
//            return false;
//        }
//         if (this.isEmpty(this.getForm().getTxtDireccion())) {
//            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente la direccion, Ejemplo: san Juan 12");
//            this.getForm().getTxtDireccion().grabFocus();
//            return false;
//        }


        return true;
    }
   //Validacion para que solo ingrese numeros para DNI FechaDeNacimiento, Telefono
    public static boolean validarNumerosDNI(String datos){
        return datos.matches("[0-9]{4,8}");
    }
    
    public static boolean validarNumerosFN(String datos){
        return datos.matches("[0-9]{8,8}");
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
    
    public void eliminar(){
        this.getModel().asEliminado();
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
        return this.listarClase(Cliente.class,"nombre");
    }
//    public DefaultComboBoxModel getComboModelTipoProyecto() {
//        return this.getGestorPais().getComboModelPais();
//    }
    
//    public DefaultComboBoxModel getComboModelMarca() {      
//        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
//        auxModel.addElement("");
//        for (Marca auxTipo : this.listarMarcas()) {
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
        String[] titulo={"","Cód.","NOMBRE","APELLIDO","DNI","FechaDeNacimiento","Telefono","Email","Direccion"};//CAMBIARRRRRRRRRRR
        String[] ancho ={"5","20","90","90","90","90","90","90","90"};
        this.newModelTable(tbl,titulo,ancho);
    }
     
    @Override
    public void getView() {
//        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
//        this.getForm().getTxtNombre().setText(this.getModel().getNombre());
//        this.getForm().getTxtApellido().setText(this.getModel().getApellido());
//        this.getForm().getTxtDni().setText(this.getModel().getDni());
//        this.getForm().getTxtFechaDeNacimiento().setText(this.getModel().getFechanacimiento());
//        this.getForm().getTxtTelefono().setText(this.getModel().getTelefono());
//        this.getForm().getTxtEmail().setText(this.getModel().getEmail());
//        this.getForm().getTxtDireccion().setText(this.getModel().getDireccion());
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
            Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getNombre(),auxModel.getApellido(),auxModel.getDni(),auxModel.getFechanacimiento(),auxModel.getTelefono(),auxModel.getEmail(),auxModel.getDireccion()}; //CAMBIARRRRRRRRRRRRRRRRRRRRRRRR
            auxModelTabla.addRow(fila); 
        }
        return auxModelTabla;
    }
     public List<Ventas> listar(String text,int ord) {
        Criteria crit = getSession().createCriteria(Cliente.class)
             .add( Restrictions.eq("estado", 0));
             crit.add( Restrictions.like("nombre",'%'+ text.toUpperCase()+'%'));
        return crit.list();
    }  
}