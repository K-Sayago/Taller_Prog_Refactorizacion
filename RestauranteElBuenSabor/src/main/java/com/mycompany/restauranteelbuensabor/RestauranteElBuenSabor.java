/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.restauranteelbuensabor;

import java.util.Scanner;

/**
 *
 * @author alfre
 */
public class RestauranteElBuenSabor {

   private static int numeroFacturaActual = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mesa mesa = new Mesa();
        int opcionMenu = 0;
        boolean ejecutando = true;
        int intentosInvalidos = 0;

        ImprimirFactura.imprimirEncabezado();
        while (ejecutando) {
            System.out.println("1. Ver carta");
            System.out.println("2. Agregar producto al pedido");
            System.out.println("3. Ver pedido actual");
            System.out.println("4. Generar factura");
            System.out.println("5. Nueva mesa");
            System.out.println("0. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opcion: ");
            opcionMenu = sc.nextInt();
            if (opcionMenu == 1) {
                ImprimirFactura.mostrarCarta();
                System.out.println();
            } else if (opcionMenu == 2) {
                System.out.println("--- AGREGAR PRODUCTO ---");
                System.out.print("Numero de producto (1-" + Carta.cantidadProductos() + "): ");
                int numeroProducto = sc.nextInt();
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();
                if (numeroProducto > 0 && numeroProducto <= Carta.cantidadProductos()) {
                    if (cantidad > 0) {
                        if (!mesa.estaActiva()) {
                            System.out.print("Ingrese numero de mesa: ");
                            int numeroMesa = sc.nextInt();
                            if (numeroMesa > 0) {
                                mesa.activar(numeroMesa);
                            } else {
                                mesa.activar(1);
                            }
                        }
                        Producto producto = Carta.getProductos()[numeroProducto - 1];
                        mesa.getPedido().agregarItem(producto, cantidad);
                        System.out.println("Producto agregado al pedido.");
                        System.out.println("  -> " + producto.getNombre() + " x" + cantidad);
                    } else {
                        if (cantidad == 0) {
                            System.out.println("La cantidad no puede ser cero.");
                        } else {
                            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
                        }
                    }
                } else {
                    if (numeroProducto <= 0) {
                        System.out.println("El numero debe ser mayor a cero.");
                    } else {
                        System.out.println("Producto no existe. La carta tiene " + Carta.cantidadProductos() + " productos.");
                    }
                }
                System.out.println();
            } else if (opcionMenu == 3) {
                System.out.println();
                if (mesa.getPedido().tieneProductos()) {
                    ImprimirFactura.mostrarPedido(mesa.getPedido());
                } else {
                    System.out.println("No hay productos en el pedido actual.");
                    System.out.println("Use la opcion 2 para agregar productos.");
                }
                System.out.println();
            } else if (opcionMenu == 4) {
                System.out.println();
                if (mesa.getPedido().tieneProductos()) {
                    Factura factura = new Factura(mesa.getPedido(), numeroFacturaActual);
                    ImprimirFactura.imprimirFacturaCompleta(factura);
                    numeroFacturaActual = numeroFacturaActual + 1;
                    System.out.println();
                } else {
                    System.out.println("No se puede generar factura.");
                    System.out.println("No hay productos en el pedido.");
                    System.out.println("Use la opcion 2 para agregar productos primero.");
                }
            } else if (opcionMenu == 5) {
                System.out.println();
                Utilidades.reiniciar(mesa);
                intentosInvalidos = 0;
                System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                System.out.println();
            } else if (opcionMenu == 0) {
                ejecutando = false;
                System.out.println("Hasta luego!");
            } else {
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
                intentosInvalidos = intentosInvalidos + 1;
                if (intentosInvalidos > 3) {
                    System.out.println("Demasiados intentos invalidos.");
                    intentosInvalidos = 0;
                }
            }
        }
        sc.close();
    }
}