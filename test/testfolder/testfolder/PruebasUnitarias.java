package testfolder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;

import java.util.ArrayList;

import modelos.Cliente;

import modelos.Cuota;
import modelos.Empleado;
import modelos.RepositorioCliente;

import modelos.RepositorioEmpleado;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Debora
 */
public class PruebasUnitarias {
    
    public PruebasUnitarias() {
    }
    


 

    @Test
    public void PruebaBuscarDniClienteExistente(){
        
        // Preparacion de la prueba
        RepositorioCliente repositorio = new RepositorioCliente();
        ArrayList<Cliente> Clientes = repositorio.getClientes();
        Cliente juanito = new Cliente(34258147, "Juan","Nito","San Juan 192",45000.0 , "3812134728" );
        Clientes.add(juanito);
        
        //Ejecucion de la prueba
        Cliente cliente_encotrado = repositorio.buscar(34258147);
        
        //Analisis de la prueba
        assertEquals(cliente_encotrado, juanito);
        
    }
    
    
    
    
    @Test
    public void PruebaNoEncontrarClienteDniDiferente(){
        
        // Preparacion de la prueba
        RepositorioCliente repositorio = new RepositorioCliente();
        ArrayList<Cliente> Clientes = repositorio.getClientes();
        Cliente josesito = new Cliente(33000000, "Jose","Sito","San Juan 192",45000.0 , "3812134728" );
        Clientes.add(josesito);
        
        //Ejecucion de la prueba
        Cliente cliente_encotrado = repositorio.buscar(14213456);
        
        //Analisis de la prueba
        assertNotEquals(cliente_encotrado, josesito);
        
    }
    
       @Test
    public void PruebaObtenerDiasDeVencimientoCuota(){

  
        Date fecha_vencimiento = new Date(2019, 11, 15);
        Cuota cuota = new Cuota(1, fecha_vencimiento, 25041.1);
        
        Date fecha_pago = new Date(2019, 11, 20);
        
        
        
        
        int dias_de_vencimiento = cuota.dias_vencimiento(fecha_pago);
        
         
        assertEquals(5, dias_de_vencimiento);
        
   
        
    }
    
    
     
    
  
    @Test
    public void PruebaRecargoCuotaVencida(){

        // POR DIA DEBE TENER 0.5 % de recargo del monto
        Date fecha_vencimiento = new Date(2019, 11, 15);
        Cuota cuota = new Cuota(1, fecha_vencimiento, 100.00);
        
        Date fecha_pago = new Date(2019, 11, 20);
        
        
        
        
       cuota.dias_vencimiento(fecha_pago);
       Double recargo = cuota.getRecargo();
       
        
        
                                   // Delta-Margen de error
        assertEquals(2.5, recargo, 0.1);
        
   
        
    }
    
    @Test
    public void PruebaAutenticacionFallidaUsuario(){
        
        RepositorioEmpleado repositorio= new RepositorioEmpleado();
        Empleado pepito = new Empleado("usuario", "pass",102, "Pepito", "Sanchez" );
        repositorio.getUsuarios().add(pepito);
        
        Empleado usuario_encontrado = repositorio.Autenticar("otrousuario", "otropassword");
         
        assertNotEquals(usuario_encontrado, pepito);
        
   
        
    }
    
    
  
      @Test
    public void PruebaAutenticacionExitosaUsuario(){
        
        RepositorioEmpleado repositorio= new RepositorioEmpleado();
        Empleado raul = new Empleado("usuario", "pass",102, "Raul", "Martinez" );
        repositorio.getUsuarios().add(raul);
        
        Empleado usuario_encontrado = repositorio.Autenticar("usuario", "pass");
         
        assertEquals(usuario_encontrado, raul);
        
   
        
    }
    
    
    
    

}
