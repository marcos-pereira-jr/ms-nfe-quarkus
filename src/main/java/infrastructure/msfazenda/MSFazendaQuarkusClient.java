package infrastructure.msfazenda;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/consultaQRCode.faces")
@RegisterRestClient(configKey = "msfazenda")
public interface MSFazendaQuarkusClient {
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response getNFE(MultivaluedMap<String, ?> params);

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response getNFE(MultivaluedMap<String, ?> params, @HeaderParam("Cookie") String cookie);
}
