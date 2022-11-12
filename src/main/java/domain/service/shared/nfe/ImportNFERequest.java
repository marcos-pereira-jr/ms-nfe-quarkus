package domain.service.shared.nfe;

import javax.ws.rs.core.MultivaluedMap;

import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import domain.service.shared.FormaterCode;

public class ImportNFERequest {
    private String code;

    private ImportNFERequest(String code) {
        this.code = code;
    }

    public static ImportNFERequest create(String code) {
        return new ImportNFERequest(FormaterCode.format(code));
    }

    public MultivaluedMap<String, String> getQueryParams() {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl<>();
        queryParams.add("formulario", "formulario");
        queryParams.add("btSubmitQRCode", "btSubmitQRCode");
        queryParams.add("p", code);
        return queryParams;
    }
}
