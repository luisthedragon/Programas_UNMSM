/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

/**
 * @Autores:
 *          BELTRÁN NUÑOVERO, Anderson          17200062
 *          ESQUIVEL GRADOS, Luis Germán        17200154
 */
public class Operaciones {
    int[] V;
    int n;
    int nEleActuales;
    public Operaciones(){
        n=10;
        V = new int[n];
        for(int i=0; i<n; i++){
            V[i]=-1;
        }
    }
    
    public String insertar(int elem){
        int indice=BPI(elem);
        if (indice==-1){
            return "Ya existe";
        }
        else if(indice==-2){
            return "Vector lleno";
        }
        else{
            V[indice]=elem;
            return "Insertado correctamente en el índice "+indice;
        }
    }
    
    public int BPI(int elem){
        int indice=-1;
        int lim;
        int i=funcDisp(elem);
        if (i==0){
            lim=n-1;
        }
        else{
            lim=i-1;
        }
        while(i!=lim){
            if (V[i]==elem){
                return -1;
            }
            else{
                if (V[i]==-1){
                    if (indice==-1){
                        indice=i;
                    }
                }
                if (i==n-1){
                    i=0;
                }
                else{
                    i++;
                }
            }
        }
        if (indice==-1){
            return -2;
        }
        else{
            return indice;
        }
    }

    public int funcDisp(int elem){
        return elem%n;
    }
    
    public String mostrar(){
        String str="";
        for (int i=0; i<n; i++){
            str+=V[i]+" ";
        }
        return str;
    }
}
