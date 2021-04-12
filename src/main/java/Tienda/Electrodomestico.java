/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

/**
 * Clase que hereda de Articulo que nos sirve para definir de Articulos de tipo
 * Electrodomestico.
 *
 * @author MarioAguirre
 * @version 1.0
 */
public class Electrodomestico extends Articulo {

    private String gama;
    private ClaseE clasificacionEnergetica;

    /**
     *
     */
    public Electrodomestico() {

    }

    /**
     *
     * @param gama
     * @param clasificacionEnergetica
     * @param codigo
     * @param nombre
     * @param precio
     * @param stock
     */
    public Electrodomestico(String gama, ClaseE clasificacionEnergetica, String codigo, String nombre, float precio, int stock) {
        super(codigo, nombre, precio, stock);
        this.gama = gama;
        this.clasificacionEnergetica = clasificacionEnergetica;
    }

    /**
     * @return the gama
     */
    public String getGama() {
        return gama;
    }

    /**
     * @param gama the gama to set
     */
    public void setGama(String gama) {
        this.gama = gama;
    }

    /**
     * @return the clasificacionEnergetica
     */
    public ClaseE getClasificacionEnergetica() {
        return clasificacionEnergetica;
    }

    /**
     * @param clasificacionEnergetica the clasificacionEnergetica to set
     */
    public void setClasificacionEnergetica(ClaseE clasificacionEnergetica) {
        this.clasificacionEnergetica = clasificacionEnergetica;
    }

    /**
     * 
     * @return toString
     * Dice la gama del articulo, la clase electrodomestica.
     */
    @Override
    public String toString() {
        return super.toString() + "Gama: " + getGama() + "\nClase Electrodomestica: " + getClasificacionEnergetica() + "\n";
    }

    @Override
    public void applyPromo(String codigopromo) {
        //Si el codigo es: "SINIVA" aplicamos un 21% de descuento.
        //Si el codigo es: "ELECPROMO" aplicamos un 10% de descuento.
        if(codigopromo.equals("SINIVA")){
            this.setPrecio(((float)this.getPrecio()*0.79));
        }
        if(codigopromo.equals("ELECPROMO")){
            this.setPrecio(((float)this.getPrecio()*0.9));
        }
    }
    
    @Override
    public String toStringFile(){
        return gama + ", " + clasificacionEnergetica 
                + ", " + super.getCodigo() 
                + ", " + super.getNombre() 
                + ", " + super.getPrecio() 
                + ", " + super.getStock();
    }
}
