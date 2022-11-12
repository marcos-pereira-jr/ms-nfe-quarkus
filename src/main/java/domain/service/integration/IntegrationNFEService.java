package domain.service.integration;

import javax.inject.Singleton;

import domain.service.shared.nfe.read.CheckHandsMSFazenda;
import domain.shared.msfazenda.MSFazendaClient;

@Singleton
public class IntegrationNFEService {

    private MSFazendaClient client;
    private CheckHandsMSFazenda checkHandsMSFazenda;

    public IntegrationNFEService(MSFazendaClient client, CheckHandsMSFazenda checkHandsMSFazenda) {
        this.client = client;
        this.checkHandsMSFazenda = checkHandsMSFazenda;
    }

    public void run(String code) {
        String checkHands = checkHandsMSFazenda.getResolved();
        System.out.println(checkHands);
    }
}
