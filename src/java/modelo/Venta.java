
package modelo;

import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author Laura
 */
public class Venta {
    
  private  String idVenta;
  private   float total;
  private  LocalDate fecha;
  private   LinkedList<LineaVenta> subtotales;
  private Usuario usuario;

    public Venta(String idVenta, Usuario usuario) {
        this.idVenta = idVenta;
        total = 0;
        fecha = LocalDate.now();
        subtotales = new LinkedList<>();
        this.usuario= usuario;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LinkedList<LineaVenta> getSubtotales() {
        return subtotales;
    }

    public void setSubtotales(LinkedList<LineaVenta> subtotales) {
        this.subtotales = subtotales;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
  
  
  public void anadirProducto(LineaVenta lineaVenta){
        subtotales.add(lineaVenta);
  }
  
  
  public float calcularTotal(){
      
      return  (float) subtotales.stream().mapToDouble(LineaVenta::getSubtotal).sum();
//        if(!subtotales.isEmpty()){
//            
//            
//            total+=subtotales.getLast().getSubtotal();
//        
//        }
        
        
//    return total;
    }
  
  public LinkedList <LineaVenta> getLineaVentas(){
  
            return subtotales;
  }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", total=" + total + ", fecha=" + fecha + ", subtotales=" + subtotales + '}';
    }
  
  
}


