package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.bean.Enfermeiro;
import br.com.fiap.challenge.bo.EnfermeiroBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/enfermeiro")
public class EnfermeiroResource {

    private EnfermeiroBO enfermeiroBO = new EnfermeiroBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Enfermeiro> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Enfermeiro>) enfermeiroBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Enfermeiro enfermeiro, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        enfermeiroBO.inserirBo(enfermeiro);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(enfermeiro.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Enfermeiro enfermeiro) throws ClassNotFoundException, SQLException {
        enfermeiroBO.atualizarBo(enfermeiro);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        enfermeiroBO.deletarBo(id);
        return Response.ok().build();
    }
}
