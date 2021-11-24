package utils.integration.fimi;

import utils.integration.fimi.entity.User;
import utils.integration.fimi.requests.InitSoapRq;
import utils.integration.fimi.requests.LogonRq;

import javax.xml.namespace.QName;
import javax.xml.soap.*;


public class SOAPClientSAAJ {

    // SAAJ - SOAP Client Testing
    public static void main(String args[]) {
        /*
            The example below requests from the Web Service at:
             http://www.webservicex.net/uszip.asmx?op=GetInfoByCity


            To call other WS, change the parameters below, which are:
             - the SOAP Endpoint URL (that is, where the service is responding from)
             - the SOAP Action

            Also change the contents of the method createSoapEnvelope() in this class. It constructs
             the inner part of the SOAP envelope that is actually sent.
         */
        String soapEndpointUrl = "http://172.22.250.89:21004";
        String soapAction = "http://172.22.250.89:21004/InitSessionRq";
        InitSoapRq initSoapRq = new LogonRq();
        var user = new User("C2B_USER2", "1C3792D899AC85E2", "615667244");
        initSoapRq.callSoapWebService(soapEndpointUrl, soapAction, user);
    }

//    private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
//        SOAPPart soapPart = soapMessage.getSOAPPart();
//
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
