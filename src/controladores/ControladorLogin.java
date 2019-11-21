/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.*;
import vistas.*;

/**
 *
 * @author Your Name <your.name at your.org>
 */
public class ControladorLogin implements ActionListener{
    
    Login vista;
    RepositorioEmpleado repo_empleado ;
    RepositorioCredito repo_credito;
    RepositorioCliente repo_cliente;
    

    public ControladorLogin() {
        vista = new Login();
        repo_empleado = new RepositorioEmpleado();
        
        vista.boton_ingresar.addActionListener(this);
        vista.iniciar();
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource()== vista.boton_ingresar){
            
            Empleado empleado = this.repo_empleado.Autenticar(vista.username.getText(), vista.password.getText());
            if(empleado != null){
                System.out.println("Te has logueado");
                this.vista.dispose();
                 repo_credito = new RepositorioCredito();
                 repo_cliente = new RepositorioCliente();
                ControladorMenu controlador = new ControladorMenu(empleado,repo_credito,repo_cliente);
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuario o password incorrectos, intente nuevamente");
            }
     
        }
        
        
        
        
        
    }
    
}
