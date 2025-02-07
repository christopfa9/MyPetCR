/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author chris
 */
public enum Mascotas {
    
    SELECT_ALL_CLIENT_PETS("EXEC sp_GetClientsPets ?"),
    SELECT_ALL_PETS_WITH_CLIENT("EXEC sp_GetAllPetsWithClient"),
    SELECT_MascotaPorNombreDuennoYNombreMascota("EXEC sp_GetMascotaPorNombreDuennoYNombreMascota ?, ?"),
    SELECT_ONE("EXEC sp_GetPet ?"),
    INSERT("EXEC sp_CreatePet ?,?,?,?"),
    DELETE("EXEC sp_DeletePet ?"),
    UPDATE("EXEC sp_UpdatePet ?,?,?,?");

    private final String proceso;

    Mascotas(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
