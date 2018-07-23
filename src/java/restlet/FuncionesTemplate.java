/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restlet;

import com.x5.template.Chunk;
import com.x5.template.Theme;
import dominio.Cine;
import java.time.LocalDate;

/**
 *
 * @author emilio
 */
public class FuncionesTemplate {
    public static String funcionesHtml(){
        Theme theme = new Theme("web/themes", "");
        Chunk html = theme.makeChunk("funciones#tabla");
        html.set("funciones", Cine.getFunciones());//getFuncionesString
        html.set("dias", Cine.getDias());
        
        return html.toString();
    }
    public static String funcionesHtml(LocalDate dia){
        Theme theme = new Theme("web/themes", "");
        Chunk html = theme.makeChunk("funciones#tabla");
        html.set("funciones", Cine.getFunciones(dia));//getFuncionesString
        html.set("dias", Cine.getDias());
        html.set("selected", dia.toString());
        
        return html.toString();
        
    }
}
