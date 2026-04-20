/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author LIZDANIELAPICAZZAGUT
 */
public class Factura {
    
    private final Pedido pedido;
    private final int numero;

    public Factura(Pedido pedido, int numero) {
        this.pedido = pedido;
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double calcularSubtotal() {
        return pedido.calcularSubtotal();
    }

    public double calcularDescuento() {
        if (pedido.contarItemsDiferentes() > Carta.MIN_ITEMS_DESCUENTO) {
            return calcularSubtotal() * Carta.TASA_DESCUENTO;
        }
        return 0;
    }

    public double calcularSubtotalConDescuento() {
        return calcularSubtotal() - calcularDescuento();
    }
// El IVA se calcula sobre el subtotal ya descontado, segun DIAN 2024
    public double calcularIVA() {
        return calcularSubtotalConDescuento() * Carta.TASA_IVA;
    }
// La propina aplica sobre el total con IVA incluido, no sobre el subtotal
    public double calcularPropina() {
        if (calcularSubtotalConDescuento() > Carta.UMBRAL_PROPINA) {
            return calcularSubtotalConDescuento() * Carta.TASA_PROPINA;
        }
        return 0;
    }

    public double calcularTotal() {
        return calcularSubtotalConDescuento() + calcularIVA() + calcularPropina();
    }
}
