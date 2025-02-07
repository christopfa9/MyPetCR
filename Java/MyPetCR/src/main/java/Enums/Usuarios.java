/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author chris
 */
public enum Usuarios {
    
    SELECT_GETUSER("EXEC sp_GetUser ?, ?"),
    SELECT_GET_ALL_USERS_EMAILS("EXEC sp_GetAllUserEmails");
    private final String proceso;

    Usuarios(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
