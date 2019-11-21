/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author Your Name <your.name at your.org>
 */
public class RepositorioPago {
    
    
    ArrayList <Pago> pagos;

    public RepositorioPago() {
        
        
        pagos = new ArrayList() ;
      
        
 
    }
    
   public void registrarPago(Pago pago){
       pagos.add(pago);
       
   }
   
   
   public int ProximoNumeroDePago(){
     int ultimo_numero = 99;
   for(Pago pago: pagos){
      ultimo_numero = pago.getNro_pago();
   }
   
   return ultimo_numero+1;
   }
    
}
