package utils.integration.fimi;

import utils.integration.fimi.entity.User;
import utils.integration.fimi.requests.GetCMSBufferRq;
import utils.integration.fimi.requests.InitSessionRq;
import utils.integration.fimi.requests.LogonRq;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class SOAPClientSAAJ {
    private static final String TEST_CRED = "DB_TEST2";
    public static void main(String args[]) {
        try {
            var initSessionResponse = initSessionRequest();
            login(SOAPParser.getValueFromBodyXML(initSessionResponse, 0),
                    SOAPParser.getKeyWordForCipher(initSessionResponse));
//            getCodeByPAN(session);


        } catch (SOAPException | IOException e) {
            e.printStackTrace();
        }
    }

//    private static String getCodeByPAN(String session) throws SOAPException, IOException {
//        var user = new User(TEST_CRED, EncoderSHA.getEncodePassword(TEST_CRED), session, "9990040083167");
//        new GetCMSBufferRq().callSoapWebService(user).writeTo(System.out);
//        System.out.println();
//        return "";
//    }
//
    private static void login(String session, String vector) throws SOAPException, IOException {
        User user = null;
        try {
            user = new User(TEST_CRED, TrippleDes.encode(vector), session);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new LogonRq().callSoapWebService(user).writeTo(System.out);
        System.out.println();
    }

    private static SOAPMessage initSessionRequest() throws SOAPException, IOException {
        var user = new User();
        user.setClerk(TEST_CRED);
        return new InitSessionRq().callSoapWebService(user);
    }
//    private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
//        SOAPPart soapPart = soapMessage.getSOAPPart();
//"DB_TEST1", EncoderSHA.getEncodePassword("DB_TEST1"), "615667244"
//        // SOAP Envelope
//        SOAPEnvelope envelope = soapPart.getEnvelope();
//        SOAPHeader header = soapMessage.getSOAPHeader();
//        SOAPBody body = soapMessage.getSOAPBody();
//
//        envelope.removeNamespaceDeclaration(envelope.getPrefix());
//        envelope.setPrefix("soap");
//        header.setPrefix("soap");
//        body.setPrefix("soap");
//        envelope
//                .addNamespaceDeclaration("soap", "http://www.w3.org/2003/05/soap-envelope")
//                .addNamespaceDeclaration(myNamespace, myNamespaceURI)
//                .addNamespaceDeclaration(myNamespace1, myNamespaceURITypes);
//            /*
//            Constructed SOAP Request Message:
//            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="http://www.webserviceX.NET">
//                <SOAP-ENV:Header/>
//                <SOAP-ENV:Body>
//                    <myNamespace:GetInfoByCity>
//                        <myNamespace:USCity>New York</myNamespace:USCity>
//                    </myNamespace:GetInfoByCity>
//                </SOAP-ENV:Body>
//            </SOAP-ENV:Envelope>
//            */
//
//        // SOAP Body
//        SOAPBody soapBody = envelope.getBody();
//        SOAPElement soapBodyElem = soapBody.addChildElement("InitSessionRq", myNamespace);
//        SOAPElement soapBodyReqElement = soapBodyElem.addChildElement("Request", myNamespace);
//        soapBodyReqElement.addAttribute(new QName("Product"), "FIMI");
//        soapBodyReqElement.addAttribute(new QName("Clerk"), "C2B_USER2");
//        soapBodyReqElement.addAttribute(new QName("Ver"), "16.12");
//
//        soapBodyReqElement.addChildElement("NeedDicts", myNamespace1)
//                    .addTextNode("0");
//        soapBodyReqElement.addChildElement("AllVendors", myNamespace1)
//                    .addTextNode("0");
//        soapBodyReqElement.addChildElement("AvoidSession", myNamespace1)
//                    .addTextNode("0");
//    }
//
//    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
//        try {
//            // Create SOAP Connection
//            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
//
//            // Send SOAP Message to SOAP Server
//            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);
//
//            // Print the SOAP Response
//            System.out.println("Response SOAP Message:");
//            soapResponse.writeTo(System.out);
//            System.out.println();
//
//            soapConnection.close();
//        } catch (Exception e) {
//            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
//            e.printStackTrace();
//        }
//    }
//
//    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
//        MessageFactory messageFactory = MessageFactory.newInstance();
//        SOAPMessage soapMessage = messageFactory.createMessage();
//
//        createSoapEnvelope(soapMessage);
//
//        MimeHeaders headers = soapMessage.getMimeHeaders();
//        headers.addHeader("Accept-Encoding", "gzip,deflate");
//        headers.addHeader("SOAPAction", soapAction);
//        headers.addHeader("Content-Length", "575");
//        headers.addHeader("Content-Type", "application/soap+xml;charset=UTF-8");
//
//
//        soapMessage.saveChanges();
//
//        /* Print the request message, just for debugging purposes */
//        System.out.println("Request SOAP Message:");
//        soapMessage.writeTo(System.out);
//        System.out.println("\t");
//
//        return soapMessage;
//    }
}
