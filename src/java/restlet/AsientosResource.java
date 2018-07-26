/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author emilio
 */
public class AsientosResource extends ServerResource {

    @Post
    public Representation getAsientos(Representation data) {
        //SOLO ESTA PARA TEST
        //Hay que emplementar la funcionalidad
        Form form = new Form(data);
        String id = form.getFirstValue("id");
        Representation rep = null;
        try {
            File tempFile = File.createTempFile("funciones", "html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<p>" + id + "</p>");
            writer.write("\n</html>");
            writer.flush();
            rep = new FileRepresentation(tempFile, MediaType.TEXT_HTML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rep;

    }

}
