/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ticket.Ticket;
import java.util.LinkedList;
import modelo.LineaVenta;
import modelo.Pago;
import modelo.Producto;
import modelo.Usuario;
import modelo.Venta;

/**
 *
 * @author Laura
 */
public class Manejador {

    private Venta venta;
    private Pago pago;
    private Ticket ticket;

    public Manejador() {
        venta = new Venta("venta", new Usuario("usuario", "Laura", "Eizmendi", "Hernández"));
        pago = new Pago();
        ticket = new Ticket();
    }

    public void agregarProducto(Producto p, int cantidad) {
        LineaVenta lineaVenta = new LineaVenta(p, cantidad);
        venta.anadirProducto(lineaVenta);
    }

    public LineaVenta ultimoProductoAgregado() {
        if (!venta.getSubtotales().isEmpty()) {
            return venta.getSubtotales().getLast();
        } else {
            return null;
        }
    }

    public float calcularTotal() {
        return venta.calcularTotal();
    }

    public float calcularCambio(float montoRecibido) {
        pago.setMontoRecibido(montoRecibido);
        float cambio = pago.calcularCambio(venta.getTotal());

        if (cambio < 0) {
            return -1;
        } else {
            return cambio;
        }
    }

    public void iniciarVenta() {
        venta.setTotal((float) 0.0);
        venta.getSubtotales().clear();
    }

    public String generarTicket(boolean efectivo) {
        return pago.generarTicket(venta, efectivo);

    }

    public LinkedList<Producto> cargarProductos() {
        return ticket.cargarProductos();
    }

    public Usuario getUsuario() {
        return venta.getUsuario();
    }

    public LinkedList<LineaVenta> getLineaVentas() {

        return venta.getLineaVentas();

    }

}
