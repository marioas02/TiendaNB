package com.mycompany.tienda;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MarioAguirre
 */
public class ArticuloCarrito {

    Articulo elemento;
    int cantidad;

    /**
     * Constructor vacio
     */
    public ArticuloCarrito() {

    }

    /**
     * Constructor con parametros.
     *
     * @param a
     * @param cantidad
     */
    public ArticuloCarrito(Articulo articulo, int cantidad) {
        this.elemento = articulo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return this.elemento + "x" + this.cantidad + "\n";
    }
}
