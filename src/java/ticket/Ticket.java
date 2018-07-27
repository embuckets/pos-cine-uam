package ticket;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laura
 */
public class Ticket {

    public LinkedList<Producto> cargarProductos() {

        //Declaración de la lista del producto.
        LinkedList<Producto> lista = new LinkedList<>();

        try {
            //lectura del archivo caracter a caracter.
            FileReader fr = new FileReader("Ticket.txt");
            //almacenamiento de los caracteres de entrada.
            BufferedReader lectura = new BufferedReader(fr);
            String cadena = null;
            while ((cadena = lectura.readLine()) != null) {
                String[] tokens = cadena.split(",");
                Producto producto = new Producto(tokens[0], tokens[2], Float.parseFloat(tokens[1]), tokens[3], tokens[4]);
                lista.add(producto);
            }
            lectura.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

}
