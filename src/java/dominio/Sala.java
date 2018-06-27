/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;


/**
 *
 * @author emilio
 */
public class Sala {
    private String numero;
    public static enum Tipo {TRADICIONAL, MACRO_XE, IMAX, CUATRO_DX, VIP}
    private Tipo tipo;
    
    

    public Sala(String numero, Tipo tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
}
