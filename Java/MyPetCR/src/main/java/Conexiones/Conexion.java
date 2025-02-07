/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexiones;

import Enums.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static User actual = User.ALEX;
    
    private static Connection conexion = null;
    private static final String CONEXION = "jdbc:sqlserver://" + actual.getServer() + ";"
            + "databaseName=MyPetCR;" 
            + "user=" + actual.getNameUser() + ";"
            + "password=" + actual.getPassword() + ";" 
            + "encrypt = false;"
            + "trustServerCertificate = false;"
            + "loginTimeout = 30;";
    
    public static Connection getSQLConnection() {
        try {
            conexion = DriverManager.getConnection(CONEXION);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return conexion;
    }
    
    
} //FINAL DE LA CLASE

