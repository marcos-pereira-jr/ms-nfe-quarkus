package infrastructure.msfazenda;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import domain.shared.msfazenda.ResponseNFE;

@Path("/consultaQRCode.faces")
@RegisterRestClient
public interface MSFazendaQuarkusClient {
    @POST
    ResponseNFE getNFE(@HeaderParam("Content-Type") String contentType, String id);
}
