/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author chris
 */
public enum ProductosEnum {
    
    SELECT_ALL("EXEC sp_GetAllProduct"),
    SELECT_ONE("EXEC sp_GetProduct ?"),
    INSERT("EXEC sp_CreateProduct ?,?,?,?"),
    DELETE("EXEC sp_DeleteProduct ?"),
    UPDATE("EXEC sp_UpdateProduct ?,?,?,?,?"),
    DESCONTAR("EXEC sp_DescontarStock ?,?,?");
    
    private final String proceso;
    
    ProductosEnum(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
