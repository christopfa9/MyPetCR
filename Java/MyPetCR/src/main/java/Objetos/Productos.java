/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.File;

/**
 *
 * @author chris
 */
public class Productos {
    
    private int idProductos = 0;
    private String Nombre = "";
    private int Categoria = 0;
    private int cantidadTotal = 0;
    private float Precio = 0;
    private File imagen = null;
    
    public Productos(){
        
    }
    
    public Productos(String Nombre,int Categoria, int cantidadTotal, float Precio){
        this.Nombre = Nombre;
        this.Categoria = Categoria;
        this.cantidadTotal = cantidadTotal;
        this.Precio = Precio;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int Categoria) {
        this.Categoria = Categoria;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    
    
    
    
    
} // FINAL DE LA CLASE
