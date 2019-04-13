
package Ordenamientos_Y_Busquedas;

import java.util.Scanner;

public class VECTOR {
    int[] vector;
    int n;
    public VECTOR(){}
    
    void leerV(){
        System.out.print("Ingrese el número de elementos: ");
        this.n=leerInt();
        vector=new int[n];
        for (int i=0;i<n;i++){
            System.out.print("Elemento en posicion "+i+": ");
            vector[i]=leerInt();
        }
    }
    
    int leerInt(){
        Scanner sc= new Scanner(System.in);
        return sc.nextInt();
    }
    
    void defaultVector(int n){
        int val;
        vector=new int[n];
        for(int i=0;i<n;i++){
            val=(int)(Math.random()*100);
            vector[i]=val;
        }
        
        this.n=n;
    }
    
    void leerV_desdeTF(String texto){
        String[] elems=texto.trim().split(" ");
        this.n=elems.length;
        vector=new int[n];
        for (int i=0;i<elems.length;i++){
            vector[i]=Integer.parseInt(elems[i]);
        }
    }
    
    String mostrar(){
        String impresion="";
        for (int i=0;i<n;i++){
            impresion+=String.valueOf(vector[i])+" ";
        }
        return impresion;
    }
}
