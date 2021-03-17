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

        
        Usuario user = new Usuario();
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
                case 4:
                    crearUsuario(user, ScannerString);
                    break;
                case 5:
                    darOpinion(user, catalogo, ScannerString, ScannerInt);
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
                + "\n\t4: Crear Usuario."
                + "\n\t5. Dar opinion de articulo"
                + "\n\t0: Salir.");
        System.out.printf("Escribe un número del menú: ");
        opcion = ScannerInt.nextInt();
        System.out.println("");
        return opcion;
    }

    private static void inicializarCatalogo(ArrayList<Articulo> c) {
//        c.add(new Articulo("0001", "Monitor", 200.00F, 10));
//        c.add(new Articulo("0002", "Teclado", 10.00F, 100));
//        c.add(new Articulo("0003", "RJ45 2m", 4.50F, 50));
//        c.add(new Articulo("0004", "Ratón", 20.00F, 15));
        c.add(new Ropa("Rojo", TallaSML.M, "0005", "Jersey", 25.50F, 100));
        c.add(new Electrodomestico("Hogar", ClaseE.A, "0006", "Lavadora", 526.89F, 10));
        c.add(new Microondas("MIELE", "ML-012", 140, "Hogar", ClaseE.B, "0007", "Microondas", 89.01F, 15));
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
        System.out.println("Introduce el color del nuevo  Artículo: ");
        String color = ScannerString.nextLine();
        System.out.println("Introduce la talla (S, M, L o XL) del nuevo  Artículo: ");
        char talla = ScannerString.next().charAt(0);
        TallaSML t = TallaSML.S;
        if(talla == 'S'){
            t = TallaSML.S;
        }
        if(talla == 'M'){
            t = TallaSML.M;
        }
        if(talla == 'L'){
            t = TallaSML.L;
        }
        if(talla == 'X'){
            t = TallaSML.XL;
        }
        
        c.add(new Ropa(color, t, codigo, nombre, precio, stock));
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
    /**
     * Metodo que compra un Articulo y lo añade al Carrito.
     * @param c
     * @param carro
     * @param ScannerString
     * @param ScannerInt 
     */
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

    private static void crearUsuario(Usuario us, Scanner sn) {
        String nombre, email, pass;
        do {
            System.out.println("Dame un nombre de usuario: ");
            nombre = sn.nextLine();
        } while (Usuario.comprobacionNombre(nombre) == false);
        us.setNombre(nombre);

        do {
            System.out.println("Dame un email: ");
            email = sn.nextLine();
        } while (Usuario.comprobacionPassword(email) == false);
        us.setMail(email);

        do {
            System.out.println("Dame un password: ");
            pass = sn.nextLine();
        } while (Usuario.comprobacionMail(pass) == false);
        us.setPassword(pass);

        System.out.println(us);

    }

    private static void darOpinion(Usuario us, ArrayList<Articulo> c, Scanner ScannerString, Scanner ScannerInt) {
        /*Mostrar catalogo de articulos
        * Pedir articulo de opinion
        * Buscar articulo por codigo
        * En caso de encontrarlo, pedir datos de la opinion y 
        * añadirla al listado del articulo
        * Mostrar articulo y sus opiniones.
        * En caso de no encontrarlo mostrar mensaje.
         */
        int salircomprar = -1;
        mostrarCatalogo(c);

        System.out.println("Introduzca el código del producto que quiere comprar: ");
        String codigo = ScannerString.nextLine();

        Articulo a = buscarArticuloPorCodigo(c, codigo);
        if (a != null) {
            crearOpinion(us, a, ScannerString, ScannerInt);
            System.out.println(a);
            System.out.println(a.showOpinion());

        } else {
            System.out.println("Articulo no existe, elije otro.");
        }
    }

    private static void crearOpinion(Usuario us, Articulo a, Scanner ScannerString, Scanner ScannerInt) {
        System.out.println("Valora del 1 al 5 siendo: /n/t1: MAL /n/t2: REGULAR /n/t3: BIEN /n/t4: PERFECTO: ");
        int puntos_aux = ScannerInt.nextInt();
        ClassPuntuacion puntos = ClassPuntuacion.Perfecto;
        if (puntos_aux == 1) {
            puntos = ClassPuntuacion.Mal;
        }
        if (puntos_aux == 2) {
            puntos = ClassPuntuacion.Regular;
        }
        if (puntos_aux == 3) {
            puntos = ClassPuntuacion.Bien;
        }
        if (puntos_aux == 4) {
            puntos = ClassPuntuacion.Perfecto;
        }

        System.out.println("Escribe un comentario breve: ");
        String comment = ScannerString.nextLine();

        a.addOpinion(new Opinion(us, puntos, comment));
    }

}
