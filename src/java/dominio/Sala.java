/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author emilio
 */
public class Sala {

    public static int MAX_ASIENTOS_POR_FILA = 30;
    private String numero;

    public static enum Tipo {
        TRADICIONAL, MACRO_XE, IMAX, CUATRO_DX, VIP
    }
    private Tipo tipo;
    private ArrayList<Fila> asientos;

    public Sala(String numero, Tipo tipo) {
        this.numero = numero;
        this.tipo = tipo;
        asientos = new ArrayList<>();
    }

    public Sala(String numero, Tipo tipo, int numDeFilas, int asientosPorFila) {
        this(numero, tipo);
        for (int i = 1; i <= numDeFilas; i++) {
            asientos.add(new Fila(i, asientosPorFila));
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numero);
        hash = 47 * hash + Objects.hashCode(this.tipo);
        hash = 47 * hash + Objects.hashCode(this.asientos);
        return hash;
    }
    
    /**
     * Son iguales si tienen el mismo numero.
     * Los demas parametro no se toman en cuenta
     * @param obj
     * @return true si tienen el mismo numero
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sala other = (Sala) obj;
        if (!this.numero.equalsIgnoreCase(other.numero)) {
            return false;
        }
        return true;
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
