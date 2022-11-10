package infrastructure.msfazenda;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import domain.shared.msfazenda.MSFazendaClient;
import domain.shared.msfazenda.ResponseNFE;

import java.net.http.HttpResponse;

@Singleton
public class MSFazendaClientImpl implements MSFazendaClient {
    @Inject
    @RestClient
    MSFazendaQuarkusClient msFazendaQuarkusClient;

    public ResponseNFE getNFE(MultivaluedMap map) {
        Response response = msFazendaQuarkusClient.getNFE(map);
        return null;
    }

}
