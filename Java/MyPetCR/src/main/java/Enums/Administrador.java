/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author chris
 */
public enum Administrador {
    SELECT_ALL("EXEC sp_GetAllAdmin"),
    SELECT_ONE_POR_ID("EXEC sp_GetAdmin ?"),
    SELECT_ONE_POR_CEDULA("EXEC sp_GetAdminByID ?"),
    INSERT("EXEC sp_CreateAdmin ?,?,?,?,?,?,?"),
    DELETE("EXEC sp_DeleteAdmin ?"),
    UPDATE("EXEC sp_UpdateAdmin ?,?,?,?,?,?,?,?"),
    UPDATE_Password("EXEC sp_UpdateAdminPassword ?,?");

    private final String proceso;

    Administrador(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
