package FRM;
import Modelos.GestionProyecto.GestorVistaMarca;
import Vistas.FrmGenerica;
import java.awt.HeadlessException;
import javax.swing.*;

public class FrmMarca extends FrmGenerica {
    private GestorVistaMarca gestorVista;
    private int YES_NO_OPTION;

    public GestorVistaMarca getGestorVista() {
        return gestorVista;
    }
    
    public void setGestorVista(GestorVistaMarca gestorVista) {
        this.gestorVista = gestorVista;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }

    public void setTblDatos(JTable tblDatos) {
        this.tblDatos = tblDatos;
    }

// Definicion de getter y setter de los componentes visuales del formulario
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }
    
    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
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
     
    public FrmMarca(GestorVistaMarca gestorVista) {
        try{
           initComponents();
           }
        catch(Exception e){
            
        }  
        this.setGestorVista(gestorVista);
        this.onViewOpened();
    }

    public FrmMarca() {
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
        btnNuevo.grabFocus();
    }

    public void viewNuevoEditarBotones(){//btnEditar
        btnNuevo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(false);
        btnCancelar.setEnabled(true);
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
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);
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

//    public void viewBuscar() {//btnBuscarCodigo
//        btnNuevo.setEnabled(true); 
//        btnEditar.setEnabled(false);
//        btnGuardar.setEnabled(false);
//        btnEliminar.setEnabled(false);
//        btnSalir.setEnabled(true);
//        btnCancelar.setEnabled(true);
//    }
    
    @Override
    public void onViewOpened() {
        this.viewOpenedBotones();
        this.viewCamposEnabled(false);
        this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
       // this.isExtra();
     }
    


    @Override
    public void viewCamposEnabled(Boolean tipo) {//al abrir el FRM
        txtCodigo.setEnabled(false);
        txtNombre.setEnabled(tipo);        
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
        this.clearView();
        txtNombre.grabFocus();
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
        txtNombre.grabFocus();
    }

    @Override
    public void clearView() {
        txtNombre.setText("");
        txtCodigo.setText("");
    }

    @Override
    public void grabFocus(){
        txtNombre.grabFocus();
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
    public void setBusqueda(int busqueda) {
        int ord = 0;
        int b=0;//b=>0 es una cadena alfanumerica      1= es una cadena numerica
        String text = null;
        String dato=this.txtBusquedaNombre.getText();//se pone en la variable dato lo que esta dentro de la barra de busqueda de la lupa
       
        //pregunta si dato es igual a un numero(codigo) o una letra(barra de busqueda)
        //busqueda=> 0=lupa de buscar     1= el candado de buscarCodigo
        if (this.getGestorVista().validarNumeros(dato)==false|| busqueda==0){
            b=1;//b=>0 es una cadena alfanumerica            1= es una cadena numerica
            String quebuscar="modelo";
            this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
            this.getGestorVista().setBusqueda(dato,ord,text,quebuscar,b);  
        }else{
            b=0;//b=>0 es una cadena alfanumerica            1= es una cadena numerica
            dato=this.txtCodigo.getText();//se pone en la variable dato lo que esta dentro de la barra de codigo
            String quebuscar="codigo";
            this.getGestorVista().initializeTablaBusqueda(this.getTblDatos());
            this.getGestorVista().setBusqueda(dato,ord,text,quebuscar,b); 
        }
    }
    
  /** Este método se llama desde dentro del constructor para inicializar el formulario.
     ADVERTENCIA: NO modifique este código. 
     El contenido de este método es siempre regenerado por el Editor de formularios.*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnBuscarCodigo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnBuscar1 = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();
        txtBusquedaNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Marca");
        setToolTipText("Marca");
        setFrameIcon(null);
        setName("TipoServicio"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descripción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 0, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");
        jLabel1.setRequestFocusEnabled(false);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 70, 90, 20);

        txtNombre.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtNombre);
        txtNombre.setBounds(20, 90, 460, 30);

        jLabel3.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        jLabel3.setText("Código");
        jLabel3.setRequestFocusEnabled(false);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 20, 90, 17);

        txtCodigo.setBackground(new java.awt.Color(204, 255, 204));
        txtCodigo.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.setToolTipText("Ingrese Código");
        txtCodigo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCodigo);
        txtCodigo.setBounds(20, 40, 90, 23);

        btnBuscarCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscarCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        btnBuscarCodigo.setToolTipText("Buscar Tipo Servicio por código");
        btnBuscarCodigo.setBorderPainted(false);
        btnBuscarCodigo.setContentAreaFilled(false);
        btnBuscarCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarCodigoMouseEntered(evt);
            }
        });
        btnBuscarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCodigoActionPerformed(evt);
            }
        });
        btnBuscarCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarCodigoKeyPressed(evt);
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
        btnNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNuevoKeyPressed(evt);
            }
        });
        jPanel2.add(btnNuevo);
        btnNuevo.setBounds(10, 5, 75, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 380, 200, 40);

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
        btnSalir.setBounds(100, 10, 75, 23);

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
        jPanel3.setBounds(310, 380, 180, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(390, 10, 500, 430);

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
        jScrollPane2.setBounds(20, 90, 340, 280);

        btnBuscar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscar1.setToolTipText("Buscar Tipo Servicio por denominación");
        btnBuscar1.setBorderPainted(false);
        btnBuscar1.setContentAreaFilled(false);
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        btnBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscar1KeyPressed(evt);
            }
        });
        jPanel4.add(btnBuscar1);
        btnBuscar1.setBounds(260, 50, 80, 30);

        btnImprimir1.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        btnImprimir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PrinterChica.png"))); // NOI18N
        btnImprimir1.setText("Imprir");
        btnImprimir1.setToolTipText("Impreme el documento");
        btnImprimir1.setBorderPainted(false);
        btnImprimir1.setContentAreaFilled(false);
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnImprimir1);
        btnImprimir1.setBounds(250, 380, 110, 40);

        txtBusquedaNombre.setFont(new java.awt.Font("Bodoni MT", 0, 14)); // NOI18N
        txtBusquedaNombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(txtBusquedaNombre);
        txtBusquedaNombre.setBounds(20, 50, 240, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Marca");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(20, 20, 190, 20);

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
        jPanel5.setBounds(21, 380, 190, 40);
        jPanel5.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 10, 380, 430);

        getAccessibleContext().setAccessibleName("Carg");

        setBounds(150, 0, 904, 481);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
//        if (evt.getKeyCode()==10) {
//            if (this.gestorVista.getModelXCodigo(txtCodigo.getText())) {
//                this.viewActualizar();
//            }
//            else {
//                JOptionPane.showMessageDialog(null,"Código no existe");
//            }
//        }
}//GEN-LAST:event_txtCodigoKeyPressed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

}//GEN-LAST:event_txtCodigoKeyTyped

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

    private void btnBuscarCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarCodigoKeyPressed
//        if(evt.getKeyCode()==10) {
//            this.viewBuscarCodigoEnter();
//        }
}//GEN-LAST:event_btnBuscarCodigoKeyPressed

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
//        if (JOptionPane.showConfirmDialog(null, "Desea Eliminar el registro seleccionado","Advertencia", YES_NO_OPTION) == 0 )
//           this.deleteView();
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
        this.clearView();
        this.setBusqueda(busqueda);
        this.viewCamposEnabled(false);
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnBuscar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscar1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1KeyPressed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
       this.getGestorVista().setDatos();
    }//GEN-LAST:event_tblDatosMouseClicked

    private void btnBuscarCodigoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarCodigoMouseEntered

     // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarCodigoMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscarCodigo;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir1;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtBusquedaNombre;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
