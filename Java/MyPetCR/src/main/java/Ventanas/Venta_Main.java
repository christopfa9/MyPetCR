/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Conexiones.NotificacionesAccess;
import Enums.TipoUsuario;
import Objetos.GLOBAL;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author sasmora
 */
public class Venta_Main extends javax.swing.JFrame {

    private ArrayList<ArrayList<String>> tabla = new ArrayList<>();

    public Venta_Main() {
        initComponents();
        changeButtons();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        CargarNotifi();
    }

    private void CargarNotifi() {
        listNotificacion.removeAll(); // Limpiar la lista actual

        if (GLOBAL.user.getTipo().equals(TipoUsuario.CLIENTE)) {
            tabla = NotificacionesAccess.GetAllNotificationsCliente(GLOBAL.user.getID());
        } else if (GLOBAL.user.getTipo().equals(TipoUsuario.VETERINARIO)) {
            tabla = NotificacionesAccess.GetAllNotificationsVete(GLOBAL.user.getID());
        } else { // Gerentes y adminis solo reciben notificaciones de seguridad
            tabla = NotificacionesAccess.GetAllNotifications();
        }

        for (ArrayList<String> fila : tabla) {
            int idNotifi = Integer.parseInt(fila.get(0));
            String idTipoNotifi = fila.get(1);
            int leido = Integer.parseInt(fila.get(3)); // Suponiendo que fila.get(3) es el campo de leído

            // Crear una representación en cadena del idNotifi y idTipoNotifi
            String notificacionStr = null;
            
            if (leido == 0) {
                notificacionStr = " NUEVA ID: " + idNotifi + " Tipo : " + idTipoNotifi;
            } else {
                notificacionStr = " ID: " + idNotifi + " Tipo : " + idTipoNotifi;
            }

            // Agregar la representación a la lista
            listNotificacion.add(notificacionStr);
        }
    }

    private void changeButtons() {
        if (GLOBAL.user.getTipo().equals(TipoUsuario.CLIENTE)) {
            btn1.setLabel("E-COMMERCE");
            btn2.setLabel("MASCOTAS");
            btn3.setLabel("CITAS");
            lblTipoUsuario.setText("Cliente");
        } else if (GLOBAL.user.getTipo().equals(TipoUsuario.VETERINARIO)) {
            btn1.setLabel("PACIENTES");
            btn2.setLabel("CITAS");
            btn3.setLabel("MEDICAMENTOS");
            lblTipoUsuario.setText("Veterinario");
        } else if (GLOBAL.user.getTipo().equals(TipoUsuario.ADMIN)) {
            btn1.setLabel("USUARIOS");
            btn2.setLabel("PRODUCTOS");
            btn3.setLabel("SUCURSAL");
            lblTipoUsuario.setText("Administrador");
        } else { //SI ES GERENTE
            btn1.setLabel("USUARIOS");
            btn2.setLabel("PRODUCTOS");
            btn3.setLabel("SUCURSAL");
            lblTipoUsuario.setText("Gerente");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlDivisor = new javax.swing.JPanel();
        lblTitulo = new java.awt.Label();
        btnInicio = new java.awt.Button();
        btnPerfil = new java.awt.Button();
        pnlOpciones = new javax.swing.JPanel();
        btn3 = new java.awt.Button();
        btn1 = new java.awt.Button();
        btn2 = new java.awt.Button();
        lblTipoUsuario = new java.awt.Label();
        pnlNotificaciones = new javax.swing.JPanel();
        listNotificacion = new java.awt.List();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNotificacion = new javax.swing.JTextArea();
        pnlTituloNotificaciones = new javax.swing.JPanel();
        lblNotificaciones = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(77, 115, 129));

        pnlDivisor.setBackground(new java.awt.Color(224, 123, 79));

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

        javax.swing.GroupLayout pnlDivisorLayout = new javax.swing.GroupLayout(pnlDivisor);
        pnlDivisor.setLayout(pnlDivisorLayout);
        pnlDivisorLayout.setHorizontalGroup(
            pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDivisorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnlDivisorLayout.setVerticalGroup(
            pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDivisorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlOpciones.setBackground(new java.awt.Color(255, 199, 167));
        pnlOpciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, new java.awt.Color(224, 123, 79), null, null));

        btn3.setActionCommand("CITAS");
        btn3.setBackground(new java.awt.Color(26, 72, 91));
        btn3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 102, 0));
        btn3.setLabel("SUCURSAL");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn1.setActionCommand("ECOMMERCE");
        btn1.setBackground(new java.awt.Color(26, 72, 91));
        btn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 102, 0));
        btn1.setLabel("USUARIOS");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setActionCommand("ECOMMERCE");
        btn2.setBackground(new java.awt.Color(26, 72, 91));
        btn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 102, 0));
        btn2.setLabel("PRODUCTOS");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        lblTipoUsuario.setAlignment(java.awt.Label.CENTER);
        lblTipoUsuario.setBackground(new java.awt.Color(255, 199, 167));
        lblTipoUsuario.setEnabled(false);
        lblTipoUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTipoUsuario.setForeground(new java.awt.Color(224, 123, 79));
        lblTipoUsuario.setText("Gerente");

        javax.swing.GroupLayout pnlOpcionesLayout = new javax.swing.GroupLayout(pnlOpciones);
        pnlOpciones.setLayout(pnlOpcionesLayout);
        pnlOpcionesLayout.setHorizontalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                    .addComponent(btn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTipoUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlOpcionesLayout.setVerticalGroup(
            pnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addComponent(lblTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlNotificaciones.setBackground(new java.awt.Color(26, 72, 91));
        pnlNotificaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(77, 115, 129), new java.awt.Color(224, 123, 79), null, null));

        listNotificacion.setBackground(new java.awt.Color(187, 202, 207));
        listNotificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listNotificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listNotificacionMouseClicked(evt);
            }
        });
        listNotificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listNotificacionActionPerformed(evt);
            }
        });

        txtAreaNotificacion.setBackground(new java.awt.Color(230, 238, 241));
        txtAreaNotificacion.setColumns(20);
        txtAreaNotificacion.setLineWrap(true);
        txtAreaNotificacion.setRows(5);
        jScrollPane1.setViewportView(txtAreaNotificacion);

        javax.swing.GroupLayout pnlNotificacionesLayout = new javax.swing.GroupLayout(pnlNotificaciones);
        pnlNotificaciones.setLayout(pnlNotificacionesLayout);
        pnlNotificacionesLayout.setHorizontalGroup(
            pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listNotificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlNotificacionesLayout.setVerticalGroup(
            pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(listNotificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlTituloNotificaciones.setBackground(new java.awt.Color(26, 72, 91));
        pnlTituloNotificaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(77, 115, 129), new java.awt.Color(224, 123, 79), null, null));

        lblNotificaciones.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblNotificaciones.setForeground(new java.awt.Color(224, 123, 79));
        lblNotificaciones.setText("Notificaciones");

        javax.swing.GroupLayout pnlTituloNotificacionesLayout = new javax.swing.GroupLayout(pnlTituloNotificaciones);
        pnlTituloNotificaciones.setLayout(pnlTituloNotificacionesLayout);
        pnlTituloNotificacionesLayout.setHorizontalGroup(
            pnlTituloNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTituloNotificacionesLayout.setVerticalGroup(
            pnlTituloNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNotificaciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlDivisor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlTituloNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addComponent(pnlDivisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(pnlNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlTituloNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(pnlOpciones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        TipoUsuario actual = GLOBAL.user.getTipo();
        if (actual.equals(TipoUsuario.CLIENTE)) {
            new Ven_ECommerce();
            this.dispose();
        } else if (actual.equals(TipoUsuario.VETERINARIO)) {
            new Ven_Mascotas();
            this.dispose();
        } else { //SI ES GERENTE O ADMIN
            new Ven_Usuarios();
            this.dispose();
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        TipoUsuario actual = GLOBAL.user.getTipo();
        if (actual.equals(TipoUsuario.CLIENTE)) {
            new Ven_Mascotas();
            this.dispose();
        } else if (actual.equals(TipoUsuario.VETERINARIO)) {
            new Ven_Cita();
            this.dispose();
        } else { //SI ES GERENTE O ADMIN
            new Ven_Productos();
            this.dispose();
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        new Venta_Main();
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        new Ven_Perfil();
        this.dispose();
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        TipoUsuario actual = GLOBAL.user.getTipo();
        if (actual.equals(TipoUsuario.CLIENTE)) {
            new Ven_Cita();
            this.dispose();
        } else if (actual.equals(TipoUsuario.VETERINARIO)) {
            new Ven_Productos();
            this.dispose();
        } else { //GERENTE O ADMIN
            //new Ven_Sucursal(GLOBAL.user);
            //this.dispose();
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void listNotificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listNotificacionMouseClicked
        // TODO add your handling code here:

        int index = listNotificacion.getSelectedIndex();

        CargarNotifi();

        if (index >= 0) {

            ArrayList<String> selectedRow = tabla.get(index);

            // Convertir el ID a entero
            int idNotifi = Integer.parseInt(selectedRow.get(0));
            String descripcion = selectedRow.get(2); // Obtener la descripción de la notificación

            NotificacionesAccess.NOFITI_LEIDA(idNotifi);

            txtAreaNotificacion.setText(descripcion);
        }
    }//GEN-LAST:event_listNotificacionMouseClicked

    private void listNotificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listNotificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listNotificacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btn1;
    private java.awt.Button btn2;
    private java.awt.Button btn3;
    private java.awt.Button btnInicio;
    private java.awt.Button btnPerfil;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label lblNotificaciones;
    private java.awt.Label lblTipoUsuario;
    private java.awt.Label lblTitulo;
    private java.awt.List listNotificacion;
    private javax.swing.JPanel pnlDivisor;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNotificaciones;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlTituloNotificaciones;
    private javax.swing.JTextArea txtAreaNotificacion;
    // End of variables declaration//GEN-END:variables
}
