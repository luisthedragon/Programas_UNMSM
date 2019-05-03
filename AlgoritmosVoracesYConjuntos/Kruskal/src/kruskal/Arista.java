/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskal;

/**
 *
 * @author LuisGerman
 */
class Arista implements Comparable<Arista>{
    private int origen;
    private int destino;
    private Integer peso;

    public Arista(int origen, int destino, int peso)  {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }
    
    public Arista(){}

    public int getOrigen() {
        return origen;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista a) {
        return this.getPeso().compareTo(a.getPeso());
    }

    @Override
    public String toString() {
        return "{"+origen+" - "+destino+" - "+peso+"}"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
