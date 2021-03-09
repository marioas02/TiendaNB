/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda;

/**
 *
 * @author MarioAguirre
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author MarioAguirre
 *
 */
public class Tienda {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub HOLA
        Scanner ScannerMenu = new Scanner(System.in);
        Scanner ScannerInt = new Scanner(System.in);
        Scanner ScannerString = new Scanner(System.in);

        int menuopcion = 0;

        ArrayList<Articulo> catalogo = new ArrayList<Articulo>();
        inicializarCatalogo(catalogo);
        Carrito cesta = new Carrito();

        do {
            menuopcion = menu(ScannerMenu);

            switch (menuopcion) {

                case 0:
                    System.out.println("Has escogido la opción 0");
                    System.out.println("Muchas Gracias por su compra.");
                    break;

                case 1:
                    addArticuloCatalogo(catalogo, ScannerString, ScannerInt);
                    mostrarCatalogo(catalogo);
                    break;

                case 2:
                    comprar(catalogo, cesta, ScannerString, ScannerInt);
                    break;

                case 3:
                    confirmarCarrito(catalogo, cesta, ScannerString, ScannerInt);
                    break;

                default:
                    System.out.println("Opcion icorrecta, lea atentamente.");
                    break;

            }
        } while (menuopcion != 0);

        ScannerInt.close();
        ScannerString.close();
    }

    private static int menu(Scanner ScannerInt) {
        int opcion = 0;
        System.out.println("");
        System.out.println(
                "Pulsa:\n\t1: Alta Artículo."
                + "\n\t2: Comprar Artículo."
                + "\n\t3: Confirmar Carrtio."
                + "\n\t0: Salir.");
        System.out.printf("Escribe un número del menú: ");
        opcion = ScannerInt.nextInt();
        System.out.println("");
        return opcion;
    }

    private static void inicializarCatalogo(ArrayList<Articulo> c) {
        c.add(new Articulo("0001", "Monitor", 200.00F, 10));
        c.add(new Articulo("0002", "Teclado", 10.00F, 100));
        c.add(new Articulo("0003", "RJ45 2m", 4.50F, 50));
        c.add(new Articulo("0004", "Ratón", 20.00F, 15));
        c.add(new Ropa("Rojo", 10, "0005", "Jersey", 25.50F, 100));
        c.add(new Electrodomestico("Hogar", ClaseE.A, "0006", "Lavadora", 526.89F, 10));
        c.add(new Microondas("MIELE", "ML-012", 140,"Hogar", ClaseE.B, "0007", "Microondas", 89.01F, 15));
    }

    private static void addArticuloCatalogo(ArrayList<Articulo> c, Scanner ScannerString, Scanner ScannerInt) {
        System.out.println("Introduce el código del nuevo Artículo: ");
        String codigo = ScannerString.nextLine();
        System.out.println("Introduce el nombre del nuevo Artículo: ");
        String nombre = ScannerString.nextLine();
        System.out.println("Introduce el precio del nuevo Artículo: ");
        float precio = ScannerInt.nextFloat();
        System.out.println("Introduce el stock del nuevo Artículo: ");
        int stock = ScannerInt.nextInt();

        c.add(new Articulo(codigo, nombre, precio, stock));
    }

    private static void mostrarCatalogo(ArrayList<Articulo> c) {
        for (Articulo a : c) {
            System.out.println(a);
        }
    }

    private static Articulo buscarArticuloPorCodigo(ArrayList<Articulo> c, String codigo) {
        int talla = c.size();
        int i = 0;
        Articulo a = null;
        boolean found = false;

        while (i < talla && !(found)) {
            if (c.get(i).getCodigo().equals(codigo)) {
                a = c.get(i);
                found = true;
            } else {
                i++;
            }
        }
        return a;
    }

    private static void comprar(ArrayList<Articulo> c, Carrito carro, Scanner ScannerString, Scanner ScannerInt) {
        /*
		 * Mostrar el catalogo
		 * Pedimos articulo por código, lo buscamos
		 * 		Si existe Pedimos cantidad
		 * 			Si hay disponibilidad
		 * 				Añadimos al carricoche
		 * Repetir mientras
         */
        int salircomprar = -1;
        do {
            mostrarCatalogo(c);

            System.out.println("Introduzca el código del producto que quiere comprar: ");
            String codigo = ScannerString.nextLine();

            Articulo a = buscarArticuloPorCodigo(c, codigo);
            if (a != null) {
                System.out.println("Introduzca la cantidad que quiera: ");
                int cantidad = ScannerInt.nextInt();
                if (a.disponible(cantidad)) {
                    carro.addArticulo(a, cantidad);
                } else {
                    System.out.println("Articulo no disponible, elije otro o revisa la cantidad.");
                }
            } else {
                System.out.println("Articulo no disponible, elije otro o revisa la cantidad.");
            }
            System.out.println(carro.mostrarCarrito());
            System.out.println("Pulsa 0: Si desea salir o confirmar.\nPulsa 1: Si desea seguir comprando.");
            salircomprar = ScannerInt.nextInt();
        } while (salircomprar != 0);
    }

    private static int buscarPosicionArticuloPorCodigo(ArrayList<Articulo> c, String codigo) {
        int talla = c.size();
        int i = 0;
        boolean found = false;

        while (i < talla && !(found)) {
            if (c.get(i).getCodigo().equals(codigo)) {
                found = true;
            } else {
                i++;
            }
        }
        if (found) {
            return i;
        } else {
            return -1;
        }

    }

    private static void modificarStockCatalogo(ArrayList<Articulo> c, Carrito carro) {
        int pos;
        for (ArticuloCarrito ac : carro.pedido) {
            pos = buscarPosicionArticuloPorCodigo(c, ac.elemento.getCodigo());
            if (pos > -1) {
                c.get(pos).ajustarStock(-1 * ac.cantidad);
            }
        }
    }

    private static void confirmarCarrito(ArrayList<Articulo> c, Carrito carro, Scanner ScannerString, Scanner ScannerInt) {
        /*
		 * Mostramos carrito articulo + cantidades + el total
		 * Preguntamos confirmacion
		 * 		Si se confirma
		 * 			Modificar en el catalogo el stock de los articulos del carrito, restando
		 * 			las cantidades al stock
		 * 			Cambiar el estado del Carrito
		 * Mostramos un mensaje.
         */
        int opcion;

        System.out.println(carro.mostrarCarrito());
        System.out.println("Pulsa 1: Si desea confirmar el Carrito."
                + "\nPulsa 2: No desea confirmar el Carrito.");
        opcion = ScannerInt.nextInt();
        if (opcion == 1) {
            carro.cambiarEstado();
            modificarStockCatalogo(c, carro);
        }
        System.out.println(carro.mostrarCarrito());

    }

}
