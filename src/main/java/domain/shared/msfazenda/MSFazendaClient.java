package domain.shared.msfazenda;

import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import infrastructure.msfazenda.response.ResponseMSFazenda;

public interface MSFazendaClient {
    ResponseMSFazenda getNFE(MultivaluedMap<String, String> map);

    ResponseMSFazenda getNFE(MultivaluedMap<String, String> querys, HashMap<String, String> headers);

}
