/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Conexiones.UsuariosAccess;
import Objetos.GLOBAL;
import javax.swing.JOptionPane;

/**
 *
 * @author sasmora
 */
public class Ven_Perfil extends javax.swing.JFrame {

    private int idUsuario;
    private int cedula;
    private int telefono;
    private String correo;
    private String nombre;
    private String apellidos;
    private String direccion;

    public Ven_Perfil() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.idUsuario = GLOBAL.user.getID();
        txtNombreUsuario.setText(GLOBAL.user.getNombre());
        txtApellidoUsuario.setText(GLOBAL.user.getApellidos());
        txtCedula.setText(GLOBAL.user.getCedula() + "");
        txtDireccion.setText(GLOBAL.user.getDirecccion());
        txtTelefono.setText(GLOBAL.user.getTelefono() + "");
        txtCorreoNuevo.setText(GLOBAL.user.getCorreo());

        txtNombreUsuario.setEnabled(false);
        txtApellidoUsuario.setEnabled(false);
        txtCedula.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtCorreoNuevo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlDivisor = new javax.swing.JPanel();
        lblTitulo = new java.awt.Label();
        btnInicio = new java.awt.Button();
        btnCerrarSesion = new java.awt.Button();
        pnlNotificaciones = new javax.swing.JPanel();
        lblCedula = new java.awt.Label();
        txtCedula = new java.awt.TextField();
        txtNombreUsuario = new java.awt.TextField();
        lblApellidos = new java.awt.Label();
        lblNombreUsuario = new java.awt.Label();
        lblDireccion = new java.awt.Label();
        txtApellidoUsuario = new java.awt.TextField();
        txtDireccion = new java.awt.TextField();
        txtCorreoNuevo = new java.awt.TextField();
        txtTelefono = new java.awt.TextField();
        lblTelefono = new java.awt.Label();
        lblCorreoNuevo1 = new java.awt.Label();
        lblNombreUsuario1 = new java.awt.Label();
        btnGuardarCambios = new java.awt.Button();
        pnlTituloNotificaciones = new javax.swing.JPanel();
        btnEditar = new java.awt.Button();
        btnCambiarContra = new java.awt.Button();

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

        btnCerrarSesion.setActionCommand("Perfil");
        btnCerrarSesion.setLabel("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDivisorLayout = new javax.swing.GroupLayout(pnlDivisor);
        pnlDivisor.setLayout(pnlDivisorLayout);
        pnlDivisorLayout.setHorizontalGroup(
            pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDivisorLayout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDivisorLayout.setVerticalGroup(
            pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDivisorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlNotificaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(77, 115, 129), new java.awt.Color(224, 123, 79), null, null));

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCedula.setText("Cédula: ");

        txtCedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        lblApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblApellidos.setText("Apellidos:");

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombreUsuario.setText("Nombre:");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDireccion.setText("Dirección:");

        txtApellidoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtCorreoNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTelefono.setText("Teléfono:");

        lblCorreoNuevo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCorreoNuevo1.setText("Correo Electrónico:");

        lblNombreUsuario1.setAlignment(java.awt.Label.CENTER);
        lblNombreUsuario1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNombreUsuario1.setForeground(new java.awt.Color(26, 72, 91));
        lblNombreUsuario1.setText("Datos de usuario");

        btnGuardarCambios.setLabel("Guardar cambios");
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNotificacionesLayout = new javax.swing.GroupLayout(pnlNotificaciones);
        pnlNotificaciones.setLayout(pnlNotificacionesLayout);
        pnlNotificacionesLayout.setHorizontalGroup(
            pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                        .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(61, 61, 61)
                                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                                        .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(68, 68, 68))
                                    .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                                        .addComponent(lblCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(61, 61, 61)))
                                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                                .addComponent(lblCorreoNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblNombreUsuario1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        pnlNotificacionesLayout.setVerticalGroup(
            pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotificacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCorreoNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlTituloNotificaciones.setBackground(new java.awt.Color(26, 72, 91));
        pnlTituloNotificaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(77, 115, 129), new java.awt.Color(224, 123, 79), null, null));

        javax.swing.GroupLayout pnlTituloNotificacionesLayout = new javax.swing.GroupLayout(pnlTituloNotificaciones);
        pnlTituloNotificaciones.setLayout(pnlTituloNotificacionesLayout);
        pnlTituloNotificacionesLayout.setHorizontalGroup(
            pnlTituloNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        pnlTituloNotificacionesLayout.setVerticalGroup(
            pnlTituloNotificacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        btnEditar.setActionCommand("ECOMMERCE");
        btnEditar.setBackground(new java.awt.Color(26, 72, 91));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 102, 0));
        btnEditar.setLabel("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCambiarContra.setActionCommand("ECOMMERCE");
        btnCambiarContra.setBackground(new java.awt.Color(26, 72, 91));
        btnCambiarContra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCambiarContra.setForeground(new java.awt.Color(255, 102, 0));
        btnCambiarContra.setLabel("CAMBIAR CONTRASEÑA");
        btnCambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDivisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTituloNotificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCambiarContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                .addComponent(pnlDivisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTituloNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(pnlNotificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCambiarContra, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        new Venta_Main();
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        new Ven_Inicio();
        this.dispose();
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        // TODO add your handling code here:

        if (getValores()) { //Obtener los valores de los textFields, etc;

            UsuariosAccess.updateCliente(idUsuario, cedula, telefono, correo, nombre, apellidos, direccion);

            if (idUsuario == GLOBAL.user.getID()) {

                GLOBAL.user.setNombre(nombre);
                GLOBAL.user.setCedula(cedula);
                GLOBAL.user.setApellidos(apellidos);
                GLOBAL.user.setDireccion(direccion);
                GLOBAL.user.setTelefono(telefono);
                GLOBAL.user.setCorreo(correo);

            }

            JOptionPane.showMessageDialog(null, "Se registro el Cliente Correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Debe Completar todos los datos para poder Actualizar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnCambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraActionPerformed
        // TODO add your handling code here:
        new Ven_Contra();
        this.dispose();
    }//GEN-LAST:event_btnCambiarContraActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        txtNombreUsuario.setEnabled(true);
        txtApellidoUsuario.setEnabled(true);
        txtCedula.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtCorreoNuevo.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private boolean getValores() {

        this.nombre = txtNombreUsuario.getText();

        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un Nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.apellidos = txtApellidoUsuario.getText();

        if (apellidos.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar Apellidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String cedu = txtCedula.getText();

        if (cedu.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la Cedula", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                this.cedula = Integer.parseInt(txtCedula.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un Numero de Cedula Valido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        this.correo = txtCorreoNuevo.getText();

        if (correo.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un Correo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        this.direccion = txtDireccion.getText();

        if (direccion.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una Direccion", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String tele = txtTelefono.getText();

        if (tele.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un Telefono", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                this.telefono = Integer.parseInt(txtTelefono.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un Numero de Telefono Valido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCambiarContra;
    private java.awt.Button btnCerrarSesion;
    private java.awt.Button btnEditar;
    private java.awt.Button btnGuardarCambios;
    private java.awt.Button btnInicio;
    private java.awt.Label lblApellidos;
    private java.awt.Label lblCedula;
    private java.awt.Label lblCorreoNuevo1;
    private java.awt.Label lblDireccion;
    private java.awt.Label lblNombreUsuario;
    private java.awt.Label lblNombreUsuario1;
    private java.awt.Label lblTelefono;
    private java.awt.Label lblTitulo;
    private javax.swing.JPanel pnlDivisor;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNotificaciones;
    private javax.swing.JPanel pnlTituloNotificaciones;
    private java.awt.TextField txtApellidoUsuario;
    private java.awt.TextField txtCedula;
    private java.awt.TextField txtCorreoNuevo;
    private java.awt.TextField txtDireccion;
    private java.awt.TextField txtNombreUsuario;
    private java.awt.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
