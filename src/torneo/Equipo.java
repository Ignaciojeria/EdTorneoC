/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo;

import java.util.logging.Level;
import java.util.logging.Logger;
import listasimple.ListaSimple;

/**
 *
 * @author nacho
 */
public abstract class Equipo {
    
    private boolean equipoIsOk;
    
    protected int puntos=0;
    
    protected boolean aceptarDesafío=false;
    
    protected int jugadoresRestantes;
    
    private Alumno[] alumnos=new Alumno[5];
    
    public void buildEquipo(ListaSimple alumnos){
            try{
                setEquipoIsOk(alumnos);
            for (int i = 0; i < alumnos.size; i++) {
                this.alumnos[i]=(Alumno)alumnos.get(i);
            }
            System.out.println("Alumnos del Curso "+this.alumnos[0].getCurso()+" preparados para la batalla");

            }catch(Exception ex){
                System.out.println(ex.getMessage());
 
        }
    }
    
    private void setEquipoIsOk(ListaSimple alumnos) throws Exception{
        if(alumnos.size()!=5)throw new Exception("El equipo ingresado debe ser de 5 jugadores");
        for (int row = 0; row < alumnos.size(); row++) {
            for (int col = 0; col < alumnos.size(); col++) {
                if(((Alumno)alumnos.get(row)).getCurso()!=((Alumno)alumnos.get(col)).getCurso())
                {throw new Exception("Los alumnos de esta lista ingresada deben pertenecer al mismo curso");}
        }
        }
        equipoIsOk=true;
           }
        
    public boolean getEquipoIsOk(){
        return equipoIsOk;
    }
    
    protected Alumno[] getEquipo(){
        return alumnos;
    }
    
    public boolean enfrentar(Equipo equipo){
    if(equipo.getEquipo()[0].getCurso()==getEquipo()[0].getCurso()){
    System.out.println("Los equipos a enfrentar no pueden ser del mismo curso");
    return false;
    }
        System.out.println("La batalla está por comenzar!");
         go();
    return true;
    }
    
    private void go(){
                try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 1; i < 4; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Qué comienze la guerra!");
    }
    
          protected void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EquipoModalidadPila.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
