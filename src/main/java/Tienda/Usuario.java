/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

/**
 *
 * @author MarioAguirre
 */
public class Usuario {

    private String nombre;
    private String password;
    private String mail;

    public Usuario() {

    }

    public Usuario(String nombre, String password, String mail) {
        this.nombre = nombre;
        this.password = password;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public static boolean comprobacionNombre(String nombre){
        return nombre.length()>=6;
    }
    public static boolean comprobacionPassword(String password){
        boolean comprueba;
        if(password.length()>=8){
            if(password.matches(".*[A-Z].*")){
                comprueba = true;
            }else{
                comprueba = false;
            }
        }else{
            comprueba = false;
        }
        return comprueba;
    }
    
    public static boolean comprobacionMail(String mail){
        boolean comprueba;
        comprueba = mail.matches("[-\\w\\.]+@\\w+\\.\\w+");
        return comprueba;
    }
}






