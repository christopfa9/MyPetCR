/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import Enums.Sucursales;
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
public class SucursalesAccess {
    
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
    
    public static ArrayList<ArrayList<String>> getSucursal (int idSucursal) {
        Sucursales comando = Sucursales.SELECT_ONE;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idSucursal);

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
    
    public static ArrayList<ArrayList<String>> getAllSucursal () {
        ArrayList<ArrayList<String>> tabla = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.createStatement(); //Crear el statement 
            resultSet = statement.executeQuery(Sucursales.SELECT_ALL.getProceso()); //Ejecutar el statement
            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }
            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static int insertSucursal( String nombre, String ubicacion) {
        Sucursales comando = Sucursales.INSERT;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setString(1, nombre);
            statement.setString(2, ubicacion);

            // Ejecutar la inserción
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int deleteCliente(int idSucursal) {
        Sucursales comando = Sucursales.DELETE;
        PreparedStatement statement = null;
        int filasAfectadas = 0;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idSucursal);
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int updateCliente(int idSucursal, String nombre, String ubicacion) {
        Sucursales comando = Sucursales.UPDATE;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idSucursal);
            statement.setString(2, nombre);
            statement.setString(3, ubicacion);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
}
