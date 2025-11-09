package br.com.fiap.challenge.resource;

import br.com.fiap.challenge.api.Endereco;
import br.com.fiap.challenge.service.ViaCepService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/cep")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CepResource {

    private final ViaCepService viaCepService = new ViaCepService();

    @GET
    @Path("/{cep}")
    public Response buscarCep(@PathParam("cep") String cep) {
        try {
            if (cep == null || cep.isBlank()) return Response.status(Response.Status.BAD_REQUEST).entity("CEP inválido").build();
            Endereco endereco = viaCepService.buscarPorCep(cep);
            if (endereco == null) return Response.status(Response.Status.NOT_FOUND).build();
            return Response.ok(endereco).build();
        } catch (IllegalArgumentException iae) {
            return Response.status(Response.Status.BAD_REQUEST).entity(iae.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
