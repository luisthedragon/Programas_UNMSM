
package newpackage;

public class AMBITO {
    private String nombreClase;
    private String nombreFuncion;
    TASPRIMITIVO tasprim;
    TASOBJETOS tasobj;
    AMBITO subzona;
    
    public AMBITO() {
        tasprim = new TASPRIMITIVO();
        tasobj = new TASOBJETOS();
        subzona = null;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getNombreFuncion() {
        return nombreFuncion;
    }

    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }
    
    void mostrarAMBITO(){
        System.out.println("\n\nMostrando ámbito de la clase "+nombreClase);
        System.out.println("===============================");
       tasprim.mostrar();
       tasobj.mostrar();
       System.out.println("-------------------------------");
    }
    
    void mostrarSUBZONA(){
        System.out.println("\n\nMostrando ámbito de la función "+nombreFuncion);
        System.out.println("===============================");
        subzona.tasprim.mostrar();
        subzona.tasobj.mostrar();
        System.out.println("-------------------------------");
    }
}