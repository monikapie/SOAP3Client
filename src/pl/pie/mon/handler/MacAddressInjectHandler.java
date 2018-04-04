package pl.pie.mon.handler;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;

public class MacAddressInjectHandler implements SOAPHandler<SOAPMessageContext>{

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Client : getHeaders()......");
        return null;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {

        System.out.println("Client : handleMessage()......");

        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        //if this is a request, true for outbound messages, false for inbound
        if(isRequest){

            try{
                SOAPMessage soapMsg = context.getMessage();
                SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
                SOAPHeader soapHeader = soapEnv.getHeader();

                //if no header, add one
                if (soapHeader == null){
                    soapHeader = soapEnv.addHeader();
                }

                //get mac address
                String mac = getMACAddress();

                //add a soap header, name as "mac address"
                QName qname = new QName("http://ws.mkyong.com/", "macAddress");
                SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);
                soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
                soapHeaderElement.addTextNode(mac);

                Map<String, List<String>> headers = new HashMap<String, List<String>>();
                headers.put("Username", Collections.singletonList("monika"));
                headers.put("Password", Collections.singletonList("pit"));
                context.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

                soapMsg.saveChanges();
                //tracking
                soapMsg.writeTo(System.out);


            }catch(SOAPException e){
                System.err.println(e);
            }catch(IOException e){
                System.err.println(e);
            }

        }

        //continue other handler chain
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        System.out.println("Client : handleFault()......");
        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Client : close()......");
    }

    private String getMACAddress(){
        InetAddress inetAddress;
        StringBuilder stringBuilder = new StringBuilder();
        byte[] mac = new byte[0];
        try {
            inetAddress = InetAddress.getLocalHost();
            System.out.println("IP address is " + inetAddress.getHostAddress());
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
            mac = networkInterface.getHardwareAddress();
            System.out.print("MAC Address is ");
            for(int i = 0; i < mac.length; i++){
                stringBuilder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(stringBuilder.toString());
        } catch (SocketException | UnknownHostException e ) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }


}
