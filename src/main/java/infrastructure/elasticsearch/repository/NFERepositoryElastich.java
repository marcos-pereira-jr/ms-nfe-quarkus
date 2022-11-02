package infrastructure.elasticsearch.repository;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.elasticsearch.client.Request;
import org.elasticsearch.client.RestClient;

import domain.model.NFE;
import domain.repository.nfe.NFERepository;
import io.vertx.core.json.JsonObject;

@Singleton
public class NFERepositoryElastich implements NFERepository {

    @Inject
    RestClient restClient;

    public void add(NFE nfe) {
        try{
        Request request = new Request(
                "POST",
                "/nfes/_doc/" + nfe.getId()); 
        request.setJsonEntity(JsonObject.mapFrom(nfe).toString()); 
        restClient.performRequest(request); 
        }catch(IOException ioException){
            throw new RuntimeException("Invalid JSON format");
        }catch (Exception exception){
            throw new RuntimeException("Conexão Recusada");
        }
    }
}
