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
import org.restlet.data.Status;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author emilio
 */
public class FuncionesResource extends ServerResource {

    public FuncionesResource() {
    }

    @Get
    public Representation getFunciones() {
        Representation rep = null;
        try {
            File tempFile = File.createTempFile("funciones", "html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write("<!DOCTYPE html>\n"
                    + "<html>\n");
            String template = FuncionesTemplate.funcionesHtml();
            writer.write(template);
            writer.write("\n</html>");
            writer.flush();
            rep = new FileRepresentation(tempFile, MediaType.TEXT_HTML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rep;
    }
    
    @Post
    public Representation getFunciones(Representation data){
        Form form = new Form(data);
        String dia = form.getFirstValue("dia");
        if (dia == null){
            setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
            return new StringRepresentation("no se pudo leer el dato", MediaType.TEXT_PLAIN);
        }
        Representation rep = null;
        try {
            File tempFile = File.createTempFile("funciones", "html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write("<!DOCTYPE html>\n"
                    + "<html>\n");
            writer.write("\n</html>");
            String template = FuncionesTemplate.funcionesHtml(LocalDate.parse(dia));
            writer.write(template);
            writer.flush();
            rep = new FileRepresentation(tempFile, MediaType.TEXT_HTML);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rep;
        
        
    }
    
    

}
