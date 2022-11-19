package domain.service.checkhands;

import javax.enterprise.context.ApplicationScoped;

import domain.service.shared.nfe.ImportNFERequest;
import domain.service.shared.nfe.read.ExtractMetaDataCheck;
import domain.shared.msfazenda.MSFazendaClient;
import infrastructure.msfazenda.response.ResponseMSFazenda;

@ApplicationScoped
public class CheckHandsMSFazenda {

    private MSFazendaClient client;
    private String initCode = "3321 1228 7901 8600 0149 6500 9000 2852 2390 0570 4466";
    private CheckHands checkHands;

    public CheckHandsMSFazenda(MSFazendaClient client) {
        this.client = client;
        this.run();
    }

    public void run() {
        ImportNFERequest request = ImportNFERequest.create(initCode);
        ResponseMSFazenda response = client.getNFE(request.getQueryParams());
        checkHands = ExtractMetaDataCheck.extract(response);
        return;
    }

    public CheckHands getResolved() {
        return this.checkHands;
    }
}
