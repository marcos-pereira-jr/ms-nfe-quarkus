package domain.service.integration;

import javax.inject.Inject;

import domain.shared.msfazenda.MSFazendaClient;

public class IntegrationNFEService {

    @Inject
    MSFazendaClient client;

    public void run(String code) {

    }
}
