package infrastructure.msfazenda.request;

public class RequestNFEInitBuilder {
    private String formulario;
    private String btSubmitQRCode;
    private String p; //TODO: Alterar Param name

    public RequestNFEInitBuilder setFormulario(String formulario) {
        this.formulario = formulario;
        return this;
    }

    public RequestNFEInitBuilder setBtSubmitQRCode(String btSubmitQRCode) {
        this.btSubmitQRCode = btSubmitQRCode;
        return this;
    }

    public RequestNFEInitBuilder setP(String p) {
        this.p = p;
        return this;
    }
}
