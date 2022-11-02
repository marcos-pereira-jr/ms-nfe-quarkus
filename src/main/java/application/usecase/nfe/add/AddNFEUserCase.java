package application.usecase.nfe.add;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Singleton;

import application.usecase.nfe.add.request.NFERequest;
import domain.model.NFE;
import domain.repository.nfe.NFERepository;
import domain.service.AddNFEService;

@Singleton  
public class AddNFEUserCase {

    @Inject
    AddNFEService addNFEService;
    public void executar(NFERequest request){
        addNFEService.executar(NFE.create(request.getId(),request.getName(),request.getColor()));
    }   
}