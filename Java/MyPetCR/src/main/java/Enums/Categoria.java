/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

/**
 *
 * @author sasmora
 */
public enum Categoria {
    SELECT_ALL("EXEC sp_GetCategorias"),
    SELECT_ONE("EXEC SELECT_AUTOR ?");
    
    private final String proceso;

    Categoria(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
    
}
