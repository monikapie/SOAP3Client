
package pl.pie.mon.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.pie.mon.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetServerName_QNAME = new QName("http://server.mon.pie.pl/", "getServerName");
    private final static QName _GetServerNameResponse_QNAME = new QName("http://server.mon.pie.pl/", "getServerNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.pie.mon.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServerName }
     * 
     */
    public GetServerName createGetServerName() {
        return new GetServerName();
    }

    /**
     * Create an instance of {@link GetServerNameResponse }
     * 
     */
    public GetServerNameResponse createGetServerNameResponse() {
        return new GetServerNameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.mon.pie.pl/", name = "getServerName")
    public JAXBElement<GetServerName> createGetServerName(GetServerName value) {
        return new JAXBElement<GetServerName>(_GetServerName_QNAME, GetServerName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServerNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.mon.pie.pl/", name = "getServerNameResponse")
    public JAXBElement<GetServerNameResponse> createGetServerNameResponse(GetServerNameResponse value) {
        return new JAXBElement<GetServerNameResponse>(_GetServerNameResponse_QNAME, GetServerNameResponse.class, null, value);
    }

}
