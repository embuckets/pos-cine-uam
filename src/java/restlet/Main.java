/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restlet;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 *
 * @author emilio
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8182);
        component.getDefaultHost().attach("/cine", new CineUamApp());
        component.start();
    }
    
}
