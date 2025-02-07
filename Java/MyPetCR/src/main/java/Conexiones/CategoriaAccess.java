/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import Auxiliares.Auxiliar;
import Enums.Categoria;
import Objetos.GLOBAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sasmora
 */
public class CategoriaAccess {
    
    public static ArrayList<ArrayList<String>> getCategorias() {
        Categoria comando = Categoria.SELECT_ALL;
        ArrayList<ArrayList<String>> tabla = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Connection SQLconexion = Conexion.getSQLConnection(); //Abrir la conexion
            statement = SQLconexion.prepareStatement(comando.getProceso()); //Crear el statement 
            resultSet = statement.executeQuery(); //Ejecutar el statement
            if (resultSet != null) {
                tabla = Auxiliar.toArrayList(resultSet);
                
                for (ArrayList<String> arrayList : tabla) {
                    GLOBAL.addCategoria(arrayList.get(0));
                }
                
            }
            SQLconexion.close(); //Cerrar la conexion
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla;
    }
    
    
} // FIN DE LA CLASE
