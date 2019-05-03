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
public class Main {
    public static void main(String[] args) {
        /*Interfaz guiKruskal = new Interfaz();
        guiKruskal.setVisible(true);*/
        prueba();
    }
    
    public static void prueba(){
        Kruskal k= new Kruskal();
        k.vertices.inserta(0);
        k.vertices.inserta(1);
        k.vertices.inserta(2);
        k.vertices.inserta(3);
        k.vertices.inserta(4);
        k.vertices.inserta(5);
        k.vertices.inserta(6);
        k.aristas.add(new Arista(0,1,1));
        k.aristas.add(new Arista(0,2,2));
        k.aristas.add(new Arista(2,3,2));
        k.aristas.add(new Arista(1,6,3));
        k.aristas.add(new Arista(2,4,4));
        k.aristas.add(new Arista(4,6,7));
        k.aristas.add(new Arista(0,6,1));
        k.aristas.add(new Arista(2,5,1));
        System.out.println(k.aristas.size());
        k.kruskal();
        k.mostrarAristasConsideradas();
        System.out.println(k.calcularPesoTotal());
    }
}
