/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

public class Mascota {
    
    private int idMascota = 0;
    private int idUsuario = 0;
    private String Nombre = "";
    private int Edad = 0;
    private boolean sexo = true;
    private boolean activo = false;
    
    public Mascota(){
        
    }
    
    public Mascota(int idMascota, int idUsuario,String Nombre,int Edad, boolean sexo, boolean activo){
        this.idMascota = idMascota;
        this.idUsuario = idUsuario;
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.sexo = sexo;
        this.activo = activo;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
    
} // FINAL DE LA CLASE
