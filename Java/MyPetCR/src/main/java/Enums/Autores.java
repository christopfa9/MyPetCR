/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

public enum Autores {
    SELECT_ALL("EXEC SELECT_AUTORES"),
    SELECT_ONE("EXEC SELECT_AUTOR ?"),
    INSERT("EXEC INSERT_AUTOR ?, ?, ?, ?, ?, ?, ?, ?"),
    DELETE("EXEC DELETE_AUTOR ?"),
    UPDATE("EXEC UPDATE_AUTOR ?, ?, ?, ?, ?, ?, ?, ?");

    private final String proceso;

    Autores(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
