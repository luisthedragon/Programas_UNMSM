/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LEG;

/**
 *
 * @author LuisGerman
 * @param <T>
 */
public class Nodo<T> {
    private T info;
    private Nodo<T> sgte;
    
    public Nodo(T info){
        this.info=info;
        this.sgte=null;
    }
    
    public Nodo(){}

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getSgte() {
        return sgte;
    }

    public void setSgte(Nodo<T> sgte) {
        this.sgte = sgte;
    }
    
    
    
}
