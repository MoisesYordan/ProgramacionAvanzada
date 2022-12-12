package FRM;
import Modelos.GestionProyecto.GestorVistaAuto;
import Modelos.GestionProyecto.Modelo;
import Vistas.FrmGenerica;
import java.awt.HeadlessException;
import javax.swing.*;

public class FrmAuto extends FrmGenerica {
    private GestorVistaAuto gestorVista;
    private int YES_NO_OPTION;

    public GestorVistaAuto getGestorVista() {
        return gestorVista;
    }
    
    public void setGestorVista(GestorVistaAuto gestorVista) {
        this.gestorVista = gestorVista;
    }
    
    public JTable getTblDatos() {
        return tblDatos;
    }

    public void setTblDatos(JTable tblDatos) {
        this.tblDatos = tblDatos;
    }

    public JTextField getTxtAñoFinal() {
        return txtFin;
    }

    public void setTxtAñoFinal(JTextField txtAñoFinal) {
        this.txtFin = txtAñoFinal;
    }

    public JTextField getTxtAñoInicial() {
        return txtInicio;
    }

    public void setTxtAñoInicial(JTextField txtAñoInicial) {
        this.txtInicio = txtAñoInicial;
    }
   
    
    public JCheckBox getCheckAño() {
        return CheckAño;
    }

    public void setCheckAño(JCheckBox CheckAño) {
        this.CheckAño = CheckAño;
    }

    public JCheckBox getCheckMarca() {
        return CheckMarca;
    }

    public void setCheckMarca(JCheckBox CheckMarca) {
        this.CheckMarca = CheckMarca;
    }

    public JCheckBox getCheckModelo() {
        return CheckModelo;
    }

    public void setCheckModelo(JCheckBox CheckModelo) {
        this.CheckModelo = CheckModelo;
    }

    public JCheckBox getCheckPais() {
        return CheckPais;
    }

// Definicion de getter y setter de los componentes visuales del formulario
    public void setCheckPais(JCheckBox CheckPais) {    
        this.CheckPais = CheckPais;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }
    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JComboBox<String> getCmbModelo() {
        return cmbModelo;
    }
    public void setCmbModelo(JComboBox<String> cmbModelo) {
        this.cmbModelo = cmbModelo;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }
    public void setTxtModelo(JTextField txtModelo) {
        this.txtModelo = txtModelo;
    }
    
    public JComboBox<String> getCmbPais() {
        return cmbPais;
    }
    public void setCmbPais(JComboBox<String> cmbPais) {
        this.cmbPais = cmbPais;
    }

    public JTextField getTxtPais() {
        return txtPais;
    }
    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }
    
    public JTextField getTxtMarca() {
        return txtMarca;
    }
    public JTextField getTxtCosto() {
        return txtCosto;
    }

    public void setTxtCosto(JTextField txtCosto) {
       this.txtCosto = txtCosto;
    }
    public int convertirAIntCosto(){
        int i = Integer.parseInt(getTxtCosto().getText());
        return i;
    }
    
    public JTextField getTxtTotal() {
       return txtTotal;   
    }
    public int convertirAIntTotal(){
        int i = Integer.parseInt(getTxtTotal().getText());
        return i;
    }
    public JTextField getTxtAño() {
        return txtAño;
    }
    public void setTxtAño(JTextField txtAño) {
        this.txtAño= txtAño;
    }
    
    public JTextField getTxtStock() {
        return txtStock;
    }
    public void setTxtStock(JTextField txtStock) {
        this.txtStock= txtStock;
    }
    public int convertirAIntCantidad(){
        int i = Integer.parseInt(getTxtStock().getText());
        return i;
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
    
    public FrmAuto(GestorVistaAuto gestorVista) {
        try{
           initComponents();
           }
        catch(Exception e){
            
        }  
        this.setGestorVista(gestorVista);
        this.onViewOpened();
    }

    public FrmAuto() {
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
        btnCalcular.setEnabled(false);
        btnNuevo.grabFocus();
    }

    public void viewNuevoEditarBotones(){//btnEditar
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(false);//false
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(true);
        btnCalcular.setEnabled(true);
    }
  
    public void viewEliminarBotones() {//btnEliminar
        this.viewOpenedBotones();
    }
  
    public void viewGuardarBotones() {//btnGuardar
        btnNuevo.setEnabled(true);
        btnEditar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(true); 
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
        btnSalir.setEnabled(true);
        btnCancelar.setEnabled(true);
    } 
    
    @Override
    public void onViewOpened() {
        this.viewOpenedBotones();
        this.viewCamposEnabled(false);
        this.cargarCombos();
        this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
        //this.isExtra();
     }
    
    @Override
    public void cargarCombos() {
        this.gestorVista.setModelModelo(cmbModelo);
        this.gestorVista.setModelPais(cmbPais);//ver no se comunicaria con modelo directamente?
    }

    @Override
    public void viewCamposEnabled(Boolean tipo) {//al abrir el FRM
        txtCodigo.setEnabled(false);
        txtTotal.setEnabled(false);
        txtMarca.setEnabled(false);
        txtAño.setEnabled(tipo);
        txtCosto.setEnabled(tipo);
        txtStock.setEnabled(tipo);
        txtModelo.setEnabled(false);
        cmbModelo.setEnabled(tipo); 
        txtPais.setEnabled(false);
        cmbPais.setEnabled(tipo); 
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
         cmbModelo.grabFocus();
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
        this.clearView();
        this.getGestorVista().newModel();
         cmbModelo.grabFocus();
    }

    @Override
    public void clearView() {
        txtCodigo.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
        txtAño.setText("");
        txtPais.setText("");
        txtCosto.setText("");
        txtTotal.setText("");
        txtStock.setText("");
        txtBusquedaNombre.setText("");
    }

    @Override
    public void grabFocus(){
         cmbModelo.grabFocus();
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
    public void setBusqueda(int busqueda,boolean mod, boolean marc, boolean año, boolean pais) {
        int ord = 0;
        int b=0;//b=>0 es una cadena alfanumerica      1= es una cadena numerica
        String text = null;
        String fin= this.txtFin.getText();
        String inicio=this.txtInicio.getText();
        String dato=this.txtBusquedaNombre.getText();//se pone en la variable dato lo que esta dentro de la barra de busqueda de la lupa
       
        //pregunta si dato es igual a un numero(codigo) o una letra(barra de busqueda)
        //busqueda=> 0=lupa de buscar     1= el candado de buscarCodigo
        if (this.getGestorVista().validarNumeros(dato)==false|| busqueda==0){
            b=1;//b=>0 es una cadena alfanumerica            1= es una cadena numerica
//            String quebuscar="marca";
            this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
            this.getGestorVista().setBusqueda(dato,ord,text,"",b,mod,marc,año,pais,inicio,fin);  
        }else{
            b=0;//b=>0 es una cadena numerica           1= es una cadena letras
            dato=this.txtCodigo.getText();//se pone en la variable dato lo que esta dentro de la barra de codigo
            String quebuscar="codigo";
            this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
            this.getGestorVista().setBusqueda(dato,ord,text,quebuscar,b,mod,marc,año,pais,inicio,fin); 
        }
    }
    
//    public void busqueda(){
//        int busqueda=1; //busqueda=> 0=lupa de buscar ------   1= el candado de buscarCodigo
//        if (btnCandado==0) {//btnCandado =0 primera vez presionado
//            txtCodigo.setEnabled(true);
//            btnCandado=1;
//            this.clearView();
//            txtBusquedaNombre.setEnabled(false);
//            btnBuscar1.setEnabled(false);
//        }
//        else {//btnCandado =1 segunda vez presionado realiza la busqueda
//            //txtCodigo.setEnabled(false);
//            if(this.getGestorVista().isDatosValidos2()==true){
//                this.setBusqueda(busqueda);
//                txtCodigo.setEnabled(false);
//                btnCandado=0;
//            }
//            txtBusquedaNombre.setEnabled(true);
//            btnBuscar1.setEnabled(true);
//            }
//    }
 /** Este método se llama desde dentro del constructor para inicializar el formulario.
     ADVERTENCIA: NO modifique este código. 
     El contenido de este método es siempre regenerado por el Editor de formularios.**/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscarCodigo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        cmbModelo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtModelo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        cmbPais = new javax.swing.JComboBox<>();
        txtPais = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtStock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnImprimir1 = new javax.swing.JButton();
        txtBusquedaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtFin = new javax.swing.JTextField();
        txtInicio = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        btnBuscar1 = new javax.swing.JButton();
        CheckAño = new javax.swing.JCheckBox();
        CheckPais = new javax.swing.JCheckBox();
        CheckMarca = new javax.swing.JCheckBox();
        CheckModelo = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Auto");
        setToolTipText("Auto");
        setFrameIcon(null);
        setName("TipoServicio"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setLayout(null);

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
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });
        jPanel2.add(btnGuardar);
        btnGuardar.setBounds(110, 5, 77, 30);

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
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        jPanel2.add(btnNuevo);
        btnNuevo.setBounds(10, 5, 75, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 570, 200, 40);

        cmbModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        cmbModelo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbModeloItemStateChanged(evt);
            }
        });
        jPanel1.add(cmbModelo);
        cmbModelo.setBounds(20, 100, 180, 30);
        cmbModelo.getAccessibleContext().setAccessibleName("");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(null);

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        btnSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSalirKeyPressed(evt);
            }
        });
        jPanel3.add(btnSalir);
        btnSalir.setBounds(95, 10, 75, 23);

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
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        jPanel3.add(btnCancelar);
        btnCancelar.setBounds(10, 10, 75, 23);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(350, 570, 180, 40);

        txtModelo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(187, 187, 198));
        txtModelo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtModelo);
        txtModelo.setBounds(20, 100, 170, 30);

        txtMarca.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtMarca.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtMarca);
        txtMarca.setBounds(210, 100, 210, 30);

        jLabel5.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel5.setText("Pais");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 140, 120, 19);

        jLabel6.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel6.setText("Año");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(430, 80, 80, 19);

        jLabel8.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel8.setText("Marca");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(210, 80, 120, 19);

        txtAño.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtAño.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtAño);
        txtAño.setBounds(430, 100, 80, 30);

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jPanel1.add(cmbPais);
        cmbPais.setBounds(20, 160, 180, 30);

        txtPais.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtPais.setForeground(new java.awt.Color(187, 187, 198));
        txtPais.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtPais);
        txtPais.setBounds(20, 160, 170, 30);

        jLabel12.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel12.setText("Modelo");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 80, 120, 19);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Auto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 65, 520, 250);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Precio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 204))); // NOI18N

        txtTotal.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        txtCosto.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtCosto.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel11.setText("$");

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel7.setText("$");

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel1.setText("Precio de Venta");
        jLabel1.setRequestFocusEnabled(false);

        jLabel9.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel9.setText("Costo");

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );

        btnCalcular.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(jPanel7);
        jPanel7.setBounds(10, 320, 520, 100);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 102, 204))); // NOI18N

        txtStock.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtStock.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel2.setText("Stock");

        jLabel10.setFont(new java.awt.Font("Bodoni MT", 0, 18)); // NOI18N
        jLabel10.setText("U°");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 388, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(10, 430, 520, 110);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(390, 10, 540, 620);

        jPanel4.setLayout(null);

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

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(20, 280, 340, 280);

        btnImprimir1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        btnImprimir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PrinterChica.png"))); // NOI18N
        btnImprimir1.setText("Imprimir");
        btnImprimir1.setToolTipText("Impreme el documento");
        btnImprimir1.setBorderPainted(false);
        btnImprimir1.setContentAreaFilled(false);
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnImprimir1);
        btnImprimir1.setBounds(260, 570, 110, 40);

        txtBusquedaNombre.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtBusquedaNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtBusquedaNombre);
        txtBusquedaNombre.setBounds(20, 40, 150, 30);
        txtBusquedaNombre.getAccessibleContext().setAccessibleName("txtBusquedaNombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Año Fin");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(20, 180, 190, 20);

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
        btnEditar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEditarKeyPressed(evt);
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
        btnEliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnEliminarKeyPressed(evt);
            }
        });
        jPanel5.add(btnEliminar);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(10, 570, 190, 40);
        jPanel5.getAccessibleContext().setAccessibleDescription("");

        txtFin.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtFin.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtFin);
        txtFin.setBounds(20, 200, 150, 30);

        txtInicio.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtInicio.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtInicio);
        txtInicio.setBounds(20, 120, 150, 30);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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

        CheckAño.setText("Año");

        CheckPais.setText("Pais");

        CheckMarca.setText("Marca");

        CheckModelo.setText("Modelo");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(btnBuscar1)
                .addGap(34, 34, 34))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(CheckPais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckModelo))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(CheckAño)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckMarca)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(btnBuscar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckAño)
                    .addComponent(CheckMarca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CheckPais, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CheckModelo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(37, 37, 37))
        );

        jPanel4.add(jPanel9);
        jPanel9.setBounds(200, 40, 170, 190);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Auto");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(20, 20, 190, 20);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Año Inicio");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(20, 100, 190, 20);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 10, 380, 620);

        getAccessibleContext().setAccessibleName("Carg");

        setBounds(150, 0, 954, 670);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCodigoActionPerformed
        int busqueda=1; //busqueda=> 0=lupa de buscar ------   1= el candado de buscarCodigo
        if (btnCandado==0) {//btnCandado =0 primera vez presionado
            txtCodigo.setEnabled(true);
            btnCandado=1;
        }
        else {//btnCandado =1 segunda vez presionado realiza la busqueda
            //txtCodigo.setEnabled(false);
            btnCandado=0;
            //txtCodigo.setEnabled(false);
            if(this.getGestorVista().isDatosValidos2()==true){
                this.setBusqueda(busqueda);
                txtCodigo.setEnabled(false);
                btnCandado=0;
            }
            txtBusquedaNombre.setEnabled(true);
            btnBuscar1.setEnabled(true);
        }    
}//GEN-LAST:event_btnBuscarCodigoActionPerformed
                                                                          
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnNuevoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNuevoKeyPressed
       if (evt.getKeyCode()==10)
          this.viewNuevoEnter();
    }//GEN-LAST:event_btnNuevoKeyPressed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEditarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEditarKeyPressed
        if (evt.getKeyCode()==10)
        this.viewEditarEnter();
    }//GEN-LAST:event_btnEditarKeyPressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.saveView();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if (evt.getKeyCode()==10)
        this.saveView();
    }//GEN-LAST:event_btnGuardarKeyPressed

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

    private void btnEliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnEliminarKeyPressed
        if(evt.getKeyCode()==10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado","Advertencia", YES_NO_OPTION) == 0 )
            this.deleteView();
        }
    }//GEN-LAST:event_btnEliminarKeyPressed

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

    private void btnSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSalirKeyPressed
        if(evt.getKeyCode()==10) {
            int n = 0;
            if (this.getGestorVista().isNuevo())
                 this.dispose();
            else
            n=JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios antes de salir?","Advertencia", YES_NO_OPTION);
            if  (n == 1 ){
                this.cancelarView();
                this.dispose();}
        }

    }//GEN-LAST:event_btnSalirKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados","Advertencia", YES_NO_OPTION) == 0 )
        this.cancelarView();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if(evt.getKeyCode()==10) {
            if (JOptionPane.showConfirmDialog(null, "Desea Cancelar los datos ingresados","Advertencia", YES_NO_OPTION) == 0 )
            this.cancelarView();
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        int busqueda=0;//busqueda=> 0=lupa de buscar ------   1= el candado de buscarCodigo
        this.setBusqueda(busqueda,this.CheckModelo.isSelected(),this.CheckMarca.isSelected(),this.CheckAño.isSelected(),this.CheckPais.isSelected());
        this.viewCamposEnabled(false);
        this.clearView();
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
       this.getGestorVista().setDatos();
    }//GEN-LAST:event_tblDatosMouseClicked

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
       Double costo= Double.parseDouble( txtCosto.getText());  //pasar a un metodo calcular dentro de gestor vista auto y solo llamar
       costo= costo+(costo*0.2);
       Math.round(costo);
       txtTotal.setText(Math.round(costo) +"");
       btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void cmbModeloItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbModeloItemStateChanged
      Modelo modelo = (Modelo) cmbModelo.getSelectedItem();
        txtMarca.setText(modelo.getMarca().toString());      //pasar a un metodo setearMarcar dentro de gestor vista auto y solo llamar
    }//GEN-LAST:event_cmbModeloItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckAño;
    private javax.swing.JCheckBox CheckMarca;
    private javax.swing.JCheckBox CheckModelo;
    private javax.swing.JCheckBox CheckPais;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscarCodigo;
    public javax.swing.JButton btnCalcular;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir1;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbModelo;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtBusquedaNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFin;
    private javax.swing.JTextField txtInicio;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
