/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author alfre
 */
public class Utilidades {

    public static boolean hayProductosEnPedido() {
        int contador = 0;
        int indice = 0;
        while (indice < DatosRestaurante.cantidades.length) {
            if (DatosRestaurante.cantidades[indice] > 0) {
                contador = contador + 1;
            }
            indice++;
        }
        if (contador == 0) {
            DatosRestaurante.totalFactura = 0;
            DatosRestaurante.mensajeTemporal = "";
        }
        return contador > 0;
    }

    public static void reiniciar() {
        int indice = 0;
        while (indice < DatosRestaurante.cantidades.length) {
            DatosRestaurante.cantidades[indice] = 0;
            indice++;
        }
        DatosRestaurante.totalFactura = 0;
        DatosRestaurante.estadoMesa = 0;
        DatosRestaurante.numeroMesaActual = 0;
        DatosRestaurante.mensajeTemporal = "";
    }
}
