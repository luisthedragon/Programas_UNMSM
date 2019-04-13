/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamientotopologico;

/**
 *
 * @author LuisGerman
 */
public class Nodo {
    private Nodo sgte;
    private INFO info;

    public Nodo() {
    }

    public Nodo(String nombre) {
        this.info = new INFO();
        sgte=null;
        info.setNombre(nombre);
    }
    
    public Nodo getSgte() {
        return sgte;
    }

    public void setSgte(Nodo sgte) {
        this.sgte = sgte;
    }

    public INFO getInfo() {
        return info;
    }

    public void setInfo(INFO info) {
        this.info = info;
    }
    
    
}
