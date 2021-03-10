/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author MarioAguirre
 */
public class UsuarioTest {

    public UsuarioTest() {
    }

    /**
     * Test of comprobacionNombre method, of class Usuario.
     */
    @Test
    @DisplayName("Test de Comprobacion del Nombre I")
    public void testComprobacionNombre() {
        String nombre = "hhhhhh";
//        Usuario yo = new Usuario("hhhhhh","Marioaguirresanz","mario@eepmad.com");
        boolean expResult = true;
        boolean result = Usuario.comprobacionNombre(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobacionNombre method, of class Usuario.
     */
    @Test
    @DisplayName("Test de Comprobacion de la Contraseña I")
    public void testComprobacionPassword() {
        String pss = "Marioaguirresanz";
//        Usuario yo = new Usuario("MarioAguirre","Marioaguirresanz","mario@eepmad.com");
        boolean expResult = true;
        boolean result = Usuario.comprobacionPassword(pss);
        assertEquals(expResult, result);
    }

    /**
     * Test of comprobacionNombre method, of class Usuario.
     */
    @Test
    @DisplayName("Test de Comprobacion del Mail I")
    public void testComprobacionMail() {
        String contr = "mario@eepmad.com";
//        Usuario yo = new Usuario("hhhhhh","Contrseña","mario@eepmad.com");
        boolean expResult = true;
        boolean result = Usuario.comprobacionMail(contr);
        assertEquals(expResult, result);
    }

}