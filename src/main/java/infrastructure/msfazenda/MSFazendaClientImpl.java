package infrastructure.msfazenda;

import javax.inject.Inject;

import domain.shared.msfazenda.MSFazendaClient;
import domain.shared.msfazenda.ResponseNFE;

public class MSFazendaClientImpl implements MSFazendaClient {
    @Inject
    MSFazendaQuarkusClient msFazendaQuarkusClient;

    public ResponseNFE getNFE(String contentType, String id) {
        return msFazendaQuarkusClient.getNFE(contentType, id);
    }

}
