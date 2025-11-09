package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.bean.Agendamento;
import br.com.fiap.challenge.bo.AgendamentoBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/agendamento")
public class AgendamentoResource {

    private AgendamentoBO agendamentoBO = new AgendamentoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Agendamento> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Agendamento>) agendamentoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Agendamento agendamento, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        agendamentoBO.inserirBo(agendamento);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(agendamento.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Agendamento agendamento) throws ClassNotFoundException, SQLException {
        agendamentoBO.atualizarBo(agendamento);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        agendamentoBO.deletarBo(id);
        return Response.ok().build();
    }
}
