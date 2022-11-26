package domain.service.shared.nfe.read;

import java.io.StringReader;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import domain.model.NFE;
import domain.service.checkhands.CheckHands;
import infrastructure.msfazenda.response.ResponseMSFazenda;

public class ExtractMetaDataCheck {
    private static DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
    public final static String PATH_VIEW_STATE = "javax.faces.ViewState";
    public final static String ATRIBUTE_VIEW_STATE = "value";

    public static CheckHands extract(ResponseMSFazenda response) {
        try {
            Document document = extractDocument(response.getXml(), "UTF-8");
            String viewState = document.getElementById(PATH_VIEW_STATE).getAttribute(ATRIBUTE_VIEW_STATE);
            return CheckHands.create(response.getCookie().concat(";"), viewState);
        } catch (Exception e) {
            throw new RuntimeException("Error on extrack Check Hands");
        }
    }

    private static Document extractDocument(String xml, String iso) {
        try {
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            InputSource inputSource = new InputSource(new StringReader(xml));
            inputSource.setEncoding(iso);
            return documentBuilder.parse(inputSource);
        } catch (Exception e) {
            throw new RuntimeException("Error on extrack Check Hands");
        }
    }

    public static NFE extractProducts(ResponseMSFazenda response) {
        String xml = response.getXml();
        byte[] utf = xml.getBytes();
        String te = new String(utf, StandardCharsets.ISO_8859_1);

        Document document = extractDocument(response.getXml(), "ISO-8859-1");
        NodeList nodes = document.getElementsByTagName("table");
        Node node = nodes.item(0);
        return new NFE();
    }
}
