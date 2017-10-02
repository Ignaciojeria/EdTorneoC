/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo;


import listasimple.ListaSimple;
import pila.Pila;

/**
 *
 * @author nacho
 */
public class EquipoModalidadPila extends Equipo {
    Pila pila= new Pila();
    public final static String MODOPILA="PILAS";
    
        @Override
    public void buildEquipo(ListaSimple alumnos){
        super.buildEquipo(alumnos);
        if(getEquipoIsOk()){
        for (int i = 0; i < super.getEquipo().length; i++) {
            //apila a los alumnos
            pila.push(alumnos.get(i));
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
           alumno1=((Alumno)pila.peek());
           if(!isVsModalidadCola(equipo)){
           alumno2=((Alumno)((EquipoModalidadPila)equipo).pila.peek()); 
           }else{
           alumno2=((Alumno)((EquipoModalidadCola)equipo).getCola().poll());
           }
           alumno1.enfrentarOponente(alumno2);
           if(!alumno1.isEnJuego()){
           pila.pop();
           }
           if(!alumno2.isEnJuego()){
           if(!isVsModalidadCola(equipo))
          ((EquipoModalidadPila)equipo).pila.pop();
           }
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
           System.out.println("Ha finalizado el torneo en modalidad "+MODOPILA+" y el curso ganador es: "+ alumno1.getCurso());
              System.out.println("-----------------------------------------------------------------");
               return true;
           }
           if(equipo.puntos==5){
               if(!isVsModalidadCola(equipo)){
                System.out.println("-----------------------------------------------------------------");
             System.out.println("Ha finalizado el torneo en modalidad "+MODOPILA+" y el curso ganador es: "+ alumno2.getCurso());  
                System.out.println("-----------------------------------------------------------------");
            }else{
             System.out.println("-----------------------------------------------------------------");
             System.out.println("Ha finalizado el torneo en modalidad "+EquipoModalidadCola.MODOCOLA+" y el curso ganador es: "+ alumno2.getCurso());  
                System.out.println("-----------------------------------------------------------------");  
               }
                return true;
           }
               System.out.println("-----------------------------------------------------------------");
        if(isVsModalidadCola(equipo)){
            alumno2.setEnJuego(true);
            ((EquipoModalidadCola)equipo).getCola().offer(alumno2);
        }
           sleep();
           }
        }
        return false;
    }
 
        private boolean isVsModalidadCola(Equipo equipo){
        return equipo.getClass().equals(EquipoModalidadCola.class);
        }
    


}
