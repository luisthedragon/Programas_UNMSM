package newpackage;

public class MATRIZ_DE_CLASES_EXISTENTES {
    String[][] matClases;
    int n;
    
    public MATRIZ_DE_CLASES_EXISTENTES() {
        this.matClases = new String[20][15];
        for(int i=0;i<20;i++){
            for(int j=0;j<15;j++){
                matClases[i][j] = "&";
            }
        }
        n=0;
    }

    void nuevaClase(String nombre){
        if(!existeClase(nombre)){
            matClases[n][0] = nombre;
            n++;
        }
        else{
            System.out.println("\n\nError semantico: Ya existe una clase con ese nombre\n\n");
            System.exit(0);
        }
    }
    
    void nuevaFuncion(String clase, String funcion){
        int k=1;
        for(int i=0;i<n;i++){
            if(clase.equals(matClases[i][0])){
                while(!matClases[i][k].equals("&")){
                    if(matClases[i][k].equals(funcion)){
                        System.out.println("\n\nError semantico: Ya existe una funcion con ese nombre en la clase\n\n");
                        System.exit(0);
                    }
                   k++;
                }
                matClases[i][k]=funcion;
            }
            
        }
    }
    
    boolean existeClase(String nom){
        for(int i=0;i<n;i++){
            if(nom.equals(matClases[i][0])){
                return true;
            }
        }
        return false;
    }
    
    void mostrarClases(){
        System.out.print("\n\nCLASES CREADAS:  ");
        for(int i=0;i<n;i++){
            System.out.print(matClases[i][0]+";  ");
        }
        System.out.println("");
    }
    
    void mostrarClasesYFunciones(){
        int k;
        System.out.println("\n\nMOSTRANDO CLASES Y FUNCIONES");
        System.out.println("==============================");
        System.out.println("CLASES [ FUNCIONES ]");
        for(int i=0;i<n;i++){
            k=0;
            System.out.print(matClases[i][k]+" [ ");
            k++;
            while(!matClases[i][k].equals("&")){
                System.out.print(matClases[i][k]+" , ");
                k++;
            }
            System.out.println(" ]");
        }
        System.out.println("--------------------------------");
    }
}