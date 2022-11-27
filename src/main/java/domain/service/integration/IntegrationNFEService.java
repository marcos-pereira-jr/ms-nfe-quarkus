package domain.service.integration;

import javax.inject.Singleton;

import domain.service.checkhands.CheckHands;
import domain.service.checkhands.CheckHandsMSFazenda;
import domain.service.shared.nfe.ImportNFERequest;
import domain.shared.msfazenda.MSFazendaClient;
import infrastructure.msfazenda.response.ResponseMSFazenda;
import infrastructure.rabbitmq.MessageService;

@Singleton
public class IntegrationNFEService {

    private MSFazendaClient client;
    private CheckHandsMSFazenda checkHandsMSFazenda;
    private MessageService messageService;

    public IntegrationNFEService(MSFazendaClient client,
            CheckHandsMSFazenda checkHandsMSFazenda,
            MessageService messageService) {
        this.client = client;
        this.checkHandsMSFazenda = checkHandsMSFazenda;
        this.messageService = messageService;
    }

    public void run(String code) {
        CheckHands checkHands = checkHandsMSFazenda.getResolved();
        ImportNFERequest request = ImportNFERequest.create(code);
        request.setCheckHands(checkHands);
        ResponseMSFazenda response = client.getNFE(request.getQueryParams(), request.getHeaders());
        messageService.send(response.getXml());
    }
}
