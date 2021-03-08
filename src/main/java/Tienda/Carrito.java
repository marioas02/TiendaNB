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

    ArrayList<ArticuloCarrito> pedido;
    float total;
    boolean estado;

    public static boolean CONFIRMADO = true;
    public static boolean PENDIENTE = false;

    public Carrito() {
        pedido = new ArrayList<ArticuloCarrito>();
        total = 0;
        estado = PENDIENTE;
    }

    private float calculaTotal() {
        float acumulado = 0;
        for (ArticuloCarrito ac : this.pedido) {
            acumulado += ac.elemento.getPrecio() * ac.cantidad;
        }
        return acumulado;
    }

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

    public boolean cambiarEstado() {
        if (estado) {
            return estado = false;
        } else {
            return estado = true;
        }
    }
}
