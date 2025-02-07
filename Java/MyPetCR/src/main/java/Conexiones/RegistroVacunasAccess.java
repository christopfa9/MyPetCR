/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import Enums.RegistroVacunas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Auxiliares.Auxiliar;
import java.sql.Date;
/**
 *
 * @author yo
 */
public class RegistroVacunasAccess {
      
    public static ArrayList<ArrayList<String>> getRegistroVacuna(int idRegistro) {
        RegistroVacunas comando = RegistroVacunas.SELECT_ONE;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idRegistro);

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = Auxiliar.toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la conexion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static ArrayList<ArrayList<String>> getAllRegistrosVacunas() {
        RegistroVacunas comando = RegistroVacunas.SELECT_ALL;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = Auxiliar.toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la conexion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static int insertRegistroVacuna(int IDMascota,int IDVacuna) {
        RegistroVacunas comando = RegistroVacunas.INSERT;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, IDMascota);
            statement.setInt(2, IDVacuna);

            // Ejecutar la inserción
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int deleteRegistroVacuna(int idRegistro) {
        RegistroVacunas comando = RegistroVacunas.DELETE;
        PreparedStatement statement = null;
        int filasAfectadas = 0;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idRegistro);

            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int updateRegistroVacuna(int IDRegistro,int IDMascota,int IDVacuna, Date FechaVacuna) {
        RegistroVacunas comando = RegistroVacunas.UPDATE;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, IDRegistro);
            statement.setInt(2, IDMascota);
            statement.setInt(3, IDVacuna);
            statement.setDate(4, FechaVacuna);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
}
