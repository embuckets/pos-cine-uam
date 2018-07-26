/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Laura
 */
public class LineaVenta {
    
    private Producto producto;
    private int cantidad;
    private float subtotal;

    public LineaVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        subtotal = calcularSubtotal();
    }
    
    

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }
    
    private float calcularSubtotal(){
    
    return  producto.getPrecio()*cantidad;
    }

    @Override
    public String toString() {
        return "LineaVenta{" + "producto=" + producto + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }
    
    
    
    
    
}
