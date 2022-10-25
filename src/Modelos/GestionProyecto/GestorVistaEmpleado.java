package Modelos.GestionProyecto;

import FRM.FrmEmpleado;
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
 * @author Moisés Yordán
 */
public class GestorVistaEmpleado extends GestorVista {
    private FrmEmpleado form;
    private Empleado model;

    public FrmEmpleado getForm() {
        return form;
    }
    public void setForm(FrmEmpleado form) {
        this.form = form;
    }

    public Empleado getModel() {
        return model;
    }
    public void setModel(Empleado model) {
        this.model = model;
    }

    @Override
    public void newModel() {
        this.setModel(new Empleado());
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
    
    public void eliminar(){
        this.getModel().asEliminado();
        this.actualizarObjeto(this.getModel());
    }
    
    @Override
    public int setModel() {
        if (this.isDatosValidos()) {
            this.getModel().setNombre(this.getForm().getTxtNombre().getText());
            this.getModel().setApellido(this.getForm().getTxtApellido().getText());
            this.getModel().setDni(this.getForm().getTxtDni().getText());
            this.getModel().setFechanacimiento(this.getForm().getTxtFechaDeNacimiento().getText());
            this.getModel().setTelefono(this.getForm().getTxtTelefono().getText());
            this.getModel().setEmail(this.getForm().getTxtEmail().getText());
            this.getModel().setDireccion(this.getForm().getTxtDireccion().getText());
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean isDatosValidos() {
        if (this.isEmpty(this.getForm().getTxtNombre())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente el nombre");
            this.getForm().getTxtNombre().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getTxtApellido())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente el apellido");
            this.getForm().getTxtApellido().grabFocus();
            return false;
        }
         if (this.isEmpty(this.getForm().getTxtDni())|| !validarNumerosDNI(this.getForm().getTxtDni().getText().trim())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente el DNI");
            this.getForm().getTxtDni().grabFocus();
            return false;
        }
        if (this.isEmpty(this.getForm().getTxtFechaDeNacimiento())|| !validarNumerosFN(this.getForm().getTxtFechaDeNacimiento().getText().trim())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente la fecha de nacimiento, Ejemplo 11021999");
            this.getForm().getTxtFechaDeNacimiento().grabFocus();
            return false;
        }
         if (this.isEmpty(this.getForm().getTxtTelefono())|| !validarNumeros(this.getForm().getTxtTelefono().getText().trim())) {
            JOptionPane.showMessageDialog(null, "Falta ingresarcorrectamente el telefono");
            this.getForm().getTxtTelefono().grabFocus();
            return false;
        }
         if (this.isEmpty(this.getForm().getTxtEmail())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente el email, Ejemplo: argentina@gmail.com");
            this.getForm().getTxtEmail().grabFocus();
            return false;
        }
         if (this.isEmpty(this.getForm().getTxtDireccion())) {
            JOptionPane.showMessageDialog(null, "Falta ingresar correctamente la direccion, Ejemplo: san Juan 12");
            this.getForm().getTxtDireccion().grabFocus();
            return false;
        }
  
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

    @Override
    public void openFormulario(JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setForm(new FrmEmpleado(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
    }

    public void openFormulario(DefaultComboBoxModel model, JDesktopPane pantalla) {
        this.setEscritorio(pantalla);
        this.setModelCombo(model);
        this.setOpcABM(2);
        this.setForm(new FrmEmpleado(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setVisible(true);
        this.setOpcABM(2);
    }

// busquedas, iteradores y otras 
    public List <Empleado> listarEmpleados(){   
        return this.listarClase(Empleado.class,"nombre");
    }
    public DefaultComboBoxModel getComboModelEmpleado() {      
        DefaultComboBoxModel auxModel= new DefaultComboBoxModel();
        auxModel.addElement("");
        for (Empleado auxTipo : this.listarEmpleados()) {
            auxModel.addElement(auxTipo);
        }
         return auxModel;
    }
    
    public int getUltimoCodigo() {
        try {
            Empleado auxModel = (Empleado) this.listarUltimo(Empleado.class).get(0);
            return auxModel.getCodigo();
        } catch (Exception e) {
            return 0;
        }

    }
    
     public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo={"","Cód.","Nombre","Apellido","DNI","FechaDeNacimiento","Telefono","Email","Direccion"};
        String[] ancho ={"3","20","90","90","90","90","90","90","90"};
        this.newModelTable(tbl,titulo,ancho);
    }
    
    @Override
    public void getView() {
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getTxtNombre().setText(this.getModel().getNombre());
        this.getForm().getTxtApellido().setText(this.getModel().getApellido());
        this.getForm().getTxtDni().setText(this.getModel().getDni());
        this.getForm().getTxtFechaDeNacimiento().setText(this.getModel().getFechanacimiento());
        this.getForm().getTxtTelefono().setText(this.getModel().getTelefono());
        this.getForm().getTxtEmail().setText(this.getModel().getEmail());
        this.getForm().getTxtDireccion().setText(this.getModel().getDireccion());

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
                    this.setModel((Empleado)this.getItemTablaSelected(this.getForm().getTblDatos()));  
                    this.getForm().clearView();
                    this.getForm().viewActualizar(); 
                }
            }
        }
        else{
            if (this.isItemTablaSelected(this.getForm().getTblDatos())) {
                this.setModel((Empleado)this.getItemTablaSelected(this.getForm().getTblDatos()));  
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
        TreeSet<Empleado> lista= new TreeSet();
        if(b==0){
            int d=Integer.parseInt(dato);
            List<Empleado> list= this.listar3(text,ordenamiento,d,quebuscar);
            Empleado  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Empleado) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Empleado ) it2.next();
//{"","Cód.","Nombre","Apellido","DNI","FechaDeNacimiento","Telefono","Email","Direccion"};
                Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getNombre(),auxModel.getApellido(),auxModel.getDni(),
                                 auxModel.getFechanacimiento(),auxModel.getTelefono(),auxModel.getEmail(),auxModel.getDireccion()};                auxModelTabla.addRow(fila); 
            }
        }
        if(b==1){
            List<Empleado> list= this.listar2(text,ordenamiento,dato,quebuscar);
            Empleado  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Empleado) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Empleado ) it2.next();
//{"","Cód.","Nombre","Apellido","DNI","FechaDeNacimiento","Telefono","Email","Direccion"};
                Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getNombre(),auxModel.getApellido(),auxModel.getDni(),
                                 auxModel.getFechanacimiento(),auxModel.getTelefono(),auxModel.getEmail(),auxModel.getDireccion()};                auxModelTabla.addRow(fila); 
            }  
        }
        if(b==3){
            List<Empleado> list= this.listar(text,ordenamiento);
            Empleado  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Empleado) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Empleado ) it2.next();
//{"","Cód.","Nombre","Apellido","DNI","FechaDeNacimiento","Telefono","Email","Direccion"};
                Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getNombre(),auxModel.getApellido(),auxModel.getDni(),
                                 auxModel.getFechanacimiento(),auxModel.getTelefono(),auxModel.getEmail(),auxModel.getDireccion()};                auxModelTabla.addRow(fila); 
            } 
        }
        return auxModelTabla;
    }
        public List<Empleado> listar(String text,int ord) {
        Criteria crit = getSession().createCriteria(Empleado.class)
             .add( Restrictions.eq("estado", 0));  
             crit.add( Restrictions.like("nombre",'%'+ text.toUpperCase()+'%'));
        return crit.list();
    }
     public List<Empleado> listar2(String text,int ord,String dato,String quebuscar) { 
        Criteria crit = getSession().createCriteria(Empleado.class)
             .add( Restrictions.eq("estado", 0));  
             crit.add( Restrictions.eq(quebuscar, dato));
           //crit.add( Restrictions.like(quebuscar,'%'+ dato.toUpperCase()+'%'));

        return crit.list();
     }
     public List<Empleado> listar3(String text,int ord,int d,String quebuscar) { 
        Criteria crit = getSession().createCriteria(Empleado.class)
             .add( Restrictions.eq("estado", 0)); 
             crit.add( Restrictions.eq(quebuscar, d));
           //crit.add( Restrictions.like(quebuscar,'%'+ dato.toUpperCase()+'%'));

        return crit.list();
     }
}
