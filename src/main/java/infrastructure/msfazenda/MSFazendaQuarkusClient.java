package infrastructure.msfazenda;

import infrastructure.msfazenda.response.ResponseNFE;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/consultaQRCode.faces")
@RegisterRestClient
public interface MSFazendaQuarkusClient {
    @POST
    ResponseNFE getNFE(@HeaderParam("Content-Type") String contentType, String id);
}
