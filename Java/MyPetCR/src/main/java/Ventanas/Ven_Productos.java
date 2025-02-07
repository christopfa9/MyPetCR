/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Auxiliares.Auxiliar;
import Conexiones.CategoriaAccess;
import Conexiones.ProductosAccess;
import Enums.TipoUsuario;
import Objetos.GLOBAL;
import Objetos.Productos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sasmora
 */
public class Ven_Productos extends javax.swing.JFrame {
    private int filasAfectadas;
    private Productos producto; 
    private int idProductos = 0;
    private String Nombre = "";
    private int Categoria = 0;
    private int cantidadTotal = 0;
    private float Precio;
    private int categoriaSelect;
    
    public Ven_Productos() {
        initComponents();
        changeVentana();
        Auxiliar.validarNumeros(null, txtIDProducto);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    void changeVentana() {
        if(GLOBAL.user.getTipo().equals(TipoUsuario.VETERINARIO)){
            lblProductos.setText("MEDICAMENTOS");
            cargarCategoriaMedicamentos();
        } else {
            cargarCategorias();
        }
    }

    private void cargarCategoriaMedicamentos() {
        cmbCategoria.removeAllItems();
        cmbCategoria.addItem("Medicamentos");
        categoriaSelect = 1;
    }

    private void cargarCategorias() {
        cmbCategoria.removeAllItems();
        CategoriaAccess.getCategorias();
        for (String categoria : GLOBAL.getCategorias()) {
            cmbCategoria.addItem(categoria);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        PanelIngresarDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtIDProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        cmbProceso = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        btnAceptar = new java.awt.Button();
        spinCantidad = new javax.swing.JSpinner();
        spinPrecio = new javax.swing.JSpinner();
        cmbCategoria = new javax.swing.JComboBox<>();
        pnlDivisor2 = new javax.swing.JPanel();
        lblTitulo = new java.awt.Label();
        btnInicio = new java.awt.Button();
        btnPerfil = new java.awt.Button();
        lblProductos = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(77, 115, 129));

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));

        tablaProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Nombre", "Categoria", "Cantidad Total", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        PanelIngresarDatos.setBackground(new java.awt.Color(177, 189, 201));
        PanelIngresarDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(51, 0, 204)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nombre :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("ID Producto:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Categoria:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Cantidad Stock:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Precio:");

        txtIDProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDProductoActionPerformed(evt);
            }
        });

        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });

        cmbProceso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consultar Todos", "Consultar uno", "Insertar", "Actualizar", "Eliminar" }));
        cmbProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProcesoActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Proceso:");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setLabel("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        spinCantidad.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spinCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spinCantidad.setFocusable(false);
        spinCantidad.setVerifyInputWhenFocusTarget(false);
        spinCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spinCantidadMouseClicked(evt);
            }
        });

        spinPrecio.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spinPrecio.setToolTipText("");
        spinPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spinPrecio.setFocusable(false);
        spinPrecio.setVerifyInputWhenFocusTarget(false);
        spinPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spinPrecioMouseClicked(evt);
            }
        });

        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelIngresarDatosLayout = new javax.swing.GroupLayout(PanelIngresarDatos);
        PanelIngresarDatos.setLayout(PanelIngresarDatosLayout);
        PanelIngresarDatosLayout.setHorizontalGroup(
            PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                        .addContainerGap(46, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresarDatosLayout.createSequentialGroup()
                                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombreProducto)
                                            .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(spinCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel18))
                                .addGap(49, 49, 49)
                                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDProducto)
                                    .addComponent(cmbProceso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        PanelIngresarDatosLayout.setVerticalGroup(
            PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresarDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pnlDivisor2.setBackground(new java.awt.Color(224, 123, 79));

        lblTitulo.setAlignment(java.awt.Label.CENTER);
        lblTitulo.setBackground(new java.awt.Color(26, 72, 91));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(224, 123, 79));
        lblTitulo.setText("MyPetCR");

        btnInicio.setLabel("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnPerfil.setActionCommand("Perfil");
        btnPerfil.setLabel("Perfil");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        lblProductos.setBackground(new java.awt.Color(224, 123, 79));
        lblProductos.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(26, 72, 91));
        lblProductos.setText("PRODUCTOS");

        javax.swing.GroupLayout pnlDivisor2Layout = new javax.swing.GroupLayout(pnlDivisor2);
        pnlDivisor2.setLayout(pnlDivisor2Layout);
        pnlDivisor2Layout.setHorizontalGroup(
            pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDivisor2Layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlDivisor2Layout.setVerticalGroup(
            pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDivisor2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelIngresarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlDivisor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlDivisor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(PanelIngresarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        new Venta_Main();
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        new Ven_Perfil();
        this.dispose();
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void spinPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spinPrecioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_spinPrecioMouseClicked

    private void spinCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spinCantidadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_spinCantidadMouseClicked

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int proceso = cmbProceso.getSelectedIndex();
        System.out.println(proceso);
        filasAfectadas = 0;
        ArrayList<ArrayList<String>> tabla= new ArrayList<ArrayList<String>>();
        switch (proceso){
            case 0://Consultar uno
            tabla = ProductosAccess.getAllProducts();
            if (!tabla.isEmpty()) {
                Auxiliar.addTabla(tabla, tablaProductos);
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo consultar la tabla",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            break;
            case 1://Consultar Todos
            tabla= ProductosAccess.getProduct(Integer.parseInt(txtIDProducto.getText()));
            if (!tabla.isEmpty()) {
                Auxiliar.addTabla(tabla, tablaProductos);
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo consultar la tabla",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }

            break;

            case 2: //insertar
            if (getValores()){

                filasAfectadas = ProductosAccess.insertProduct(Nombre, Categoria+1, cantidadTotal, Precio);
                JOptionPane.showMessageDialog(null,
                    filasAfectadas + " filas fueron afectadas");
            }
            break;
            case 3://Actualizar
            if (txtIDProducto.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debe ingresar un ID de producto", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            }
            else if (getValores()){
                idProductos = Integer.parseInt(txtIDProducto.getText());
                ProductosAccess.updateProducto(idProductos,
                    Nombre, Categoria, cantidadTotal, Precio);
                JOptionPane.showMessageDialog(null,
                    "Producto modificado con exito");
            }
            break;
            case 4://Eliminar
            if (ProductosAccess.deleteProduct(Integer.parseInt(txtIDProducto.getText()))!=0){
                JOptionPane.showMessageDialog(null,
                    "Producto eliminado con exito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            break;
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cmbProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProcesoActionPerformed

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void txtIDProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDProductoActionPerformed

    private boolean getValores () {
        
        idProductos = Integer.parseInt(txtIDProducto.getText());

        
        Nombre = txtNombreProducto.getText();
        if (Nombre.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un Nombre de Producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        Categoria = cmbCategoria.getSelectedIndex();
        cantidadTotal = Integer.parseInt(spinCantidad.getValue().toString());
        Precio = Integer.parseInt(spinPrecio.getValue().toString());
        return true;
    }
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelIngresarDatos;
    private java.awt.Button btnAceptar;
    private java.awt.Button btnInicio;
    private java.awt.Button btnPerfil;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbProceso;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label lblProductos;
    private java.awt.Label lblTitulo;
    private javax.swing.JPanel pnlDivisor2;
    private javax.swing.JSpinner spinCantidad;
    private javax.swing.JSpinner spinPrecio;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtIDProducto;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}
