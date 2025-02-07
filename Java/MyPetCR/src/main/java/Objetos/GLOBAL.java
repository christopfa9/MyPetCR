
package Objetos;

import Enums.Categoria;
import java.util.ArrayList;

/**
 *
 * @author sasmora
 */
public class GLOBAL {
    public static Usuario user;
    public static final String medicamentos = "Medicamentos";
    public static final String rutaImagenes = System.getProperty("user.dir") + "\\images\\";
    private static ArrayList<Productos> productos = new ArrayList<>();
    private static ArrayList<Productos> carrito = new ArrayList<>();
    public static int ancho = 232;
    public static int largo = 188;
    private static ArrayList<String> categorias = new ArrayList<>();

    public static ArrayList<String>  getCategorias() {
        return categorias;
    }

    public static void setCategorias(ArrayList<String> categorias) {
        GLOBAL.categorias = categorias;
    }
    

    public static ArrayList<Productos> getProductos() {
        return productos;
    }

    public static void setProductos(ArrayList<Productos> productos) {
        GLOBAL.productos = productos;
    }

    
    public static void clearProductos() {
        GLOBAL.productos.clear();
    }

    public static ArrayList<Productos> getCarrito() {
        return carrito;
    }

    public static void addToCarrito(Productos producto) {
        GLOBAL.carrito.add(producto);
    }
    
    public static void addProducto(Productos producto) {
        GLOBAL.productos.add(producto);
    }
   
    public static void addCategoria(String categoria){
        GLOBAL.categorias.add(categoria);
    }
    
}
