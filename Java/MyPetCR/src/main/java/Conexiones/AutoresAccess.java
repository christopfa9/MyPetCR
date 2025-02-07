/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import Enums.Autores;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoresAccess {

    private static ArrayList<ArrayList<String>> toArrayList(ResultSet resultSet, int columnas) throws SQLException {
        ArrayList<ArrayList<String>> tabla = new ArrayList();
        while (resultSet.next()) {
            ArrayList<String> fila = new ArrayList();
            for (int i = 0; i <= columnas; i++) {
                fila.add(resultSet.getString(i));
            }
            tabla.add(fila);
        }
        return tabla;
    }

    public static ArrayList<ArrayList<String>> getAutores() {
        String datos = "";
        ArrayList<ArrayList<String>> tabla = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData rsmd;
        int columnas;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.createStatement(); //Crear el statement 
            resultSet = statement.executeQuery(Autores.SELECT_ALL.getProceso()); //Ejecutar el statement
            rsmd = resultSet.getMetaData();
            columnas = rsmd.getColumnCount();
            if (resultSet != null) {
                tabla = toArrayList(resultSet,columnas);
            }
            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(AutoresAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static ArrayList<ArrayList<String>> getAutor(String idAutor) {
        Autores comando = Autores.SELECT_ONE;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ResultSetMetaData rsmd;
        int columnas;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setString(1, idAutor);

            resultSet = statement.executeQuery(); //Ejecutar el statement
            rsmd = resultSet.getMetaData();
            columnas = rsmd.getColumnCount();
            if (resultSet != null) {
                tabla = toArrayList(resultSet,columnas);
            }

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(AutoresAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static int insertAutor(String idAutor, String nombre, String idPais, String vivo, Date fechaNacimiento, Date primeraPubli, int publicaciones, BigDecimal calificacion) {
        Autores comando = Autores.INSERT;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setString(1, idAutor);
            statement.setString(2, nombre);
            statement.setString(3, idPais);
            statement.setString(4, vivo);
            statement.setDate(5, fechaNacimiento);
            statement.setDate(6, primeraPubli);
            statement.setInt(7, publicaciones);
            statement.setBigDecimal(8, calificacion);

            // Ejecutar la inserción
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(AutoresAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int deleteAutor(String idAutor) {
        Autores comando = Autores.DELETE;
        PreparedStatement statement = null;
        int filasAfectadas = 0;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setString(1, idAutor);
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(AutoresAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int updateAutor(String idAutor, String nombre, String idPais, String vivo, Date fechaNacimiento, Date primeraPubli, int publicaciones, BigDecimal calificacion) {
        Autores comando = Autores.UPDATE;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setString(1, idAutor);
            statement.setString(2, nombre);
            statement.setString(3, idPais);
            statement.setString(4, vivo);
            statement.setDate(5, fechaNacimiento);
            statement.setDate(6, primeraPubli);
            statement.setInt(7, publicaciones);
            statement.setBigDecimal(8, calificacion);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(AutoresAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }

} // FINAL DE LA CLASE

