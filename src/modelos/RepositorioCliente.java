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
public class RepositorioCliente {

    public ArrayList<Cliente> getClientes() {
        return Clientes;
    }
    

   
    ArrayList <Cliente> Clientes;
   
// documentos válidos para consultas van en el rango de: 33000000 a 33000999
    public RepositorioCliente() {
        Clientes = new ArrayList() ;
        Cliente c1 = new Cliente(33000821, "Carlos","Diaz","San Juan 129",34000.0 ,"3814566721" );
        Cliente c2 = new Cliente(33000657, "Maria","Araoz","San Luis 19",41000.0 , "3816522728" );
        Clientes.add(c1);
        Clientes.add(c2);
    }
    
      public Cliente buscar(int dni){
        
        for (Cliente cliente : Clientes) 
                { 
                if(cliente.getDni()== dni){
                    return cliente;
                }
        }
        
        
        return null;
    }

    public Cliente agregarCliente(int dni, String nombre, String apellido, String domicilio, double sueldo, String telefono) {
        Cliente client = new Cliente(dni,  nombre,  apellido,  domicilio,  sueldo,  telefono);
        boolean add = Clientes.add(client);
        return client;
    }

}
