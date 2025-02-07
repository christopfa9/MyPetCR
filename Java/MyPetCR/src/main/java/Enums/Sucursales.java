/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;


public enum Sucursales {
    
    SELECT_ALL("EXEC sp_GetAllStores"),
    SELECT_ONE("EXEC sp_GetStore ?"),
    INSERT("EXEC sp_CreateStore ?,?"),
    DELETE("EXEC sp_DeleteStore ?"),
    UPDATE("EXEC sp_UpdateStore ?,?,?");

    private final String proceso;

    Sucursales(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
