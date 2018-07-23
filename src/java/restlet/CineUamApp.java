/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restlet;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Route;
import org.restlet.routing.Router;

/**
 *
 * @author emilio
 */
public class CineUamApp extends Application {
    @Override
    public synchronized Restlet createInboundRoot(){
        Router router = new Router(getContext());
        router.attach("/funciones", FuncionesResource.class);
        router.attach("/asientos", AsientosResource.class);
        
        return router;
    }
    
}
