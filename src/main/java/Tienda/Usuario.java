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
    
    private boolean comprobacionNombre(String nombre){
        if(nombre.length()>6){
            return true;
        }else{
            return false;
        }
    }
    private boolean comprobacionPassword(String password){
        if(password.length()>8){
            for(int i=0; i<password.length(); i++){
                if(Character.isUpperCase(password.charAt(i))){
                    return true;
                }
            }
        }else{
            return false;
        }
        return false;
    }
    private boolean comprobacionEmail(String mail){
        for(int i=0; i<mail.length(); i++){
            if(mail.length(i)!='@'){
                return false;
            } else {
                return true;
            }
        }
        return false;
        
    }
}







