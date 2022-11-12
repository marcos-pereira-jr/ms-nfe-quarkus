package domain.shared.msfazenda;

import javax.ws.rs.core.MultivaluedMap;

import infrastructure.msfazenda.response.ResponseMSFazenda;

public interface MSFazendaClient {
    ResponseMSFazenda getNFE(MultivaluedMap<String, String> map);
}
