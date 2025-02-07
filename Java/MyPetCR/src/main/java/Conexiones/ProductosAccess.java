/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import Objetos.Productos;
import Enums.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Objetos.GLOBAL;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
/**
 *
 * @author yo
 */
public class ProductosAccess {
      
    private static void toArrayListProductos(ResultSet resultSet) throws SQLException {   
        Productos producto = new Productos();
        producto.setIdProductos(resultSet.getInt(1));
        producto.setNombre(resultSet.getString(2));
        producto.setCategoria(resultSet.getInt(3));
        producto.setCantidadTotal(resultSet.getInt(4));
        producto.setPrecio(resultSet.getFloat(5));
        GLOBAL.addProducto(producto);
    }
    public static ArrayList<ArrayList<String>> toArrayList(ResultSet resultSet) throws SQLException {
        GLOBAL.clearProductos();
        ArrayList<ArrayList<String>> tabla = new ArrayList();
        ResultSetMetaData rsmd;
        rsmd = resultSet.getMetaData();
        int Columnas = rsmd.getColumnCount();
        
        while (resultSet.next()) {
            ArrayList<String> fila = new ArrayList();
            for (int i = 0; i < Columnas; i++) {
                fila.add(resultSet.getString(i+1));
            }
            toArrayListProductos(resultSet);
            tabla.add(fila);
        }
        return tabla;
    }

    public static ArrayList<ArrayList<String>> getProduct(int idProduct) {
        ProductosEnum comando = ProductosEnum.SELECT_ONE;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idProduct);

            resultSet = statement.executeQuery(); //Ejecutar el statement

            if (resultSet != null) {
                tabla = toArrayList(resultSet);
            }

            SQLconexion.close(); //Cerrar la conexion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static ArrayList<ArrayList<String>> getAllProducts() {
        ProductosEnum comando = ProductosEnum.SELECT_ALL;
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

            SQLconexion.close(); //Cerrar la conexion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }

    public static int insertProduct(String nombre,int categoria,int cantidadTotal, Float precio) {
        ProductosEnum comando = ProductosEnum.INSERT;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); // Abrir la conexión
            // Crear el statement con la opción de devolver claves generadas
            statement = SQLconexion.prepareStatement(comando.getProceso(), Statement.RETURN_GENERATED_KEYS);

            // Pasar los parámetros al statement
            statement.setString(1, nombre);
            statement.setInt(2, categoria);
            statement.setInt(3, cantidadTotal);
            statement.setFloat(4, precio);

            // Ejecutar la inserción
            filasAfectadas = statement.executeUpdate();
            getAllProducts();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int deleteProduct(int idProducto) {
        ProductosEnum comando = ProductosEnum.DELETE;
        PreparedStatement statement = null;
        int filasAfectadas = 0;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar el parámetro idAutor al statement
            statement.setInt(1, idProducto);
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la coneccion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
    }

    public static int updateProducto(int idProducto,String nombre,int categoria, int cantidadTotal, float precio) {
        ProductosEnum comando = ProductosEnum.UPDATE;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idProducto);
            statement.setString(2, nombre);
            statement.setInt(3, categoria);
            statement.setInt(4, cantidadTotal);
            statement.setFloat(5, precio);
            // Ejecutar la actualizacion
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;

    }
    
    public static int descontar(int idProducto, int idSucursal, int decrementar){
        ProductosEnum comando = ProductosEnum.DESCONTAR;
        int filasAfectadas = 0;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 

            // Pasar los parámetros al statement
            statement.setInt(1, idProducto);
            statement.setInt(2, idSucursal);
            statement.setInt(3, decrementar);
            filasAfectadas = statement.executeUpdate();

            SQLconexion.close(); //Cerrar la conexión
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return filasAfectadas;
        
        
        
    }    
    
    
    
    
    
}
