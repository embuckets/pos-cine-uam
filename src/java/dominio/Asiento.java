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
public class Asiento {
    private Character fila;
    private Integer numero;
    
    // fila debe estar ser caracter entre a-z || A-Z
    //numero deber ser un valor entre 1-MAX_POR_FILA(30)
    public Asiento (Character fila, Integer numero) throws IllegalArgumentException {
        setFila(fila);
        setNumero(numero);
    }
    
    public Asiento (Integer numero) {
        this.fila = 'A';
        this.numero = numero;
    }
    
    @Override
    public String toString(){
        return fila + numero.toString();
    }
    
    public void setFila(Character fila) throws IllegalArgumentException {
        int valorDecimal = Character.getNumericValue(fila);
        if (valorDecimal >= Character.getNumericValue('A') && valorDecimal <= Character.getNumericValue('Z')) {
            this.fila = fila;
        } else if (valorDecimal >= Character.getNumericValue('a') && valorDecimal <= Character.getNumericValue('z')){
            this.fila = Character.toUpperCase(fila);
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    public void setNumero(Integer numero) throws IllegalArgumentException {
        if (numero > 0 && numero <= Sala.MAX_ASIENTOS_POR_FILA) {
            this.numero = numero;
        } else {
            throw new IllegalArgumentException();
        }
    }
}