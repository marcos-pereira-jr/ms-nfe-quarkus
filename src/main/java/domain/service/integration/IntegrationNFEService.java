package domain.service.integration;

import javax.inject.Singleton;
import javax.ws.rs.core.MultivaluedMap;

import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import domain.shared.msfazenda.MSFazendaClient;
import domain.shared.msfazenda.ResponseNFE;

@Singleton
public class IntegrationNFEService {

    private MSFazendaClient client;

    public IntegrationNFEService(MSFazendaClient client) {
        this.client = client;
    }

    public void run(String code) {
        this.init();
    }

    private void init() {
        String initialCode = "3321 1228 7901 8600 0149 6500 9000 2852 2390 0570 4466";
        String formulario = "formulario";
        String btSubmitQRCode = "btSubmitQRCode";
        String p = getParameterizedCode(initialCode);

        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl<>();
        queryParams.add("formulario", formulario);
        queryParams.add("btSubmitQRCode", btSubmitQRCode);
        queryParams.add("p", p);

        ResponseNFE nfe = client.getNFE(queryParams);
        return;

    }

    private String getParameterizedCode(String code) {
        if (code == null)
            throw new RuntimeException("Code not be null");
        return code.replace("\\s+", "") + "|2|1|1|0000000000000000000000000000000000000000|";

    }
}
