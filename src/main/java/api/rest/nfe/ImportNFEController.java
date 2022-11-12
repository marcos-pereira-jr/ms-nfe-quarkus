package api.rest.nfe;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import application.usecase.nfe.integration.IntrationNFEUserCase;
import application.usecase.nfe.integration.request.IntegrationImport;

@Path("/v1/import")
public class ImportNFEController {

    @Inject
    IntrationNFEUserCase integration;

    @POST
    public Response integration(IntegrationImport request) {
        integration.run(request.getCode());
        return Response.ok().build();
    }
}
