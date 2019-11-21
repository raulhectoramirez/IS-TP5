/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Cliente;
import modelos.Credito;
import modelos.Empleado;
import modelos.Pago;
import modelos.Plan;
import modelos.PlanCuotaAdelantada;
import modelos.RepositorioCliente;
import modelos.RepositorioCredito;
import modelos.RepositorioPago;
import modelos.RepositorioPlan;
import modelos.ServicioPublico;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoOperacion;
import org.tempuri.IServicioPublicoCreditoInformarCreditoOtorgadoErrorServicioFaultFaultMessage;
import vistas.SolicitudCredito;


class ControladorSolicitud implements ActionListener{
    
    private Empleado empleado;
    private Cliente  cliente_seleccionado;
    private SolicitudCredito vista; 
    private RepositorioPlan repo_planes;
    Credito credito_actual;
    RepositorioCredito repo_creditos;
    RepositorioCliente repo_clientes;
    private RepositorioPago repo_pagos;
    
    ControladorSolicitud(Empleado empleado, Cliente cliente_seleccionado,RepositorioCredito repo_creditos, int cantidad_creditos_activos, RepositorioCliente repo_clientes ) {
        
        // NECESITAMOS AL EMPLEADO QUE REGISTRA EL CREDITO Y AL CLIENTE QUE LO SOLICITA 
        this.empleado = empleado;
        this.cliente_seleccionado = cliente_seleccionado;
        
      // CONFIGURAMOS LA VISTA
        vista = new SolicitudCredito();
        vista.cargarDatosDelCliente(cliente_seleccionado,cantidad_creditos_activos);
        
        
        this.repo_clientes =  repo_clientes;
        // traemos el repositorio de creditos donde almacenaremos el credito si se registra
        this.repo_creditos =  repo_creditos;
        
        // DATOS QUE NECESITA LA VISTA
        repo_planes = new RepositorioPlan();
        ArrayList<Plan> planes = new ArrayList();
        planes = repo_planes.obtenerPlanes(); //PLANES
        
        //BOTONES QUE ESCUCHAREMOS
        vista.botonSeleccionar.addActionListener(this);
        vista.botonConfirmar.addActionListener(this);
        
        
        
        vista.cargarPlanes(planes); // CARGAR PLANES EN LA VISTA Y LA INICIAMOS
        vista.iniciar();
        
        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                
//--------------------- SELECCIONAR Y CALCULAR CREDITO-----------------------------
//--------------------------------------------------------------------------------
        
                if(e.getSource() == vista.botonSeleccionar){

                    // Buscamos el plan

                        Plan plan_seleccionado =    repo_planes.buscarPlan(vista.comboPlanes.getSelectedIndex()+1);

                         credito_actual = new Credito(

                        /*plan */                  plan_seleccionado,vista.input_identificador.getText(),
                        /*Fecha de solicitud */    vista.input_fecha_solicitud.getDate(),
                        /*Monto del credito */     Double.parseDouble(vista.inputMontoSolicitado.getText()),
                        /*cliente */               cliente_seleccionado.getDni(),
                        /*empleado */              empleado.getLegajo());

                            
                        //VALIDACION
                    if(credito_actual.noEsValido()!= null){
                        // Si No es Valido muestra el error
                        JOptionPane.showMessageDialog(null, credito_actual.noEsValido());
                    }else {
                        // Caso contrario, osea valido Mostramos en la vista como quedaria el credito antes de confirmalo

                        vista.mostrarDetalle(credito_actual);

                    }}
                
                
                
//-------------------------- CONFIRMAR CREDITO  Y REGISTRARLO ----------------------------------
//-------------------------------------------------------------------------------------
                 if(e.getSource() == vista.botonConfirmar){
                 
                 
                    ServicioPublico servicio = new ServicioPublico();
                    try {
                        // TRATAMOS DE  INFORMAR EL CREDITO AL SERVICIO
                        ResultadoOperacion respuesta_del_servicio = servicio.InformarCreditoOtorgado(
                                credito_actual.getDni_cliente(), 
                                credito_actual.getNro_credito(),
                                credito_actual.getMonto_solicitado() );
                        
                        
                        if(respuesta_del_servicio.isOperacionValida()){
                            
                            // si esta todo ok lo almacenamos al credito
                            repo_creditos.RegistrarCredito(credito_actual);
                            JOptionPane.showMessageDialog(null, "Credito Registrado Correctamente");
                            
                            
                            if(credito_actual.isPlanAdelantada()){
                                
                               
                                
                                // PAGAR PRIMERA CUOTA
                                repo_pagos = new RepositorioPago();
                                int num_pago= repo_pagos.ProximoNumeroDePago();
                                 Pago pago = new Pago(num_pago, credito_actual.obtenerPrimeraCuota()); 
                                 repo_pagos.registrarPago(pago);
                                
                                //Aca se deberia imprimir el comprobante
                                
                                String mensaje = "Debe abonar la primera cuota $" + pago.getMonto();
                                System.err.println(mensaje);
                                JOptionPane.showMessageDialog(null, mensaje);
                            }
                            
                            
                            
                            vista.dispose();
                            ControladorMenu controlador =  new ControladorMenu(empleado, repo_creditos,repo_clientes);// rediceccionamos al menu
                            
                            
                            
                            
                           
                            
                        }else {
                            // En caso que sea rechazado el credito mostramos el mensaje
                            JOptionPane.showMessageDialog(null, respuesta_del_servicio.getError().getValue());
                        }
                        
                    } catch (IServicioPublicoCreditoInformarCreditoOtorgadoErrorServicioFaultFaultMessage ex) {
                        Logger.getLogger(ControladorSolicitud.class.getName()).log(Level.SEVERE, null, ex);
                        // CASO QUE NO SE PUEDA CONECTAR AL SERVICIO REGISTRAMOS EL CREDITO COMO PENDIENTE
                        
                        credito_actual.pendiente(); //
                        repo_creditos.RegistrarCredito(credito_actual);
                        JOptionPane.showMessageDialog(null, "Fallo de conexion, Credito Registrado como pendiente");
                           
                         
                           if(credito_actual.isPlanAdelantada() ){
                                
                                repo_pagos = new RepositorioPago();
                                int num_pago= repo_pagos.ProximoNumeroDePago();
                                 Pago pago = new Pago(num_pago, credito_actual.obtenerPrimeraCuota()); 
                                 repo_pagos.registrarPago(pago);
                                // PAGAR PRIMERA CUOTA
                                //Aca se deberia imprimir el comprobante
                                String mensaje = "Debe abonar la primera cuota $" + pago.getMonto();
                                System.err.println(mensaje);
                                JOptionPane.showMessageDialog(null, mensaje);
                            }
                        
                        vista.dispose();
                        ControladorMenu controlador =  new ControladorMenu(empleado, repo_creditos, repo_clientes);// rediceccionamos al menu
                        
                    }
                    
                 }
                 
                 
    }
                
                
 }
    
    
  
    

