/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2s1;

/**
 *
 * @author antonio
 */
import java.util.ArrayList;

public class Empleado {
    private String nombre;
    private static int num_max = 2;
    private ArrayList<Hotel> trabaja;
    
    public Empleado(String nombre){
        this.nombre = nombre;
        trabaja = new ArrayList<>();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public boolean addTrabajo(Hotel hotel){
        if(trabaja.size() >= num_max){
            return false; 
        }else{
            trabaja.add(hotel);
            return true;
        }
    }

}
