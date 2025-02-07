
package Ventanas;

import Auxiliares.Auxiliar;
import Conexiones.SucursalesAccess;
import Conexiones.UsuariosAccess;
import Enums.TipoUsuario;
import Objetos.GLOBAL;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sasmora
 */
public class Ven_Usuarios extends javax.swing.JFrame {

    private int filasAfectadas;
    private ArrayList<ArrayList<String>> tabla = new ArrayList<>();

    private int idUsuario;
    private int cedula;
    private int telefono;
    private int numSucursal;
    private String correo;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String contrasena;

    public Ven_Usuarios() {
        initComponents();
        changeVentana();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void changeVentana() {
        if (GLOBAL.user.getTipo().equals(TipoUsuario.GERENTE)) {
            cmbTipoUsuario.addItem("Administradores");

            cmbSucursales.removeAllItems();
            tabla = SucursalesAccess.getAllSucursal();
            for (ArrayList<String> fila : tabla) {
                cmbSucursales.addItem(fila.get(1));
            }

        } else {

            cmbSucursales.setVisible(false);
            lblSucursal.setVisible(false);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        PanelIngresarDatos = new javax.swing.JPanel();
        cmbProceso = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        btnAceptar = new java.awt.Button();
        cmbTipoUsuario = new javax.swing.JComboBox<>();
        panel1 = new java.awt.Panel();
        lblDireccion = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblIdUsuario = new javax.swing.JLabel();
        lblContra = new javax.swing.JLabel();
        txtContra = new javax.swing.JTextField();
        cmbSucursales = new javax.swing.JComboBox<>();
        lblSucursal = new javax.swing.JLabel();
        pnlDivisor2 = new javax.swing.JPanel();
        lblTitulo = new java.awt.Label();
        btnExpedientes = new java.awt.Button();
        lblProductos = new java.awt.Label();
        btnInicio = new java.awt.Button();
        btnRegistrarCita = new java.awt.Button();
        btnPerfil = new java.awt.Button();
        btnRegistrarCompra = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(77, 115, 129));

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));

        tablaUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Usuario", "Cedula", "Nombre", "Apellidos", "Correo", "Direccion", "Telefono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        PanelIngresarDatos.setBackground(new java.awt.Color(177, 189, 201));
        PanelIngresarDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 255, 255), new java.awt.Color(51, 0, 204)));

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

        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes", "Veterinarios" }));
        cmbTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoUsuarioActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(177, 189, 201));
        panel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDireccion.setText("Dirección:");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblApellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblApellidos.setText("Apellidos:");

        lblCorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCorreo.setText("Correo:");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTelefono.setText("Telefóno:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCedula.setText("Cédula:");

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNombre.setText("Nombre :");

        lblIdUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblIdUsuario.setText("ID usuario:");

        lblContra.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblContra.setText("Contraseña:");

        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(lblContra, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdUsuario)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID)
                                    .addComponent(txtCedula)
                                    .addComponent(txtApellido)
                                    .addComponent(txtNombre)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(txtCorreo))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtDireccion)
                                    .addComponent(txtContra))))
                        .addGap(10, 10, 10))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContra, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cmbSucursales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Consultar Todos", "Consultar uno", "Insertar", "Actualizar", "Eliminar" }));
        cmbSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSucursalesActionPerformed(evt);
            }
        });

        lblSucursal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSucursal.setText("Sucursal");

        javax.swing.GroupLayout PanelIngresarDatosLayout = new javax.swing.GroupLayout(PanelIngresarDatos);
        PanelIngresarDatos.setLayout(PanelIngresarDatosLayout);
        PanelIngresarDatosLayout.setHorizontalGroup(
            PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresarDatosLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel18)
                        .addGap(59, 59, 59)
                        .addComponent(cmbProceso, 0, 186, Short.MAX_VALUE))
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresarDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        PanelIngresarDatosLayout.setVerticalGroup(
            PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelIngresarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDivisor2.setBackground(new java.awt.Color(224, 123, 79));

        lblTitulo.setAlignment(java.awt.Label.CENTER);
        lblTitulo.setBackground(new java.awt.Color(26, 72, 91));
        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(224, 123, 79));
        lblTitulo.setText("MyPetCR");

        btnExpedientes.setLabel("Expedientes");
        btnExpedientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpedientesActionPerformed(evt);
            }
        });

        lblProductos.setBackground(new java.awt.Color(224, 123, 79));
        lblProductos.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblProductos.setForeground(new java.awt.Color(26, 72, 91));
        lblProductos.setText("USUARIOS");

        btnInicio.setLabel("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnRegistrarCita.setLabel("Registrar Cita");
        btnRegistrarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCitaActionPerformed(evt);
            }
        });

        btnPerfil.setLabel("Perfil");
        btnPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerfilActionPerformed(evt);
            }
        });

        btnRegistrarCompra.setLabel("Registrar compra");
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDivisor2Layout = new javax.swing.GroupLayout(pnlDivisor2);
        pnlDivisor2.setLayout(pnlDivisor2Layout);
        pnlDivisor2Layout.setHorizontalGroup(
            pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDivisor2Layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnExpedientes, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnRegistrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnRegistrarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDivisor2Layout.setVerticalGroup(
            pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDivisor2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDivisor2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExpedientes, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrarCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelIngresarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(pnlDivisor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlDivisor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(PanelIngresarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cmbProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbProcesoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        int proceso = cmbProceso.getSelectedIndex();
        int tipoUsuario = cmbTipoUsuario.getSelectedIndex();
        filasAfectadas = 0;

        if (tipoUsuario == 0) { // se van a consultar Clientes

            if (proceso == 0) {// se consultan todos los clientes
                tabla = UsuariosAccess.getAllClientes();
                if (!tabla.isEmpty()) {
                    Auxiliar.addTabla(tabla, tablaUsuarios);
                }
            } else if (proceso == 1) { //Consultar un un Cliente por ID

                if (!hayID()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un ID", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    tabla = UsuariosAccess.getClienteID(idUsuario);
                    if (!tabla.isEmpty()) {
                        Auxiliar.addTabla(tabla, tablaUsuarios);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo encontrar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else if (proceso == 2) { //Insertar un Cliente
                if (getValores()) { //Obtener los valores de los textFields, etc;
                    filasAfectadas = UsuariosAccess.insertCliente(cedula, telefono, correo, contrasena, nombre, apellidos, direccion);
                    JOptionPane.showMessageDialog(null, "Se registro el cliente correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe Completar todos los datos para poder Ingresar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (proceso == 3) { //Actualizar un clientes
                if (getValores()) { //Obtener los valores de los textFields, etc;

                    if (idUsuario == GLOBAL.user.getID()) {

                        GLOBAL.user.setNombre(nombre);
                        GLOBAL.user.setCedula(cedula);
                        GLOBAL.user.setApellidos(apellidos);
                        GLOBAL.user.setDireccion(direccion);
                        GLOBAL.user.setTelefono(telefono);
                        GLOBAL.user.setCorreo(correo);

                    }
                    filasAfectadas = UsuariosAccess.updateCliente(idUsuario, cedula, telefono, correo, nombre, apellidos, direccion);
                    JOptionPane.showMessageDialog(null, "Se registro el cliente correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe Completar todos los datos para poder Actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (proceso == 4) { //Eliminar un clientes

                if (!hayID()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un ID", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    filasAfectadas = UsuariosAccess.deleteCliente(idUsuario);
                    JOptionPane.showMessageDialog(null, "Se Elimino el cliente correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else if (tipoUsuario == 1) { // se van a consultar Veterinacios

            if (proceso == 0) {// se consultan todos los Veterinacios
                tabla = UsuariosAccess.getAllVeterinarios();
                if (!tabla.isEmpty()) {
                    Auxiliar.addTabla(tabla, tablaUsuarios);
                }
            } else if (proceso == 1) { //Consultar un un Veterinacios por ID

                if (!hayID()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un ID", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    tabla = UsuariosAccess.getVeterinarioID(idUsuario);
                    if (!tabla.isEmpty()) {
                        Auxiliar.addTabla(tabla, tablaUsuarios);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo encontrar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else if (proceso == 2) { //Insertar un Veterinacios
                if (getValores()) { //Obtener los valores de los textFields, etc;
                    filasAfectadas = UsuariosAccess.insertVeterinario(cedula, telefono, correo, contrasena, nombre, apellidos);
                    JOptionPane.showMessageDialog(null, "Se registro el veterinario correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe Completar todos los datos para poder Ingresar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (proceso == 3) { //Actualizar un Veterinacios
                if (getValores()) { //Obtener los valores de los textFields, etc;

                    if (idUsuario == GLOBAL.user.getID()) {

                        GLOBAL.user.setNombre(nombre);
                        GLOBAL.user.setCedula(cedula);
                        GLOBAL.user.setApellidos(apellidos);
                        GLOBAL.user.setDireccion(direccion);
                        GLOBAL.user.setTelefono(telefono);
                        GLOBAL.user.setCorreo(correo);

                    }

                    filasAfectadas = UsuariosAccess.updateVeterinario(cedula, telefono, correo, contrasena, nombre, apellidos);
                    JOptionPane.showMessageDialog(null, "Se registro el veterinario correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe Completar todos los datos para poder Actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (proceso == 4) { //Eliminar un Veterinacios

                if (!hayID()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un ID", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    filasAfectadas = UsuariosAccess.deleteVeterinario(idUsuario);
                    JOptionPane.showMessageDialog(null, "Se Elimino el veterinario correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else if (tipoUsuario == 2) { // se van a consultar Administradores

            if (proceso == 0) {// se consultan todos los Veterinacios
                tabla = UsuariosAccess.getAllAdmins();
                if (!tabla.isEmpty()) {
                    Auxiliar.addTabla(tabla, tablaUsuarios);
                }
            } else if (proceso == 1) { //Consultar un un Admin por ID

                if (!hayID()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un ID", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    tabla = UsuariosAccess.getAdminID(idUsuario);
                    if (!tabla.isEmpty()) {
                        Auxiliar.addTabla(tabla, tablaUsuarios);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo encontrar", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else if (proceso == 2) { //Insertar un Admin
                if (getValores()) { //Obtener los valores de los textFields, etc;
                    filasAfectadas = UsuariosAccess.insertAdmin(cedula, telefono, numSucursal, correo, contrasena, nombre, apellidos, direccion);
                    JOptionPane.showMessageDialog(null, "Se registro el admin correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe Completar todos los datos para poder Ingresar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (proceso == 3) { //Actualizar un Admin
                if (getValores()) { //Obtener los valores de los textFields, etc;

                    if (idUsuario == GLOBAL.user.getID()) {

                        GLOBAL.user.setNombre(nombre);
                        GLOBAL.user.setCedula(cedula);
                        GLOBAL.user.setApellidos(apellidos);
                        GLOBAL.user.setDireccion(direccion);
                        GLOBAL.user.setTelefono(telefono);
                        GLOBAL.user.setCorreo(correo);

                    }

                    filasAfectadas = UsuariosAccess.updateAdmin(idUsuario, cedula, telefono, numSucursal, correo, contrasena, nombre, apellidos, direccion);
                    JOptionPane.showMessageDialog(null, "Se registro el admin correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe Completar todos los datos para poder Actualizar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (proceso == 4) { //Eliminar un Veterinacios

                if (!hayID()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un ID", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    filasAfectadas = UsuariosAccess.deleteVeterinario(idUsuario);
                    JOptionPane.showMessageDialog(null, "Se Elimino el admin correctamente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

        clearEspacios();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cmbTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoUsuarioActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        new Venta_Main();
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnRegistrarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCitaActionPerformed
        new Ven_Cita();
        this.dispose();
    }//GEN-LAST:event_btnRegistrarCitaActionPerformed

    private void btnPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerfilActionPerformed
        new Ven_Perfil();
        this.dispose();
    }//GEN-LAST:event_btnPerfilActionPerformed

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    private void btnExpedientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpedientesActionPerformed
        new Ven_IngresarExpediente(this);
    }//GEN-LAST:event_btnExpedientesActionPerformed

    private void cmbSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSucursalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSucursalesActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked
        // TODO add your handling code here:

        int fila = tablaUsuarios.getSelectedRow();
        int id = Integer.parseInt(tablaUsuarios.getValueAt(fila, 0).toString());
        int tipoUsuario = cmbTipoUsuario.getSelectedIndex();

        if (tipoUsuario == 0) { // select para clientes
            tabla = UsuariosAccess.getClienteID(id);

            txtID.setText(id + "");
            txtNombre.setText(tabla.get(0).get(0));
            txtApellido.setText(tabla.get(0).get(1));
            txtCedula.setText((tabla.get(0).get(2)));
            txtContra.setText(tabla.get(0).get(3));
            txtCorreo.setText(tabla.get(0).get(4));
            txtDireccion.setText(tabla.get(0).get(5));
            txtTelefono.setText(tabla.get(0).get(6));

        } else if (tipoUsuario == 1) { //select para veterinarios

            tabla = UsuariosAccess.getVeterinarioID(id);

            txtID.setText(id + "");
            txtNombre.setText(tabla.get(0).get(0));
            txtApellido.setText(tabla.get(0).get(1));
            txtCedula.setText((tabla.get(0).get(2)));
            txtContra.setText(tabla.get(0).get(3));
            txtCorreo.setText(tabla.get(0).get(4));
            txtTelefono.setText(tabla.get(0).get(5));
        } else if (tipoUsuario == 2) {

            tabla = UsuariosAccess.getAdminID(id);

            txtID.setText(id + "");
            txtNombre.setText(tabla.get(0).get(0));
            txtApellido.setText(tabla.get(0).get(1));
            txtCedula.setText((tabla.get(0).get(2)));
            txtContra.setText(tabla.get(0).get(3));
            txtCorreo.setText(tabla.get(0).get(4));

            cmbSucursales.setSelectedIndex(Integer.parseInt(tabla.get(0).get(6)));

            txtTelefono.setText(tabla.get(0).get(7));
        }
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void clearEspacios() {
        txtApellido.setText("");
        txtCedula.setText("");
        txtNombre.setText("");
        txtContra.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtID.setText("");
        txtTelefono.setText("");
    }

    private boolean hayID() {

        String IDUsuario = txtID.getText();

        if (IDUsuario.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un ID", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                this.idUsuario = Integer.parseInt(txtID.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un Numero de ID valido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    private boolean getValores() {

        String IDUsuario = txtID.getText();

        if (IDUsuario.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un ID", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                this.idUsuario = Integer.parseInt(txtID.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un Numero de ID valido", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        this.nombre = txtNombre.getText();

        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un Nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.apellidos = txtApellido.getText();

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

        this.correo = txtCorreo.getText();

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

        this.contrasena = txtContra.getText();

        if (contrasena.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una Contrasenia", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        this.numSucursal = cmbSucursales.getSelectedIndex();

        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelIngresarDatos;
    private java.awt.Button btnAceptar;
    private java.awt.Button btnExpedientes;
    private java.awt.Button btnInicio;
    private java.awt.Button btnPerfil;
    private java.awt.Button btnRegistrarCita;
    private java.awt.Button btnRegistrarCompra;
    private javax.swing.JComboBox<String> cmbProceso;
    private javax.swing.JComboBox<String> cmbSucursales;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContra;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblIdUsuario;
    private javax.swing.JLabel lblNombre;
    private java.awt.Label lblProductos;
    private javax.swing.JLabel lblSucursal;
    private javax.swing.JLabel lblTelefono;
    private java.awt.Label lblTitulo;
    private java.awt.Panel panel1;
    private javax.swing.JPanel pnlDivisor2;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContra;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
