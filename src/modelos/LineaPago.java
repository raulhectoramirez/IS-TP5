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
class LineaPago {
    private Double monto; 
    private Cuota cuota;

    public LineaPago(Double monto, Cuota cuota) {
        this.monto = monto;
        this.cuota = cuota;
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
     * @return the cuota
     */
    public Cuota getCuota() {
        return cuota;
    }

    /**
     * @param cuota the cuota to set
     */
    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }
            
}
