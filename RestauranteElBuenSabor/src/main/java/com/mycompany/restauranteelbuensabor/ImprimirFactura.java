/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class ImprimirFactura {

    public static void mostrarCarta() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");
        int indice = 0;
        while (indice < DatosRestaurante.nombres.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), DatosRestaurante.nombres[indice], DatosRestaurante.precios[indice]);
            indice++;
        }
        System.out.println("========================================");
    }

    public static void mostrarPedido() {
        double subtotal = 0;
        int indice = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (indice < DatosRestaurante.nombres.length) {
            if (DatosRestaurante.cantidades[indice] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", DatosRestaurante.nombres[indice], DatosRestaurante.cantidades[indice], (DatosRestaurante.precios[indice] * DatosRestaurante.cantidades[indice]));
                subtotal = subtotal + DatosRestaurante.precios[indice] * DatosRestaurante.cantidades[indice];
            }
            indice++;
        }
        System.out.println("--------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotal);
    }

    public static void imprimirFacturaCompleta() {
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        double propina = 0;
        int itemsDiferentes = 0;
        double subtotalConDescuento = 0;
        int indice = 0;
        while (indice < DatosRestaurante.nombres.length) {
            if (DatosRestaurante.cantidades[indice] > 0) {
                subtotal = subtotal + DatosRestaurante.precios[indice] * DatosRestaurante.cantidades[indice];
                itemsDiferentes = itemsDiferentes + 1;
            }
            indice++;
        }
        if (itemsDiferentes > 3) {
            subtotalConDescuento = subtotal - (subtotal * 0.05);
        } 
        else {
            subtotalConDescuento = subtotal;
        }
        if (subtotalConDescuento > 50000) {
            iva = subtotalConDescuento * 0.19;
            total = subtotalConDescuento + iva;
            propina = total * 0.10;
            total = total + propina;
        } 
        else {
            iva = subtotalConDescuento * 0.19;
            total = subtotalConDescuento + iva;
            propina = 0;
        }
        String separador = "========================================";
        System.out.println(separador);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(separador);
        System.out.printf("FACTURA No. %03d%n", DatosRestaurante.numeroFactura);
        System.out.println("----------------------------------------");
        int j = 0;
        while (j < DatosRestaurante.nombres.length) {
            if (DatosRestaurante.cantidades[j] > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", DatosRestaurante.nombres[j], DatosRestaurante.cantidades[j], (DatosRestaurante.precios[j] * DatosRestaurante.cantidades[j]));
            }
            j++;
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalConDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);
        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(separador);
        System.out.println("Gracias por su visita!");
        System.out.println("El Buen Sabor - Valledupar");
        System.out.println(separador);
        DatosRestaurante.numeroFactura = DatosRestaurante.numeroFactura + 1;
        DatosRestaurante.estadoMesa = 0;
        DatosRestaurante.totalFactura = total;
    }

    public static void imprimirFacturaResumen() {
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        double propina = 0;
        int itemsDiferentes = 0;
        double subtotalConDescuento = 0;
        int indice = 0;
        while (indice < DatosRestaurante.nombres.length) {
            if (DatosRestaurante.cantidades[indice] > 0) {
                subtotal = subtotal + DatosRestaurante.precios[indice] * DatosRestaurante.cantidades[indice];
                itemsDiferentes = itemsDiferentes + 1;
            }
            indice++;
        }
        if (itemsDiferentes > 3) {
            subtotalConDescuento = subtotal - (subtotal * 0.05);
        } else {
            subtotalConDescuento = subtotal;
        }
        if (subtotalConDescuento > 50000) {
            iva = subtotalConDescuento * 0.19;
            total = subtotalConDescuento + iva;
            propina = total * 0.10;
            total = total + propina;
        }
        else {
            iva = subtotalConDescuento * 0.19;
            total = subtotalConDescuento + iva;
            propina = 0;
        }
        String separador = "========================================";
        System.out.println(separador);
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    Calle 15 #8-32, Valledupar");
        System.out.println("    NIT: 900.123.456-7");
        System.out.println(separador);
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", DatosRestaurante.numeroFactura);
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "Subtotal:", subtotalConDescuento);
        System.out.printf("%-27s $%,.0f%n", "IVA (19%):", iva);
        if (propina > 0) {
            System.out.printf("%-27s $%,.0f%n", "Propina (10%):", propina);
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-27s $%,.0f%n", "TOTAL:", total);
        System.out.println(separador);
    }
}
