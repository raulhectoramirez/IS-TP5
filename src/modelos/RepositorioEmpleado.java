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
public class RepositorioEmpleado {
    
    ArrayList <Empleado> Usuarios;
   

    public RepositorioEmpleado() {
        Usuarios = new ArrayList() ;
        Empleado debora = new Empleado("debora", "1234",100, "Debora", "Villafañe" );
        Usuarios.add(debora);
    }

    public ArrayList<Empleado> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(ArrayList<Empleado> Usuarios) {
        this.Usuarios = Usuarios;
    }
    
    
    public Empleado Autenticar(String username,String password){
        
        for (Empleado usuario : Usuarios) 
                { 
                if(usuario.getUsername().equals(username) &&  usuario.getPassword().equals(password)){
                    return usuario;
                }
        }
        
        
        return null;
    }
}
