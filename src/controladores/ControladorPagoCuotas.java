/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Cliente;
import modelos.Credito;
import modelos.Cuota;
import modelos.Empleado;
import modelos.Pago;
import modelos.RepositorioCliente;
import modelos.RepositorioCredito;
import modelos.RepositorioPago;
import org.tempuri.IServicioPublicoCreditoInformarCreditoFinalizadoErrorServicioFaultFaultMessage;
import vistas.PagoCuotas;

/**
 *
 * @author Your Name <your.name at your.org>
 */
class ControladorPagoCuotas implements ActionListener {
    Empleado empleado;
    RepositorioCredito repo_creditos; // repositorio de los creditos
    PagoCuotas vista;
     ArrayList<Cuota> todaslascuotas;
    Date fecha_actual ;
    Cliente cliente_seleccionado;
    RepositorioPago repo_pagos ;
    RepositorioCliente repo_cliente;
    int cantidad_cuotas_vencidas;
    
    ControladorPagoCuotas(Empleado empleado, RepositorioCredito repo_creditos, Cliente cliente_seleccionado, RepositorioCliente repo_cliente){
       this.empleado = empleado; 
       this.repo_creditos=repo_creditos;
       vista = new PagoCuotas();
       fecha_actual= new Date(); // FECHA ACTUAL
       this.cliente_seleccionado = cliente_seleccionado;
       todaslascuotas = new ArrayList<>();
       ArrayList<Credito> creditos_del_cliente = repo_creditos.obtenerCreditos(cliente_seleccionado.getDni());
        creditos_del_cliente.forEach((cred) -> {
            todaslascuotas.addAll(cred.CuotasNoPagadas(fecha_actual));
        });
        todaslascuotas = repo_creditos.ordenarCuotas(todaslascuotas);// ORDENAMOS LAS CUOTAS DE MENOR A MAYOR
        cantidad_cuotas_vencidas = repo_creditos.cantidad_cuotas_vencidas(todaslascuotas);
        cliente_seleccionado.actualizarEstado(cantidad_cuotas_vencidas);
        
       
        this.repo_cliente = repo_cliente;
        repo_pagos = new RepositorioPago();
        

       vista.boton_confirmar_pago.addActionListener(this);
       vista.boton_cancelar.addActionListener(this);
       vista.cargarCreditos(todaslascuotas);
       vista.iniciar();
       if(cliente_seleccionado.isMoroso()){
           
            JOptionPane.showMessageDialog(null, "Cliente esta moroso, posee dos o mas cuotas vencidas");
           
       }
       
       
       
       
       
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.boton_confirmar_pago){
            
///////////////////------------PAGO CUOTAS POR MONTO --------------------------
//------------------------------------------------------------------------

           if(vista.radioPagoMonto.isSelected()){
               
               
               
             
              int num_pago= repo_pagos.ProximoNumeroDePago();
              //Creacion del pago, dentro del contructor se calcula las cuotas que se pudieron pagar y se actualizo el estado de ellas
              Pago pago = new Pago(num_pago, Double.parseDouble(vista.monto_enviado.getText()), todaslascuotas);
              repo_pagos.registrarPago(pago); // Almacenamos el pago en el repositorio de pagos
              
              // Actualizamos el estado del Cliente
               cantidad_cuotas_vencidas = repo_creditos.cantidad_cuotas_vencidas(todaslascuotas);
                cliente_seleccionado.actualizarEstado(cantidad_cuotas_vencidas); // Actualizamos el estado del cliente despues de pagar
                
               try {
                   //Revisar  los creditos que pudieron finalizar para informar al servicio publico
                   repo_creditos.finalizarCreditosPagados(cliente_seleccionado.getDni());
               } catch (IServicioPublicoCreditoInformarCreditoFinalizadoErrorServicioFaultFaultMessage ex) {
                   Logger.getLogger(ControladorPagoCuotas.class.getName()).log(Level.SEVERE, null, ex);
               }finally {
                   JOptionPane.showMessageDialog(null, "Registro de Pago exitoso");
                   vista.dispose();
                   ControladorMenu controlador= new ControladorMenu(empleado,repo_creditos,repo_cliente);// REGRESAMOS AL MENU
               }
               
                
              
               
           }
           
 ///////////////////------------PAGO CUOTAS POR NUMERO DE CUOTAS --------------------------  
//------------------------------------------------------------------------ 
           else{
               int[] array_auxiliar =  vista.tablaCuotas.getSelectedRows();
                ArrayList<Cuota> cuotas_seleccionadas_a_pagar = new ArrayList();
               for(int indice: array_auxiliar){
              
                 cuotas_seleccionadas_a_pagar.add(todaslascuotas.get(indice)); //AGREGA LAS CUOTAS SELECCIONADAS
                   
               }
               
               int num_pago= repo_pagos.ProximoNumeroDePago();
               Pago pago = new Pago(num_pago, cuotas_seleccionadas_a_pagar); 
               
               
               repo_pagos.registrarPago(pago); // Almacenamos el pago en el repositorio de pagos
              
              // Actualizamos el estado del Cliente

              cantidad_cuotas_vencidas = repo_creditos.cantidad_cuotas_vencidas(todaslascuotas);
                cliente_seleccionado.actualizarEstado(cantidad_cuotas_vencidas); // Actualizamos el estado del cliente despues de pagar
                
               try {
                   //Revisar  los creditos que pudieron finalizar para informar al servicio publico
                   repo_creditos.finalizarCreditosPagados(cliente_seleccionado.getDni());
               } catch (IServicioPublicoCreditoInformarCreditoFinalizadoErrorServicioFaultFaultMessage ex) {
                   Logger.getLogger(ControladorPagoCuotas.class.getName()).log(Level.SEVERE, null, ex);
               } finally {
                   JOptionPane.showMessageDialog(null, "Registro de Pago exitoso");
                   vista.dispose();
                   ControladorMenu controlador= new ControladorMenu(empleado,repo_creditos,repo_cliente);// REGRESAMOS AL MENU
               }
               
               
           }

        }
///////////////////////---------------- BOTON CANCELAR ------------

          if(e.getSource()== vista.boton_cancelar){
              
              vista.dispose();
              ControladorMenu controlador= new ControladorMenu(empleado,repo_creditos,repo_cliente);// REGRESAMOS AL MENU
          }
        
        
        
    }
    
}
