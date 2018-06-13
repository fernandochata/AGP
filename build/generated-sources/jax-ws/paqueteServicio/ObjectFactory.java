
package paqueteServicio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the paqueteServicio package. 
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

    private final static QName _Antiguedad_QNAME = new QName("http://paqueteServicio/", "Antiguedad");
    private final static QName _OperationResponse_QNAME = new QName("http://paqueteServicio/", "operationResponse");
    private final static QName _AntiguedadResponse_QNAME = new QName("http://paqueteServicio/", "AntiguedadResponse");
    private final static QName _Operation_QNAME = new QName("http://paqueteServicio/", "operation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: paqueteServicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Antiguedad_Type }
     * 
     */
    public Antiguedad_Type createAntiguedad_Type() {
        return new Antiguedad_Type();
    }

    /**
     * Create an instance of {@link OperationResponse }
     * 
     */
    public OperationResponse createOperationResponse() {
        return new OperationResponse();
    }

    /**
     * Create an instance of {@link AntiguedadResponse }
     * 
     */
    public AntiguedadResponse createAntiguedadResponse() {
        return new AntiguedadResponse();
    }

    /**
     * Create an instance of {@link Operation }
     * 
     */
    public Operation createOperation() {
        return new Operation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Antiguedad_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paqueteServicio/", name = "Antiguedad")
    public JAXBElement<Antiguedad_Type> createAntiguedad(Antiguedad_Type value) {
        return new JAXBElement<Antiguedad_Type>(_Antiguedad_QNAME, Antiguedad_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paqueteServicio/", name = "operationResponse")
    public JAXBElement<OperationResponse> createOperationResponse(OperationResponse value) {
        return new JAXBElement<OperationResponse>(_OperationResponse_QNAME, OperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AntiguedadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paqueteServicio/", name = "AntiguedadResponse")
    public JAXBElement<AntiguedadResponse> createAntiguedadResponse(AntiguedadResponse value) {
        return new JAXBElement<AntiguedadResponse>(_AntiguedadResponse_QNAME, AntiguedadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Operation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://paqueteServicio/", name = "operation")
    public JAXBElement<Operation> createOperation(Operation value) {
        return new JAXBElement<Operation>(_Operation_QNAME, Operation.class, null, value);
    }

}
