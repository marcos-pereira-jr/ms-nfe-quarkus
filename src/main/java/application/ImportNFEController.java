package application;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import application.usecase.nfe.add.AddNFEUserCase;
import application.usecase.nfe.add.request.NFERequest;

@Path("/v1/import")
public class ImportNFEController {

    @Inject
    private AddNFEUserCase addNFEUserCase;

    @POST
    public Response save(NFERequest request){
        addNFEUserCase.executar(request);
        return Response.ok().build();
    }
}
