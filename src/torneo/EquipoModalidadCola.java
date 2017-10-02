/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo;

import cola.Cola;
import listasimple.ListaSimple;

/**
 *
 * @author nacho
 */
public class EquipoModalidadCola extends Equipo {
    private Cola cola=new Cola();
    public static final String MODOCOLA="COLAS";
   
    
        @Override
    public void buildEquipo(ListaSimple alumnos){
        super.buildEquipo(alumnos);
        if(getEquipoIsOk()){
        for (int i = 0; i < super.getEquipo().length; i++) {
            //Encola a los alumnos 
            cola.offer(alumnos.get(i));
        }}
    }
    
    @Override
    public boolean enfrentar(Equipo equipo){
         Alumno alumno1=null;
         Alumno alumno2=null;
        System.out.println("-----------------------------------------------------------------");
 if(super.enfrentar(equipo)){
             System.out.println("-----------------------------------------------------------------");
           while(true){
           if(puntos!=5 || equipo.puntos!=5){
           alumno1=((Alumno)cola.poll());
           if(!isVsModalidadPila(equipo)){
           alumno2=((Alumno)((EquipoModalidadCola)equipo).cola.poll()); 
           }else{
               System.out.println("Entroooo");
           alumno2=((Alumno)((EquipoModalidadCola)equipo).getCola().poll());
           }
           alumno1.enfrentarOponente(alumno2);

           if(alumno1.isEnJuego()==alumno2.isEnJuego()){
           puntos--;
           equipo.puntos--;
           }
           if(alumno1.isEnJuego())
           puntos++;
           if(alumno2.isEnJuego())
           equipo.puntos++;
           }
           if(puntos==5){
                System.out.println("-----------------------------------------------------------------");
           System.out.println("Ha finalizado el torneo en modalidad "+MODOCOLA+" y el curso ganador es: "+ alumno1.getCurso());
              System.out.println("-----------------------------------------------------------------");
               return true;
           }
           if(equipo.puntos==5){
               if(!isVsModalidadPila(equipo)){
                System.out.println("-----------------------------------------------------------------");
             System.out.println("Ha finalizado el torneo en modalidad "+MODOCOLA+" y el curso ganador es: "+ alumno2.getCurso());  
                System.out.println("-----------------------------------------------------------------");
            }else{
             System.out.println("-----------------------------------------------------------------");
             System.out.println("Ha finalizado el torneo en modalidad "+EquipoModalidadPila.MODOPILA+" y el curso ganador es: "+ alumno2.getCurso());  
                System.out.println("-----------------------------------------------------------------");  
               }
                return true;
           }
               System.out.println("-----------------------------------------------------------------");
   
            
             alumno2.setEnJuego(true);
            ((EquipoModalidadCola)equipo).getCola().offer(alumno2);
            alumno1.setEnJuego(true);
            getCola().offer(alumno1);
           sleep();
           }
        }
        return false;
    }
    
            private boolean isVsModalidadPila(Equipo equipo){
        return equipo.getClass().equals(EquipoModalidadPila.class);
        }

    public Cola getCola(){
        return cola;
    }

 
}
