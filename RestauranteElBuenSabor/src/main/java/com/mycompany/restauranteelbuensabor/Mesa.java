/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteelbuensabor;

/**
 *
 * @author LIZDANIELAPICAZZAGUT
 */
public class Mesa {
    
    private int numero;
    private boolean activa;
    private final Pedido pedido;

    public Mesa() {
        this.numero = 0;
        this.activa = false;
        this.pedido = new Pedido();
    }

    public void activar(int numeroMesa) {
        this.numero = numeroMesa;
        this.activa = true;
    }

    public void reiniciar() {
        this.numero = 0;
        this.activa = false;
        this.pedido.limpiar();
    }

    public boolean estaActiva() {
        return activa;
    }

    public int getNumero() {
        return numero;
    }

    public Pedido getPedido() {
        return pedido;
    }
}
