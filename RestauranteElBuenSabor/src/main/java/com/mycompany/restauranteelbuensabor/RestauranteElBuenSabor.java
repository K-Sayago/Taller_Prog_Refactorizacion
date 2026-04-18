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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionMenu = 0;
        boolean ejecutando = true;
        int intentosInvalidos = 0;
        String mensajeAux = "";
        int numeroMesa = 0;
        double montoProducto = 0;
        boolean continuar = true;
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println("========================================");
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
            } 
            else if (opcionMenu == 2) {
                System.out.println("--- AGREGAR PRODUCTO ---");
                System.out.print("Numero de producto (1-" + DatosRestaurante.nombres.length + "): ");
                int numeroProducto = sc.nextInt();
                System.out.print("Cantidad: ");
                int cantidad = sc.nextInt();
                if (numeroProducto > 0 && numeroProducto <= DatosRestaurante.nombres.length) {
                    if (cantidad > 0) {
                        if (DatosRestaurante.estadoMesa == 0) {
                            System.out.print("Ingrese numero de mesa: ");
                            DatosRestaurante.numeroMesaActual = sc.nextInt();
                            if (DatosRestaurante.numeroMesaActual > 0) {
                                DatosRestaurante.estadoMesa = 1;
                                mensajeAux = String.valueOf(DatosRestaurante.numeroMesaActual);
                                numeroMesa = DatosRestaurante.numeroMesaActual;
                                intentosInvalidos = numeroMesa + 1;
                            } 
                            else {
                                DatosRestaurante.numeroMesaActual = 1;
                                DatosRestaurante.estadoMesa = 1;
                                mensajeAux = "1";
                                numeroMesa = 1;
                                intentosInvalidos = 2;
                            }
                        }
                        DatosRestaurante.cantidades[numeroProducto - 1] = DatosRestaurante.cantidades[numeroProducto - 1] + cantidad;
                        System.out.println("Producto agregado al pedido.");
                        System.out.println("  -> " + DatosRestaurante.nombres[numeroProducto - 1] + " x" + cantidad);
                        montoProducto = DatosRestaurante.precios[numeroProducto - 1] * cantidad;
                    } 
                    else {
                        if (cantidad == 0) {
                            System.out.println("La cantidad no puede ser cero.");
                        } 
                        else {
                            System.out.println("Cantidad invalida. Ingrese un valor positivo.");
                        }
                    }
                } 
                else {
                    if (numeroProducto <= 0) {
                        System.out.println("El numero debe ser mayor a cero.");
                    } else {
                        System.out.println("Producto no existe. La carta tiene " + DatosRestaurante.nombres.length + " productos.");
                    }
                }
                System.out.println();
            } 
            else if (opcionMenu == 3) {
                System.out.println();
                if (Utilidades.hayProductosEnPedido()) {
                    ImprimirFactura.mostrarPedido();
                } else {
                    System.out.println("No hay productos en el pedido actual.");
                    System.out.println("Use la opcion 2 para agregar productos.");
                    continuar = true;
                }
                System.out.println();
            }
            else if (opcionMenu == 4) {
                System.out.println();
                if (Utilidades.hayProductosEnPedido()) {
                    double totalCalculado = 0;
                    totalCalculado = CalcularFactura.calcularTotalFactura();
                    numeroMesa = (int) totalCalculado;
                    mensajeAux = "Total calculado: $" + numeroMesa;
                    montoProducto = totalCalculado;
                    ImprimirFactura.imprimirFacturaCompleta();
                    System.out.println();
                } 
                else {
                    System.out.println("No se puede generar factura.");
                    System.out.println("No hay productos en el pedido.");
                    System.out.println("Use la opcion 2 para agregar productos primero.");
                    numeroMesa = 0;
                    mensajeAux = "";
                    montoProducto = 0;
                    continuar = true;
                }
            } 
            else if (opcionMenu == 5) {
                System.out.println();
                Utilidades.reiniciar();
                intentosInvalidos = 0;
                numeroMesa = 0;
                mensajeAux = "";
                montoProducto = 0;
                continuar = true;
                System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
                System.out.println();
            } 
            else if (opcionMenu == 0) {
                ejecutando = false;
                System.out.println("Hasta luego!");
            } 
            else {
                System.out.println("Opcion no valida. Seleccione entre 0 y 5.");
                Scanner sc2 = new Scanner(System.in);
                intentosInvalidos = intentosInvalidos + 1;
                if (intentosInvalidos > 3) {
                    System.out.println("Demasiados intentos invalidos.");
                    intentosInvalidos = 0;
                    String lineaDescartada = sc2.hasNextLine() ? sc2.nextLine() : "";
                }
            }
        }
        sc.close();
    }
}
