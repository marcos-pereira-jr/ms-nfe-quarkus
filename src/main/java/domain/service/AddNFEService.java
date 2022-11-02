package domain.service;

import application.usecase.nfe.add.request.NFERequest;
import domain.model.NFE;
import domain.repository.nfe.NFERepository;

import javax.inject.Singleton;

@Singleton //TODO: remove that Singleton
public class AddNFEService {
    private final NFERepository repository;

    public AddNFEService(NFERepository repository){
        this.repository = repository;
    }

    public void executar(NFE nfe){
        repository.add(nfe);
    }
}
