package modelos;

import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoEstadoCliente;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoOperacion;
import org.tempuri.IServicioPublicoCreditoInformarCreditoFinalizadoErrorServicioFaultFaultMessage;
import org.tempuri.IServicioPublicoCreditoInformarCreditoOtorgadoErrorServicioFaultFaultMessage;
import org.tempuri.IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage;
import org.tempuri.ServicioPublicoCredito;

public class ServicioPublico {


		private ServicioPublicoCredito client;
		private String codigoFinanciera;
		

        public ServicioPublico( ) {
			super();
			this.client =  new ServicioPublicoCredito();
                        this.codigoFinanciera = "f1e939ce-5126-4d42-a1a4-66ba1244218c"; // codigo guid
		}
		
        
        public ResultadoEstadoCliente ObtenerEstadoCliente( int dni) throws IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage {
        	
        	return  client.getSGEBusService().obtenerEstadoCliente(codigoFinanciera, dni);
        	
        }
        
        
        public ResultadoOperacion InformarCreditoOtorgado( int dni,String identificadorCredito, double montoOtorgado) throws IServicioPublicoCreditoInformarCreditoOtorgadoErrorServicioFaultFaultMessage {
        	
        	return  client.getSGEBusService().informarCreditoOtorgado(codigoFinanciera, dni, identificadorCredito, montoOtorgado);
        }
        
        
        public ResultadoOperacion InformarCreditoFinalizado(int dni,String identificadorCredito) throws IServicioPublicoCreditoInformarCreditoFinalizadoErrorServicioFaultFaultMessage {
        	 
        	return client.getSGEBusService().informarCreditoFinalizado(  codigoFinanciera,  dni,
            		 identificadorCredito);
        }
        			
        
     


	

}
