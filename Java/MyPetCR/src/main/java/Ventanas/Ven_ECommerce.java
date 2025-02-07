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
import Objetos.Usuario;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author sasmora
 */
public class Ven_ECommerce extends javax.swing.JFrame {
    private int filasAfectadas;
    
    public Ven_ECommerce() {
        initComponents();
        this.setLocationRelativeTo(null);
        CategoriaAccess.getCategorias();
        ProductosAccess.getAllProducts();
        //CUANDO SE PRECIONA UNA LINEA SE MUESTRA LA INFO DEL PRODUCTO EN EL PANEL DERECHO
        listProductos.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                mostrarDetallesProducto();
            }
        });
        actualizarListaProductos();
        this.setVisible(true);
    }

    public void actualizarListaProductos(){
        listProductos.removeAll();
        for (Productos producto : GLOBAL.getProductos()) {
            String nombreProducto = producto.getNombre();
            
            String mensaje = Auxiliar.fixedLengthString("ID: " + producto.getIdProductos() , 15) +
                    Auxiliar.fixedLengthString("Nombre: " + producto.getNombre() , 40);
            listProductos.add(mensaje);
            actualizarDetalles(0);
        }
    }
    
    private void mostrarDetallesProducto() {
        int selectedIndex = listProductos.getSelectedIndex();
        if (selectedIndex != -1) {
            actualizarDetalles(selectedIndex);
        } else {
            lblNombreProducto.setText("No hay producto seleccionado");
        }
    }
    
    private void actualizarDetalles(int selectedIndex){
        Productos productoSeleccionado = GLOBAL.getProductos().get(selectedIndex);
            lblNombreProducto.setText(productoSeleccionado.getNombre());
            lblIDProducto.setText( "ID: " + productoSeleccionado.getIdProductos());
            
            int idCategoria = productoSeleccionado.getCategoria();
            String nombreCategoria = GLOBAL.getCategorias().get(idCategoria-1);
            lblCategoria.setText(nombreCategoria);
            
            lblCantidad.setText(productoSeleccionado.getCantidadTotal() + "");
            lblPrecio.setText(productoSeleccionado.getPrecio() + "");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        PanelIngresarDatos = new javax.swing.JPanel();
        btnAgregarCarrito = new java.awt.Button();
        jLabel19 = new javax.swing.JLabel();
        lblNombreProducto = new java.awt.Label();
        lblIDProducto = new java.awt.Label();
        lblCategoriaFija = new java.awt.Label();
        lblCategoriaFija1 = new java.awt.Label();
        lblCategoriaFija2 = new java.awt.Label();
        lblCategoria = new java.awt.Label();
        lblPrecio = new java.awt.Label();
        lblCantidad = new java.awt.Label();
        button1 = new java.awt.Button();
        textField1 = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        pnlDivisor2 = new javax.swing.JPanel();
        lblTitulo3 = new java.awt.Label();
        btnCarrito = new java.awt.Button();
        btnVolver = new java.awt.Button();
        lblProductos = new java.awt.Label();
        btnPerfil = new java.awt.Button();
        pnlListaProductos = new javax.swing.JPanel();
        listProductos = new java.awt.List();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(77, 115, 129));
        jPanel2.setPreferredSize(new java.awt.Dimension(980, 517));

        PanelIngresarDatos.setBackground(new java.awt.Color(177, 189, 201));
        PanelIngresarDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(51, 0, 204)));
        PanelIngresarDatos.setPreferredSize(new java.awt.Dimension(285, 400));

        btnAgregarCarrito.setBackground(new java.awt.Color(224, 123, 79));
        btnAgregarCarrito.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAgregarCarrito.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCarrito.setLabel("Agregar al carrito");
        btnAgregarCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCarritoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblNombreProducto.setAlignment(java.awt.Label.CENTER);
        lblNombreProducto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(26, 72, 91));
        lblNombreProducto.setText("Nombre del producto");

        lblIDProducto.setAlignment(java.awt.Label.CENTER);
        lblIDProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIDProducto.setForeground(new java.awt.Color(26, 72, 91));
        lblIDProducto.setText("ID del producto");

        lblCategoriaFija.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCategoriaFija.setForeground(new java.awt.Color(26, 72, 91));
        lblCategoriaFija.setText("Categoria:");

        lblCategoriaFija1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCategoriaFija1.setForeground(new java.awt.Color(26, 72, 91));
        lblCategoriaFija1.setText("Precio:");

        lblCategoriaFija2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCategoriaFija2.setForeground(new java.awt.Color(26, 72, 91));
        lblCategoriaFija2.setText("Cantidad disponible:");

        lblCategoria.setAlignment(java.awt.Label.RIGHT);
        lblCategoria.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(26, 72, 91));

        lblPrecio.setAlignment(java.awt.Label.RIGHT);
        lblPrecio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPrecio.setForeground(new java.awt.Color(224, 123, 79));

        lblCantidad.setAlignment(java.awt.Label.RIGHT);
        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(26, 72, 91));

        button1.setBackground(new java.awt.Color(26, 72, 91));
        button1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        button1.setForeground(new java.awt.Color(224, 123, 79));
        button1.setLabel("Añadir reseña");

        textField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout PanelIngresarDatosLayout = new javax.swing.GroupLayout(PanelIngresarDatos);
        PanelIngresarDatos.setLayout(PanelIngresarDatosLayout);
        PanelIngresarDatosLayout.setHorizontalGroup(
            PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresarDatosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAgregarCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresarDatosLayout.createSequentialGroup()
                        .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIDProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelIngresarDatosLayout.createSequentialGroup()
                                .addComponent(lblCategoriaFija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelIngresarDatosLayout.createSequentialGroup()
                                .addComponent(lblCategoriaFija2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelIngresarDatosLayout.createSequentialGroup()
                                .addComponent(lblCategoriaFija1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresarDatosLayout.createSequentialGroup()
                        .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                                .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        PanelIngresarDatosLayout.setVerticalGroup(
            PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                        .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCategoriaFija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoriaFija2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCategoriaFija1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addComponent(btnAgregarCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pnlDivisor2.setBackground(new java.awt.Color(224, 123, 79));

        lblTitulo3.setAlignment(java.awt.Label.CENTER);
        lblTitulo3.setBackground(new java.awt.Color(26, 72, 91));
        lblTitulo3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo3.setForeground(new java.awt.Color(224, 123, 79));
        lblTitulo3.setText("MyPetCR");

        btnCarrito.setLabel("Carrito");
        btnCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarritoActionPerformed(evt);
            }
        });

        btnVolver.setActionCommand("Perfil");
        btnVolver.setLabel("Inicio");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblProductos.setAlignment(java.awt.Label.CENTER);
        lblProductos.setBackground(new java.awt.Color(224, 123, 79));
        lblProductos.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(26, 72, 91));
        lblProductos.setText("E - COMMERCE");

        btnPerfil.setActionCommand("Perfil");
        btnPerfil.setLabel("Perfil");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDivisor2Layout = new javax.swing.GroupLayout(pnlDivisor2);
        pnlDivisor2.setLayout(pnlDivisor2Layout);
        pnlDivisor2Layout.setHorizontalGroup(
            pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDivisor2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(btnCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(lblTitulo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlDivisor2Layout.setVerticalGroup(
            pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDivisor2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCarrito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDivisor2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlListaProductos.setBackground(new java.awt.Color(177, 189, 201));

        listProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listProductos.setMinimumSize(new java.awt.Dimension(20, 80));
        listProductos.setName(""); // NOI18N
        listProductos.setPreferredSize(new java.awt.Dimension(20, 80));

        javax.swing.GroupLayout pnlListaProductosLayout = new javax.swing.GroupLayout(pnlListaProductos);
        pnlListaProductos.setLayout(pnlListaProductosLayout);
        pnlListaProductosLayout.setHorizontalGroup(
            pnlListaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListaProductosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(listProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlListaProductosLayout.setVerticalGroup(
            pnlListaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlListaProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlListaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(PanelIngresarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pnlDivisor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlDivisor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelIngresarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlListaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCarritoActionPerformed
        int selectedIndex = listProductos.getSelectedIndex();
        if (selectedIndex != -1){
            Productos productoSeleccionado = GLOBAL.getProductos().get(selectedIndex);
            if (productoSeleccionado.getCantidadTotal() > 0 ){
                GLOBAL.addToCarrito(productoSeleccionado);
                productoSeleccionado.setCantidadTotal(productoSeleccionado.getCantidadTotal()-1);
                mostrarDetallesProducto();
            }
        }
        
        
    }//GEN-LAST:event_btnAgregarCarritoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if(GLOBAL.user.getTipo().equals(TipoUsuario.INVITADO)){
            new Ven_Inicio();
        } else {
            new Venta_Main();
        }
            this.dispose();
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        new Ven_Perfil();
        this.dispose();
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarritoActionPerformed
        new Ven_Carrito(this);
        this.setVisible(false);
    }//GEN-LAST:event_btnCarritoActionPerformed


    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelIngresarDatos;
    private java.awt.Button btnAgregarCarrito;
    private java.awt.Button btnCarrito;
    private java.awt.Button btnPerfil;
    private java.awt.Button btnVolver;
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private java.awt.Label lblCantidad;
    private java.awt.Label lblCategoria;
    private java.awt.Label lblCategoriaFija;
    private java.awt.Label lblCategoriaFija1;
    private java.awt.Label lblCategoriaFija2;
    private java.awt.Label lblIDProducto;
    private java.awt.Label lblNombreProducto;
    private java.awt.Label lblPrecio;
    private java.awt.Label lblProductos;
    private java.awt.Label lblTitulo3;
    private java.awt.List listProductos;
    private javax.swing.JPanel pnlDivisor2;
    private javax.swing.JPanel pnlListaProductos;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
