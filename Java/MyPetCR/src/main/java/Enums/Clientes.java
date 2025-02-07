/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author chris
 */
public enum Clientes {

    SELECT_ALL("EXEC sp_GetAllClient"),
    SELECT_ONE_POR_ID("EXEC sp_GetClient ?"),
    SELECT_ONE_POR_CEDULA("EXEC sp_GetClientByID ?"),
    INSERT("EXEC sp_CreateClient ?,?,?,?,?,?,?"),
    DELETE("EXEC sp_DeleteClient ?"),
    UPDATE("EXEC sp_UpdateClient ?,?,?,?,?,?,?"),
    UPDATE_Password("EXEC sp_UpdateClientPassword ?,?");

    private final String proceso;

    Clientes(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
