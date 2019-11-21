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
public class Plan {
    private int nro_plan;
    private String descripcion;
    private Double interes_mensual;
    private int nro_cuotas;

    public Plan(int nro_plan, String descripcion, Double interes_mensual, int nro_cuotas) {
        this.nro_plan = nro_plan;
        this.descripcion = descripcion;
        this.interes_mensual = interes_mensual;
        this.nro_cuotas = nro_cuotas;
    }

    public int getNro_plan() {
        return nro_plan;
    }

    public void setNro_plan(int nro_plan) {
        this.nro_plan = nro_plan;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getInteres_mensual() {
        return interes_mensual;
    }

    public void setInteres_mensual(Double interes_mensual) {
        this.interes_mensual = interes_mensual;
    }

    public int getNro_cuotas() {
        return nro_cuotas;
    }

    public void setNro_cuotas(int nro_cuotas) {
        this.nro_cuotas = nro_cuotas;
    }
            
    
}
