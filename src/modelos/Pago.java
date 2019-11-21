/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Your Name <your.name at your.org>
 */
public class Pago {
    
    private int nro_pago;
    private int nro_cuotas;
    private Double intereses;
    private Double monto;
    private Date fecha;
    private ArrayList<LineaPago> lineas_pago;
    private Double vuelto;

 
    // Constructor Del pago por monto
    public Pago(int numero_pago, double monto_pagado, ArrayList<Cuota> cuotas) {
        
        this.fecha = new Date();
        lineas_pago = new ArrayList();
        creacionLineasDePago(monto_pagado, cuotas);
        this.nro_pago= numero_pago;
        
        
    
               
                
     }

    public Pago(int numero_pago, ArrayList<Cuota> cuotas_seleccionadas_a_pagar ) {
        this.nro_pago= numero_pago;
        this.fecha = new Date();
        lineas_pago = new ArrayList();
        
        creacionLineasDePago(cuotas_seleccionadas_a_pagar);


    }
            
            
            
        
       
    

    /**
     * @return the nro_pago
     */
    public int getNro_pago() {
        return nro_pago;
    }

    /**
     * @param nro_pago the nro_pago to set
     */
    public void setNro_pago(int nro_pago) {
        this.nro_pago = nro_pago;
    }

    /**
     * @return the nro_cuotas
     */
    public int getNro_cuotas() {
        return nro_cuotas;
    }

    /**
     * @param nro_cuotas the nro_cuotas to set
     */
    public void setNro_cuotas(int nro_cuotas) {
        this.nro_cuotas = nro_cuotas;
    }

    /**
     * @return the intereses
     */
    public Double getIntereses() {
        return intereses;
    }

    /**
     * @param intereses the intereses to set
     */
    public void setIntereses(Double intereses) {
        this.intereses = intereses;
    }

    /**
     * @return the monto
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the lineas_pago
     */
    public ArrayList<LineaPago> getLineas_pago() {
        return lineas_pago;
    }

    /**
     * @param lineas_pago the lineas_pago to set
     */
    public void setLineas_pago(ArrayList<LineaPago> lineas_pago) {
        this.lineas_pago = lineas_pago;
    }
    
    
    public void creacionLineasDePago(Double monto_pagado,ArrayList<Cuota>cuotas){
        Double total_cuota=0.0;
        Double monto_parcial= 0.0;
        Double interes_total= 0.0;
        int cuotas_pagadas=0;
        
        for(Cuota cuota: cuotas){
            total_cuota = cuota.getMonto()+cuota.getRecargo();
            monto_parcial = monto_parcial+total_cuota;
            
            if(monto_pagado>monto_parcial)
            {
               interes_total=cuota.getRecargo();
               cuotas_pagadas = cuotas_pagadas +1;
               cuota.finalizar(); // ESTADO PAGADA
               LineaPago linea_pago =  new LineaPago(total_cuota,cuota);
                getLineas_pago().add(linea_pago);
               
               
            }else {
                
                setNro_cuotas(cuotas_pagadas);
               
                setIntereses(interes_total);
                setMonto((Double) monto_parcial- cuota.getMonto()-cuota.getRecargo());
                setVuelto((Double) monto_pagado - getMonto());
                
                
            }
        }
    }

    /**
     * @return the vuelto
     */
    public Double getVuelto() {
        return vuelto;
    }

    /**
     * @param vuelto the vuelto to set
     */
    public void setVuelto(Double vuelto) {
        this.vuelto = vuelto;
    }

    private void creacionLineasDePago(ArrayList<Cuota> cuotas_seleccionadas_a_pagar) {         
        int cuotas_pagada=0;
        Double interes_total=0.0;
        Double monto_total=0.0;
        
        for(Cuota cuota: cuotas_seleccionadas_a_pagar){
            
           interes_total = interes_total+ cuota.getRecargo();
           Double total_cuota = cuota.getMonto()+cuota.getRecargo();
           monto_total = monto_total +total_cuota;
            cuota.finalizar(); // ESTADO PAGADA
            
            
            LineaPago linea_pago =  new LineaPago(total_cuota,cuota);
            getLineas_pago().add(linea_pago);
           
        }
 
     
                setIntereses(interes_total);
    
                setMonto( monto_total);
    }
            
            
       
    
    
    
    
    
}
