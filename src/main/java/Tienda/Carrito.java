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
public class Carrito {

    /**
     * Atributos.
     */
    ArrayList<ArticuloCarrito> pedido;
    float total;
    boolean estado;

    public static boolean CONFIRMADO = true;
    public static boolean PENDIENTE = false;

    /**
     * Constructor.
     */
    public Carrito() {
        pedido = new ArrayList<ArticuloCarrito>();
        total = 0;
        estado = PENDIENTE;
    }

    /**
     * 
     * @return el total de lo que cuesta mi carrito.
     */
    private float calculaTotal() {
        float acumulado = 0;
        for (ArticuloCarrito ac : this.pedido) {
            acumulado += ac.elemento.getPrecio() * ac.cantidad;
        }
        return acumulado;
    }

    /**
     *
     * @param articulo
     * @param cantidad
     */
    public void addArticulo(Articulo articulo, int cantidad) {
        boolean found = false;
        for (ArticuloCarrito ac : pedido) {
            if (ac.elemento.equals(articulo)) {
                ac.cantidad += cantidad;
                found = true;
            }
        }
        if (!found) {
            ArticuloCarrito nuevo = new ArticuloCarrito(articulo, cantidad);
            pedido.add(nuevo);
        }
        this.total = calculaTotal();
    }

    /**
     *
     * @return toString para motrar si el Carrito esta confirmado o pendiente.
     */
    public String mostrarCarrito() {
        StringBuilder sb = new StringBuilder();
        sb.append("**********CARRITO**********\n");
        for (ArticuloCarrito ac : pedido) {
            sb.append(ac);
        }
        sb.append("\nTotal: ").append(this.total);
        if (estado) {
            sb.append("\nEstado confirmado\n");
        } else {
            sb.append("\nEstado pendiente\n");
        }
        sb.append("**********CARRITO**********");
        return sb.toString();
    }

    /**
     *
     * @return estado
     * para cambiar de pendiente a confirmado.
     */
    public boolean cambiarEstado() {
        if (estado) {
            return estado = false;
        } else {
            return estado = true;
        }
    }
}
