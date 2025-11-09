package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.bean.Setor;
import br.com.fiap.challenge.bo.SetorBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/setor")
public class SetorResource {

    private SetorBO setorBO = new SetorBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Setor> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Setor>) setorBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Setor setor, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        setorBO.inserirBo(setor);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(setor.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Setor setor) throws ClassNotFoundException, SQLException {
        setorBO.atualizarBo(setor);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        setorBO.deletarBo(id);
        return Response.ok().build();
    }
}
