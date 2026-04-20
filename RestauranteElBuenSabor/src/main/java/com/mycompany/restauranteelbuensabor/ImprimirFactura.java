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

    private static final String SEPARADOR_DOBLE = "========================================";
    private static final String SEPARADOR_SIMPLE = "----------------------------------------";
    private static final String FORMATO_ITEM = "%-20s x%-6d $%,.0f%n";
    private static final String FORMATO_LINEA = "%-27s $%,.0f%n";

    public static void imprimirEncabezado() {
        System.out.println(SEPARADOR_DOBLE);
        System.out.println("    RESTAURANTE " + DatosRestaurante.NOMBRE_RESTAURANTE);
        System.out.println("    " + DatosRestaurante.DIRECCION);
        System.out.println("    NIT: " + DatosRestaurante.NIT);
        System.out.println(SEPARADOR_DOBLE);
    }

    public static void mostrarCarta() {
        imprimirEncabezado();
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEPARADOR_DOBLE);
        int indice = 0;
        while (indice < DatosRestaurante.nombres.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), DatosRestaurante.nombres[indice], DatosRestaurante.precios[indice]);
            indice++;
        }
        System.out.println(SEPARADOR_DOBLE);
    }

    public static void mostrarPedido() {
        double subtotal = 0;
        int indice = 0;
        System.out.println("--- PEDIDO ACTUAL ---");
        while (indice < DatosRestaurante.nombres.length) {
            if (DatosRestaurante.cantidades[indice] > 0) {
                System.out.printf(FORMATO_ITEM, DatosRestaurante.nombres[indice], DatosRestaurante.cantidades[indice], (DatosRestaurante.precios[indice] * DatosRestaurante.cantidades[indice]));
                subtotal = subtotal + DatosRestaurante.precios[indice] * DatosRestaurante.cantidades[indice];
            }
            indice++;
        }
        System.out.println("--------------------");
        System.out.printf(FORMATO_LINEA, "Subtotal:", subtotal);
    }

    public static void imprimirFacturaCompleta() {
        double subtotal = CalcularFactura.calcularSubtotal();
        double subtotalConDescuento = CalcularFactura.aplicarDescuento(subtotal);
        double iva = CalcularFactura.calcularIVA(subtotalConDescuento);
        double propina = CalcularFactura.calcularPropina(subtotalConDescuento);
        double total = subtotalConDescuento + iva + propina;

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", DatosRestaurante.numeroFactura);
        System.out.println(SEPARADOR_SIMPLE);
        int indice = 0;
        while (indice < DatosRestaurante.nombres.length) {
            if (DatosRestaurante.cantidades[indice] > 0) {
                System.out.printf(FORMATO_ITEM, DatosRestaurante.nombres[indice], DatosRestaurante.cantidades[indice], (DatosRestaurante.precios[indice] * DatosRestaurante.cantidades[indice]));
            }
            indice++;
        }
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "Subtotal:", subtotalConDescuento);
        System.out.printf(FORMATO_LINEA, "IVA (19%):", iva);
        if (propina > 0) {
            System.out.printf(FORMATO_LINEA, "Propina (10%):", propina);
        }
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "TOTAL:", total);
        System.out.println(SEPARADOR_DOBLE);
        System.out.println("Gracias por su visita!");
        System.out.println(DatosRestaurante.NOMBRE_RESTAURANTE + " - Valledupar");
        System.out.println(SEPARADOR_DOBLE);
        DatosRestaurante.numeroFactura = DatosRestaurante.numeroFactura + 1;
        DatosRestaurante.estadoMesa = 0;
        DatosRestaurante.totalFactura = total;
    }

    public static void imprimirFacturaResumen() {
        double subtotal = CalcularFactura.calcularSubtotal();
        double subtotalConDescuento = CalcularFactura.aplicarDescuento(subtotal);
        double iva = CalcularFactura.calcularIVA(subtotalConDescuento);
        double propina = CalcularFactura.calcularPropina(subtotalConDescuento);
        double total = subtotalConDescuento + iva + propina;

        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", DatosRestaurante.numeroFactura);
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "Subtotal:", subtotalConDescuento);
        System.out.printf(FORMATO_LINEA, "IVA (19%):", iva);
        if (propina > 0) {
            System.out.printf(FORMATO_LINEA, "Propina (10%):", propina);
        }
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "TOTAL:", total);
        System.out.println(SEPARADOR_DOBLE);
    }
}