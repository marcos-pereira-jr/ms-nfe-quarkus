package domain.service.integration;

import javax.inject.Singleton;

import domain.service.shared.nfe.ImportNFERequest;
import domain.service.shared.nfe.read.checkhands.CheckHands;
import domain.service.shared.nfe.read.checkhands.CheckHandsMSFazenda;
import domain.shared.msfazenda.MSFazendaClient;
import infrastructure.msfazenda.response.ResponseMSFazenda;

@Singleton
public class IntegrationNFEService {

    private MSFazendaClient client;
    private CheckHandsMSFazenda checkHandsMSFazenda;

    public IntegrationNFEService(MSFazendaClient client, CheckHandsMSFazenda checkHandsMSFazenda) {
        this.client = client;
        this.checkHandsMSFazenda = checkHandsMSFazenda;
    }

    public void run(String code) {
        CheckHands checkHands = checkHandsMSFazenda.getResolved();
        ImportNFERequest request = ImportNFERequest.create(code);
        request.setCheckHands(checkHands);
        ResponseMSFazenda response = client.getNFE(request.getQueryParams(), request.getHeaders());
        System.out.println(response);
    }
}
