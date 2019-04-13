/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordenamientos_Y_Busquedas;

/**
 *
 * @author LuisGerman
 */
public class Busquedas{
    public Busquedas(){}
    
    int busqSec(int[] vector, int n, int dato){
       int i=0;
       boolean encontrado=false;
       while(i<n && !encontrado){
           if(vector[i]==dato){
               encontrado=true;
           }
           else{
               i+=1;
           }
       }
       return i;
    }
    
    int busBin(int[] vector,int n, int dato){
        int izq=0, der=n-1;
        int med=(int)((izq+der)/2);
        boolean encontrado=false;
        while(izq<=der && !encontrado){
            med=(int)((izq+der)/2);
            if(vector[med]==dato){
                encontrado=true;
            }
            else{
                if(vector[med]>dato){
                    der=med-1;
                }
                else{
                    izq=med+1;
                }
            }
        }
        if(encontrado){
            return med;
        }
        else{
            return n;
        }
    }
}
