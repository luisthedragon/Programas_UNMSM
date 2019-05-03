/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LEG;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author LuisGerman
 * @param <T>
 */
public class Lista_Enlazada<T> {
    private Nodo<T> cab;
    private Nodo<T> ult;
    
    public Nodo<T> getCab() {
        return cab;
    }

    public void setCab(Nodo<T> cab) {
        this.cab = cab;
    }

    public Nodo<T> getUlt() {
        return ult;
    }

    public void setUlt(Nodo<T> ult) {
        this.ult = ult;
    }
    
    public Lista_Enlazada(){
        cab=null;
        ult=null;
    }
    
    public void agregar(T info){
        Nodo<T> nuevo = new Nodo<>(info);
        if(cab==null){
            cab=nuevo;
            ult=nuevo;
        }
        else{
            ult.setSgte(nuevo);
            ult=nuevo;
        }
    }
    
    public void eliminar(T info){
        Nodo<T> nodoEliminar=buscar(info);
        if(nodoEliminar!=null){
            if (nodoEliminar==cab){
                if (nodoEliminar ==ult){
                    cab=null; 
                    ult=null;
                }
                else{
                    cab=cab.getSgte();
                }
            }
            else{
                if (nodoEliminar == ult){
                    Nodo<T> aux=cab;
                    while(aux.getSgte().getSgte()!=null){
                        aux=aux.getSgte();
                    }
                    ult=aux;
                    ult.setSgte(null);
                }
            }
            nodoEliminar=null;
        }
        else{
            System.out.println("El elemento no está en la lista");
        }
    }
    
    public Nodo<T> buscar(T infoBuscada){
        boolean encontrado=false;
        Nodo<T> aux=cab;
        Nodo<T> nodoBuscado=null;
        while(!encontrado && aux!=null){
            if(aux.getInfo().equals(infoBuscada)){
                nodoBuscado=aux;
                encontrado=true;
            }
            else{
                aux=aux.getSgte();
            }
        }
        return nodoBuscado;
    }
    
    public void salvar(String nomArchivo){
        Nodo<T> aux=cab;
        ObjectOutputStream escribiendoFichero;
        try {
            escribiendoFichero = new ObjectOutputStream( 
                    new FileOutputStream(nomArchivo) );
            while(aux!=null){
                escribiendoFichero.writeObject(aux.getInfo());
                aux=aux.getSgte();
            }
            escribiendoFichero.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
    }
    
    public void recuperar(String nomArchivo){
        ObjectInputStream leyendoFichero;
        T informacion;
        try {
            leyendoFichero = new ObjectInputStream( 
            new FileInputStream(nomArchivo) );
            try{
                informacion = (T)leyendoFichero.readObject();
                while(true){
                    agregar(informacion);
                    informacion = (T)leyendoFichero.readObject();
                }
            }
            catch(EOFException eof){
                leyendoFichero.close();
            }
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }          
    }
    /*
    public Nodo<T> minimo(){
        if(getCab()!=null){
            Nodo<T> aux = getCab();
            Nodo<T> min = getCab();
            while(aux!=null){
                if(aux.getInfo().compareTo(min.getInfo())<0){
                    min=aux;
                }
                aux=aux.getSgte();
            }
            return min;
        }
        return null;
    }
    
    public Nodo<T> maximo(){
        if(getCab()!=null){
            Nodo<T> aux = getCab();
            Nodo<T> max = getCab();
            while(aux!=null){
                if(aux.getInfo().compareTo(max.getInfo())<0){
                    max=aux;
                }
                aux=aux.getSgte();
            }
            return max;
        }
        return null;
    }
    */
    public String listar(){
        String lista="";
        Nodo<T> aux=cab;
        while(aux!=null){
            lista+=aux.getInfo().toString()+" -> ";;
            aux=aux.getSgte();
        }
        lista+="*";
        return lista;
    }
}
