package FRM;
import Modelos.GestionProyecto.Auto;
import Modelos.GestionProyecto.GestorVistaVentas;
import Vistas.FrmGenerica;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;


public class FrmVentas extends FrmGenerica {
    private GestorVistaVentas gestorVista;
    private int YES_NO_OPTION;

    public GestorVistaVentas getGestorVista() {
        return gestorVista;
    }
    
    public void setGestorVista(GestorVistaVentas gestorVista) {
        this.gestorVista = gestorVista;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }

    public void setTblDatos(JTable tblDatos) {
        this.tblDatos = tblDatos;
    }
    
// Definicion de getter y setter de los componentes visuales del formulario
    public JCheckBox getCheckFechaDeVenta() {
        return CheckFechaDeVenta;
    }

    public JCheckBox getCheckMarca() {
        return CheckMarca;
    }

    public JCheckBox getCheckModelo() {
        return CheckModelo;
    }

    public JCheckBox getCheckPrecioDeVenta() {    
        return CheckPrecioDeVenta;
    }

    public void setCheckFechaDeVenta(JCheckBox CheckFechaDeVenta) {
        this.CheckFechaDeVenta = CheckFechaDeVenta;
    }

    public void setCheckMarca(JCheckBox CheckMarca) {
        this.CheckMarca = CheckMarca;
    }

    public void setCheckModelo(JCheckBox CheckModelo) {
        this.CheckModelo = CheckModelo;
    }

    public void setCheckPrecioDeVenta(JCheckBox CheckPrecioDeVenta) {
        this.CheckPrecioDeVenta = CheckPrecioDeVenta;
    }
    

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }
    public JTextField getTxtAuto() {
        return txtAuto;
    }

    public void setTxtAuto(JTextField txtAuto) {
        this.txtAuto = txtAuto;
    }
    public JComboBox<String> getCmbAuto() {
        return cmbAuto;
    }

    public void setCmbAuto(JComboBox<String> cmbAuto) {
        this.cmbAuto = cmbAuto;
    }
    
    public JTextField getTxtPais() {
        return txtPais;
    }
    
      public JTextField getTxtModelo() {
        return txtModelo;
    }
      
    public JTextField getTxtMarca() {
        return txtMarca;
    }
    
    public JTextField getTxtAño() {
        return txtAño;
    }
    public JTextField getTxtInicio() {
        return txtInicio;
    }
    public void setTxtInicio(JTextField txtInicio) {
        this.txtInicio = txtInicio;
    }
    public JTextField getTxtFin() {
        return txtFin;
    }
    public void setTxtFin(JTextField txtFin) {
        this.txtFin = txtFin;
    }
    public JTextField getTxtMontoInicial() {
        return txtMontoInicial;
    }
    public void setTxtMontoInicial(JTextField txtMontonInicial) {
        this.txtMontoInicial = txtMontoInicial;
    }
    public JTextField getTxtMontoFinal() {
        return txtMontoFinal;
    }
    public void setTxtMontoFinal(JTextField txtMontonInicial) {
        this.txtMontoFinal = txtMontoFinal;
    }
    public JComboBox<String> getCmbEmpleado() {
        return cmbEmpleado;
    }
    
    public void setCmbEmpleado(JComboBox<String> cmbEmpleado) {
        this.cmbEmpleado = cmbEmpleado;
    }
    
    public JComboBox<String> getCmbCliente() {
        return cmbCliente;
    }

    public void setCmbCliente(JComboBox<String> cmbCliente) {
        this.cmbCliente = cmbCliente;
    }
    
    public JTextField getTxtCantidad() {
        return txtCantidad;
    }
    public void setTxtCantidad(JTextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public JTextField getTxtImpuesto() {
        return txtImpuesto;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public JTextField getTxtObvservaciones() {
        return txtObvservaciones;
    }
    public void setTxtObvservaciones(JTextField txtObvservaciones) {
        this.txtObvservaciones = txtObvservaciones;
    }

    public JTextField getTxtFechaDeVenta() {
        return txtFechaDeVenta;
    }
    public void setTxtFechaDeVenta(JTextField txtFechaDeVenta) {
        this.txtFechaDeVenta = txtFechaDeVenta;
    }
    
    public JTextField getTxtBuscar(){
        return txtBusquedaNombre;
    }
    public void setTxtBuscar(JTextField txtBusquedaNombre){
        this.txtBusquedaNombre=txtBusquedaNombre;
    }
  
    public JTextField getTxtBuscarCodigo(){
        return txtCodigo;
    }
    public void setTxtBuscarCodigo(JTextField txtCodigo){
        this.txtCodigo=txtCodigo;
    }    
// Constructores del formulario 
    int btnCandado=0;//btnCandado=> 0 se presiono por 1era Vez (habilitar el campo)  1= 2da vez realiza la buscaqueda (desabilitar el campo)
    
    public FrmVentas(GestorVistaVentas gestorVista) {
        try{
           initComponents();
           }
        catch(Exception e){
            
        }  
        this.setGestorVista(gestorVista);
        this.onViewOpened();
    }

    public FrmVentas() {
        initComponents();
    }
    
// Metodos que gestionan los botones de la barra comando 
    public void viewOpenedBotones() {//abris el frm
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnFrmCliente.setEnabled(false);
        btnCalcular.setEnabled(false); 
        btnNuevo.grabFocus();
    }

    public void viewNuevoEditarBotones(){//btnEditar
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnFrmCliente.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnCalcular.setEnabled(false); 
        btnSalir.setEnabled(true);
    }
  
    public void viewEliminarBotones() {//btnEliminar
        this.viewOpenedBotones();
    }
  
    public void viewGuardarBotones() {//btnGuardar
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnFrmCliente.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
        btnCalcular.setEnabled(false); 
        btnNuevo.grabFocus();
    }

    public void viewBuscarBotones() {//btnBuscar
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true);
        btnFrmCliente.setEnabled(false);
        btnSalir.setEnabled(true);
        btnCancelar.setEnabled(true); 
        btnCalcular.setEnabled(false); 
    } 
    
    @Override
    public void onViewOpened() {
        this.viewOpenedBotones();
        this.viewCamposEnabled(false);
        this.cargarCombos();
        this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
       // this.isExtra();
     }
    
    @Override
    public void cargarCombos() {
        this.gestorVista.setModelAuto(cmbAuto);
        this.gestorVista.setModelEmpleado(cmbEmpleado);
        this.gestorVista.setModelCliente(cmbCliente);
    }

    @Override
    public void viewCamposEnabled(Boolean tipo) {//al abrir el FRM
        txtCodigo.setEnabled(false);
        
        cmbAuto.setEnabled(tipo);
        txtAuto.setEnabled(false);
        txtModelo.setEnabled(false);
        txtPais.setEnabled(false);
        txtMarca.setEnabled(false);
        txtAño.setEnabled(false);
        
        txtCantidad.setEnabled(tipo);
        txtImpuesto.setEnabled(false);
        txtTotal.setEnabled(false);
        
        cmbEmpleado.setEnabled(tipo);
        cmbCliente.setEnabled(tipo);
        
        txtObvservaciones.setEnabled(tipo);
        txtFechaDeVenta.setEnabled(false);
    }

    private void viewBasic(){
        this.viewNuevoEditarBotones();
        this.viewCamposEnabled(true);
    }

    @Override
    public void viewNuevoEnter( ) {
        this.viewBasic();
        this.viewNueva();
    }

    @Override
    public void viewEditarEnter( ) {
        this.viewBasic();
        txtAuto.grabFocus();
        this.getGestorVista().setModoEditar();
    }

    @Override
    public void viewGuardar() {
        this.viewGuardarBotones();
        this.viewGuardarBotones();
        this.viewCamposEnabled(false);
    }

    @Override
    public void viewEliminar() {
        this.viewEliminarBotones();
        this.viewGuardarBotones();
        this.viewCamposEnabled(false);
        this.clearView();
    }

    public void viewActualizar() {
        this.setView();
        this.viewCamposEnabled(false);
        this.viewBuscarBotones();
    }


    private void viewNueva(){
        Date today;
        
        today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        this.clearView();
        this.getGestorVista().newModel();
        txtAuto.grabFocus();
        txtFechaDeVenta.setText(sdf.format(today)+"");
        
    }
    @Override
    public void clearView() {
        txtCodigo.setText("");
        
        txtAuto.setText("");
        txtModelo.setText("");
        txtPais.setText("");
        txtMarca.setText("");
        txtAño.setText("");
        
        txtCantidad.setText("");
        txtImpuesto.setText("");
        txtTotal.setText("");
        
        txtObvservaciones.setText("");
        txtFechaDeVenta.setText("");
    }

    @Override
    public void grabFocus(){
        cmbAuto.grabFocus();
    }

   @Override
    public void cancelarView() {
        this.getGestorVista().cancelarView();
        this.onViewOpened();
        this.clearView();
    }

    @Override
    public void deleteView() {
         this.getGestorVista().deleteView();
    }

    @Override
    public void saveView(){
        this.getGestorVista().saveView();
    }

    @Override
    public void setView(){
       this.getGestorVista().getView();
    }  
  
//llenado de tablas
    public void setBusqueda(int busqueda,boolean mod, boolean marc, boolean pre, boolean fecha) {
        int ord = 0;
        int b=0;//b=>0 es una cadena alfanumerica      1= es una cadena numerica
        String text = null;
        //String inicio=this.txtBusquedaNombre.getText();
        String fin= this.txtFin.getText();
        String inicio=this.txtInicio.getText();
        String dato=this.txtBusquedaNombre.getText();//se pone en la variable dato lo que esta dentro de la barra de busqueda de la lupa
        String montoInicial=this.txtMontoInicial.getText();
        String montoFinal= this.txtMontoFinal.getText();
        //pregunta si dato es igual a un numero(codigo) o una letra(barra de busqueda)
        //busqueda=> 0=lupa de buscar     1= el candado de buscarCodigo
        if (this.getGestorVista().validarNumeros(dato)==false|| busqueda==0){
            b=1;//b=>0 es una cadena alfanumerica            1= es una cadena numerica
            String quebuscar="modelo";
            this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
            this.getGestorVista().setBusqueda(dato,ord,text,quebuscar,b,mod,marc,pre,fecha,inicio,fin,montoInicial,montoFinal);  
        }else{
            b=0;//b=>0 es una cadena alfanumerica            1= es una cadena numerica
            dato=this.txtCodigo.getText();//se pone en la variable dato lo que esta dentro de la barra de codigo
            String quebuscar="codigo";
            this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
            this.getGestorVista().setBusqueda(dato,ord,text,quebuscar,b,mod,marc,pre,fecha,inicio,fin,montoInicial,montoFinal); 
        }
    }
    
     public void llenadoCmbAutos(){
        Auto auto = (Auto) cmbAuto.getSelectedItem();
        txtModelo.setText(auto.getModelo().toString());   
        txtMarca.setText(auto.getMarca());  
        txtPais.setText(auto.getPais().toString());  
        txtAño.setText(auto.getAño()); 
        btnCalcular.setEnabled(true); 
     }
     
    public void calcularTotal(){
        Auto auto = (Auto) cmbAuto.getSelectedItem();
        int cantidad = Integer.parseInt(txtCantidad.getText());//cantidad ingresada
//        int stock = this.gestorVista.convertirToInteger(this.gestorVista.getGestorAuto().getForm().getTxtStock());//stock que tengo por auto
//        int total2=stock-cantidad;//total2 sirve para saber si tengo Stock o no
//        if(total2<0){
            Double impuesto=Double.parseDouble( auto.getPais().getImpuesto());
            Double total= Double.parseDouble( auto.getTotal());
            total= total+(total*cantidad*(impuesto/100));
            txtImpuesto.setText(auto.getPais().getImpuesto()); 
            txtTotal.setText(Math.round(total) +"");
//            JTextField total3 = new JTextField(total2);//total3 lo uso unicamentee para convertir el int a JTextField
//            this.gestorVista.getGestorAuto().getForm().setTxtStock(total3);
//        }else{
//            JOptionPane.showMessageDialog(null, "NO HAY STOCK","Validación de Datos",JOptionPane.WARNING_MESSAGE);
//        }
    }
    
     /** Este método se llama desde dentro del constructor para inicializar el formulario.
     ADVERTENCIA: NO modifique este código. 
     El contenido de este método es siempre regenerado por el Editor de formularios.**/
    @SuppressWarnings("unchecked")//para suprimir avisos relativos a operaciones no comprobadas .
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnImprimir1 = new javax.swing.JButton();
        txtBusquedaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtInicio = new javax.swing.JTextField();
        txtFin = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnBuscar1 = new javax.swing.JButton();
        CheckModelo = new javax.swing.JCheckBox();
        CheckMarca = new javax.swing.JCheckBox();
        CheckFechaDeVenta = new javax.swing.JCheckBox();
        CheckPrecioDeVenta = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtMontoInicial = new javax.swing.JTextField();
        txtMontoFinal = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtPais = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscarCodigo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        cmbEmpleado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnFrmCliente = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFechaDeVenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtObvservaciones = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbAuto = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtAuto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Ventas");
        setToolTipText("Ventas");
        setFrameIcon(null);
        setName("TipoServicio"); // NOI18N
        getContentPane().setLayout(null);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(935, 660));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDatos);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 450, 310));

        btnImprimir1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        btnImprimir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PrinterChica.png"))); // NOI18N
        btnImprimir1.setText("Imprir");
        btnImprimir1.setToolTipText("Impreme el documento");
        btnImprimir1.setBorderPainted(false);
        btnImprimir1.setContentAreaFilled(false);
        jPanel4.add(btnImprimir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 110, 40));

        txtBusquedaNombre.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtBusquedaNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtBusquedaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 240, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Monto Inicial");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 190, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setMinimumSize(new java.awt.Dimension(190, 40));
        jPanel5.setPreferredSize(new java.awt.Dimension(190, 40));

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarChico.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnEditar.setMaximumSize(new java.awt.Dimension(75, 29));
        btnEditar.setMinimumSize(new java.awt.Dimension(75, 29));
        btnEditar.setPreferredSize(new java.awt.Dimension(75, 29));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEditar);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/remove.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnEliminar.setMaximumSize(new java.awt.Dimension(75, 29));
        btnEliminar.setMinimumSize(new java.awt.Dimension(75, 29));
        btnEliminar.setPreferredSize(new java.awt.Dimension(75, 29));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel5.add(btnEliminar);

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, -1, -1));
        jPanel5.getAccessibleContext().setAccessibleDescription("");

        txtInicio.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtInicio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 240, 30));

        txtFin.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtFin.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 240, 30));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscar1.setText("Buscar");
        btnBuscar1.setToolTipText("Buscar Tipo Servicio por denominación");
        btnBuscar1.setBorderPainted(false);
        btnBuscar1.setContentAreaFilled(false);
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 30));

        CheckModelo.setText("Modelo");
        jPanel7.add(CheckModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        CheckMarca.setText("Marca");
        jPanel7.add(CheckMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        CheckFechaDeVenta.setText("Fecha De Venta");
        jPanel7.add(CheckFechaDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        CheckPrecioDeVenta.setText("Precio De Venta");
        jPanel7.add(CheckPrecioDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 200, 180));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Ventas");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Fecha Inicio");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 190, -1));

        txtMontoInicial.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtMontoInicial.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtMontoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 240, 30));

        txtMontoFinal.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtMontoFinal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtMontoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 240, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Fecha Final");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 190, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Monto Final");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 190, -1));

        jDesktopPane1.add(jPanel4);
        jPanel4.setBounds(10, 30, 480, 640);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 660));
        jPanel1.setLayout(null);

        txtPais.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtPais.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtPais);
        txtPais.setBounds(150, 100, 120, 30);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel3.setText("Código");
        jLabel3.setRequestFocusEnabled(false);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 90, 19);

        txtCodigo.setBackground(new java.awt.Color(204, 255, 204));
        txtCodigo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.setToolTipText("Ingrese Código");
        txtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtCodigo);
        txtCodigo.setBounds(20, 40, 90, 25);

        btnBuscarCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        btnBuscarCodigo.setToolTipText("Buscar Tipo Servicio por código");
        btnBuscarCodigo.setBorderPainted(false);
        btnBuscarCodigo.setContentAreaFilled(false);
        btnBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarCodigo);
        btnBuscarCodigo.setBounds(110, 40, 30, 30);

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel2.setText("Empleado");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 390, 120, 19);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(null);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir);
        btnSalir.setBounds(112, 5, 75, 30);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnCancelar.setMaximumSize(new java.awt.Dimension(61, 21));
        btnCancelar.setMinimumSize(new java.awt.Dimension(61, 21));
        btnCancelar.setPreferredSize(new java.awt.Dimension(61, 21));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar);
        btnCancelar.setBounds(12, 5, 75, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(300, 590, 200, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);
        btnGuardar.setBounds(110, 5, 75, 30);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/add.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnNuevo.setMaximumSize(new java.awt.Dimension(75, 29));
        btnNuevo.setMinimumSize(new java.awt.Dimension(75, 29));
        btnNuevo.setPreferredSize(new java.awt.Dimension(75, 29));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);
        btnNuevo.setBounds(10, 5, 75, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 590, 200, 40);

        cmbEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jPanel1.add(cmbEmpleado);
        cmbEmpleado.setBounds(20, 410, 120, 30);

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel5.setText("%");
        jLabel5.setRequestFocusEnabled(false);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(140, 250, 30, 30);

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel6.setText("Pais");
        jLabel6.setRequestFocusEnabled(false);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(150, 80, 90, 20);

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jPanel1.add(cmbCliente);
        cmbCliente.setBounds(200, 410, 120, 30);

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel7.setText("Cliente");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(200, 390, 120, 19);

        btnFrmCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Add_Symbol.png"))); // NOI18N
        btnFrmCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFrmClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnFrmCliente);
        btnFrmCliente.setBounds(330, 410, 40, 30);

        txtMarca.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtMarca);
        txtMarca.setBounds(280, 100, 120, 30);

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel8.setText("Marca");
        jLabel8.setRequestFocusEnabled(false);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(280, 80, 90, 20);

        txtFechaDeVenta.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtFechaDeVenta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtFechaDeVenta);
        txtFechaDeVenta.setBounds(400, 520, 120, 30);

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel9.setText("FechaDeVenta");
        jLabel9.setRequestFocusEnabled(false);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(400, 500, 110, 20);

        txtObvservaciones.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtObvservaciones.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtObvservaciones);
        txtObvservaciones.setBounds(20, 500, 320, 50);

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel10.setText("Obvservaciones");
        jLabel10.setRequestFocusEnabled(false);
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 480, 110, 20);

        txtTotal.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtTotal);
        txtTotal.setBounds(400, 330, 120, 30);

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel11.setText("Total");
        jLabel11.setRequestFocusEnabled(false);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(400, 310, 90, 20);

        txtAño.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtAño.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtAño);
        txtAño.setBounds(410, 100, 120, 30);

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel12.setText("Año");
        jLabel12.setRequestFocusEnabled(false);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(410, 80, 90, 20);

        jLabel13.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel13.setText("Precio Unitario");
        jLabel13.setRequestFocusEnabled(false);
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 310, 120, 20);

        jLabel14.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel14.setText("U°");
        jLabel14.setRequestFocusEnabled(false);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(140, 170, 30, 30);

        cmbAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        cmbAuto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbAutoItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbAuto);
        cmbAuto.setBounds(150, 30, 380, 30);

        jLabel15.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel15.setText("Auto");
        jLabel15.setRequestFocusEnabled(false);
        jPanel1.add(jLabel15);
        jLabel15.setBounds(150, 10, 90, 20);

        jLabel16.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel16.setText("Cantidad");
        jLabel16.setRequestFocusEnabled(false);
        jPanel1.add(jLabel16);
        jLabel16.setBounds(20, 150, 90, 20);

        txtImpuesto.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtImpuesto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtImpuesto);
        txtImpuesto.setBounds(20, 250, 120, 30);

        txtModelo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtModelo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtModelo);
        txtModelo.setBounds(20, 100, 120, 30);

        txtAuto.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtAuto.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtAuto);
        txtAuto.setBounds(150, 30, 380, 30);
        jPanel1.add(txtCantidad);
        txtCantidad.setBounds(20, 170, 120, 30);

        jLabel17.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel17.setText("Modelo");
        jLabel17.setRequestFocusEnabled(false);
        jPanel1.add(jLabel17);
        jLabel17.setBounds(20, 80, 90, 20);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Auto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 65, 530, 80);

        btnCalcular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calcular.png"))); // NOI18N
        btnCalcular.setMargin(new java.awt.Insets(1, 1, 1, 1));
        btnCalcular.setMaximumSize(new java.awt.Dimension(61, 21));
        btnCalcular.setMinimumSize(new java.awt.Dimension(61, 21));
        btnCalcular.setPreferredSize(new java.awt.Dimension(61, 21));
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalcular);
        btnCalcular.setBounds(170, 170, 30, 30);

        jLabel18.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel18.setText("$");
        jLabel18.setRequestFocusEnabled(false);
        jPanel1.add(jLabel18);
        jLabel18.setBounds(140, 330, 30, 30);
        jPanel1.add(txtPrecioUnitario);
        txtPrecioUnitario.setBounds(20, 330, 120, 30);

        jLabel21.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel21.setText("Impuesto Aplicado");
        jLabel21.setRequestFocusEnabled(false);
        jPanel1.add(jLabel21);
        jLabel21.setBounds(20, 230, 120, 20);

        jLabel22.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel22.setText("$");
        jLabel22.setRequestFocusEnabled(false);
        jPanel1.add(jLabel22);
        jLabel22.setBounds(520, 330, 30, 30);

        jDesktopPane1.add(jPanel1);
        jPanel1.setBounds(480, 30, 560, 640);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(-10, -30, 1040, 670);

        getAccessibleContext().setAccessibleName("Carg");

        setBounds(150, 0, 1040, 670);
    }// </editor-fold>//GEN-END:initComponents
//ASD
    private void btnBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodigoActionPerformed
        int busqueda=1; //busqueda=> 0=lupa de buscar ------   1= el candado de buscarCodigo
        if (btnCandado==0) {//btnCandado =0 primera vez presionado
            txtCodigo.setEnabled(true);
            btnCandado=1;
        }
        else {//btnCandado =1 segunda vez presionado realiza la busqueda
            txtCodigo.setEnabled(false);
            this.setBusqueda(busqueda);
            btnCandado=0;
        }
}//GEN-LAST:event_btnBuscarCodigoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.saveView();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            this.getGestorVista().setForm(this);
            if(JOptionPane.showConfirmDialog(null, "Se eliminara la fila seleccionada, esta seguro que desea eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0){
                 this.getGestorVista().eliminar();
                 this.viewEliminarBotones();
            }
        }
        catch(HeadlessException e) {
            System.out.println("Error al intentar eliminar la fila"+ e.getMessage());
            JOptionPane.showMessageDialog(null, "no selecciono una fila de la tabla");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int n = 0;
        if (this.getGestorVista().isNuevo() || this.getGestorVista().isOnlyRead())
        this.dispose();
        else
        n=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?","Advertencia", YES_NO_OPTION);
        if  (n == 1 ){
            this.cancelarView();
            this.dispose();}
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados","Advertencia", YES_NO_OPTION) == 0 )
        this.cancelarView();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        int busqueda=0;//busqueda=> 0=lupa de buscar ------   1= el candado de buscarCodigo
        this.clearView();       
        this.setBusqueda(busqueda,this.CheckModelo.isSelected(),this.CheckMarca.isSelected(),this.CheckPrecioDeVenta.isSelected(),this.CheckFechaDeVenta.isSelected());
        this.viewCamposEnabled(false);
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
       this.getGestorVista().setDatos();
    }//GEN-LAST:event_tblDatosMouseClicked

    private void btnFrmClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrmClienteActionPerformed
       this.gestorVista.crearCliente();
    }//GEN-LAST:event_btnFrmClienteActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        if (!txtCantidad.getText().equals("")&& this.gestorVista.validarNumeros(txtCantidad.getText()) ){
            this.calcularTotal();
        }else{
            JOptionPane.showMessageDialog(null, "INGRESAR LA CANTIDAD DESEADA","Validación de Datos",JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_btnCalcularActionPerformed

    private void cmbAutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbAutoItemStateChanged
        this.llenadoCmbAutos();
    }//GEN-LAST:event_cmbAutoItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckFechaDeVenta;
    private javax.swing.JCheckBox CheckMarca;
    private javax.swing.JCheckBox CheckModelo;
    private javax.swing.JCheckBox CheckPrecioDeVenta;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscarCodigo;
    public javax.swing.JButton btnCalcular;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFrmCliente;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir1;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbAuto;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtAuto;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtBusquedaNombre;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFechaDeVenta;
    private javax.swing.JTextField txtFin;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMontoFinal;
    private javax.swing.JTextField txtMontoInicial;
    private javax.swing.JTextField txtObvservaciones;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
