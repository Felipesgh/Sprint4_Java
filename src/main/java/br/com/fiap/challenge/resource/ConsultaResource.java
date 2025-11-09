package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.bean.Consulta;
import br.com.fiap.challenge.bo.ConsultaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/consulta")
public class ConsultaResource {

    private ConsultaBO consultaBO = new ConsultaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Consulta> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Consulta>) consultaBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Consulta consulta, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        consultaBO.inserirBo(consulta);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(consulta.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Consulta consulta) throws ClassNotFoundException, SQLException {
        consultaBO.atualizarBo(consulta);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        consultaBO.deletarBo(id);
        return Response.ok().build();
    }
}
