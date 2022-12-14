package application.usecase.nfe.add;

import javax.inject.Inject;
import javax.inject.Singleton;

import application.usecase.nfe.add.request.NFERequest;
import domain.model.NFETest;
import domain.service.AddNFEService;

@Singleton
public class AddNFEUserCase {

    @Inject
    AddNFEService addNFEService;

    public void executar(NFERequest request) {
        addNFEService.executar(NFETest.create(request.getId(), request.getName(), request.getColor()));
    }
}
