package application.usecase.nfe.integration;

import javax.inject.Inject;
import javax.inject.Singleton;

import domain.service.integration.IntegrationNFEService;

@Singleton
public class IntrationNFEUserCase {
    @Inject
    IntegrationNFEService integrationNFEService;

    public void run(String code) {
        integrationNFEService.run(code);
    }
}
