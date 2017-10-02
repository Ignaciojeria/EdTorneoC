/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo;

import java.util.Random;

/**
 *
 * @author nacho
 */
public class Alumno {
    private Curso curso;
    private String nombre;
    private boolean enJuego=true;
 //   private PiedraPapelOTijera mano;

    public Alumno(Curso curso, String nombre) {
        this.curso = curso;
        this.nombre = nombre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean isEnJuego(){
        return enJuego;
    }
    protected void setEnJuego(boolean enJuego){
        this.enJuego=enJuego;
    }
    
    //private void setMano(int ramdom){
    //   mano=PiedraPapelOTijera.values()[ramdom];
   // }
    
    //public PiedraPapelOTijera getMano(){
    //    return mano;
    //}

    //métodos personalizados
    public Mano mostrarMano(){
       return Mano.values()[new Random().nextInt(3)];
    }
    
    public void enfrentarOponente(Alumno alumno){
        Mano miMano=mostrarMano();
        Mano manoOponente=alumno.mostrarMano();
        System.out.println(nombre+" del curso "+ curso+" sacó " +miMano);
        System.out.println(alumno.getNombre()+" del curso "+alumno.getCurso()+" sacó "+manoOponente);
        
        if(miMano==manoOponente){
        System.out.println("Empate");}
        
        if(miMano==Mano.Papel && manoOponente==Mano.Piedra){
        //    System.out.println(alumno.getNombre()+" Ha perdido");
            alumno.enJuego=false;
        }
        
        if(miMano==Mano.Papel && manoOponente==Mano.Tijera){
       //     System.out.println(alumno.getNombre()+" Ha ganado");
            this.enJuego=false;
        }
        
        if(miMano==Mano.Piedra && manoOponente==Mano.Tijera){
      //      System.out.println(alumno.getNombre()+" Ha perdido");
            alumno.enJuego=false;
        }
        
        if(miMano==Mano.Piedra && manoOponente==Mano.Papel){
     //  System.out.println(alumno.getNombre()+" Ha ganado");
        this.enJuego=false;
        }
        
        if(miMano==Mano.Tijera && manoOponente==Mano.Papel){
     //       System.out.println(alumno.getNombre()+" Ha perdido");
            alumno.enJuego=false;
        }
        
        if(miMano==Mano.Tijera && manoOponente==Mano.Piedra){
    //        System.out.println(alumno.getNombre()+" Ha ganado");
            this.enJuego=false;
        }
        
        if(enJuego && alumno.enJuego){
            return;
        }
     
        if(enJuego)
            System.out.println("El ganador es: "+nombre+
                              " +1 punto para "+curso);
        
        if(alumno.enJuego)
                   System.out.println("El ganador es: "+ alumno.getNombre()+
                              " +1 punto para "+alumno.getCurso());
            }
    
}
