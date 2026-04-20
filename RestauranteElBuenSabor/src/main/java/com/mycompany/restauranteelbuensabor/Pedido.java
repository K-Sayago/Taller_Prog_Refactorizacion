/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LIZDANIELAPICAZZAGUT
 */
public class Pedido {
    
     private final List<ItemPedido> items = new ArrayList<>();

    public void agregarItem(Producto producto, int cantidad) {
        int indice = 0;
        while (indice < items.size()) {
            if (items.get(indice).getProducto().getNombre().equals(producto.getNombre())) {
                items.get(indice).agregarCantidad(cantidad);
                return;
            }
            indice++;
        }
        items.add(new ItemPedido(producto, cantidad));
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        int indice = 0;
        while (indice < items.size()) {
            subtotal = subtotal + items.get(indice).calcularSubtotal();
            indice++;
        }
        return subtotal;
    }

    public int contarItemsDiferentes() {
        return items.size();
    }

    public boolean tieneProductos() {
        return !items.isEmpty();
    }

    public void limpiar() {
        items.clear();
    }

    public List<ItemPedido> getItems() {
        return items;
    }
}
