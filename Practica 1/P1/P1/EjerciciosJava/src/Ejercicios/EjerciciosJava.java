/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios;

/**
 *
 * @author antonio
 */
public class EjerciciosJava {
    public static void main(String[] args){
        
        Parcela p1 = new Parcela("Parcela 1", 1000, 200, 100);
        Parcela p2 = new Parcela("Parcela 2", 2000, 500, 350);
        
        //Pruebas de construir casas, hoteles y obtener el alquiler completo 
        
        p1.construirCasa();
        p1.construirCasa();
        
        System.out.println("La parcela 1 tiene de alquiler completo: " + p1.getPrecioAlquilerCompleto()); //100 * (1 + 2) = 300
        
        p2.construirHotel();
       
        System.out.println("La parcela 2 tiene de alquiler completo: " + p2.getPrecioAlquilerCompleto());  //350 * (1 + 4) = 1750
        
        //Pruebas de las igualdades
        
        Parcela p3 = new Parcela("Parcela 3", 500, 50, 25);
        Parcela p4 = p3;
        
        
        //Prueba de igualdad
        
        boolean identidadIgualP3P4 = p3.igualdadIdentidad(p4);
        
        if(identidadIgualP3P4)
            System.out.println("P3 y P4 tienen la misma identidad");
        else
            System.out.println("P3 y P4 NO tienen la misma identidad");
        
        
        //Prueba de estado
        
        Parcela p5 = new Parcela("Parcela 3", 500, 50, 25); //Es igual a la parcela 3 en estado, pero no en identidad
            
        boolean estadoIgualP3P5 = p3.igualdadEstado(p5);
        boolean IdentidadIgualP3P5 = p3.igualdadIdentidad(p5);
        
        if(estadoIgualP3P5)
            System.out.println("P3 y P5 tienen el mismo estado");
        else
            System.out.println("P3 y P5 NO tienen el mismo estado");
        
         if(IdentidadIgualP3P5)
            System.out.println("P3 y P5  tienen la misma identidad");
        else
            System.out.println("P3 y P5 NO tienen la misma identidad");
        
        
      
        //Prueba para referencias distintas en estado e identidad
        Parcela p6 = new Parcela("Parcela 6", 1500, 450, 125);
        
        boolean estadoIgualP5P6 = p5.igualdadEstado(p6);
        boolean identidadIgualP5P6 = p5.igualdadIdentidad(p6);
        
        if(estadoIgualP5P6)
            System.out.println("P5 y P6  tienen el mismo estado");
        else
            System.out.println("P5 y P6 NO tienen el mismo estado");
        
         if(identidadIgualP5P6)
            System.out.println("P5 y P6  tienen la misma identidad");
        else
            System.out.println("P5 y P6 NO tienen la misma identidad");
        
        
        
    }
}
