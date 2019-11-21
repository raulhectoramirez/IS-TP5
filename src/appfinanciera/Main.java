/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfinanciera;

import modelos.*;
import vistas.*;
import controladores.*;
import java.util.Calendar;
import java.util.Date;
import org.datacontract.schemas._2004._07.sge_service_contracts.ResultadoEstadoCliente;
import org.tempuri.IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage;
/**
 *
 * @author Your Name <your.name at your.org>
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws org.tempuri.IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage
     */
    public static void main(String[] args) throws IServicioPublicoCreditoObtenerEstadoClienteErrorServicioFaultFaultMessage {
//       ServicioPublico p = new ServicioPublico();
//        ResultadoEstadoCliente resultado = p.ObtenerEstadoCliente("", 0);
       
    ControladorLogin controlador= new ControladorLogin();

    
}}
