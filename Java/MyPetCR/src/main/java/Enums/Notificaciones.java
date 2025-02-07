/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author chris
 */
public enum Notificaciones {
    SELECT_ALL_NOTIFI_DE_CLIENTE("EXEC sp_GetAllNotificationsCliente ?"),
    SELECT_ALL_NOTIFI_DE_VETE("EXEC sp_GetAllNotificationsVete ?"),
    SELECT_ALL_NOTIFI("EXEC sp_GetAllNotifications"),
    NOFITI_LEIDA("EXEC sp_MarkAsRead ?"),
    INSERT("EXEC sp_CreateNotification ?,?,?,?");

    private final String proceso;

    Notificaciones(String nombre) {
        this.proceso = nombre;
    }

    public String getProceso() {
        return proceso;
    }
}
