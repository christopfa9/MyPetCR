/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author chris
 */
public enum Veterinarios {
    SELECT_ALL("EXEC sp_GetAllVet"),
    SELECT_ONE_POR_ID("EXEC sp_GetVet ?"),
    SELECT_ONE_POR_CEDULA("EXEC sp_GetVetByID ?"),
    INSERT("EXEC sp_CreateVet ?,?,?,?,?,?"),
    DELETE("EXEC sp_DeleteVet ?"),
    UPDATE("EXEC sp_UpdateVet ?,?,?,?,?,?"),
    UPDATE_Password("EXEC sp_UpdateVetPassword ?,?");

    private final String proceso;

    Veterinarios(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
