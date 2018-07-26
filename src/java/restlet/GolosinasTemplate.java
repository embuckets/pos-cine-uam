/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restlet;

import controlador.Manejador;
import ticket.Ticket;
import com.x5.template.Chunk;
import com.x5.template.Theme;

/**
 *
 * @author Fer
 */
public class GolosinasTemplate {
    
    public static String getHtml(){
        Theme theme = new Theme("web/themes", "");
        Chunk html = theme.makeChunk("golosinas#tabla");
        html.set("listaprod", new Ticket().cargarProductos());
        return html.toString();
        
    }
    
    public static String getTicket(Manejador manejador){
        
        Theme theme = new Theme("web/themes", "");
        Chunk html = theme.makeChunk("ticket#tabla");
        html.set("producto", manejador.getLineaVentas());
        html.set("total", manejador.calcularTotal());
        return html.toString();
    
    }
       
    
}
