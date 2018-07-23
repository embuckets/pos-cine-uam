/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.ArrayList;
import java.util.Objects;

/** Tal vez sea mejor quitar esta clase y manejar los asientos como lista de lista de asientos
 *
 * @author emilio
 */
public class Fila {

    private Integer numero;
    private ArrayList<Asiento> asientos;

    public Fila(Integer numero, int numeroAsientos) throws IllegalArgumentException {
        setNumero(numero);
        asientos = new ArrayList<>();
        char c = getLetraFila().charAt(0);
        for (int i = 1; i <= numeroAsientos; i++) {
            asientos.add(new Asiento(c, i));
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, asientos);
    }
    
    

    @Override
    public String toString() {
        String result = asientos.get(0).toString();
        for (int i = 1; i < asientos.size(); i++) {
            result += "," + asientos.get(i).toString();
        }
        //TODO falta representar todos los asientos en la fila
        return result;
    }
    
    //TODO mover este metodo a una clase en el paquete util
    private String getLetraFila() {
        char[] letras = {'0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z'};
        return "" + letras[this.numero];
    }

    public void setNumero(int numero) throws IllegalArgumentException {
        if (numero < 1 || numero > 26) {
            throw new IllegalArgumentException();
        }
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void agregarAsiento() {
        char c = getLetraFila().charAt(0);
        asientos.add(new Asiento(c, asientos.size() + 1));
    }

}
