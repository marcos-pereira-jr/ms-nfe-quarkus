package infrastructure.msfazenda;

import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import domain.shared.msfazenda.MSFazendaClient;
import infrastructure.msfazenda.response.ResponseMSFazenda;

@Singleton
public class MSFazendaClientImpl implements MSFazendaClient {
    @Inject
    @RestClient
    MSFazendaQuarkusClient msFazendaQuarkusClient;

    public ResponseMSFazenda getNFE(MultivaluedMap<String, String> map) {
        ResponseMSFazenda responseMSFazenda = new ResponseMSFazenda();
        Response response = msFazendaQuarkusClient.getNFE(map);

        responseMSFazenda.setXml(response.readEntity(String.class));
        responseMSFazenda.setCookie(response.getHeaderString("set-cookie"));
        return responseMSFazenda;
    }

    public ResponseMSFazenda getNFE(MultivaluedMap<String, String> querys, HashMap<String, String> headers) {
        ResponseMSFazenda responseMSFazenda = new ResponseMSFazenda();
        Response response = msFazendaQuarkusClient.getNFE(querys, headers.get("Cookie"));
        responseMSFazenda.setXml(response.readEntity(String.class));
        responseMSFazenda.setCookie(response.getHeaderString("set-cookie"));
        return responseMSFazenda;
    }
}
