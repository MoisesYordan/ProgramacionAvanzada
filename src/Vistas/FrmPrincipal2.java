/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.JDesktopPane;


/**
 *
 * @author el negro
 */
public class FrmPrincipal2 extends javax.swing.JFrame {
    public GestorVistaPrincipal gestorVista;
    
    public GestorVistaPrincipal getGestorVista() {
        return gestorVista;
    }

    public void setGestorVista(GestorVistaPrincipal gestorVista) {
        this.gestorVista = gestorVista;
    }
    public FrmPrincipal2() {
        initComponents();
//        this.setLocationRelativeTo(this);
        
    }
    public FrmPrincipal2(GestorVistaPrincipal aThis) {
        initComponents();
        gestorVista=aThis;
    }
    public JDesktopPane getEscritorio() {
        return Escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.Escritorio = escritorio;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        Marca = new rsbuttom.RSButtonMetro();
        Modelo = new rsbuttom.RSButtonMetro();
        Auto = new rsbuttom.RSButtonMetro();
        Ventas = new rsbuttom.RSButtonMetro();
        Cliente = new rsbuttom.RSButtonMetro();
        Empleado = new rsbuttom.RSButtonMetro();
        Pais = new rsbuttom.RSButtonMetro();
        jPanel5 = new javax.swing.JPanel();
        MenuPlegable = new rsbuttom.RSButtonMetroMenu();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1040, 601));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Escritorio.setPreferredSize(new java.awt.Dimension(1040, 670));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(220, 550));
        jPanel2.setLayout(null);

        Marca.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Marca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chromecast.png"))); // NOI18N
        Marca.setText("MARCA");
        Marca.setColorHover(new java.awt.Color(255, 102, 51));
        Marca.setColorNormal(new java.awt.Color(255, 153, 51));
        Marca.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Marca.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Marca.setPreferredSize(new java.awt.Dimension(150, 80));
        Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaActionPerformed(evt);
            }
        });
        jPanel2.add(Marca);
        Marca.setBounds(0, 0, 220, 80);

        Modelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Modelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modelo2.png"))); // NOI18N
        Modelo.setText("MODELO");
        Modelo.setColorHover(new java.awt.Color(255, 102, 51));
        Modelo.setColorNormal(new java.awt.Color(255, 153, 51));
        Modelo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Modelo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Modelo.setPreferredSize(new java.awt.Dimension(150, 80));
        Modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModeloActionPerformed(evt);
            }
        });
        jPanel2.add(Modelo);
        Modelo.setBounds(0, 80, 220, 80);

        Auto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Auto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Auto.png"))); // NOI18N
        Auto.setText("AUTO");
        Auto.setColorHover(new java.awt.Color(255, 102, 51));
        Auto.setColorNormal(new java.awt.Color(255, 153, 51));
        Auto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Auto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Auto.setPreferredSize(new java.awt.Dimension(150, 80));
        Auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoActionPerformed(evt);
            }
        });
        jPanel2.add(Auto);
        Auto.setBounds(0, 160, 220, 80);

        Ventas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carrito-de-compra-anadir.png"))); // NOI18N
        Ventas.setText("VENTAS");
        Ventas.setColorHover(new java.awt.Color(255, 102, 51));
        Ventas.setColorNormal(new java.awt.Color(255, 153, 51));
        Ventas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Ventas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Ventas.setPreferredSize(new java.awt.Dimension(150, 80));
        Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentasActionPerformed(evt);
            }
        });
        jPanel2.add(Ventas);
        Ventas.setBounds(0, 240, 220, 80);

        Cliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/directorio.png"))); // NOI18N
        Cliente.setText("CLIENTE");
        Cliente.setColorHover(new java.awt.Color(255, 102, 51));
        Cliente.setColorNormal(new java.awt.Color(255, 153, 51));
        Cliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Cliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Cliente.setPreferredSize(new java.awt.Dimension(150, 80));
        Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClienteActionPerformed(evt);
            }
        });
        jPanel2.add(Cliente);
        Cliente.setBounds(0, 320, 220, 80);

        Empleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Empleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comentario-usuario.png"))); // NOI18N
        Empleado.setText("EMPLEADO");
        Empleado.setColorHover(new java.awt.Color(255, 102, 51));
        Empleado.setColorNormal(new java.awt.Color(255, 153, 51));
        Empleado.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Empleado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Empleado.setPreferredSize(new java.awt.Dimension(150, 80));
        Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmpleadoActionPerformed(evt);
            }
        });
        jPanel2.add(Empleado);
        Empleado.setBounds(0, 400, 220, 80);

        Pais.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Pais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bandera-usa.png"))); // NOI18N
        Pais.setText("PAIS");
        Pais.setColorHover(new java.awt.Color(255, 102, 51));
        Pais.setColorNormal(new java.awt.Color(255, 153, 51));
        Pais.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Pais.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaisActionPerformed(evt);
            }
        });
        jPanel2.add(Pais);
        Pais.setBounds(0, 480, 220, 70);

        Escritorio.add(jPanel2);
        jPanel2.setBounds(0, 82, 220, 550);

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(1040, 50));

        MenuPlegable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        MenuPlegable.setColorHover(new java.awt.Color(255, 102, 51));
        MenuPlegable.setColorNormal(new java.awt.Color(0, 0, 0));
        MenuPlegable.setColorPressed(new java.awt.Color(255, 102, 51));
        MenuPlegable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPlegableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuPlegable, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(982, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuPlegable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Escritorio.add(jPanel5);
        jPanel5.setBounds(0, 0, 1040, 50);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GTR_1 (online-video-cutter.com).gif"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1040, 570));
        jLabel1.setMinimumSize(new java.awt.Dimension(1040, 570));
        Escritorio.add(jLabel1);
        jLabel1.setBounds(0, 0, 1040, 670);

        getContentPane().add(Escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuPlegableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPlegableActionPerformed
        int posicion = this.jPanel2.getX();
        if(posicion>=-1){
            Animacion.Animacion.mover_izquierda(0, -260, 2, 2, jPanel2);
        }
        else{
            Animacion.Animacion.mover_derecha(-260, 0, 2, 2, jPanel2);
           }//GEN-LAST:event_MenuPlegableActionPerformed
    }
    private void MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaActionPerformed
        this.gestorVista.abrirMarca(getEscritorio()); 
    }//GEN-LAST:event_MarcaActionPerformed

    private void ModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModeloActionPerformed
        this.gestorVista.abrirModelo(getEscritorio());    }//GEN-LAST:event_ModeloActionPerformed

    private void AutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoActionPerformed
        this.gestorVista.abrirAuto(getEscritorio());
    }//GEN-LAST:event_AutoActionPerformed

    private void VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentasActionPerformed
        this.gestorVista.abrirVentas(getEscritorio());
    }//GEN-LAST:event_VentasActionPerformed

    private void ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClienteActionPerformed
        this.gestorVista.abrirCliente(getEscritorio());
    }//GEN-LAST:event_ClienteActionPerformed

    private void EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpleadoActionPerformed
        this.gestorVista.abrirEmpleado(getEscritorio());
    }//GEN-LAST:event_EmpleadoActionPerformed

    private void PaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaisActionPerformed
        this.gestorVista.abrirPais(getEscritorio());
    }//GEN-LAST:event_PaisActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal2().setVisible(true);
            }
        });
    }  
  
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro Auto;
    private rsbuttom.RSButtonMetro Cliente;
    private rsbuttom.RSButtonMetro Empleado;
    private javax.swing.JDesktopPane Escritorio;
    private rsbuttom.RSButtonMetro Marca;
    private rsbuttom.RSButtonMetroMenu MenuPlegable;
    private rsbuttom.RSButtonMetro Modelo;
    private rsbuttom.RSButtonMetro Pais;
    private rsbuttom.RSButtonMetro Ventas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
