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
public class PlanCuotaVencida extends Plan{
    private double cargo;
    
    public PlanCuotaVencida(int nro_plan, String descripcion, Double interes_mensual, int nro_cuotas, double cargo) {
        super(nro_plan, descripcion, interes_mensual, nro_cuotas);
        this.cargo = cargo;
    }

    /**
     * @return the cargo
     */
    public double getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(double cargo) {
        this.cargo = cargo;
    }
    
}
