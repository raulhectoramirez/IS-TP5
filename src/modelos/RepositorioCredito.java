/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoOperacion;
import org.tempuri.IServicioPublicoCreditoInformarCreditoFinalizadoErrorServicioFaultFaultMessage;

/**
 *
 * @author Your Name <your.name at your.org>
 */
public class RepositorioCredito {
    

   ArrayList <Credito> creditos;

    public RepositorioCredito() {
        
        
        creditos = new ArrayList() ;
      
        
 
    }
    
    public void RegistrarCredito(Credito credito){
        creditos.add(credito);
        
    }
    
    public ArrayList<Credito> obtenerCreditos(int dni){
        
        ArrayList <Credito> creditosdelcliente = new ArrayList();
        creditos.forEach((credito)->{
        if(credito.getDni_cliente()== dni && credito.getEstado()==Credito.EstadoCredito.ACTIVO){
           creditosdelcliente.add(credito);
        }
        });
        
        return creditosdelcliente;
    }

    public ArrayList<Cuota> ordenarCuotas(ArrayList<Cuota> todaslascuotas) {
    
  
    
    // ORDENAMIENTO DE BURBUJA
   for (int x = 0; x < todaslascuotas.size(); x++) {
     for (int i = 0; i < todaslascuotas.size()-x-1; i++) {
            if(todaslascuotas.get(i).getFecha_vencimiento().getTime() > todaslascuotas.get(i+1).getFecha_vencimiento().getTime()){
                Cuota tmp = todaslascuotas.get(i+1);
                todaslascuotas.set(i+1, todaslascuotas.get(i));
                todaslascuotas.set(i, tmp);
       
            }
        }
    }
    
    
    
    
    
    return todaslascuotas;
    
    }

    public int cantidad_cuotas_vencidas(ArrayList<Cuota> todaslascuotas) {
        int cantidad = 0;
        
        for(Cuota cuota: todaslascuotas){
        if(cuota.getEstado()==EstadoCuota.VENCIDA){
            cantidad=cantidad+1;
        }}
        
        return cantidad;
    }

    public void finalizarCreditosPagados(int dni) throws IServicioPublicoCreditoInformarCreditoFinalizadoErrorServicioFaultFaultMessage {
        
       ArrayList<Credito> creditos_del_cliente = obtenerCreditos(dni);
       
       for(Credito credito: creditos_del_cliente){
           
           ArrayList<Cuota> cuotas_credito = credito.getCuotas();
           boolean finaliza=true;
           for(Cuota cuota: cuotas_credito){
              
               if(cuota.getEstado()!=EstadoCuota.PAGADA){ // SI ALGUNA CUOTA NO ESTA PAGADA no se finaliza el credito
                   finaliza=false;
               }
           }
           if(finaliza){ // SI Se finaliza se registra en el servicio publico 
               ServicioPublico s = new ServicioPublico();
               ResultadoOperacion respuesta = s.InformarCreditoFinalizado(dni, credito.getNro_credito());
               if(respuesta.isOperacionValida()){
                  credito.finalizar(); // SI LA OPERACION SE REALIZO CORRECTAMENTE SE FINALIZA
               }else{
                   credito.pendienteFinalizacion(); // SI FALL QUEDA PENDIENTE DE FINALIZACION
               }
               
           }
           
       }
       
       
       
    }
    

}
