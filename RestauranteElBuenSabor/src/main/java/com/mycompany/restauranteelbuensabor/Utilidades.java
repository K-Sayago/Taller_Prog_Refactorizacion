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
        while (indice < Datos.cantidades.length) {
            if (Datos.cantidades[indice] > 0) {
                contador = contador + 1;
            }
            indice++;
        }
        if (contador == 0) {
            Datos.totalFactura = 0;
            Datos.mensajeTemporal = "";
        }
        return contador > 0;
    }

    public static void reiniciar() {
        int indice = 0;
        while (indice < Datos.cantidades.length) {
            Datos.cantidades[indice] = 0;
            indice++;
        }
        Datos.totalFactura = 0;
        Datos.estadoMesa = 0;
        Datos.numeroMesaActual = 0;
        Datos.mensajeTemporal = "";
    }
}
