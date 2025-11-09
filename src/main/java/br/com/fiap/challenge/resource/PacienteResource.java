package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.bean.Paciente;
import br.com.fiap.challenge.bo.PacienteBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/paciente")
public class PacienteResource {

    private PacienteBO pacienteBO = new PacienteBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Paciente> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Paciente>) pacienteBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Paciente paciente, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        pacienteBO.inserirBo(paciente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(paciente.getCpf());
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Paciente paciente) throws ClassNotFoundException, SQLException {
        pacienteBO.atualizarBo(paciente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("cpf") String cpf) throws ClassNotFoundException, SQLException {
        pacienteBO.deletarBo(cpf);
        return Response.ok().build();
    }
}
