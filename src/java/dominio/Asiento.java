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

    private String fila;
    private String numero;

    public Asiento(String fila, String numero) {
        this.fila = fila;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return fila + "," + numero;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Asiento) {
            Asiento asiento = (Asiento) o;
            return fila.equalsIgnoreCase(asiento.getFila()) && numero.equalsIgnoreCase(asiento.getNumero());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return fila.concat(numero).hashCode();
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        if (fila.length() == 1) {
            if (Character.isAlphabetic(fila.codePointAt(0))) {
                this.fila = fila;
            }
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
