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

    public static double calcularTotalFactura() {
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        double subtotalConDescuento = 0;
        int itemsDiferentes = 0;
        int indice = 0;
        while (indice < DatosRestaurante.nombres.length) {
            if (DatosRestaurante.cantidades[indice] > 0) {
                subtotal = subtotal + DatosRestaurante.precios[indice] * DatosRestaurante.cantidades[indice];
                itemsDiferentes = itemsDiferentes + 1;
            }
            indice++;
        }
        if (itemsDiferentes > 3) {
            if (subtotal > 0) {
                subtotalConDescuento = subtotal - (subtotal * 0.05);
                if (subtotalConDescuento > 50000) {
                    iva = subtotalConDescuento * 0.19;
                    total = subtotalConDescuento + iva;
                    total = total + (total * 0.10);
                } 
                else {
                    iva = subtotalConDescuento * 0.19;
                    total = subtotalConDescuento + iva;
                }
            }
        } 
        else {
            if (subtotal > 50000) {
                iva = subtotal * 0.19;
                total = subtotal + iva;
                total = total + (total * 0.10);
            } 
            else {
                iva = subtotal * 0.19;
                total = subtotal + iva;
            }
        }
        DatosRestaurante.estadoMesa = 1;
        DatosRestaurante.totalFactura = total;
        return total;
    }
}
