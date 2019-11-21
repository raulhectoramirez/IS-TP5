/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.*;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoEstadoCliente;
import org.tempuri.IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage;
import vistas.*;

/**
 *
 * @author Your Name <your.name at your.org>
 */
public class ControladorMenu implements ActionListener {
    
    
    
    
    
     MenuPrincipal vista ;
     RepositorioCliente repo_cliente;
     Empleado empleado;
     Cliente cliente_seleccionado;
     RepositorioCredito repo_creditos;
     
     


    public ControladorMenu(Empleado empleado, RepositorioCredito repo_creditos, RepositorioCliente repo_cliente) {
        this.empleado = empleado;
        vista = new MenuPrincipal();
        this.repo_creditos = repo_creditos;
        this.repo_cliente = repo_cliente;
        vista.iniciar();
        vista.botonBuscar.addActionListener(this);
        vista.botonNuevoCliente.addActionListener(this);
        vista.botonRegistrarCliente.addActionListener(this);
        vista.botonSolicitarCredito.addActionListener(this);
        vista.boton_abonar_cuotas.addActionListener(this);
        
    }

           @Override
        public void actionPerformed(ActionEvent evento) {
            
//------------------------------------------------------------------------------------------------            
//-------------------------------------- OPCION BUSCAR CLIENTE -------------------------------
//---------------------------------------------------------------------------------------------
            if(evento.getSource()== vista.botonBuscar){

                 cliente_seleccionado = repo_cliente.buscar(Integer.parseInt(vista.inputDni1.getText()));
                if(cliente_seleccionado != null){

                    vista.cargarCliente(cliente_seleccionado);

                }else{
                    JOptionPane.showMessageDialog(null, "Cliente No encontrado, Ingrese nuevamente el dni");
                }

            }
        
//------------------------------------------------------------------------------------------------            
//-------------------------------------- OPCION NUEVO CLIENTE -------------------------------
//---------------------------------------------------------------------------------------------
            if(evento.getSource()== vista.botonNuevoCliente){

                    vista.nuevoCliente();

            }

//------------------------------------------------------------------------------------------------            
//-------------------------------------- OPCION REGISTRAR NUEVO CLIENTE -------------------------------
//---------------------------------------------------------------------------------------------
         if(evento.getSource()== vista.botonRegistrarCliente){
            
            
             
             if(!"".equals(vista.inputDniRegistro.getText()) 
                && !"".equals(vista.inputApellido.getText()) 
                &&  !"".equals(vista.inputNombre.getText())
                && !"".equals(vista.inputDomicilio.getText())
                &&  !"".equals(vista.inputSueldo.getText())
                &&   !"".equals(vista.inputTelefono.getText()))

               cliente_seleccionado = repo_cliente.agregarCliente(
               Integer.parseInt(vista.inputDniRegistro.getText()),
               vista.inputNombre.getText(),
               vista.inputApellido.getText(),
               vista.inputDomicilio.getText(),
               Double.parseDouble(vista.inputSueldo.getText()),
               vista.inputTelefono.getText()
               );
                if (cliente_seleccionado != null){
                // Relogueo a datos del cliente
                    vista.cargarCliente(cliente_seleccionado);
                    JOptionPane.showMessageDialog(null, "Cliente Registrado Exitosamente");
                }else{
                JOptionPane.showMessageDialog(null, "Error en los campos, revise e intente nuevamente");
            }
             
            
            } 

         
//------------------------------------------------------------------------------------------------            
//-------------------------------------- OPCION SOLICITAR NUEVO CREDITO -------------------------------
//---------------------------------------------------------------------------------------------
         
         if(evento.getSource()== vista.botonSolicitarCredito){
             
             // validacion de cliente
             ServicioPublico p = new ServicioPublico();
                
                try {
                    ResultadoEstadoCliente resultado = p.ObtenerEstadoCliente(cliente_seleccionado.getDni());
                   
//                    System.out.println(resultado.getError());
                    
                    if(resultado.isConsultaValida()){
                        // Consulta valida
                        
                        
                        // Validando que el cliente no tenga mas 3 creditos activos 
                       if(resultado.getCantidadCreditosActivos() > 2){ // para probar cosas
                            
                            JOptionPane.showMessageDialog(null, "El cliente no puede tener más de 3(tres) créditos activos");

                        }else 
                             if(resultado.isTieneDeudas()){

                            JOptionPane.showMessageDialog(null, "El cliente presenta deudas");

                             
                        } else{
                            
                        vista.dispose();
                       
                        
                        ControladorSolicitud controlador =  new ControladorSolicitud(empleado, cliente_seleccionado, repo_creditos,resultado.getCantidadCreditosActivos(), repo_cliente);
                            
                        }  }
                        
                        // Mostrando los errores de la consulta
                        
                        
                        
                        //      System.out.println(resultado.getError());
                        
                        // Validando que el cliente no tenga deudas
                 

                        
                } catch (IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage ex) {
                    Logger.getLogger(ControladorMenu.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Eror de conexion");

                }
                
                
                
             
         }
         
         
//------------------------------------------------------------------------------------------------            
//-------------------------------------- OPCION PAGAR CUOTAS DEL CLIENTE -------------------------------
//---------------------------------------------------------------------------------------------
        
            if(evento.getSource()== vista.boton_abonar_cuotas){

                    vista.dispose();
                    ControladorPagoCuotas controlador = new ControladorPagoCuotas(empleado, repo_creditos,cliente_seleccionado, repo_cliente);
                    
                          

            }





    }

}
