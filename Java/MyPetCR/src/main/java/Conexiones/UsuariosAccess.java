/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import Enums.Administrador;
import Enums.Clientes;
import Enums.Usuarios;
import Enums.Veterinarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class UsuariosAccess {

    private static ArrayList<ArrayList<String>> toArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<ArrayList<String>> tabla = new ArrayList();
        ResultSetMetaData rsmd;
        rsmd = resultSet.getMetaData();
        int Columnas = rsmd.getColumnCount();
        
        while (resultSet.next()) {
            ArrayList<String> fila = new ArrayList();
            for (int i = 0; i < Columnas; i++) {
                fila.add(resultSet.getString(i+1));
            }
            tabla.add(fila);
        }
        return tabla;
    }
    
    public static ArrayList<ArrayList<String>> getUser(String correo, String contra) {
        Usuarios comando = Usuarios.SELECT_GETUSER;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setString(1, correo);
            statement.setString(2, contra);

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
    
    public static ArrayList<ArrayList<String>> getAllEmailUsers() {
        ArrayList<ArrayList<String>> tabla = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.createStatement(); //Crear el statement 
            resultSet = statement.executeQuery(Usuarios.SELECT_GET_ALL_USERS_EMAILS.getProceso()); //Ejecutar el statement
            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }
            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static ArrayList<ArrayList<String>> getAllClientes() {
        ArrayList<ArrayList<String>> tabla = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.createStatement(); //Crear el statement 
            resultSet = statement.executeQuery(Clientes.SELECT_ALL.getProceso()); //Ejecutar el statement
            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }
            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static ArrayList<ArrayList<String>> getClienteID(int idUsuario) {
        Clientes comando = Clientes.SELECT_ONE_POR_ID;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idUsuario);

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
    
    public static ArrayList<ArrayList<String>> getClienteCedula(int cedula) {
        Clientes comando = Clientes.SELECT_ONE_POR_CEDULA;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, cedula);

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static int insertCliente(int cedula, int telefono, String correo, String contra, String nombre, String apellidos, String direccion) {
        Clientes comando = Clientes.INSERT;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setInt(3, cedula);
            statement.setString(4, contra);
            statement.setString(5, correo);
            statement.setString(6, direccion);
            statement.setInt(7, telefono);

            // Ejecutar la inserción
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int deleteCliente(int idAutor) {
        Clientes comando = Clientes.DELETE;
        PreparedStatement statement = null;
        int filasAfectadas = 0;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idAutor);
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int updateCliente(int IdCliente,int cedula, int telefono, String correo, String nombre, String apellidos, String direccion) {
        Clientes comando = Clientes.UPDATE;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, IdCliente);
            statement.setString(2, nombre);
            statement.setString(3, apellidos);
            statement.setInt(4, cedula);
            statement.setString(5, correo);
            statement.setString(6, direccion);
            statement.setInt(7, telefono);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
    
    public static int updateClientePassword(int IdCliente, String contra) {
        Clientes comando = Clientes.UPDATE_Password;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, IdCliente);
            statement.setString(2, contra);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
    
    public static ArrayList<ArrayList<String>> getAllVeterinarios() {
        ArrayList<ArrayList<String>> tabla = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.createStatement(); //Crear el statement 
            resultSet = statement.executeQuery(Veterinarios.SELECT_ALL.getProceso()); //Ejecutar el statement
            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }
            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static ArrayList<ArrayList<String>> getVeterinarioID(int idUsuario) {
        Veterinarios comando = Veterinarios.SELECT_ONE_POR_ID;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idUsuario);

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
    
    public static ArrayList<ArrayList<String>> getVeteriCedula(int cedula) {
        Veterinarios comando = Veterinarios.SELECT_ONE_POR_CEDULA;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, cedula);

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static int insertVeterinario(int cedula, int telefono, String correo, String contra, String nombre, String apellidos) {
        Veterinarios comando = Veterinarios.INSERT;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setInt(3, cedula);
            statement.setString(4, contra);
            statement.setString(5, correo);
            statement.setInt(6, telefono);

            // Ejecutar la inserción
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int deleteVeterinario(int idAutor) {
        Veterinarios comando = Veterinarios.DELETE;
        PreparedStatement statement = null;
        int filasAfectadas = 0;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idAutor);
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int updateVeterinario(int cedula, int telefono, String correo, String contra, String nombre, String apellidos) {
        Veterinarios comando = Veterinarios.UPDATE;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setInt(3, cedula);
            statement.setString(4, contra);
            statement.setString(5, correo);
            statement.setInt(6, telefono);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
    
    public static int updateVetPassword(int IdVet, String contra) {
        Veterinarios comando = Veterinarios.UPDATE_Password;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, IdVet);
            statement.setString(2, contra);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
    
    
    public static ArrayList<ArrayList<String>> getAllAdmins() {
        ArrayList<ArrayList<String>> tabla = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.createStatement(); //Crear el statement 
            resultSet = statement.executeQuery(Administrador.SELECT_ALL.getProceso()); //Ejecutar el statement
            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }
            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static ArrayList<ArrayList<String>> getAdminID(int idUsuario) {
        Administrador comando = Administrador.SELECT_ONE_POR_ID;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idUsuario);

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
    
    public static ArrayList<ArrayList<String>> getAdminCedula(int cedula) {
        Administrador comando = Administrador.SELECT_ONE_POR_CEDULA;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, cedula);

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static int insertAdmin(int cedula, int telefono, int idSucursal, String correo, String contra, String nombre, String apellidos,String direccion) {
        Administrador comando = Administrador.INSERT;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setInt(3, cedula);
            statement.setString(4, contra);
            statement.setString(5, correo);
            statement.setInt(6, telefono);

            // Ejecutar la inserción
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int deleteAdmin(int idAutor) {
        Administrador comando = Administrador.DELETE;
        PreparedStatement statement = null;
        int filasAfectadas = 0;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idAutor);
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int updateAdmin(int idAdmin, int cedula, int telefono, int idSucursal, String correo, String contra, String nombre, String apellidos,String direccion) {
        Administrador comando = Administrador.UPDATE;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setInt(3, cedula);
            statement.setString(4, contra);
            statement.setString(5, correo);
            statement.setInt(6, telefono);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
    
    public static int updateAdminPassword(int IdVet, String contra) {
        Administrador comando = Administrador.UPDATE_Password;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, IdVet);
            statement.setString(2, contra);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
}
