/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auxiliares;

import java.awt.Graphics2D;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class Auxiliar {
    
    public static Date toDate(String fechaString){ 
        //El formato debe ser "año-mes-dia"
        return Date.valueOf(fechaString); 
    } //
    
    public static boolean validarFechas(Date fechaInicio, Date fechaFinal, Date fechaAnalizar) {
        if (fechaAnalizar.before(fechaInicio)) {
            return false;
        } else if (fechaAnalizar.after(fechaFinal)) {
            return false;
        }
        return true;
    } //

    public static void clearTextFields(ArrayList<TextField> arrayTxtFields){
        for (TextField textField : arrayTxtFields) {
            if(textField != null)
                textField.setText("");
        }
        
    }//
    
    public static void addTabla (ArrayList<ArrayList<String>> arrayDatos, JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        for (ArrayList<String> fila : arrayDatos) {
            modelo.addRow(fila.toArray());
        }
    }//
    
    //Solo permitir que se digiten numeros en un textField
    public static void validarNumeros(TextField txt, JTextField jTxt){
        if (txt!=null){
            txt.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        e.consume(); // Ignora la tecla presionada si no es un dígito, retroceso o suprimir
                    }
                }
            });
        }
        if (jTxt!=null) {
            jTxt.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                        e.consume(); // Ignora la tecla presionada si no es un dígito, retroceso o suprimir
                    }
                }
            });
        }
    }
    
   
    public static File importarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes", "png", "jpg", "jpeg");
        fileChooser.setFileFilter(filter);
        int archivo = fileChooser.showOpenDialog(null);
        if (archivo == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        } else {
            return null;
        }
    }
    
    public static int generarCodigoRecuperacion(){
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return code;
    }
    
    //VALIDAR UN CORREO ELECTRONICO
    private static final String EMAIL_PATTERN = 
       "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public static boolean esCorreoValido(String correo) {
        if (correo == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
    
    
    public static void actualizarImagen(File archivo, JLabel label){
        if (archivo != null) {
            try {
                ImageIcon icon = new ImageIcon(archivo.getAbsolutePath());
                label.setIcon(icon);
            } catch (Exception ex) {
                label.setText("Error al cargar el archivo.");
            }
        } else label.setIcon(null);
    }
    
    public static String fixedLengthString(String str, int length) {
        return String.format("%-" + length + "s", str);
    }
    
   public static boolean validarFecha(String dateStr, String format) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate parsedDate = LocalDate.parse(dateStr, dateFormatter);
            // Comparar con la fecha actual
            return parsedDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    public static ArrayList<ArrayList<String>> toArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<ArrayList<String>> tabla = new ArrayList();
        ResultSetMetaData rsmd;
        rsmd = resultSet.getMetaData();
        int Columnas = rsmd.getColumnCount();
        
        while (resultSet.next()) {
            ArrayList<String> fila = new ArrayList();
            for (int i = 0; i < Columnas; i++) {
                fila.add(resultSet.getString(i+1));
            }
            tabla.add(fila);
        }
        return tabla;
    }
    
  
} //FINAL DE LA CLASE
