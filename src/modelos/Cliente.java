/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Your Name <your.name at your.org>
 */
public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;
    private String domicilio;
    private Double sueldo;
    private String telefono;
    private boolean moroso;

    public Cliente(int dni, String nombre, String apellido, String domicilio, Double sueldo, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.sueldo = sueldo;
        this.telefono = telefono;
        this.moroso = false;
    }

    /**
     * @return the dni
     */
    public int getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(int dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return the sueldo
     */
    public Double getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the moroso
     */
    public boolean isMoroso() {
        return moroso;
    }

    /**
     * @param moroso the moroso to set
     */
    public void setMoroso(boolean moroso) {
        this.moroso = moroso;
    }



    public void actualizarEstado(int cantidad_cuotas_vencidas) {
        if(cantidad_cuotas_vencidas>1){
            
            setMoroso(true);
        }else{
            setMoroso(false);
        }
    }
    
    
    
    
    
}
