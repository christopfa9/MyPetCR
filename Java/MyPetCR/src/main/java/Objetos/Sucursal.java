/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author chris
 */
public class Sucursal {
    
    private int idSucursal;
    private String Nombre;
    private String Ubicacion;
    
    public Sucursal(){
        
    }
    
    public Sucursal(int idSucursal, String Nombre, String Ubicacion){
        this.idSucursal = idSucursal;
        this.Nombre = Nombre;
        this.Ubicacion = Ubicacion;
    }
}
