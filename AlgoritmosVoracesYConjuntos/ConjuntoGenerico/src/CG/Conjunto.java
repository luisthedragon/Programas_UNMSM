/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CG;

import LEG.Lista_Enlazada;
import LEG.Nodo;

/**
 *
 * @author LuisGerman
 * @param <T>
 */
public class Conjunto<T> extends Lista_Enlazada<T>{
    public Conjunto(){
        super();
    }
    
    
    public boolean esMiembro(T info){
        return buscar(info)!=null;
        asigna(Conjunto B);
        combinacion(this);
        diferencia(Conjunto B);
        eliminarConjunto(Nodo<T> );
    }
    
    public Conjunto union(Conjunto B){
        Nodo<T> aux =this.getCab();
        Conjunto<T> C = new Conjunto <>();
        while(aux!=null){
            C.inserta(aux.getInfo());
            aux=aux.getSgte();
        }
        aux=B.getCab();
        while(aux!=null){
            C.inserta(aux.getInfo());
            aux=aux.getSgte();
        }
        return C;
    }
    
    public Conjunto interseccion(Conjunto B){
        Nodo<T> aux =this.getCab();
        Conjunto<T> C = new Conjunto <>();
        while(aux!=null){
            if(B.esMiembro(aux.getInfo())){
                C.inserta(aux.getInfo());
            }
            aux=aux.getSgte();
        }
        return C;
    }
    
    public Conjunto diferencia(Conjunto B){
        Nodo<T> aux =this.getCab();
        Conjunto<T> C = new Conjunto <>();
        while(aux!=null){
            if(!B.esMiembro(aux.getInfo())){
                C.inserta(aux.getInfo());
            }
            aux=aux.getSgte();
        }
        return C;
    }
    
    public Conjunto combinacion(Conjunto B){
        Nodo<T> aux =this.getCab();
        Conjunto<T> C = new Conjunto <>();
        while(aux!=null){
            C.agregar(aux.getInfo());
            aux=aux.getSgte();
        }
        aux=B.getCab();
        while(aux!=null){
            C.agregar(aux.getInfo());
            aux=aux.getSgte();
        }
        return C;
    }
    
    public void asigna(Conjunto B){
        eliminarConjunto(getCab());
        Nodo<T> aux=B.getCab();
        while(aux!=null){
            inserta(aux.getInfo());
            aux=aux.getSgte();
        }
    }
    
    public void eliminarTodo(){
        eliminarConjunto(getCab());
    }
    
    private void eliminarConjunto(Nodo<T> nodo){
        if(nodo.getSgte()!=null){
            eliminarConjunto(nodo.getSgte());
        }
        nodo=null;
    }
    
    public boolean igual(Conjunto<T> B){
        boolean coincidencia;
        boolean fallo=false;
        Nodo<T> auxA=this.getCab();
        Nodo<T> auxB;
        while(auxA!=null && !fallo){
            fallo=false;
            coincidencia=false;
            auxB = B.getCab();
            while(auxB!=null && !coincidencia){
                if(auxB.getInfo().equals(auxA.getInfo())){
                    coincidencia = true;
                }
                else{
                    auxB = auxB.getSgte();
                }
            }
            if(auxB==null){
                fallo=true;
            }
            auxA=auxA.getSgte();
        }
        return !fallo;
    }
    
    public void inserta(T info){
        if (!esMiembro(info)){
            agregar(info);
        }
    }
}
