package domain.service;

import javax.inject.Singleton;

import domain.model.NFE;
import domain.repository.nfe.NFERepository;

@Singleton // TODO: remove that Singleton
public class AddNFEService {
    private final NFERepository repository;

    public AddNFEService(NFERepository repository) {
        this.repository = repository;
    }

    public void executar(NFE nfe) {
        repository.add(nfe);
    }
}
