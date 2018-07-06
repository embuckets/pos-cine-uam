/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio.golosinas;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Fer
 */
public class ListaDeProductos {
   
    LinkedList <Producto> cargarProductos() throws IOException{
        
        LinkedList <Producto> lista = new LinkedList();
        
        try{
            FileReader f = new FileReader("Productos.txt");
            BufferedReader lectura = new BufferedReader(f);
            
            String cadena = lectura.readLine();
            StringTokenizer st;
            
                  while(cadena!=null){
                
                st = new StringTokenizer(cadena, ",");
                while(st.hasMoreTokens()){
                    lista.add(new Producto(st.nextToken(),Float.parseFloat(st.nextToken()),st.nextToken(),st.nextToken(),st.nextToken()));  
                }
                
                cadena = lectura.readLine();
            }
                  
                  lectura.close();
                  f.close();
        }catch(FileNotFoundException ex){
        
                Logger.getLogger(ListaDeProductos.class.getName()).log(Level.SEVERE, null, ex);

        }catch(IOException ex){
                 Logger.getLogger(ListaDeProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    
    
    
    }
    
}
