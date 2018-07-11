/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restlet;

import com.x5.template.Chunk;
import com.x5.template.Theme;
import dominio.Cine;

/**
 *
 * @author emilio
 */
public class FuncionesTemplate {
    public static String funcionesHtml(){
        Theme theme = new Theme("web/themes", "");
        Chunk html = theme.makeChunk("funciones#tabla");
        html.set("funciones", Cine.getFuncionesString());
        
        return html.toString();
    }
}
