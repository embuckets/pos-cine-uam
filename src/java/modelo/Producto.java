
package modelo;

/**
 *
 * @author Laura
 */
public class Producto {
    String id_producto;
    String producto;
    float precio;
    String marca;
    String cantidadNeta;

    public Producto(String id_producto, String producto, float precio, String marca, String cantidadNeta) {
        this.id_producto = id_producto;
        this.producto = producto;
        this.precio = precio;
        this.marca = marca;
        this.cantidadNeta = cantidadNeta;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCantidadNeta() {
        return cantidadNeta;
    }

    public void setCantidadNeta(String cantidadNeta) {
        this.cantidadNeta = cantidadNeta;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", producto=" + producto + ", precio=" + precio + ", marca=" + marca + ", cantidadNeta=" + cantidadNeta + '}';
    }
    
    
    
    
    
}
