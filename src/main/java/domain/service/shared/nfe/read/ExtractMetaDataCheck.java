package domain.service.shared.nfe.read;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import infrastructure.msfazenda.response.ResponseMSFazenda;

public class ExtractMetaDataCheck {
    private static DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
    public final static String PATH_VIEW_STATE = "javax.faces.ViewState";
    public final static String ATRIBUTE_VIEW_STATE = "value";

    public static CheckHands extract(ResponseMSFazenda response) {
        try {

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(response.getXml()));
            inputSource.setEncoding("UTF-8");
            Document document = documentBuilder.parse(inputSource);
            String viewState = document.getElementById(PATH_VIEW_STATE).getAttribute(ATRIBUTE_VIEW_STATE);
            return CheckHands.create(response.getCookie().concat(";"), viewState);
        } catch (Exception e) {
            throw new RuntimeException("Error on extrack Check Hands");
        }
    }
}
