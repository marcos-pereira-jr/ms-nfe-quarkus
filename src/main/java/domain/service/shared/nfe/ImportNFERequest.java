package domain.service.shared.nfe;

import java.util.HashMap;

import javax.ws.rs.core.MultivaluedMap;

import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import domain.service.shared.FormaterCode;
import domain.service.shared.nfe.read.CheckHands;

public class ImportNFERequest {
    private String code;
    private CheckHands checkHands;

    private ImportNFERequest(String code) {
        this.code = code;
    }

    public static ImportNFERequest create(String code) {
        return new ImportNFERequest(FormaterCode.format(code));
    }

    public void setCheckHands(CheckHands checkHands) {
        this.checkHands = checkHands;
    }

    public MultivaluedMap<String, String> getQueryParams() {
        MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl<>();
        queryParams.add("formulario", "formulario");
        queryParams.add("btSubmitQRCode", "btSubmitQRCode");
        queryParams.add("p", code);
        if (checkHands != null) {
            queryParams.add("javax.faces.ViewState", checkHands.getViewState());
        }
        return queryParams;
    }

    public HashMap<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        if (checkHands != null) {
            headers.put("Cookie", checkHands.getCookie());
        }
        return headers;
    }
}
