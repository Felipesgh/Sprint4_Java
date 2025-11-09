package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.bean.Medico;
import br.com.fiap.challenge.bo.MedicoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/medico")
public class MedicoResource {

    private MedicoBO medicoBO = new MedicoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Medico> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Medico>) medicoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Medico medico, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        medicoBO.inserirBo(medico);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(medico.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Medico medico) throws ClassNotFoundException, SQLException {
        medicoBO.atualizarBo(medico);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        medicoBO.deletarBo(id);
        return Response.ok().build();
    }
}
