/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Auxiliares.Auxiliar;
import Conexiones.ProductosAccess;
import Conexiones.UsuariosAccess;
import Enums.TipoUsuario;
import Objetos.GLOBAL;
import Objetos.Productos;
import Objetos.Usuario;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ven_Carrito extends javax.swing.JFrame {

    private ArrayList<ArrayList<String>> tabla = new ArrayList<>();
    private int filasAfectadas;
    private String email;
    private String contrasena;
    private int codigoRecuperacion;
    private JFrame ventanaAnterior;
    private int monto = 0;

    public Ven_Carrito(JFrame ventanaAnterior) {
        initComponents();
        this.ventanaAnterior = ventanaAnterior;
        Auxiliar.validarNumeros(txtCodigoSimpe, null);
        Auxiliar.validarNumeros(txtNumCuenta, null);
        actualizarListaProductos();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    
    private void actualizarListaProductos(){
        listProductos.removeAll();
        lblTotal.setText("TOTAL: 0");
        if (GLOBAL.getCarrito().isEmpty()){
            btnPago.setEnabled(false);
        } else {
            for (Productos producto : GLOBAL.getCarrito()) {
            String nombreProducto = producto.getNombre();
            
            String mensaje = Auxiliar.fixedLengthString("Precio: " + producto.getPrecio() , 15) +
                    Auxiliar.fixedLengthString("Nombre: " + producto.getNombre() , 40);
            listProductos.add(mensaje);
            calcularMonto();
        }
    }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicioSesion = new javax.swing.JPanel();
        listProductos = new java.awt.List();
        jPanel1 = new javax.swing.JPanel();
        txtNumCuenta = new java.awt.TextField();
        txtCodigoSimpe = new java.awt.TextField();
        lblTotal = new java.awt.Label();
        checkEnvio = new java.awt.Checkbox();
        lblNombreUsuario2 = new java.awt.Label();
        radTarjeta = new javax.swing.JRadioButton();
        radSimpe = new javax.swing.JRadioButton();
        lblNombreUsuario3 = new java.awt.Label();
        lblNombreUsuario4 = new java.awt.Label();
        btnPago = new java.awt.Button();
        pnlDivisor2 = new javax.swing.JPanel();
        lblTitulo1 = new java.awt.Label();
        btnVolver = new java.awt.Button();
        lblProductos = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlInicioSesion.setBackground(new java.awt.Color(77, 115, 129));
        pnlInicioSesion.setPreferredSize(new java.awt.Dimension(980, 510));

        listProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listProductos.setName(""); // NOI18N

        jPanel1.setBackground(new java.awt.Color(177, 189, 201));

        txtNumCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNumCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumCuentaActionPerformed(evt);
            }
        });

        txtCodigoSimpe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigoSimpe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoSimpeActionPerformed(evt);
            }
        });

        lblTotal.setAlignment(java.awt.Label.CENTER);
        lblTotal.setBackground(new java.awt.Color(224, 123, 79));
        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(26, 72, 91));
        lblTotal.setText("TOTAL");

        checkEnvio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkEnvio.setForeground(new java.awt.Color(26, 72, 91));
        checkEnvio.setLabel("    Envio a domicilio (4500 extra)");

        lblNombreUsuario2.setAlignment(java.awt.Label.CENTER);
        lblNombreUsuario2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNombreUsuario2.setForeground(new java.awt.Color(26, 72, 91));
        lblNombreUsuario2.setText("Metodo de pago");

        radTarjeta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radTarjeta.setText("Tarjeta");
        radTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTarjetaActionPerformed(evt);
            }
        });

        radSimpe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radSimpe.setText("Simpe movil");
        radSimpe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radSimpeActionPerformed(evt);
            }
        });

        lblNombreUsuario3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombreUsuario3.setForeground(new java.awt.Color(26, 72, 91));
        lblNombreUsuario3.setText("Ingrese el numero de cuenta:");

        lblNombreUsuario4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombreUsuario4.setForeground(new java.awt.Color(26, 72, 91));
        lblNombreUsuario4.setText("Ingrese el numero de comprobante");

        btnPago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPago.setForeground(new java.awt.Color(26, 72, 91));
        btnPago.setLabel("Realizar pago");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombreUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radSimpe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(radTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigoSimpe, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(txtNumCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblNombreUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radSimpe)
                    .addComponent(radTarjeta))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreUsuario3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreUsuario4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoSimpe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumCuenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(183, 183, 183)
                    .addComponent(lblNombreUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(144, Short.MAX_VALUE)))
        );

        pnlDivisor2.setBackground(new java.awt.Color(224, 123, 79));

        lblTitulo1.setAlignment(java.awt.Label.CENTER);
        lblTitulo1.setBackground(new java.awt.Color(26, 72, 91));
        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(224, 123, 79));
        lblTitulo1.setText("MyPetCR");

        btnVolver.setActionCommand("Perfil");
        btnVolver.setLabel("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblProductos.setBackground(new java.awt.Color(224, 123, 79));
        lblProductos.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(26, 72, 91));
        lblProductos.setText("CARRITO");

        javax.swing.GroupLayout pnlDivisor2Layout = new javax.swing.GroupLayout(pnlDivisor2);
        pnlDivisor2.setLayout(pnlDivisor2Layout);
        pnlDivisor2Layout.setHorizontalGroup(
            pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDivisor2Layout.createSequentialGroup()
                .addComponent(lblTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlDivisor2Layout.setVerticalGroup(
            pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDivisor2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlInicioSesionLayout = new javax.swing.GroupLayout(pnlInicioSesion);
        pnlInicioSesion.setLayout(pnlInicioSesionLayout);
        pnlInicioSesionLayout.setHorizontalGroup(
            pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioSesionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDivisor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(listProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(628, Short.MAX_VALUE)))
        );
        pnlInicioSesionLayout.setVerticalGroup(
            pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDivisor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(listProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(68, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumCuentaActionPerformed

    private void txtCodigoSimpeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoSimpeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoSimpeActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        ventanaAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void radTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radTarjetaActionPerformed
        if (radSimpe.isSelected() == true) {
            radSimpe.setSelected(false);
        }
        calcularMonto();
    }//GEN-LAST:event_radTarjetaActionPerformed

    private void radSimpeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radSimpeActionPerformed
        if (radTarjeta.isSelected() == true) {
            radTarjeta.setSelected(false);
        }
        calcularMonto();
    }//GEN-LAST:event_radSimpeActionPerformed

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed

        if (validar()){
            calcularMonto();
            pagar();
            GLOBAL.getCarrito().clear();
            actualizarListaProductos();
            
        }
    }//GEN-LAST:event_btnPagoActionPerformed
    
    private void pagar(){
        for ( Productos producto : GLOBAL.getCarrito()){
            ProductosAccess.descontar(producto.getIdProductos(), 1, 1);
        }
    }
    
    
    private int calcularMonto(){
        monto = 0;
        for (Productos producto : GLOBAL.getCarrito()){
            monto += producto.getPrecio();
        }
        if (checkEnvio.getState()){
            monto += 4500;
        }
        lblTotal.setText("TOTAL: " + monto);
        return monto;
    }
    
    private boolean validar (){
        if (radTarjeta.isSelected()){
            if (txtNumCuenta.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero de cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } 
        } else if (radSimpe.isSelected()){
             if (txtCodigoSimpe.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debe ingresar un comprobante", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } 
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnPago;
    private java.awt.Button btnVolver;
    private java.awt.Checkbox checkEnvio;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label lblNombreUsuario2;
    private java.awt.Label lblNombreUsuario3;
    private java.awt.Label lblNombreUsuario4;
    private java.awt.Label lblProductos;
    private java.awt.Label lblTitulo1;
    private java.awt.Label lblTotal;
    private java.awt.List listProductos;
    private javax.swing.JPanel pnlDivisor2;
    private javax.swing.JPanel pnlInicioSesion;
    private javax.swing.JRadioButton radSimpe;
    private javax.swing.JRadioButton radTarjeta;
    private java.awt.TextField txtCodigoSimpe;
    private java.awt.TextField txtNumCuenta;
    // End of variables declaration//GEN-END:variables
}
