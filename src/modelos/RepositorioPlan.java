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





public class RepositorioPlan {
    
    ArrayList <Plan> planes;
   

    public RepositorioPlan() {
        planes = new ArrayList() ;
        /// DEFINICION DE LOS PLANES--(NUMERO_PLAN, DESCRIPCION, INTERES_MENSUAL, CUOTAS, CARGO_ADMINISTRATIVO(SOLO PARA 1RA CUOTA VENCIDA)
        Plan plan1 = new PlanCuotaAdelantada(1, "6 Cuotas al 3% de interes mensual- Primera cuota adelantada", 0.03, 6);
        Plan plan2 = new PlanCuotaAdelantada(2, "12 Cuotas al 4% de interes mensual- Primera cuota adelantada", 0.04, 12);
        Plan plan3 = new PlanCuotaVencida(3, "6 Cuotas al 4% de interes mensual- Primera cuota Vencida- Costos Administrativos 4%", 0.04, 6,    0.4);
        Plan plan4 = new PlanCuotaVencida(4, "12 Cuotas al 5% de interes mensual- Primera cuota Vencida- Costos Administrativos 5%", 0.05, 12, 0.05);
        planes.add(plan1);
        planes.add(plan2);
        planes.add(plan3);
        planes.add(plan4);
        
    }
    
    
   public ArrayList <Plan>  obtenerPlanes(){
       return planes;
   } 
    
   
   
   
      public Plan buscarPlan(int numero_plan){
        
        for(Plan plan: planes){
            if(numero_plan == plan.getNro_plan()){
                return plan;
            }
            }
        
         return null;
        }
 
}
