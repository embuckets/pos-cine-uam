package restlet;

import controlador.Manejador;
import ticket.Ticket;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.representation.FileRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Fer
 */
public class GolosinasResource extends ServerResource {

    public GolosinasResource() {
    }

    @Get
    public Representation getGolosinas() {
        Representation rep = null;
        try {

            File temFile = File.createTempFile("golosinas", "html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(temFile));

            bw.write("<!DOCTYPE html>\n <html>\n");
            String template = GolosinasTemplate.getHtml();
            bw.write(template);
            bw.write("\n</html>");
            bw.flush();
            rep = new FileRepresentation(temFile, MediaType.TEXT_HTML);

        } catch (IOException ex) {
            Logger.getLogger(GolosinasResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rep;

    }

    @Post
    public Representation getTicket(Representation data) {

        Form form = new Form(data);
        String values = form.getValues("cantidades");

        String[] cantidades = values.split(",");
        Manejador manejador = new Manejador();
        Ticket ticket = new Ticket();
        LinkedList<Producto> listaProductos = ticket.cargarProductos();

        for (int i = 0; i < listaProductos.size(); i++) {
            manejador.agregarProducto(listaProductos.get(i), Integer.parseInt(cantidades[i]));
        }
        Representation rep = null;
        try {

            File temFile = File.createTempFile("golosinas", "html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(temFile));

            bw.write("<!DOCTYPE html>\n <html>\n");
            String template = GolosinasTemplate.getTicket(manejador);
            bw.write(template);
            bw.write("\n</html>");
            bw.flush();
            rep = new FileRepresentation(temFile, MediaType.TEXT_HTML);

        } catch (IOException ex) {
            Logger.getLogger(GolosinasResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rep;

    }

}
