package Modelos.GestionProyecto;

import FRM.FrmVentas;
import Vistas.GestorVista;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Moisés Yordán
 */
public class GestorVistaVentas extends GestorVista  {
    private FrmVentas form;
    private Ventas model;
    private GestorVistaAuto gestorAuto = new GestorVistaAuto();
    private GestorVistaCliente gestorCliente = new GestorVistaCliente();
    private GestorVistaEmpleado gestorEmpleado = new GestorVistaEmpleado();
    //private FrmPrincipal2 fPrincipal = new FrmPrincipal2();

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
//    public Date convertirStringADate() throws ParseException {
//        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
//        java.util.Date fechadefactura = formatDate.parse(this.getForm().getTxtFechaDeVenta().getText());
//        
//        return fechadefactura;
//    }
    @Override
    public int setModel() {
        if (this.isDatosValidos()) {
            this.getModel().setModelo(this.getForm().getTxtModelo().getText());
            this.getModel().setPais(this.getForm().getTxtPais().getText());
            this.getModel().setMarca(this.getForm().getTxtMarca().getText());
            this.getModel().setAño(this.getForm().getTxtAño().getText());
            
            this.getModel().setCantidad(this.getForm().convertirAIntCantidad());
            this.getModel().setImpuesto(this.getForm().getTxtImpuesto().getText());
            
            this.getModel().setTotal(this.getForm().convertirAInt());
            
            this.getModel().setObvservaciones(this.getForm().getTxtObvservaciones().getText());
            
            this.getModel().setFechaDeVenta(this.getForm().getTxtFechaDeVenta().getText());
            
            this.getModel().setEmpleado((Empleado) this.getForm().getCmbEmpleado().getModel().getSelectedItem());
            this.getModel().setCliente((Cliente) this.getForm().getCmbCliente().getModel().getSelectedItem());
            this.getModel().setAuto((Auto) this.getForm().getCmbAuto().getModel().getSelectedItem()); //agrege esta linea
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    //validacion para datos ingresados cuando se crea un objeto, NO se permite el no ingreso de estos datos son campos obligatorios
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
    //metodo para validar si lo ingresado son numeros
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
        this.setForm(new FrmVentas(this));
        this.setTitulo(this.getForm().getTitle());
        this.getEscritorio().add(this.getForm());
        this.getForm().setLocation(0,0);
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
    
// busquedas, iteradores y otras 
    public List <Ventas> listarVentas(){   
        return this.listarClase(Ventas.class,"auto");
    }

    public int getUltimoCodigo() {
        try {
            Ventas auxModel = (Ventas) this.listarUltimo(Ventas.class).get(0);
            return auxModel.getCodigo();
        } catch (Exception e) {
            return 0;
        }
    }
    
     public void initializeTablaBusqueda(JTable tbl) {
        String[] titulo={"","Cód.","Modelo","Marca","Pais","Año","Cliente","Empleado","Cantidad U°","Total $","Impuesto %","FechaDeVenta","Obvservaciones"};
        String[] ancho ={"5","20","90","90","90","90","90","90","90","90","90","90","90"};
        this.newModelTable(tbl,titulo,ancho);
    }
     
    @Override
    public void getView() {
       this.getForm().getCmbAuto().setSelectedItem(this.getModel().getAuto());
        this.getForm().getTxtCodigo().setText(this.getModel().getCodigoS());
        this.getForm().getTxtModelo().setText(this.getModel().getModelo());
        this.getForm().getTxtMarca().setText(this.getModel().getMarca());
        this.getForm().getTxtPais().setText(this.getModel().getPais());
        this.getForm().getTxtAño().setText(this.getModel().getAño());

        this.getForm().getTxtCantidad().setText(this.getModel().convertirAStringCantidad());
        this.getForm().getTxtImpuesto().setText(this.getModel().getImpuesto());
        this.getForm().getTxtTotal().setText(this.getModel().convertirAString());
        
        this.getForm().getTxtObvservaciones().setText(this.getModel().getObvservaciones());
         this.getForm().getTxtFechaDeVenta().setText(this.getModel().getFechaDeVenta());
     
       this.getForm().getCmbEmpleado().setSelectedItem(this.getModel().getEmpleado());
       this.getForm().getCmbCliente().setSelectedItem(this.getModel().getCliente());
    }
 // set busqueda trae lo el dato que se ingresa para buscar, asi tambien una bandera que indica cual boton de busqueda se preciono, como parametro 
public void setBusqueda(String dato,int ord, String text, String quebuscar,int b,boolean mod,boolean marc,boolean pre, boolean fecha,String inicio,String fin,String montoInicial,String montoFinal){ 
        this.initializeTablaBusqueda(this.getForm().getTblDatos());
      
        if(!"".equals(dato)){ 
           if(b==0){//b=>0 es una cadena numerica    1= es una cadena alfanumerica

                this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),dato,quebuscar,b,"",null,null,mod,marc,pre,fecha,"","","",""));
                int d=Integer.parseInt(dato);
                if(this.listarGenericoNumero(ord,d,quebuscar,Cliente.class,-1).size()==0){
                    JOptionPane.showMessageDialog(null, "error, no se encontro en la BD","Validación de Datos",JOptionPane.WARNING_MESSAGE);
                }
           }
           else{
                //this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),dato,quebuscar,b,"",null));
               
                List listaCliente= new ArrayList<Cliente>();
                List listaEmpleado= new ArrayList<Empleado>();
                DefaultTableModel d =new DefaultTableModel();
                //listo todos los nombre de los clientes q considan con el dato a buscar y los traigo en un array
//                listaCliente=this.listarGenericoLetraObj(ord,"nombre",dato,Cliente.class,-1);
//                //listo todos los nombre de los empleados q considan con el dato a buscar y los traigo en un array
//                listaEmpleado=this.listarGenericoLetraObj(ord,"nombre",dato,Empleado.class,-1);
                //d es una tabla vacia que solo se va utilizar para saber su tamaño, en caso de que el cliente/empleado/marca/modelo  no coinsidan con el dato
                // entrar al if y mostrara el cartel de error
                
                if(this.listarDatos(d ,this.getOrdenamiento(),dato,"",b,"",listaCliente,listaEmpleado,mod,marc,pre,fecha,inicio,fin,montoInicial,montoFinal).getRowCount()==0){
                    JOptionPane.showMessageDialog(null, "error, no se encontro en la BD","Validación de Datos",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    
                    this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),dato,"",b,"",listaCliente,listaEmpleado,mod,marc,pre,fecha,inicio,fin,montoInicial,montoFinal));
                
                    
               } 
            }
        }
        else {
            b=3;
            this.getForm().getTblDatos().setModel(this.listarDatos((DefaultTableModel )this.getForm().getTblDatos().getModel(),this.getOrdenamiento(),"","",b,"",null,null,false,false,false,false,"","","","")); 
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

    public Object getItemTablaSelected(JTable tbl) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        return model.getValueAt(tbl.getSelectedRow(),0);
    }
    
public DefaultTableModel listarDatos(DefaultTableModel auxModelTabla, int ordenamiento, String dato, String quebuscar , int b,String text,List listaCliente, List listaEmpleado,boolean mod, boolean marc, boolean pre, boolean fecha,String inicio,String fin,String montoInicial,String montoFinal) { 
        TreeSet<Ventas> lista = new TreeSet(); 
        // en este if se buscara por codigo solo se permitira ingresar numeros
        if(b==0){
            int d=Integer.parseInt(dato);
            List<Ventas> list= this.listarGenericoNumero(ordenamiento,d,quebuscar,Ventas.class,-1);
            Ventas  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Ventas) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Ventas ) it2.next();
                //{"","Cód.","Modelo","Marca","Año","Costo","Total","Stock","Pais"};
                Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getModelo(),auxModel.getMarca(),
                                 auxModel.getPais(),auxModel.getAño(),auxModel.getCliente(),auxModel.getEmpleado(),
                                 auxModel.getCantidad(),auxModel.getTotal(),auxModel.getImpuesto(),auxModel.getFechaDeVenta(), 
                                 auxModel.getObvservaciones()};      
                auxModelTabla.addRow(fila);
            }
        }
        // si b=1 entonces sera la busqueda de la lupa y se podra ingresar tanto numero como letras se busca por nombrecliente nombreempleado marca y modelo
        if(b==1){
            Ventas  auxModel;
//            for( int i =0; i<listaCliente.size();i++){
//               List listCliente=(this.listarGenericoLetra(ordenamiento,"cliente",listaCliente.get(i),Ventas.class, -1));
//                Iterator it = (Iterator) listCliente.iterator();
//                while (it.hasNext())  {
//                    auxModel =(Ventas) it.next(); 
//                    lista.add(auxModel);
//                }
//            }
//               for( int i =0; i<listaEmpleado.size();i++){
//               List listEmpleado=(this.listarGenericoLetra(ordenamiento,"empleado",listaEmpleado.get(i),Ventas.class, -1));
//                Iterator it = (Iterator) listEmpleado.iterator();
//                while (it.hasNext())  {
//                    auxModel =(Ventas) it.next(); 
//                    lista.add(auxModel);
//                }
//            }
            if (marc){
            
            List listMarca=(this.listarGenericoLetraObj(ordenamiento,"marca",dato,Ventas.class, -1));
                Iterator it = (Iterator) listMarca.iterator();
                while (it.hasNext())  {
                    auxModel =(Ventas) it.next(); 
                    lista.add(auxModel);
                }
            }

            if(mod){
            
            List listModelo=(this.listarGenericoLetraObj(ordenamiento,"modelo",dato,Ventas.class, -1));
                Iterator it1 = (Iterator) listModelo.iterator();
                while (it1.hasNext())  {
                    auxModel =(Ventas) it1.next(); 
                    lista.add(auxModel);
                }
            }
            if(pre){
            
            List listtotal=(this.listarGenericoMonto(ordenamiento,"total",dato,Ventas.class, -1,montoInicial,montoFinal));
                Iterator it1 = (Iterator) listtotal.iterator();
                while (it1.hasNext())  {
                    auxModel =(Ventas) it1.next(); 
                    lista.add(auxModel);
                }
            System.out.print(listtotal.size());
            }
            if(fecha){
            
            List listfecha=(this.listarGenericoFecha(ordenamiento,"fechaDeVenta",dato,Ventas.class, -1,inicio,fin));
                Iterator it1 = (Iterator) listfecha.iterator();
                while (it1.hasNext())  {
                    auxModel =(Ventas) it1.next(); 
                    lista.add(auxModel);
                }
            System.out.print(listfecha.size());
            }
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Ventas ) it2.next();
                Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getModelo(),auxModel.getMarca(),
                                 auxModel.getPais(),auxModel.getAño(),auxModel.getCliente(),auxModel.getEmpleado(),
                                 auxModel.getCantidad(),auxModel.getTotal(),auxModel.getImpuesto(),auxModel.getFechaDeVenta(), 
                                 auxModel.getObvservaciones()};      
                auxModelTabla.addRow(fila);
            }  
        }
        // si b=3 quiere decir q no hay dato ingresado por lo tanto se listara todo lo q se encuentre en la base de datos
        if(b==3){
            List<Ventas> list= this.listarTodo(text,ordenamiento,Ventas.class,-1);
            Ventas  auxModel;
            Iterator it = (Iterator) list.iterator();
            while (it.hasNext())  {
                auxModel =(Ventas) it.next(); 
                lista.add(auxModel);
            }
       
            Iterator it2 = (Iterator) lista.iterator();
            while (it2.hasNext())  {
                auxModel =( Ventas ) it2.next();
                Object[] fila = {auxModel,auxModel.getCodigo(),auxModel.getModelo(),auxModel.getMarca(),
                                 auxModel.getPais(),auxModel.getAño(),auxModel.getCliente(),auxModel.getEmpleado(),
                                 auxModel.getCantidad(),auxModel.getTotal(),auxModel.getImpuesto(),auxModel.getFechaDeVenta(), 
                                 auxModel.getObvservaciones()};      
                auxModelTabla.addRow(fila); 
            } 
        }
     return auxModelTabla;
}
    
    public void crearCliente(){
        this.gestorCliente.openFormulario(escritorio);
    }


}