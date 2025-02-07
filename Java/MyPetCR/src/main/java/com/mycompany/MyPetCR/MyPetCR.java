/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.MyPetCR;

import Ventanas.*;
import javax.swing.UIManager;

public class MyPetCR {
    public static void main(String args[]) {
        //cambiar formato del sistema
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
          e.printStackTrace();
        } 
        
        //VENTANAS
        new Ven_Inicio();
    }
    
} //FINAL DE LA CLASE

