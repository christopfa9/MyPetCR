/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author chris
 */
public enum Citas {
    SELECT_ALL_FUTURE_APPOINTMENTS("EXEC sp_GetAllFutureAppointments"),
    SELECT_ALL_FUTURE_CLIENT_APPOINTMENTS("EXEC sp_GetAllFutureClientsAppointments ?"),
    SELECT_ALL_FUTURE_PETS_APPOINTMENTS("EXEC sp_GetAllFuturePetsAppointments ?"),
    SELECT_ALL_FUTURE_VET_APPOINTMENTS("EXEC sp_GetAllFutureVetsAppointments ?"),
    ExtraerVetsDisponibles("EXEC sp_ExtraerVetsDisponibles ?, ?"),
    SELECT_ONE("EXEC sp_GetAppointment ?"),
    INSERT("EXEC sp_CreateAppointment ?,?,?,?,?"),
    DELETE("EXEC sp_CancelAppointment ?"),
    UPDATE("EXEC sp_UpdateAppointment ?,?,?,?,?");

    private final String proceso;

    Citas(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
