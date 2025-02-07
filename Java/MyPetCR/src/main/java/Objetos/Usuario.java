/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import Enums.TipoUsuario;
import java.util.ArrayList;

public class Usuario {
    private int idUsuario = 7; 
    private int cedula = 0;
    private int telefono = 0;
    private String correo = "";
    private String contra = "";
    private String nombre = "";
    private String apellidos = "";
    private String direcccion = "";
    private TipoUsuario tipo = TipoUsuario.INVITADO;
    private ArrayList mascotas = new ArrayList();

    public Usuario() {
    }
    

    public Usuario(int IdUsuario,int cedula, int telefono, String correo, String contra, String nombre, String apellidos, String direccion, TipoUsuario tipo) {
           
        this.idUsuario = IdUsuario;
        this.cedula = cedula;
        this.correo = correo;
        this.contra = contra;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direcccion = direccion;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", telefono=" + telefono + ", correo=" + correo + ", contra=" + contra + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direcccion=" + direcccion + ", tipo=" + tipo + ", mascotas=" + mascotas + '}';
    }

    // Getters y Setters
    
    public int getID() {
        return idUsuario;
    }

    public void setID(int cedula) {
        this.idUsuario = cedula;
    }
    
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direcccion;
    }

    public void setDireccion(String direccion) {
        this.direcccion = direccion;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public String getDirecccion() {
        return direcccion;
    }

    public void setDirecccion(String direcccion) {
        this.direcccion = direcccion;
    }

    public ArrayList getMascotas() {
        return mascotas;
    }
} //FINAL CLASE
