/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Ventanas;

import Conexiones.MascotasAccess;
import Objetos.Mascota;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ven_IngresarExpediente extends javax.swing.JFrame {

    private JFrame ventanaAnterior;
    private Mascota mascota;

    private int filasAfectadas;
    private ArrayList<ArrayList<String>> tabla = new ArrayList<>();

    private int idUsuario;
    private int idMascota;
    private String nombreM;
    private String nombreD;
    private int edad;
    private boolean Sexo;
    private boolean Activo;

    public Ven_IngresarExpediente(JFrame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        cambiarEstados(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInicioSesion = new javax.swing.JPanel();
        pnlDivisor = new javax.swing.JPanel();
        pnlTitulo = new javax.swing.JPanel();
        lblTitulo = new java.awt.Label();
        lblCorreo = new java.awt.Label();
        btnRegresar = new java.awt.Button();
        pnlNombre = new javax.swing.JPanel();
        txtNomMascota = new java.awt.TextField();
        txtNomDueno = new java.awt.TextField();
        lblCorreo2 = new java.awt.Label();
        lblCorreo3 = new java.awt.Label();
        lblCorreo4 = new java.awt.Label();
        pnlID = new javax.swing.JPanel();
        txtIDMascota = new java.awt.TextField();
        lblCorreo1 = new java.awt.Label();
        btnBuscar = new java.awt.Button();
        radNombre = new javax.swing.JRadioButton();
        radID = new javax.swing.JRadioButton();

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
        lblTitulo.setText("EXPEDIENTES");

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

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(224, 123, 79));
        lblCorreo.setText("Buscar expediente por:");

        btnRegresar.setBackground(new java.awt.Color(224, 123, 79));
        btnRegresar.setLabel("volver");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        pnlNombre.setBackground(new java.awt.Color(255, 199, 167));
        pnlNombre.setEnabled(false);
        pnlNombre.setPreferredSize(new java.awt.Dimension(213, 223));

        txtNomMascota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNomMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomMascotaActionPerformed(evt);
            }
        });

        txtNomDueno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNomDueno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomDuenoActionPerformed(evt);
            }
        });

        lblCorreo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorreo2.setForeground(new java.awt.Color(26, 72, 91));
        lblCorreo2.setText("Nombre del dueño:");

        lblCorreo3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorreo3.setForeground(new java.awt.Color(224, 123, 79));
        lblCorreo3.setText("Nombre de la mascota:");
        lblCorreo3.setVisible(false);

        lblCorreo4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorreo4.setForeground(new java.awt.Color(26, 72, 91));
        lblCorreo4.setText("Nombre de la mascota:");

        javax.swing.GroupLayout pnlNombreLayout = new javax.swing.GroupLayout(pnlNombre);
        pnlNombre.setLayout(pnlNombreLayout);
        pnlNombreLayout.setHorizontalGroup(
            pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNombreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCorreo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomMascota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomDueno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlNombreLayout.createSequentialGroup()
                        .addGroup(pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCorreo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlNombreLayout.setVerticalGroup(
            pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNombreLayout.createSequentialGroup()
                .addGroup(pnlNombreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNombreLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(lblCorreo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNombreLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomDueno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCorreo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtNomMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pnlID.setBackground(new java.awt.Color(255, 199, 167));

        txtIDMascota.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIDMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMascotaActionPerformed(evt);
            }
        });

        lblCorreo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorreo1.setForeground(new java.awt.Color(26, 72, 91));
        lblCorreo1.setText("Ingrese el id de la mascota:");

        javax.swing.GroupLayout pnlIDLayout = new javax.swing.GroupLayout(pnlID);
        pnlID.setLayout(pnlIDLayout);
        pnlIDLayout.setHorizontalGroup(
            pnlIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIDLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIDLayout.createSequentialGroup()
                        .addComponent(lblCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(txtIDMascota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlIDLayout.setVerticalGroup(
            pnlIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIDLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(26, 72, 91));
        btnBuscar.setLabel("Buscar expediente");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        radNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radNombre.setText("NOMBRE MASCOTA");
        radNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNombreActionPerformed(evt);
            }
        });

        radID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radID.setSelected(true);
        radID.setText("ID MASCOTA");
        radID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInicioSesionLayout = new javax.swing.GroupLayout(pnlInicioSesion);
        pnlInicioSesion.setLayout(pnlInicioSesionLayout);
        pnlInicioSesionLayout.setHorizontalGroup(
            pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioSesionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioSesionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                        .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(pnlDivisor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioSesionLayout.createSequentialGroup()
                        .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                                .addComponent(pnlID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(radID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInicioSesionLayout.createSequentialGroup()
                                .addComponent(radNombre)
                                .addGap(64, 64, 64)))
                        .addGap(12, 12, 12))
                    .addGroup(pnlInicioSesionLayout.createSequentialGroup()
                        .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(283, 283, 283))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radID)
                    .addComponent(radNombre))
                .addGap(18, 18, 18)
                .addGroup(pnlInicioSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlInicioSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if (buscarMascota()) {
            new Ven_Expediente(mascota);  //PRIMERO BUSCAR LA MASCOTA EN LA BASE DE DATOS YA SEA POR ID O POR NOMBRE Y NOMBRE DEL DUEÑO
            ventanaAnterior.dispose();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar a la mascota.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIDMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMascotaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtNomMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomMascotaActionPerformed

    private void txtNomDuenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomDuenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomDuenoActionPerformed

    private void radNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNombreActionPerformed
        if (radID.isSelected() == true) {
            radID.setSelected(false);
        }
        cambiarEstados(false);
    }//GEN-LAST:event_radNombreActionPerformed

    private void radIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radIDActionPerformed
        if (radNombre.isSelected() == true) {
            radNombre.setSelected(false);
        }
        cambiarEstados(true);
    }//GEN-LAST:event_radIDActionPerformed

//---------------------------------------------------------------------------------------------   
    private void cambiarEstados(boolean on) {
        txtIDMascota.setEnabled(on);
        txtNomDueno.setEnabled(!on);
        txtNomMascota.setEnabled(!on);
    }

    private boolean hayIdMascota() {

        String IDUsu = txtIDMascota.getText();

        if (IDUsu.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un ID de Mascota", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                this.idMascota = Integer.parseInt(IDUsu);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un Numero de ID valido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }
    
    private boolean hayNombreMascata(){
        
        this.nombreM = txtNomMascota.getText();
        this.nombreD = txtNomDueno.getText();
        
        if (nombreM.equals("") || nombreD.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar ambos nombres", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean buscarMascota() {

        if (radID.isSelected() == true) {
            //BUSCAR MASCOTA POR ID DE MASCOTA

            if (hayIdMascota()) {

                tabla = MascotasAccess.getPet(idMascota);

                if (!tabla.isEmpty()) {

                    this.idUsuario = Integer.parseInt(tabla.get(0).get(0));
                    this.nombreM = tabla.get(0).get(1);
                    this.edad = Integer.parseInt(tabla.get(0).get(2));
                    this.Sexo = "1".equals(tabla.get(0).get(3));
                    this.Activo = "1".equals(tabla.get(0).get(4));
                    this.mascota = new Mascota(idMascota, idUsuario, nombreM, edad, Sexo, Activo);
                    
                    return true;
                    
                }
            }

        } else {
            // BUSCAR MASCOTA POR NOMBRE DE CLIENTE Y MASCOTA
            if(hayNombreMascata()){
                
                tabla = MascotasAccess.GetMascotaPorNombreDuennoYNombreMascota(nombreM,nombreD);

                if (!tabla.isEmpty()) {
                        
                    this.idMascota = Integer.parseInt(tabla.get(0).get(0));
                    this.idUsuario = Integer.parseInt(tabla.get(0).get(1));
                    this.edad = Integer.parseInt(tabla.get(0).get(5));
                    this.Sexo = "1".equals(tabla.get(0).get(6));
                    this.Activo = "1".equals(tabla.get(0).get(7));
                    this.mascota = new Mascota(idMascota, idUsuario, nombreM, edad, Sexo, Activo);
                    
                    return true;
                    
                }
                
            }           
        }

        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnBuscar;
    private java.awt.Button btnRegresar;
    private java.awt.Label lblCorreo;
    private java.awt.Label lblCorreo1;
    private java.awt.Label lblCorreo2;
    private java.awt.Label lblCorreo3;
    private java.awt.Label lblCorreo4;
    private java.awt.Label lblTitulo;
    private javax.swing.JPanel pnlDivisor;
    private javax.swing.JPanel pnlID;
    private javax.swing.JPanel pnlInicioSesion;
    private javax.swing.JPanel pnlNombre;
    private javax.swing.JPanel pnlTitulo;
    private javax.swing.JRadioButton radID;
    private javax.swing.JRadioButton radNombre;
    private java.awt.TextField txtIDMascota;
    private java.awt.TextField txtNomDueno;
    private java.awt.TextField txtNomMascota;
    // End of variables declaration//GEN-END:variables
}
