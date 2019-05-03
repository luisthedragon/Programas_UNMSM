/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

import java.util.Collections;
import CG.Conjunto;
import LEG.Nodo;
import java.util.ArrayList;

/**
 *
 * @author LuisGerman
 */
public class Kruskal {
    Conjunto<Integer> vertices = new Conjunto<>();
    ArrayList<Conjunto<Integer>> conjuntos = new ArrayList<>();
    ArrayList<Arista> aristas = new ArrayList<>();
    ArrayList<Arista> aristasConsideradas = new ArrayList<>();
    
    public Kruskal(){
        
    }
    
    public Conjunto<Integer> encuentraConjunto(int i){
        for(int k=0;k<conjuntos.size();k++){
            Nodo<Integer> auxV = conjuntos.get(k).getCab();
            while(auxV!=null){
                if(auxV.getInfo()==i){
                    return conjuntos.get(k);
                }
                auxV=auxV.getSgte();
            }
        }
        return null;
    }
    
    public boolean evalArista(Arista a){
        Conjunto<Integer> conjA=encuentraConjunto(a.getOrigen());
        Conjunto<Integer> conjB=encuentraConjunto(a.getDestino());
        Conjunto<Integer> conjC=new Conjunto<>();
        boolean considerado=false;
        if(conjA != conjB){
            conjC = conjA.union(conjB);
            conjuntos.add(conjC);
            conjuntos.remove(conjA);
            conjuntos.remove(conjB);
            considerado=true;
        }
        
        for (int i=0;i<conjuntos.size();i++){
            System.out.println(conjuntos.get(i).listar());
        }
        System.out.println("************");
        return considerado;
    }
    
    public void kruskal(){
        Collections.sort(aristas);
        Nodo<Integer> aux = vertices.getCab();
        while(aux!=null){
            Conjunto<Integer> temp = new Conjunto<>();
            temp.agregar(aux.getInfo());
            conjuntos.add(temp);
            aux=aux.getSgte();
        }
        for(int i=0;i<aristas.size() && conjuntos.size()!=1;i++){
            if(evalArista(aristas.get(i))){
                System.out.println(aristas.get(i).toString());
                aristasConsideradas.add(aristas.get(i));
            }
        }
    }
    
    public void mostrarAristasConsideradas(){
        for(int i=0;i<aristasConsideradas.size();i++){
            System.out.println(aristasConsideradas.get(i).toString());
        }
    }
    
    public int calcularPesoTotal(){
        int pesoTotal=0;
        for(int i=0;i<aristasConsideradas.size();i++){
            pesoTotal+=aristasConsideradas.get(i).getPeso();
        }
        return pesoTotal;
    }
}
