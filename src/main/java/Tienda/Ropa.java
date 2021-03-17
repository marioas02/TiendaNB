/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

/**
 * Clase que hereda Articulo que nos sirve para definir articulos de tipo ropa de los que nos interesa tambien el color y la talla.
 * @author MarioAguirre
 */
public final class Ropa extends Articulo {

    private String color;
    private TallaSML  talla;

    /**
     * Contructor vacío.
     */
    public Ropa() {

    }

    /**
     * Contructo con parametros.
     * @param color
     * @param talla
     * @param codigo
     * @param nombre
     * @param precio
     * @param stock
     */
    public Ropa(String color, TallaSML talla, String codigo, String nombre, float precio, int stock) {
        super(codigo, nombre, precio, stock);
        this.color = color;
        this.talla = talla;
    }

    /**
     *
     * @return toString Color y talla.
     */
    @Override
    public String toString() {
        return super.toString() + "Color: " + getColor() + "\nTalla: " + getTalla() + "\n";
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the talla
     */
    public TallaSML getTalla() {
        return talla;
    }

    /**
     * @param talla the talla to set
     */
    public void setTalla(TallaSML talla) {
        this.talla = talla;
    }
    
    @Override
    public void applyPromo (String codigopromo){
        //Si el codigo es ROPAPROMO se aplica 20%
        if(codigopromo.equals("ROPAPROMO")){
            this.setPrecio(((float)this.getPrecio()*0.8));
        }
    }
    
}