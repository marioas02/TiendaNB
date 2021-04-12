/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

/**
 * Clase que hereda Articulo que nos sirve para definir articulos de tipo ropa
 * de los que nos interesa tambien el color y la talla.
 *
 * @author MarioAguirre
 */
public final class Ropa extends Articulo implements Reciclable {

    private String color;
    private TallaSML talla;
    private int reciclada;

    /**
     * Contructor vacío.
     */
    public Ropa() {

    }

    /**
     * Contructo con parametros.
     *
     * @param color
     * @param talla
     * @param contador
     * @param codigo
     * @param nombre
     * @param precio
     * @param stock
     */
    public Ropa(String color, TallaSML talla, int reciclada, String codigo, String nombre, float precio, int stock) {
        super(codigo, nombre, precio, stock);
        this.color = color;
        this.talla = talla;
        this.reciclada = reciclada;
    }

    /**
     *
     * @return toString Color y talla.
     */
    @Override
    public String toString() {
        return super.toString() + "Color: " + getColor() + "\nTalla: " + getTalla() + "\n";
    }
    
    
    @Override
    public String toStringFile(){
        return color + ", " + talla + ", " + reciclada + ", " + super.getCodigo() 
                + ", " + super.getNombre() 
                + ", " + super.getPrecio() 
                + ", " + super.getStock();
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
    public void applyPromo(String codigopromo) {
        //Si el codigo es ROPAPROMO se aplica 20%
        if (codigopromo.equals("ROPAPROMO")) {
            this.setPrecio(((float) this.getPrecio() * 0.8));
        }
    }

    @Override
    public boolean esReciclable() {
        /**
         * Solo es reciclable 2 veces
         */
        boolean reciclo;
        if (this.reciclada < 2){
            reciclo = true;
            this.reciclada++;
        }else{
            reciclo = false;
        }
        return reciclo;
    }

    @Override
    public void applyDiscouent() {
        
        /**
         * La ropa reciclada tiene un 50% de descuento por vez que se recicla.
         */
        
        /*float precio;
        if(this.reciclada == 0 || this.reciclada == 1){
            precio = (float) (this.getPrecio() * 0.5);
            this.reciclada++;
        }else{
            precio = this.getPrecio();
        }
        setPrecio(precio);*/

        this.setPrecio(((float) this.getPrecio() * 0.5));
        
        
    }
}
