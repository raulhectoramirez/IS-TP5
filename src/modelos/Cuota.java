/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.Date;

/**
 *
 * @author Your Name <your.name at your.org>
 */
 enum EstadoCuota{
        ACTIVA, VENCIDA, PAGADA;
       
    }
public class Cuota {

    public static void ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int nro;
    private Date fecha_vencimiento;
    private Double monto;
    private Double recargo;
    private EstadoCuota estado;

    public Cuota(int nro, Date fecha_vencimiento, Double monto) {
        this.nro = nro;
        this.fecha_vencimiento = fecha_vencimiento;
        this.monto = monto;
        this.recargo = 0.0;
        estado = EstadoCuota.ACTIVA;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getRecargo() {
        return recargo;
    }

    public void setRecargo(Double recargo) {
        this.recargo = recargo;
    }

    public EstadoCuota getEstado() {
        return estado;
    }

    public void finalizar( ) {
        this.setEstado(EstadoCuota.PAGADA);
    }
     public void activar( ) {
         this.setEstado(EstadoCuota.ACTIVA);
    }
      public void vencer( ) {
          this.setEstado(EstadoCuota.VENCIDA);
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoCuota estado) {
        this.estado = estado;
    }
    
    public int dias_vencimiento(Date fecha){
        
        int dias=(int) ((fecha.getTime()-getFecha_vencimiento().getTime())/86400000);
        
        
        if(dias>0){
            this.vencer(); // Actulizar estado a vencida
            setRecargo(monto * 0.005 * dias); // cargar el recargo
            
        }
        
        
        
        
        return dias;
    }
}
