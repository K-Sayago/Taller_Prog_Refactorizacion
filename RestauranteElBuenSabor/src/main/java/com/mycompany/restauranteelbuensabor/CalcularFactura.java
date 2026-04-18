/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class CalcularFactura {

    public static double calcularSubtotal() {
        double subtotal = 0;
        int indice = 0;
        while (indice < DatosRestaurante.nombres.length) {
            if (DatosRestaurante.cantidades[indice] > 0) {
                subtotal = subtotal + DatosRestaurante.precios[indice] * DatosRestaurante.cantidades[indice];
            }
            indice++;
        }
        return subtotal;
    }

    public static int contarItemsDiferentes() {
        int contador = 0;
        int indice = 0;
        while (indice < DatosRestaurante.cantidades.length) {
            if (DatosRestaurante.cantidades[indice] > 0) {
                contador = contador + 1;
            }
            indice++;
        }
        return contador;
    }

    public static double aplicarDescuento(double subtotal) {
        if (contarItemsDiferentes() > DatosRestaurante.MIN_ITEMS_DESCUENTO) {
            return subtotal - (subtotal * DatosRestaurante.TASA_DESCUENTO);
        }
        return subtotal;
    }

    public static double calcularIVA(double base) {
        return base * DatosRestaurante.TASA_IVA;
    }

    public static double calcularPropina(double base) {
        if (base > DatosRestaurante.UMBRAL_PROPINA) {
            return base * DatosRestaurante.TASA_PROPINA;
        }
        return 0;
    }

    public static double calcularTotal() {
        double subtotal = calcularSubtotal();
        double subtotalConDescuento = aplicarDescuento(subtotal);
        double iva = calcularIVA(subtotalConDescuento);
        double propina = calcularPropina(subtotalConDescuento);
        double total = subtotalConDescuento + iva + propina;
        DatosRestaurante.estadoMesa = 1;
        DatosRestaurante.totalFactura = total;
        return total;
    }
}