package utils.integration.fimi;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

public class SOAPParser {
    public static String getValueFromBodyXML(SOAPMessage soapResponse, int index) throws SOAPException {
        return soapResponse
                .getSOAPBody()
                .getTextContent()
                .trim()
                .split("\\s+")[index];
    }

    public static String getKeyWordForCipher(SOAPMessage soapResponse) throws SOAPException {
        var responseList = soapResponse.getSOAPPart().getEnvelope().getBody().getElementsByTagName("Response").item(0);
        return responseList.getAttributes().item(0).getTextContent();
    }
}
