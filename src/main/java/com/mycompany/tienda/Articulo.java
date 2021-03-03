/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda;

/**
 *
 * @author MarioAguirre
 */
public class Articulo {

    /**
     * Atributos de nuestra clase privada.
     */
    private String codigo;
    private String nombre;
    private float precio;
    private int stock;

    /**
     * Constructor vacio
     */
    public Articulo() {

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
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo: ").append(this.codigo).append("\nNombre: ").append(this.nombre).append("\nPrecio: ")
                .append(this.precio).append("€\nStock: ").append(this.stock).append("\n");
        return sb.toString();
    }

    public boolean disponible(int cantidad) {
        return cantidad <= stock;
    }

    public void ajustarStock(int cantidad) {
        this.stock += cantidad;
    }

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
}
