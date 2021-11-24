package utils.integration.fimi.requests;

import utils.integration.fimi.entity.User;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.IOException;

public class GetCMSBufferRq extends InitSoapRq {
    @Override
    public SOAPMessage callSoapWebService(String soapEndpointUrl, String soapAction, User user) {
        try {
            var soapConnection = createSoapConnect();
            var soapMessage = formSoapEnvelope(formHeadersForReq(soapAction), user);
            soapMessage.saveChanges();
            System.out.println("Request SOAP Message:");
            soapMessage.writeTo(System.out);
            System.out.println("\n");
            return soapConnection.call(soapMessage, soapEndpointUrl);
        } catch (SOAPException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SOAPConnection createSoapConnect() throws SOAPException {
        var soapConnectionFactory = SOAPConnectionFactory.newInstance();
        return soapConnectionFactory.createConnection();
    }

    private SOAPMessage formSoapEnvelope(SOAPMessage soapMessage, User user) throws SOAPException {
        var soapBody = initBodyEnvelope(soapMessage).getBody();
        var soapBodyElem = soapBody.addChildElement("GetCMSBufferRq", myNamespace);
        var soapBodyReqElement = soapBodyElem.addChildElement("Request", myNamespace);
        soapBodyReqElement.addAttribute(new QName("Product"), "FIMI");
        soapBodyReqElement.addAttribute(new QName("Clerk"), user.getClerk());
        soapBodyReqElement.addAttribute(new QName("Password"), user.getPassword());
        soapBodyReqElement.addAttribute(new QName("Session"), user.getSession());
        soapBodyReqElement.addAttribute(new QName("Ver"), "16.12");

        soapBodyReqElement.addChildElement("PAN", myNamespace1)
                .addTextNode(user.getPAN());
        soapBodyReqElement.addChildElement("MBR", myNamespace1)
                .addTextNode("0");
        return soapMessage;
    }
}
