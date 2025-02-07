/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author chris
 */
public class Notificacion {
    
    private int idNotifi;
    private int idTipoNotifi;
    private String descripcion;
    private boolean leido;
    private int idUsuario;
    private int idCliente;
    private int idVet;
    
    // Constructor sin parámetros
    public Notificacion() {
    }

    // Constructor con parámetros
    public Notificacion(int idNotifi, int idTipoNotifi, String descripcion, boolean leido, int idUsuario, int idCliente, int idVet) {
        this.idNotifi = idNotifi;
        this.idTipoNotifi = idTipoNotifi;
        this.descripcion = descripcion;
        this.leido = leido;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.idVet = idVet;
    }

    // Getters and Setters
    public int getIdNotifi() {
        return idNotifi;
    }

    public void setIdNotifi(int idNotifi) {
        this.idNotifi = idNotifi;
    }

    public int getIdTipoNotifi() {
        return idTipoNotifi;
    }

    public void setIdTipoNotifi(int idTipoNotifi) {
        this.idTipoNotifi = idTipoNotifi;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVet() {
        return idVet;
    }

    public void setIdVet(int idVet) {
        this.idVet = idVet;
    }
}
