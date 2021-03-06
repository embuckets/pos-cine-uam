/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author emilio
 */
public class Sala {

    public static int MAX_ASIENTOS_POR_FILA = 30;//TAL VEZ QUITARLO
    private final String numero;

    public static enum Tipo {
        TRADICIONAL, MACRO_XE, IMAX, CUATRO_DX, VIP
    }
    private final Tipo tipo;
    private final List<Fila> asientos;

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
    public String toString() {
        return "Sala{" + "numero=" + numero + ", tipo=" + tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, tipo);
    }

    /**
     * Son iguales si tienen el mismo numero. Los demas parametro no se toman en
     * cuenta
     *
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

    public Tipo getTipo() {
        return tipo;
    }
}
