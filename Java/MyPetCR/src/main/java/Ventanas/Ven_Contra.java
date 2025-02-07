/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Auxiliares.Auxiliar;
import Conexiones.UsuariosAccess;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ven_Contra extends javax.swing.JFrame {

    private ArrayList<ArrayList<String>> tabla = new ArrayList<>();
    private int filasAfectadas;
    private String email;
    private String contrasena;
    private int codigoRecuperacion;

    public Ven_Contra() {
        initComponents();
        Auxiliar.validarNumeros(txtCodigo, null);
        txtCorreo.setEnabled(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicioSesion = new javax.swing.JPanel();
        pnlDivisor = new javax.swing.JPanel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new java.awt.Label();
        txtCodigo = new java.awt.TextField();
        txtCorreo = new java.awt.TextField();
        lblContra = new java.awt.Label();
        lblCorreo = new java.awt.Label();
        btnVerificarCodigo = new java.awt.Button();
        btnEnviarCodigo = new java.awt.Button();
        txtContra = new java.awt.TextField();
        btnGuardar = new java.awt.Button();
        lblContraseña = new java.awt.Label();
        btnRegresar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlInicioSesion.setBackground(new java.awt.Color(77, 115, 129));
        pnlInicioSesion.setPreferredSize(new java.awt.Dimension(980, 510));

        pnlDivisor.setBackground(new java.awt.Color(224, 123, 79));

        javax.swing.GroupLayout pnlDivisorLayout = new javax.swing.GroupLayout(pnlDivisor);
        pnlDivisor.setLayout(pnlDivisorLayout);
        pnlDivisorLayout.setHorizontalGroup(
            pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlDivisorLayout.setVerticalGroup(
            pnlDivisorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
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
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTituloLayout.setVerticalGroup(
            pnlTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblContra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContra.setForeground(new java.awt.Color(224, 123, 79));
        lblContra.setText("Código:");

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(224, 123, 79));
        lblCorreo.setText("Correo Electrónico:");

        btnVerificarCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVerificarCodigo.setForeground(new java.awt.Color(26, 72, 91));
        btnVerificarCodigo.setLabel("Verificar");
        btnVerificarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarCodigoActionPerformed(evt);
            }
        });

        btnEnviarCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEnviarCodigo.setForeground(new java.awt.Color(26, 72, 91));
        btnEnviarCodigo.setLabel("Enviar codigo");
        btnEnviarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarCodigoActionPerformed(evt);
            }
        });

        txtContra.setEnabled(false);
        txtContra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });

        btnGuardar.setActionCommand("Confirmar");
        btnGuardar.setEnabled(false);
        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(26, 72, 91));
        btnGuardar.setLabel("Guardar contraseña");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblContraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContraseña.setForeground(new java.awt.Color(224, 123, 79));
        lblContraseña.setText("Ingrese su nueva contraseña:");

        btnRegresar.setBackground(new java.awt.Color(224, 123, 79));
        btnRegresar.setLabel("volver");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInicioSesionLayout = new javax.swing.GroupLayout(pnlInicioSesion);
        pnlInicioSesion.setLayout(pnlInicioSesionLayout);
        pnlInicioSesionLayout.setHorizontalGroup(
            pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                        .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                        .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(pnlDivisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                        .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addGap(254, 254, 254)))
                .addGap(10, 10, 10))
            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerificarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(268, Short.MAX_VALUE))
            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addComponent(txtContra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlInicioSesionLayout.setVerticalGroup(
            pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlDivisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnviarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(lblContra, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioSesionLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVerificarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(lblContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicioSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarCodigoActionPerformed
        email = txtCorreo.getText(); //obtener el email del txt

        //maybe verificar que ya existe el correo en la base antes de enviar el codigo
        if (!Auxiliar.esCorreoValido(email)) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un correo valido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.tabla = UsuariosAccess.getAllEmailUsers();

        if (!Correo_existe_en_la_base_de_datos(email)) {
            JOptionPane.showMessageDialog(null, "No existe ninguna cuenta asociada a este correo.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tabla.clear();

        String invocar = "..\\..\\enviarCorreosKris.exe";
        String subject = "Código de recuperación de contraseña";
        codigoRecuperacion = Auxiliar.generarCodigoRecuperacion();
        String content = "Su código de recuperación es: " + codigoRecuperacion;

        ProcessBuilder processBuilder = new ProcessBuilder(invocar, email, subject, content);

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Correo enviado exitosamente.");

            } else {
                System.out.println("Error al enviar el correo. Código de salida: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnEnviarCodigoActionPerformed

    private void btnVerificarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarCodigoActionPerformed
        int cod = Integer.parseInt(txtCodigo.getText());
        if (cod == codigoRecuperacion) {
            txtContra.setEnabled(true);
            btnGuardar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Código incorrecto. Intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnVerificarCodigoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        contrasena = txtContra.getText();
        if (contrasena != null && !contrasena.trim().isEmpty()) {

            Actualizar_Contrasea();
            JOptionPane.showMessageDialog(null, "La contraseña se cambió con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new Ven_Inicio();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

//---------------------------------------------------------------------------------------------   
    public boolean Correo_existe_en_la_base_de_datos(String email) {
        for (ArrayList<String> fila : tabla) {
            if (fila.get(0).equals(email)) {
                return true; // Email encontrado
            }
        }
        return false; // Email no encontrado
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
    
    public void Actualizar_Contrasea(){
        
        tabla = UsuariosAccess.getAllClientes();

            String idUsua = buscarEmail(email);

            if (!idUsua.equals("")) {
                
                int idUsuario = Integer.parseInt(idUsua);
                filasAfectadas = UsuariosAccess.updateClientePassword(idUsuario, contrasena);
                return;
            }
            
            tabla = UsuariosAccess.getAllVeterinarios();
            
            idUsua = buscarEmail(email);

            if (!idUsua.equals("")) {
                
                int idUsuario = Integer.parseInt(idUsua);
                filasAfectadas = UsuariosAccess.updateVetPassword(idUsuario, contrasena);
                return;
            }
            
            tabla = UsuariosAccess.getAllAdmins();
            
            idUsua = buscarEmailAdmins(email);

            if (!idUsua.equals("")) {
                
                int idUsuario = Integer.parseInt(idUsua);
                filasAfectadas = UsuariosAccess.updateAdminPassword(idUsuario, contrasena);
                return;
            }
            
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnEnviarCodigo;
    private java.awt.Button btnGuardar;
    private java.awt.Button btnRegresar;
    private java.awt.Button btnVerificarCodigo;
    private java.awt.Label lblContra;
    private java.awt.Label lblContraseña;
    private java.awt.Label lblCorreo;
    private java.awt.Label lblTitulo;
    private javax.swing.JPanel pnlDivisor;
    private javax.swing.JPanel pnlInicioSesion;
    private javax.swing.JPanel pnlTitulo;
    private java.awt.TextField txtCodigo;
    private java.awt.TextField txtContra;
    private java.awt.TextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
