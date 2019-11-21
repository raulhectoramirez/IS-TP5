
package org.datacontract.schemas._2004._07.sge_service_contracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.sge_service_contracts package. 
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

    private final static QName _ResultadoOperacion_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "ResultadoOperacion");
    private final static QName _ErrorServicio_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Faults", "ErrorServicio");
    private final static QName _ResultadoEstadoCliente_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "ResultadoEstadoCliente");
    private final static QName _ErrorServicioMensajeError_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Faults", "MensajeError");
    private final static QName _ResultadoOperacionError_QNAME = new QName("http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", "Error");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.sge_service_contracts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResultadoEstadoCliente }
     * 
     */
    public ResultadoEstadoCliente createResultadoEstadoCliente() {
        return new ResultadoEstadoCliente();
    }

    /**
     * Create an instance of {@link ResultadoOperacion }
     * 
     */
    public ResultadoOperacion createResultadoOperacion() {
        return new ResultadoOperacion();
    }

    /**
     * Create an instance of {@link ErrorServicio }
     * 
     */
    public ErrorServicio createErrorServicio() {
        return new ErrorServicio();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultadoOperacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "ResultadoOperacion")
    public JAXBElement<ResultadoOperacion> createResultadoOperacion(ResultadoOperacion value) {
        return new JAXBElement<ResultadoOperacion>(_ResultadoOperacion_QNAME, ResultadoOperacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorServicio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Faults", name = "ErrorServicio")
    public JAXBElement<ErrorServicio> createErrorServicio(ErrorServicio value) {
        return new JAXBElement<ErrorServicio>(_ErrorServicio_QNAME, ErrorServicio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultadoEstadoCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "ResultadoEstadoCliente")
    public JAXBElement<ResultadoEstadoCliente> createResultadoEstadoCliente(ResultadoEstadoCliente value) {
        return new JAXBElement<ResultadoEstadoCliente>(_ResultadoEstadoCliente_QNAME, ResultadoEstadoCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Faults", name = "MensajeError", scope = ErrorServicio.class)
    public JAXBElement<String> createErrorServicioMensajeError(String value) {
        return new JAXBElement<String>(_ErrorServicioMensajeError_QNAME, String.class, ErrorServicio.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Error", scope = ResultadoOperacion.class)
    public JAXBElement<String> createResultadoOperacionError(String value) {
        return new JAXBElement<String>(_ResultadoOperacionError_QNAME, String.class, ResultadoOperacion.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/SGE.Service.Contracts.Data", name = "Error", scope = ResultadoEstadoCliente.class)
    public JAXBElement<String> createResultadoEstadoClienteError(String value) {
        return new JAXBElement<String>(_ResultadoOperacionError_QNAME, String.class, ResultadoEstadoCliente.class, value);
    }

}
