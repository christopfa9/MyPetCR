/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Auxiliares.Auxiliar;
import Conexiones.NotificacionesAccess;
import Conexiones.UsuariosAccess;
import Enums.TipoUsuario;
import Objetos.GLOBAL;
import Objetos.Usuario;
import java.awt.TextField;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ven_Inicio extends javax.swing.JFrame {

    private ArrayList<ArrayList<String>> tabla = new ArrayList<>();
    private int idUsuario = 1;
    private int cedula;
    private int telefono;
    private String correo;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String contrasena;
    private String TipoUsu;
    private ArrayList<TextField> arrayCuentaNueva = new ArrayList();
    private ArrayList<TextField> arrayInicioSesion = new ArrayList();

    public Ven_Inicio() {
        initComponents();
        Auxiliar.validarNumeros(txtCedula, null);
        Auxiliar.validarNumeros(txtTelefono, null);
        iniciarArrays();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void iniciarArrays() {
        arrayCuentaNueva.add(txtContraNueva);
        arrayCuentaNueva.add(txtCorreoNuevo);
        arrayCuentaNueva.add(txtApellidoUsuario);
        arrayCuentaNueva.add(txtNombreUsuario);
        arrayCuentaNueva.add(txtDireccion);
        arrayCuentaNueva.add(txtTelefono);
        arrayCuentaNueva.add(txtCedula);

        arrayInicioSesion.add(txtContra);
        arrayInicioSesion.add(txtCorreo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicioSesion = new javax.swing.JPanel();
        pnlDivisor = new javax.swing.JPanel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new java.awt.Label();
        txtContra = new java.awt.TextField();
        txtCorreo = new java.awt.TextField();
        lblContra = new java.awt.Label();
        lblCorreo = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        lblNombreUsuario = new java.awt.Label();
        txtApellidoUsuario = new java.awt.TextField();
        txtCorreoNuevo = new java.awt.TextField();
        lblContraNueva = new java.awt.Label();
        btnCrearCuenta = new java.awt.Button();
        txtContraNueva = new java.awt.TextField();
        lblCorreoNuevo1 = new java.awt.Label();
        lblCedula = new java.awt.Label();
        txtCedula = new java.awt.TextField();
        txtNombreUsuario = new java.awt.TextField();
        lblApellidos = new java.awt.Label();
        lblDireccion = new java.awt.Label();
        txtDireccion = new java.awt.TextField();
        txtTelefono = new java.awt.TextField();
        lblTelefono = new java.awt.Label();
        btnInicioSesion = new java.awt.Button();
        btnInvitado = new java.awt.Button();
        btnCambiarContra = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlInicioSesion.setBackground(new java.awt.Color(77, 115, 129));
        pnlInicioSesion.setPreferredSize(new java.awt.Dimension(980, 510));

        pnlDivisor.setBackground(new java.awt.Color(224, 123, 79));

        javax.swing.GroupLayout pnlDivisorLayout = new javax.swing.GroupLayout(pnlDivisor);
        pnlDivisor.setLayout(pnlDivisorLayout);
        pnlDivisorLayout.setHorizontalGroup(
            pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlDivisorLayout.setVerticalGroup(
            pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlTitulo.setBackground(new java.awt.Color(255, 199, 167));

        lblTitulo.setAlignment(java.awt.Label.CENTER);
        lblTitulo.setBackground(new java.awt.Color(26, 72, 91));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(224, 123, 79));
        lblTitulo.setText("MyPetCR");

        javax.swing.GroupLayout pnlTituloLayout = new javax.swing.GroupLayout(pnlTitulo);
        pnlTitulo.setLayout(pnlTituloLayout);
        pnlTituloLayout.setHorizontalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtContra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblContra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContra.setForeground(new java.awt.Color(224, 123, 79));
        lblContra.setText("Contraseña:");

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(224, 123, 79));
        lblCorreo.setText("Correo Electrónico:");

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombreUsuario.setText("Nombre:");

        txtApellidoUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtCorreoNuevo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblContraNueva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblContraNueva.setText("Contraseña:");

        btnCrearCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrearCuenta.setForeground(new java.awt.Color(26, 72, 91));
        btnCrearCuenta.setLabel("Crear cuenta");
        btnCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCuentaActionPerformed(evt);
            }
        });

        txtContraNueva.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCorreoNuevo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCorreoNuevo1.setText("Correo Electrónico:");

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCedula.setText("Cédula: ");

        txtCedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        txtNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblApellidos.setText("Apellidos:");

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDireccion.setText("Dirección:");

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTelefono.setText("Teléfono:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreoNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCorreoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCorreoNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtCorreoNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblContraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        btnInicioSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInicioSesion.setForeground(new java.awt.Color(26, 72, 91));
        btnInicioSesion.setLabel("Iniciar Sesión");
        btnInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesionActionPerformed(evt);
            }
        });

        btnInvitado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnInvitado.setForeground(new java.awt.Color(26, 72, 91));
        btnInvitado.setLabel("Iniciar sin cuenta");
        btnInvitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvitadoActionPerformed(evt);
            }
        });

        btnCambiarContra.setBackground(new java.awt.Color(77, 115, 129));
        btnCambiarContra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCambiarContra.setForeground(new java.awt.Color(255, 102, 0));
        btnCambiarContra.setLabel("¿Olvido su contraseña?");
        btnCambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInicioSesionLayout = new javax.swing.GroupLayout(pnlInicioSesion);
        pnlInicioSesion.setLayout(pnlInicioSesionLayout);
        pnlInicioSesionLayout.setHorizontalGroup(
            pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioSesionLayout.createSequentialGroup()
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblContra, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                        .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnCambiarContra, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(btnInvitado, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(btnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 131, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDivisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlInicioSesionLayout.setVerticalGroup(
            pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDivisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInvitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(lblContra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicioSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        updateCorreo(2);
        updateContra(2);
        if (updateDatos()) {
            UsuariosAccess.insertCliente(cedula, telefono, correo, contrasena, nombre, apellidos, direccion);
            generarUsuario(TipoUsuario.CLIENTE, true);
            ingresarMenu(); //Ingresar al menu de inicio
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }

        //TODO INSERTAR DATOS EN LA BASE
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void btnInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesionActionPerformed

        if (hayCorreo() && hayContra()) {

            tabla = UsuariosAccess.getUser(correo, contrasena);

            if (tabla != null) {

                this.TipoUsu = tabla.get(0).get(0);
                ObtenerID();

                if (TipoUsu.equals("Gerente")) {
                    generarUsuario(TipoUsuario.GERENTE, false);
                    GLOBAL.user.setTipo(TipoUsuario.GERENTE);
                    ingresarMenu(); //Ingresar al menu de inicio

                } else if (TipoUsu.equals("Administrador")) {
                    generarUsuario(TipoUsuario.ADMIN, false);
                    GLOBAL.user.setTipo(TipoUsuario.ADMIN);
                    ingresarMenu(); //Ingresar al menu de inicio

                } else if (TipoUsu.equals("Veterinario")) {
                    generarUsuario(TipoUsuario.VETERINARIO, false);
                    GLOBAL.user.setTipo(TipoUsuario.VETERINARIO);
                    ingresarMenu(); //Ingresar al menu de inicio

                } else {
                    generarUsuario(TipoUsuario.CLIENTE, false);
                    GLOBAL.user.setTipo(TipoUsuario.CLIENTE);
                    ingresarMenu(); //Ingresar al menu de inicio

                }
            } else {

                //notificacion creada por intento fallido de inicio de secion
                LocalDate fechaActual = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaFormateada = fechaActual.format(formatter);
                String Descripcion = "A las  " + LocalTime.now() + ", Del Dia : " + fechaFormateada + " se intento iniciar seccion con las credenciales:\n Correo: " + correo + "\n Contrasenia: " + contrasena;
                NotificacionesAccess.intsetAppointment(1, Descripcion, 0, 0);
                JOptionPane.showMessageDialog(null, "Usuario no encontrado o contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnInicioSesionActionPerformed

    private void btnInvitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvitadoActionPerformed
        generarUsuario(TipoUsuario.INVITADO, false);
        new Ven_ECommerce(); //Ingresar al ecoomerce directamente
        this.dispose();
    }//GEN-LAST:event_btnInvitadoActionPerformed

    private void btnCambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraActionPerformed
        new Ven_Contra();
        this.dispose();
    }//GEN-LAST:event_btnCambiarContraActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed


    }//GEN-LAST:event_txtCedulaActionPerformed

//---------------------------------------------------------------------------------------------    
    private boolean hayCorreo() {

        this.correo = txtCorreo.getText();

        if (correo.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un Correo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean hayContra() {

        this.contrasena = txtContra.getText();

        if (contrasena.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un Correo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void updateCorreo(int btnPress) {
        //TODO VALIDAR CORREO
        if (btnPress == 1) //Iniciar sesion
        {
            this.correo = txtCorreo.getText();
        } else {
            this.correo = txtCorreoNuevo.getText(); //Cuenta nueva
        }
    }

    private void updateContra(int btnPress) {
        //TODO VALIDAR CONTRASENA
        if (btnPress == 1) //Iniciar sesion
        {
            this.contrasena = txtContra.getText();
        } else {
            this.contrasena = txtContraNueva.getText(); //Cuenta nueva
        }
    }

    private boolean updateDatos() {
        //TODO VALIDAR DATOS
        this.nombre = txtNombreUsuario.getText();
        this.apellidos = txtApellidoUsuario.getText();
        this.direccion = txtDireccion.getText();
        //Validar cedula
        if (!txtCedula.getText().isEmpty()) {
            this.cedula = Integer.parseInt(txtCedula.getText());
        } else {
            return false;
        }
        // validar telefono
        if (!txtTelefono.getText().isEmpty()) {
            this.telefono = Integer.parseInt(txtTelefono.getText());
        } else {
            return false;
        }

        return true;
    }

    private void resetVentana() {
        Auxiliar.clearTextFields(arrayCuentaNueva);
        Auxiliar.clearTextFields(arrayInicioSesion);
    }

    private void ingresarMenu() {
        new Venta_Main();
        this.dispose();
    }

    private void generarUsuario(TipoUsuario tipo, boolean nuevo) {
        if (tipo.equals(TipoUsuario.INVITADO)) {
            GLOBAL.user = new Usuario();
        } else if (nuevo) {
            ObtenerID();
            GLOBAL.user = new Usuario(idUsuario, cedula, telefono, correo, contrasena, nombre, apellidos, direccion, tipo);
        } else {
            Cargar_Datos();
            GLOBAL.user = new Usuario(idUsuario, cedula, telefono, correo, contrasena, nombre, apellidos, direccion, tipo);

        }
    }

    public String buscarCedula(String Cedula) {
        for (ArrayList<String> fila : tabla) {

            System.out.println(fila.get(4));
            if (fila.get(0).equals(Cedula)) {
                return fila.get(0); // Retornar el valor de la columna 0
            }
        }
        return ""; // Email no encontrado
    }

    public void ObtenerID() {

        tabla = UsuariosAccess.getAllClientes();

        String idUsua = buscarCedula(cedula + "");

        if (!idUsua.equals("")) {

            this.idUsuario = Integer.parseInt(idUsua);
            return;
        }

        tabla = UsuariosAccess.getAllVeterinarios();

        idUsua = buscarCedula(cedula + "");

        if (!idUsua.equals("")) {

            this.idUsuario = Integer.parseInt(idUsua);
            return;
        }

        tabla = UsuariosAccess.getAllAdmins();

        idUsua = buscarCedula(cedula + "");

        if (!idUsua.equals("")) {

            this.idUsuario = Integer.parseInt(idUsua);
            return;
        }

    }

    public void Cargar_Datos() {

        tabla = UsuariosAccess.getAllClientes();

        String idUsua = buscarEmail(correo);

        if (!idUsua.equals("")) {

            int idUsuario = Integer.parseInt(idUsua);

            tabla = UsuariosAccess.getClienteID(idUsuario);

            this.cedula = Integer.parseInt(tabla.get(0).get(2));
            this.telefono = Integer.parseInt(tabla.get(0).get(6));
            this.contrasena = tabla.get(0).get(3);
            this.nombre = tabla.get(0).get(0);
            this.apellidos = tabla.get(0).get(1);
            this.direccion = tabla.get(0).get(5);

            return;
        }

        tabla = UsuariosAccess.getAllVeterinarios();

        idUsua = buscarEmail(correo);

        if (!idUsua.equals("")) {

            int idUsuario = Integer.parseInt(idUsua);

            tabla = UsuariosAccess.getVeterinarioID(idUsuario);

            this.cedula = Integer.parseInt(tabla.get(0).get(2));
            this.telefono = Integer.parseInt(tabla.get(0).get(5));
            this.contrasena = tabla.get(0).get(3);
            this.nombre = tabla.get(0).get(0);
            this.apellidos = tabla.get(0).get(1);
            return;
        }

        tabla = UsuariosAccess.getAllAdmins();

        idUsua = buscarEmailAdmins(correo);

        if (!idUsua.equals("")) {

            int idUsuario = Integer.parseInt(idUsua);

            tabla = UsuariosAccess.getAdminID(idUsuario);

            this.cedula = Integer.parseInt(tabla.get(0).get(2));
            this.telefono = Integer.parseInt(tabla.get(0).get(7));
            this.contrasena = tabla.get(0).get(3);
            this.nombre = tabla.get(0).get(0);
            this.apellidos = tabla.get(0).get(1);
            return;
        }

    }

    public String buscarEmail(String email) {
        for (ArrayList<String> fila : tabla) {

            System.out.println(fila.get(4));
            if (fila.get(5).equals(email)) {
                return fila.get(0); // Retornar el valor de la columna 0
            }
        }
        return ""; // Email no encontrado
    }

    public String buscarEmailAdmins(String email) {
        for (ArrayList<String> fila : tabla) {

            System.out.println(fila.get(4));
            if (fila.get(5).equals(email)) {
                return fila.get(0); // Retornar el valor de la columna 0
            }
        }
        return ""; // Email no encontrado
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCambiarContra;
    private java.awt.Button btnCrearCuenta;
    private java.awt.Button btnInicioSesion;
    private java.awt.Button btnInvitado;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label lblApellidos;
    private java.awt.Label lblCedula;
    private java.awt.Label lblContra;
    private java.awt.Label lblContraNueva;
    private java.awt.Label lblCorreo;
    private java.awt.Label lblCorreoNuevo1;
    private java.awt.Label lblDireccion;
    private java.awt.Label lblNombreUsuario;
    private java.awt.Label lblTelefono;
    private java.awt.Label lblTitulo;
    private javax.swing.JPanel pnlDivisor;
    private javax.swing.JPanel pnlInicioSesion;
    private javax.swing.JPanel pnlTitulo;
    private java.awt.TextField txtApellidoUsuario;
    private java.awt.TextField txtCedula;
    private java.awt.TextField txtContra;
    private java.awt.TextField txtContraNueva;
    private java.awt.TextField txtCorreo;
    private java.awt.TextField txtCorreoNuevo;
    private java.awt.TextField txtDireccion;
    private java.awt.TextField txtNombreUsuario;
    private java.awt.TextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
