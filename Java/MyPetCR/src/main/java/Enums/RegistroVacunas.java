/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author chris
 */
public enum RegistroVacunas {
    
    SELECT_ALL("EXEC sp_GetAllRegistrosVacuna"),
    SELECT_ONE("EXEC  sp_GetRegistroVacuna ?"),
    INSERT("EXEC sp_CreateRegistroVacuna ?, ?"),
    DELETE("EXEC sp_DeleteRegistroVacuna ?"),
    UPDATE("EXEC sp_UpdateRegistroVacuna ?,?,?,?");
    
    private final String proceso;
    
    RegistroVacunas(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
