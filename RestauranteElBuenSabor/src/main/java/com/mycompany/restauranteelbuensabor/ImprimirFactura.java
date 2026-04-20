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
        System.out.println("    RESTAURANTE " + Carta.NOMBRE_RESTAURANTE);
        System.out.println("    " + Carta.DIRECCION);
        System.out.println("    NIT: " + Carta.NIT);
        System.out.println(SEPARADOR_DOBLE);
    }

    public static void mostrarCarta() {
        imprimirEncabezado();
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println(SEPARADOR_DOBLE);
        int indice = 0;
        Producto[] productos = Carta.getProductos();
        while (indice < productos.length) {
            System.out.printf("%d. %-22s $%,.0f%n", (indice + 1), productos[indice].getNombre(), productos[indice].getPrecio());
            indice++;
        }
        System.out.println(SEPARADOR_DOBLE);
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("--- PEDIDO ACTUAL ---");
        int indice = 0;
        while (indice < pedido.getItems().size()) {
            ItemPedido item = pedido.getItems().get(indice);
            System.out.printf(FORMATO_ITEM, item.getProducto().getNombre(), item.getCantidad(), item.calcularSubtotal());
            indice++;
        }
        System.out.println("--------------------");
        System.out.printf(FORMATO_LINEA, "Subtotal:", pedido.calcularSubtotal());
    }

    public static void imprimirFacturaCompleta(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d%n", factura.getNumero());
        System.out.println(SEPARADOR_SIMPLE);
        int indice = 0;
        while (indice < factura.getPedido().getItems().size()) {
            ItemPedido item = factura.getPedido().getItems().get(indice);
            System.out.printf(FORMATO_ITEM, item.getProducto().getNombre(), item.getCantidad(), item.calcularSubtotal());
            indice++;
        }
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "Subtotal:", factura.calcularSubtotalConDescuento());
        System.out.printf(FORMATO_LINEA, "IVA (19%):", factura.calcularIVA());
        if (factura.calcularPropina() > 0) {
            System.out.printf(FORMATO_LINEA, "Propina (10%):", factura.calcularPropina());
        }
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "TOTAL:", factura.calcularTotal());
        System.out.println(SEPARADOR_DOBLE);
        System.out.println("Gracias por su visita!");
        System.out.println(Carta.NOMBRE_RESTAURANTE + " - Valledupar");
        System.out.println(SEPARADOR_DOBLE);
    }

    public static void imprimirFacturaResumen(Factura factura) {
        imprimirEncabezado();
        System.out.printf("FACTURA No. %03d (RESUMEN)%n", factura.getNumero());
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "Subtotal:", factura.calcularSubtotalConDescuento());
        System.out.printf(FORMATO_LINEA, "IVA (19%):", factura.calcularIVA());
        if (factura.calcularPropina() > 0) {
            System.out.printf(FORMATO_LINEA, "Propina (10%):", factura.calcularPropina());
        }
        System.out.println(SEPARADOR_SIMPLE);
        System.out.printf(FORMATO_LINEA, "TOTAL:", factura.calcularTotal());
        System.out.println(SEPARADOR_DOBLE);
    }
}