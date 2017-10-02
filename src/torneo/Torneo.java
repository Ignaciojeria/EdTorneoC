/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneo;


import java.util.Scanner;
import listasimple.ListaSimple;

/**
 *
 * @author nacho
 */
public class Torneo {
    
    private static boolean pilaOrCola;

    public static void main(String[] args) {
        
        //Se válida que el tamaño del equipo sea de 5.
        //Se válida que los alumnos de la instancia alumnosPrimeroA pertenezcan al mismo curso
        ListaSimple alumnosPrimeroA=new ListaSimple();
        alumnosPrimeroA.addDer(new Alumno(Curso.PrimeroA,"Juan"));
        alumnosPrimeroA.addDer(new Alumno(Curso.PrimeroA,"Ignacio"));
        alumnosPrimeroA.addDer(new Alumno(Curso.PrimeroA,"Freddy"));
        alumnosPrimeroA.addDer(new Alumno(Curso.PrimeroA,"Daniel"));
        alumnosPrimeroA.addDer(new Alumno(Curso.PrimeroA,"Ximena"));
        
         ListaSimple alumnosPrimeroB=new ListaSimple();
         alumnosPrimeroB.addDer(new Alumno(Curso.PrimeroB,"Lissette"));
         alumnosPrimeroB.addDer(new Alumno(Curso.PrimeroB,"Antonio"));
         alumnosPrimeroB.addDer(new Alumno(Curso.PrimeroB,"Gabriela"));
         alumnosPrimeroB.addDer(new Alumno(Curso.PrimeroB,"Francisca"));
         alumnosPrimeroB.addDer(new Alumno(Curso.PrimeroB,"Chris Cornell"));
        while(true){
        try{    
        new Torneo().menu();
        if(pilaOrCola){
        EquipoModalidadCola equipoA=new EquipoModalidadCola();
        equipoA.buildEquipo(alumnosPrimeroA);
  
        EquipoModalidadCola equipoB=new EquipoModalidadCola();
        equipoB.buildEquipo(alumnosPrimeroB);  
  
        equipoB.enfrentar(equipoA);
        return;
       }
        
        if(!pilaOrCola){
        EquipoModalidadPila equipoA=new EquipoModalidadPila();
        equipoA.buildEquipo(alumnosPrimeroA);
  
        EquipoModalidadPila equipoB=new EquipoModalidadPila();
        equipoB.buildEquipo(alumnosPrimeroB);  
   
        equipoB.enfrentar(equipoA);
        return;
        }
             }catch(Exception ex){
                 System.out.println("Error en la asignación de jugadores");
                 return;
             }
        }
    }
    
    private void menu(){
        Scanner scanner=new Scanner(System.in);
        try{ 
         System.out.println("-----------------------------------------------------------------");
        System.out.println("Escoja el tipo de enfrentamiento (escojer una opción númerica!)");
        System.out.println("------------------------------------------------------------------");
        System.out.println("1) Enfrentamiento de tipo Cola");
        System.out.println("2) Enfrentamiento de tipo Pila ");
        int opcion=scanner.nextInt();
        
        switch (opcion) {
 
        case 1:
        pilaOrCola=true;
        return;
 
        case 2:
        pilaOrCola=false;
        return;
        
        default:
        System.out.println("--------------------ERROR--------------------------");
        System.out.println("Escoja una de las opciones solicitadas");
        menu();
        break;
        
 }
        }catch(Exception e){
            System.out.println("--------------------ERROR--------------------------");
            System.out.println("Porfavor Escoja una opción correcta");
        menu();
        }
    }
    
}
