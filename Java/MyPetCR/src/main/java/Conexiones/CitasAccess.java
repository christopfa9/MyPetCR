
package Conexiones;

import Enums.Citas;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class CitasAccess {
    
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
    
    public static ArrayList<ArrayList<String>> getAllFutureAppointments() {
        Citas comando = Citas.SELECT_ALL_FUTURE_APPOINTMENTS;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 
            
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
    
    public static ArrayList<ArrayList<String>> getAllFutureClientsAppointments(int idClient) {
        Citas comando = Citas.SELECT_ALL_FUTURE_CLIENT_APPOINTMENTS;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idClient);

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
    
    public static ArrayList<ArrayList<String>> ExtraerVetsDisponibles( String FechaCita,String Hora) {
        Citas comando = Citas.ExtraerVetsDisponibles;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            
            // Formato de la fecha en tu cadena
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            // Convertir el String a java.util.Date
            Date utilDate = null;
            try {
                utilDate = dateFormat.parse(FechaCita);
            } catch (ParseException ex) {
                Logger.getLogger(CitasAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Convertir java.util.Date a java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            
            statement.setDate(1, sqlDate);
            statement.setString(2, Hora);

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
    
    public static ArrayList<ArrayList<String>> getAllFuturePetsAppointments(int idPet) {
        Citas comando = Citas.SELECT_ALL_FUTURE_PETS_APPOINTMENTS;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idPet);

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
    
    public static ArrayList<ArrayList<String>> getAllFutureVetsAppointments(int idVet) {
        Citas comando = Citas.SELECT_ALL_FUTURE_VET_APPOINTMENTS;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idVet);

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
    
    public static ArrayList<ArrayList<String>> GetAppointment(int idCita) {
        Citas comando = Citas.SELECT_ONE;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idCita);

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

    public static int intsetAppointment( String FechaCita,String Hora,int idPet, int idVet, int idSucursal) {
        Citas comando = Citas.INSERT;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            
            // Formato de la fecha en tu cadena
            SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
            // Convertir el String a java.util.Date
            Date utilDate = null;
            try {
                utilDate = dateFormat.parse(FechaCita);
            } catch (ParseException ex) {
                Logger.getLogger(CitasAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Convertir java.util.Date a java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            
            statement.setDate(1, sqlDate);
            
            statement.setString(2, Hora);
            statement.setInt(3, idPet);
            statement.setInt(4, idVet);
            statement.setInt(5, idSucursal);
            // Ejecutar la inserción
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int deleteAppointment(int idCita) {
        Citas comando = Citas.DELETE;
        PreparedStatement statement = null;
        int filasAfectadas = 0;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idCita);
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int updateAppointment(int idCita, Date FehcaCita,String Hora, int idVet, int idSucursal) {
        Citas comando = Citas.UPDATE;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            
            statement.setInt(1, idCita);
            statement.setDate(2, (java.sql.Date) FehcaCita);
            statement.setString(3, Hora);
            statement.setInt(4, idVet);
            statement.setInt(5, idSucursal);

            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
}
