
package newpackage;

public class TASOBJETOS {
    REGTASOBJETOS[] tasob;
    int n;

    public TASOBJETOS() {
        tasob = new REGTASOBJETOS[20];
        n=0;
    }
    public void nuevoObjeto(String nombre, String tipo,MATRIZ_DE_CLASES_EXISTENTES mat){
        //System.out.println(tipo); (debug)
        if(mat.existeClase(tipo)){
            if(!existeEnTAS(nombre)){
                REGTASOBJETOS identificador = new REGTASOBJETOS(nombre, tipo);
                tasob[n] = identificador;
                n++;
            }
            else{
                System.out.println("\n\nError semantico: El nombre de la variabe ya ha sido reservado ==> "+nombre+"\n\n");
                System.exit(0);
            }        
        }
        else{
            System.out.println("\n\nError semantico: La clase especificada no existe ==> "+tipo+"\n\n");
            System.exit(0);
        }
    }
    
    boolean existeEnTAS(String nom){
        for(int i=0;i<n;i++){
            if(nom.equals(tasob[i].getNombre())){
                return true;
            }
        }
        return false;
    }
    
    void mostrar(){
        System.out.println("\n\nTAS DE OBJETOS");
        System.out.println("  NOMBRE       TIPO");
        for(int i=0;i<n;i++){
            System.out.printf("%-14s%-14s\n",tasob[i].getNombre(),tasob[i].getTipo());
        }
        System.out.println("");
    }
}
