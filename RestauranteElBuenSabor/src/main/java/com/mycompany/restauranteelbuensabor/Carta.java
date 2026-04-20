/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author LIZDANIELAPICAZZAGUT
 */
public class Carta {
    
    public static final String NOMBRE_RESTAURANTE = "El Buen Sabor";
    public static final String DIRECCION = "Calle 15 #8-32, Valledupar";
    public static final String NIT = "900.123.456-7";

    public static final double TASA_IVA = 0.19;
    public static final double TASA_PROPINA = 0.10;
    public static final double TASA_DESCUENTO = 0.05;
    public static final double UMBRAL_PROPINA = 50000;
    public static final int MIN_ITEMS_DESCUENTO = 3;

    private static final Producto[] productos = {
        new Producto("Bandeja Paisa", 32000),
        new Producto("Sancocho de Gallina", 28000),
        new Producto("Arepa con Huevo", 8000),
        new Producto("Jugo Natural", 7000),
        new Producto("Gaseosa", 4500),
        new Producto("Cerveza Poker", 6000),
        new Producto("Agua Panela", 3500),
        new Producto("Arroz con Pollo", 25000)
    };

    public static Producto[] getProductos() {
        return productos;
    }

    public static int cantidadProductos() {
        return productos.length;
    }
}
