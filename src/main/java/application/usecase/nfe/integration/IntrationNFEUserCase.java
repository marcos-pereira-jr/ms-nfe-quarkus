package application.usecase.nfe.integration;

import javax.inject.Inject;

import domain.service.integration.IntegrationNFEService;

public class IntrationNFEUserCase {
    @Inject
    IntegrationNFEService integrationNFEService;

    public void run(String code) {
        integrationNFEService.run(code);
    }
}
