package domain.shared.msfazenda;

import javax.ws.rs.core.MultivaluedMap;

public interface MSFazendaClient {
    ResponseNFE getNFE(MultivaluedMap map);
}
