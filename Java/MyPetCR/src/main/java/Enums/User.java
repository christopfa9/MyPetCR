/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enums;

public enum User {
    ALEX("kyun\\SQLEXPRESS:1433", "kuro", "12345"),
    CRISTO("LaMalcriada\\SQLEXPRESS:1433", "Proyecto2", "password"),
    KEN("", "", ""),
    KRIS("", "", "");

    private final String server;
    private final String password;
    private final String nameUser;

    User(String server, String name, String contra) {
        this.server = server;
        this.password = contra;
        this.nameUser = name;
    }

    public String getServer() {
        return server;
    }

    public String getPassword() {
        return password;
    }

    public String getNameUser() {
        return nameUser;
    }

} //FINAL CLASE
