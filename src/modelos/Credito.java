/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import static modelos.Credito.EstadoCredito.ACTIVO;
import static modelos.EstadoCuota.PAGADA;

/**
 *
 * @author Capu
 */
public class Credito {

    public String noEsValido() {
        if(this.monto_solicitado > 100000){
            return "El monto solicitado es mayor al monto máximo permitido $100.000";
        }if(this.plan instanceof PlanCuotaAdelantada){
           
            if(plan.getNro_cuotas()<2){
                
                return "El número de cuotas mínimo es 2(dos)";
            }
        }
                return null;
        
    }

    public ArrayList<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(ArrayList<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public ArrayList<Cuota> obtenerPrimeraCuota() {
       ArrayList<Cuota> primeracuota =  new ArrayList<>();
       primeracuota.add(cuotas.get(0));
       
        return primeracuota;
    }

    public boolean isPlanAdelantada() {
        
       RepositorioPlan repo =  new RepositorioPlan();
       plan = repo.buscarPlan(this.getPlan().getNro_plan());
        boolean resultado = false;
        if(plan  instanceof PlanCuotaAdelantada){
            resultado = true;
        }
    return resultado;
    }
    

 

   

     

   

   

    /// Estado del Credito
    
    enum EstadoCredito{
        ACTIVO, PENDIENTE, FINALIZADO, PENDIENTE_FINALIZACION;
       
    }
    
    private String nro_credito;
    private Date fecha_solicitud;
    private Double monto_solicitado;
    private Double interes;
    private Double importe_total;
    private ArrayList<Cuota> cuotas;
    private EstadoCredito estado;
    private Plan plan;
    private int dni_cliente;

    public int getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(int dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public int getLegajo_empleado() {
        return legajo_empleado;
    }

    public void setLegajo_empleado(int legajo_empleado) {
        this.legajo_empleado = legajo_empleado;
    }
    private int legajo_empleado;
   

    public Credito(Plan plan, String nro_credito, Date fecha_solicitud, Double monto_solicitado, int dni, int legajo) {
        this.nro_credito = nro_credito;
        this.fecha_solicitud = fecha_solicitud;
        this.monto_solicitado = monto_solicitado;
        dni_cliente = dni;
        legajo_empleado = legajo;
        this.cuotas = new ArrayList();
        this.plan=plan;
        
        
        calcularMontoCuotas(plan);
        
        estado = ACTIVO;
        
        
    }
    
     private void calcularMontoCuotas(Plan plan) {
         // Este metodo calcula las el interes, importe total y el importe de las cuotas
         
         if(plan instanceof PlanCuotaVencida){
             // Plan con primera Cuota Vencida
             int numero_cuotas = plan.getNro_cuotas();
      
            PlanCuotaVencida plan_cuota_vencida = (PlanCuotaVencida)plan; //Casteo de la instancia a su tipo especializado(subclase)
             Double porcentaje_cargo = plan_cuota_vencida.getCargo(); // 2% Porcentaje de recargo fijado
            
            // cargo por gastos gastos administrativos
            Double cargo =  monto_solicitado * porcentaje_cargo;
            
            
            
            //Calculando Importe total + cargo administrativo
            this.interes = plan.getInteres_mensual()* numero_cuotas;
            this.importe_total =monto_solicitado + cargo + monto_solicitado * interes;
            
            
            //----  Creando Cuotas
            Double valor_mensual = importe_total/numero_cuotas;
            Date vencimiento_actual = calcularPrimeraFechaVencimiento(fecha_solicitud);
           
            for(int i=1; i<= numero_cuotas; i++ ){
                
   
                if(i>1){
                 // demas cuotas
                 vencimiento_actual = aumentarUnMes(vencimiento_actual);
                 Cuota  cuota = new Cuota(i,vencimiento_actual,valor_mensual);
                 this.cuotas.add(cuota);
                 
                 
                }else {
                    // Primera Cuota
                    Cuota  cuota = new Cuota(i,vencimiento_actual,valor_mensual);
                     this.cuotas.add(cuota);
                }
                
          }
            
             
             
             
         }
         
         
         
         
         // -------PLAN CUOTA ADELANTADA
         
         
         if(plan instanceof PlanCuotaAdelantada){
             
             int numero_cuotas = plan.getNro_cuotas();
      
            PlanCuotaAdelantada plan_cuota_adelantada = (PlanCuotaAdelantada)plan; //Casteo de la instancia a su tipo especializado(subclase)
          
            
            // cargo por gastos gastos administrativos
      
            
            
            //Calculando Importe total
            this.interes = plan.getInteres_mensual()* numero_cuotas;
            this.importe_total = monto_solicitado + monto_solicitado * interes;
            
            
            //----  Creando Cuotas
            Double valor_mensual = importe_total/numero_cuotas;
            
            
           Date vencimiento_actual = fecha_solicitud;
            for(int i=1; i<= numero_cuotas; i++ ){
                
   
                if(i>1){
                 // demas cuotas
                 vencimiento_actual = aumentarUnMes(vencimiento_actual);
                 Cuota  cuota = new Cuota(i,vencimiento_actual,valor_mensual);
                 this.cuotas.add(cuota);
                 
                }else {
                    // Primera Cuota 
                    Cuota  cuota = new Cuota(i,fecha_solicitud,valor_mensual);
                     this.cuotas.add(cuota);
                }
                
          }
            
             
             
             
         }
         
         
         
         
         
         
         
         
        
    }
    
    
    // METODO QUE CALCULA LA PRIMERA FECHA DE VENCIMIENTO
    public Date calcularPrimeraFechaVencimiento(Date fecha_solicitud) {
         
         Date fecha_primera_cuota;
          if(fecha_solicitud.getDate() < 10){ // SI ESTAMOS ANTES DEL 10, EL VENCIMIENTO ES EL MISMO MES
                fecha_primera_cuota =new Date(fecha_solicitud.getYear(), fecha_solicitud.getMonth() ,10);
            }else {
                                              // SI ES DESPUES DEL 10 AUMENTAMOS UN MES LA FECHA
                Date fecha_auxiliar = new Date(fecha_solicitud.getYear(), fecha_solicitud.getMonth() ,10);
                fecha_primera_cuota = aumentarUnMes(fecha_auxiliar);
            
                 
                        
                        
            }
          
          return fecha_primera_cuota;
         
    }
   
     
   // AUMENTA UN MES 
    public Date aumentarUnMes(Date fecha_auxiliar) {
                
                 Calendar cal = Calendar.getInstance(); 
                 cal.setTime(fecha_auxiliar); 
                 cal.add(Calendar.MONTH, 1);
                Date fecha_incrementada = cal.getTime();
                fecha_incrementada.setDate(10);
                return fecha_incrementada;
               
                 
        
    }
    
    
    
    
    
    
    

    public EstadoCredito getEstado() {
        return estado;
    }
    
    /**
     *
     * @param estado
     */
  

  

    public String getNro_credito() {
        return nro_credito;
    }

    public void setNro_credito(String nro_credito) {
        this.nro_credito = nro_credito;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public Double getMonto_solicitado() {
        return monto_solicitado;
    }

    public void setMonto_solicitado(Double monto_solicitado) {
        this.monto_solicitado = monto_solicitado;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Double getImporte_total() {
        return importe_total;
    }

    public void setImporte_total(Double importe_total) {
        this.importe_total = importe_total;
    }
     public void activar(){
      estado = EstadoCredito.ACTIVO;  
    }
        
    public void finalizar(){
      estado = EstadoCredito.FINALIZADO;  
    }
     public void pendiente(){
        estado = EstadoCredito.PENDIENTE;
    }
    public void pendienteFinalizacion(){
        estado = EstadoCredito.PENDIENTE_FINALIZACION;
    }


    public ArrayList<Cuota> CuotasNoPagadas(Date fecha_actual){
        // RECUPERA LAS CUOTAS QUE NO ESTAN PAGADAS
        ArrayList<Cuota> cuotas_sin_pagar= new ArrayList();
        cuotas.forEach((cuota) ->{
            
         
         if(cuota.getEstado() != PAGADA){
             cuota.dias_vencimiento(fecha_actual); // actualiza el estado segun la fecha   
                                            // cargamos el recargo                         
             cuotas_sin_pagar.add(cuota); // agrega las que esten sin pagar
         }
        });
        if(cuotas_sin_pagar.size()>0){
          return cuotas_sin_pagar;  
        }else{
            return null;
        }
        
    }


}
