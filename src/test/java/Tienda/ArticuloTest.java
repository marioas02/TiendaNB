/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MarioAguirre
 */
public class ArticuloTest {
    
    public ArticuloTest() {
    }

    /**
     * Test of toString method, of class Articulo.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Articulo instance = new Articulo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disponible method, of class Articulo.
     */
    @Test
    public void testDisponible() {
        System.out.println("disponible");
        int cantidad = 0;
        Articulo instance = new Articulo();
        boolean expResult = false;
        boolean result = instance.disponible(cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajustarStock method, of class Articulo.
     */
    @Test
    public void testAjustarStock() {
        System.out.println("ajustarStock");
        int cantidad = 0;
        Articulo instance = new Articulo();
        instance.ajustarStock(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Articulo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Articulo instance = new Articulo();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
