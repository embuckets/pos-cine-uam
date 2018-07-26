/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restlet;

import java.io.File;
import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author emilio
 */
public class IndexResource extends ServerResource {

    public IndexResource() {
    }

    @Get
    public Representation getIndex() {
        File index = new File("web/index.html");
        return new FileRepresentation(index, MediaType.TEXT_HTML);
    }

}
