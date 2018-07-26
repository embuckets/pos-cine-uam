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
public class Pago {
    
    float montoRecibido;
    float cambio;
    
    
    public float calcularCambio(float total){
    
        cambio = (float)montoRecibido - total;
        
        if(cambio<0){
               return -1;
        }else 
            return cambio;
        
        
    
   // return 0;
    }

    public void setMontoRecibido(float montoRecibido) {
        this.montoRecibido = montoRecibido;
    }
    
       public String generarTicket(Venta venta, boolean efectivo){
        
        
            return "------------TICKET------------"+venta.toString()+"\nTipo de Pago: Efectivo\nMonto recibido: $"+montoRecibido+"\nCambio: $"+cambio;
        
        
    }
    
    

}
