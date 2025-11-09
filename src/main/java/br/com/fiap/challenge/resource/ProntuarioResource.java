package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.bean.Prontuario;
import br.com.fiap.challenge.bo.ProntuarioBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/prontuario")
public class ProntuarioResource {

    private ProntuarioBO prontuarioBO = new ProntuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Prontuario> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Prontuario>) prontuarioBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Prontuario prontuario, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        prontuarioBO.inserirBo(prontuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(prontuario.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Prontuario prontuario) throws ClassNotFoundException, SQLException {
        prontuarioBO.atualizarBo(prontuario);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        prontuarioBO.deletarBo(id);
        return Response.ok().build();
    }
}
