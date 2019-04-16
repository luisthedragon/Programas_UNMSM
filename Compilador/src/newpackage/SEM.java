/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Luis German
 */
public class SEM {
    private String estado;
    private String tempNombre;
    private String tempTipo;
    private double tempValor;
    private String entradaInfija;
    //private char tempOP;
    
    SEM(){
        estado="#";
        entradaInfija="";
    }

    public String getEntradaInfija() {
        return entradaInfija;
    }

    public void setEntradaInfija(String entradaInfija) {
        this.entradaInfija = entradaInfija;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTempNombre() {
        return tempNombre;
    }

    public void setTempNombre(String tempNombre) {
        this.tempNombre = tempNombre;
    }

    public String getTempTipo() {
        return tempTipo;
    }

    public void setTempTipo(String tempTipo) {
        this.tempTipo = tempTipo;
    }

    public double getTempValor() {
        return tempValor;
    }

    public void setTempValor(double tempValor) {
        this.tempValor = tempValor;
    }
/*
    public char getTempOP() {
        return tempOP;
    }

    public void setTempOP(char tempOP) {
        this.tempOP = tempOP;
    }
*/
    /*boolean verificarDeclaracion(TAS tas,String nombre,char type){
        if(estado=='A' && tas.existe(nombre, type)){
            return true;
        }
        return false;
    }
    */
}
