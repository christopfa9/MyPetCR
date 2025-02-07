/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;



import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;



/**
 *
 * @author sap1
 */
public class FileManager {

    public static String readFile (String path) throws FileNotFoundException, IOException
    {
        String everything;
        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        everything = sb.toString();
        }   

        return everything;
    }
    
    
        // read txt file, para ller el query
    public static void writeFile (String path, String value) throws IOException 
    {
        try(BufferedWriter bw = new BufferedWriter (new FileWriter(path, true))) 
        {
            bw.write(value);
            bw.close();
        } 
    }
    
    // escribe un objeto
    public static void writeObject (Object obj, String filePath)
    {
        try{
            //use buffering
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try{
                // escribe el objeto
              output.writeObject(obj);
            }
            finally{
              output.close();
            }
          }  
          catch(IOException ex){
              
          }
        
    }
    
      // escribe un objeto
    public static Object readObject(String filePath)
    {
        try{
            //use buffering
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);
            try{
              //deserialize the List
              return input.readObject();
            }
            finally{
              input.close();
            }
          }
          catch(ClassNotFoundException ex){
           
          }
          catch(IOException ex){
            
          }
        return null;
    }  
    
    public static ArrayList<String> obtenerNombresArchivosEnCarpeta(String carpeta) {
        ArrayList<String> nombresArchivos = new ArrayList<>();

        File carpetaDirectorio = new File(carpeta);

        // Verificar si la carpeta existe y es un directorio
        if (carpetaDirectorio.exists() && carpetaDirectorio.isDirectory()) {
            File[] archivosEnCarpeta = carpetaDirectorio.listFiles();

            if (archivosEnCarpeta != null) {
                for (File archivo : archivosEnCarpeta) {
                    if (archivo.isFile()) {
                        // Agregar el nombre del archivo a la lista
                        nombresArchivos.add(archivo.getName());
                    }
                }
            }
        } else {
            System.err.println("La carpeta especificada no existe o no es un directorio válido.");
        }

        return nombresArchivos;
    }
    
    
    public static File CambiarDimensionImagen(File imagen, int ancho, int alto, String rutaCarpeta, String nombreNuevo) {
        try {
            // Carga la imagen de entrada
            BufferedImage imagenEntrada = ImageIO.read(imagen);

            // Crea una imagen vacía con las nuevas dimensiones
            BufferedImage imagenSalida = new BufferedImage(ancho, alto, imagenEntrada.getType());

            // Escala la imagen de entrada a las nuevas dimensiones
            Graphics2D g = imagenSalida.createGraphics();
            g.drawImage(imagenEntrada, 0, 0, ancho, alto, null);
            g.dispose();

            // Obtén el nombre del archivo sin la extensión
            String nombreArchivoSinExtension = imagen.getName().replaceFirst("[.][^.]+$", "");

            // Especifica la ruta completa para guardar el archivo en la ubicación deseada
            String rutaCompleta =  rutaCarpeta + nombreNuevo + ".png";

            File archivoSalida = new File(rutaCompleta);

            // Guarda la nueva imagen en el archivo de salida
            ImageIO.write(imagenSalida, "png", archivoSalida);

            // Imprime un mensaje con la ruta donde se guardó la imagen
            String message = "Imagen redimensionada y guardada en " + rutaCompleta;
            System.out.println(message);

            return archivoSalida;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("no se logro papu");
        }
        return null;
    }
}// fin clase
