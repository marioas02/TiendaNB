/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

import java.util.ArrayList;

/**
 *
 * @author MarioAguirre
 */
public abstract class Articulo {

    /**
     * Atributos de nuestra clase privada.
     */
    private String codigo;
    private String nombre;
    private float precio;
    private int stock;
    private ArrayList<Opinion> opinion;

    /**
     * Constructor vacio
     */
    public Articulo() {
        opinion = new ArrayList<Opinion>();
    }

    /**
     * Constructor con parametros.
     *
     * @param codigo
     * @param nombre
     * @param precio
     * @param stock
     */
    public Articulo(String codigo, String nombre, float precio, int stock) {
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
        opinion = new ArrayList<Opinion>();
    }
    
    /**
     * Método abstracto a implementar por clases.
     * @param codigopromo 
     */
    public abstract void applyPromo (String codigopromo);
    
    /**
     * 
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * 
     * @return precio
     */
    public float getPrecio() {
        return precio;
    }
    
    /**
     * 
     * @return stock
     */
    public int getStock() {
        return stock;
    }
    
    /**
     * 
     * @param codigo 
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * 
     * @param precio 
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    /**
     * 
     * @param stock 
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * 
     * @return Un String el cual te dice el Código del producto, el nombre, el precio
     * el Stock y la media de las valorciones.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo: ").append(this.codigo).append("\nNombre: ").append(this.nombre).append("\nPrecio: ")
                .append(this.precio).append("€\nStock: ").append(this.stock).append("\nMedia: ").append(this.mediaOpiniones()).append("\n");
        return sb.toString();
    }
    
    /**
     * 
     * @param cantidad
     * @return la cantidad si es que hay en stock
     */
    public boolean disponible(int cantidad) {
        return cantidad <= stock;
    }
    
    /**
     * 
     * @param cantidad 
     */
    public void ajustarStock(int cantidad) {
        this.stock += cantidad;
    }
    
    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        } else {
            Articulo a = (Articulo) o;
            if (this.codigo.equals(a.getCodigo())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    /**
     * 
     * @param op 
     * Añade una Opinion en el ArrayList de Opiniones.
     */
    public void addOpinion(Opinion op) {
        opinion.add(op);
    }
    
    /**
     * 
     * @return String
     */
    public String showOpinion(){
        StringBuilder sb = new StringBuilder("");
        for(Opinion o: opinion){
            sb.append("\n").append(o);
        }
        /*for (int i = 0; i < opinion.size(); i++) {
            opiniones.append(opinion.get(i).toString());
            opiniones.append("\n");
        }*/
        return sb.toString();
    }
    
    /**
     * 
     * @return media de las valoraciones de Opiniones.
     */
    private float mediaOpiniones(){
        int contador = 0;
        float media = 0;
        for (Opinion o: opinion) {
            if(o.getPuntuacion()==ClassPuntuacion.Mal){
                media = media + 1;
                contador++;
            }
            if(o.getPuntuacion()==ClassPuntuacion.Regular){
                media = media + 2;
                contador++;
            }
            if(o.getPuntuacion()==ClassPuntuacion.Bien){
                media = media + 3;
                contador++;
            }
            if(o.getPuntuacion()==ClassPuntuacion.Perfecto){
                media = media + 4;
                contador++;
            }
        }
        if(opinion.size()>0){
            return media/contador;
        }
        return 0;
    }
}
 