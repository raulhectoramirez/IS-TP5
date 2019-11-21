
package service.contracts.service.istp1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoEstadoCliente;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoOperacion;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service.contracts.service.istp1 package. 
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

    private final static QName _ObtenerEstadoClienteResponseObtenerEstadoClienteResult_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "ObtenerEstadoClienteResult");
    private final static QName _InformarCreditoFinalizadoIdentificadorCredito_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "identificadorCredito");
    private final static QName _InformarCreditoFinalizadoCodigoFinanciera_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "codigoFinanciera");
    private final static QName _InformarCreditoOtorgadoResponseInformarCreditoOtorgadoResult_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "InformarCreditoOtorgadoResult");
    private final static QName _InformarCreditoFinalizadoResponseInformarCreditoFinalizadoResult_QNAME = new QName("http://ISTP1.Service.Contracts.Service", "InformarCreditoFinalizadoResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service.contracts.service.istp1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ObtenerEstadoClienteResponse }
     * 
     */
    public ObtenerEstadoClienteResponse createObtenerEstadoClienteResponse() {
        return new ObtenerEstadoClienteResponse();
    }

    /**
     * Create an instance of {@link InformarCreditoOtorgadoResponse }
     * 
     */
    public InformarCreditoOtorgadoResponse createInformarCreditoOtorgadoResponse() {
        return new InformarCreditoOtorgadoResponse();
    }

    /**
     * Create an instance of {@link InformarCreditoOtorgado }
     * 
     */
    public InformarCreditoOtorgado createInformarCreditoOtorgado() {
        return new InformarCreditoOtorgado();
    }

    /**
     * Create an instance of {@link InformarCreditoFinalizadoResponse }
     * 
     */
    public InformarCreditoFinalizadoResponse createInformarCreditoFinalizadoResponse() {
        return new InformarCreditoFinalizadoResponse();
    }

    /**
     * Create an instance of {@link ObtenerEstadoCliente }
     * 
     */
    public ObtenerEstadoCliente createObtenerEstadoCliente() {
        return new ObtenerEstadoCliente();
    }

    /**
     * Create an instance of {@link InformarCreditoFinalizado }
     * 
     */
    public InformarCreditoFinalizado createInformarCreditoFinalizado() {
        return new InformarCreditoFinalizado();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultadoEstadoCliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "ObtenerEstadoClienteResult", scope = ObtenerEstadoClienteResponse.class)
    public JAXBElement<ResultadoEstadoCliente> createObtenerEstadoClienteResponseObtenerEstadoClienteResult(ResultadoEstadoCliente value) {
        return new JAXBElement<ResultadoEstadoCliente>(_ObtenerEstadoClienteResponseObtenerEstadoClienteResult_QNAME, ResultadoEstadoCliente.class, ObtenerEstadoClienteResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "identificadorCredito", scope = InformarCreditoFinalizado.class)
    public JAXBElement<String> createInformarCreditoFinalizadoIdentificadorCredito(String value) {
        return new JAXBElement<String>(_InformarCreditoFinalizadoIdentificadorCredito_QNAME, String.class, InformarCreditoFinalizado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "codigoFinanciera", scope = InformarCreditoFinalizado.class)
    public JAXBElement<String> createInformarCreditoFinalizadoCodigoFinanciera(String value) {
        return new JAXBElement<String>(_InformarCreditoFinalizadoCodigoFinanciera_QNAME, String.class, InformarCreditoFinalizado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultadoOperacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "InformarCreditoOtorgadoResult", scope = InformarCreditoOtorgadoResponse.class)
    public JAXBElement<ResultadoOperacion> createInformarCreditoOtorgadoResponseInformarCreditoOtorgadoResult(ResultadoOperacion value) {
        return new JAXBElement<ResultadoOperacion>(_InformarCreditoOtorgadoResponseInformarCreditoOtorgadoResult_QNAME, ResultadoOperacion.class, InformarCreditoOtorgadoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "identificadorCredito", scope = InformarCreditoOtorgado.class)
    public JAXBElement<String> createInformarCreditoOtorgadoIdentificadorCredito(String value) {
        return new JAXBElement<String>(_InformarCreditoFinalizadoIdentificadorCredito_QNAME, String.class, InformarCreditoOtorgado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "codigoFinanciera", scope = InformarCreditoOtorgado.class)
    public JAXBElement<String> createInformarCreditoOtorgadoCodigoFinanciera(String value) {
        return new JAXBElement<String>(_InformarCreditoFinalizadoCodigoFinanciera_QNAME, String.class, InformarCreditoOtorgado.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "codigoFinanciera", scope = ObtenerEstadoCliente.class)
    public JAXBElement<String> createObtenerEstadoClienteCodigoFinanciera(String value) {
        return new JAXBElement<String>(_InformarCreditoFinalizadoCodigoFinanciera_QNAME, String.class, ObtenerEstadoCliente.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultadoOperacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ISTP1.Service.Contracts.Service", name = "InformarCreditoFinalizadoResult", scope = InformarCreditoFinalizadoResponse.class)
    public JAXBElement<ResultadoOperacion> createInformarCreditoFinalizadoResponseInformarCreditoFinalizadoResult(ResultadoOperacion value) {
        return new JAXBElement<ResultadoOperacion>(_InformarCreditoFinalizadoResponseInformarCreditoFinalizadoResult_QNAME, ResultadoOperacion.class, InformarCreditoFinalizadoResponse.class, value);
    }

}
