package newpackage;

public class TASPRIMITIVO {
    REGTASPRIM[] tasp;
    int n;

    public TASPRIMITIVO() {
        tasp= new REGTASPRIM[20];
        n=0;
    }
    
    void nuevoID(String nombre, String tipo, double valor){
        if(!existeEnTAS(nombre)){
            REGTASPRIM identificador = new REGTASPRIM(nombre, tipo, valor);
            tasp[n] = identificador;
            n++;
        }
        else{
            System.out.println("\n\nError semantico: El nombre de la variabe ya ha sido reservado\n\n");
            System.exit(0);
        }
    }
    
    void modificarValor(String nombre,double valor){
        for(int i=0;i<n;i++){
            if(nombre.equals(tasp[i].getNombre())){
                if(tasp[i].getTipo().equals("TOT") && (int)valor - valor == 0 || (tasp[i].getTipo().equals("VOLI") || tasp[i].getTipo().equals("REALI"))){
                    tasp[i].setValor(valor);
                }
                else {
                    System.out.println("\n\nError semántico: Tipos incompatibles en asignacion de la variable ==> "+nombre+"\n\n");
                    System.exit(0);
                }
            }
        }
    }
    
    public int buscarID(String nom){
        for(int i=0;i<n;i++){
            if(nom.equals(tasp[i].getNombre())){
                return i;
            }
        }
        System.out.println("\n\nError semantico: No existe esa variable\n\n");
        System.exit(0);
        return -1;
    }
    
    public boolean existeEnTAS(String nom){
        for(int i=0;i<n;i++){
            if(nom.equals(tasp[i].getNombre())){
                return true;
            }
        }
        return false;
    }
    
    public void mostrar(){
        System.out.println("TAS DE ID PRIMITIVOS");
        System.out.println("  NOMBRE       TIPO       VALOR");
        for(int i=0;i<n;i++){
            if(tasp[i].getTipo().equals("TOT")){
                System.out.printf("%-14s%-14s%-14d\n",tasp[i].getNombre(),tasp[i].getTipo(),(int)tasp[i].getValor());
            }else if (tasp[i].getTipo().equals("REALI")){
                System.out.printf("%-14s%-14s%-14f\n",tasp[i].getNombre(),tasp[i].getTipo(),tasp[i].getValor());
            }else if (tasp[i].getTipo().equals("VOLI")){
                System.out.printf("%-14s%-14s%-14.2f\n",tasp[i].getNombre(),tasp[i].getTipo(),tasp[i].getValor());
            }
            //System.out.println(tasp[i].getNombre()+"  "+tasp[i].getTipo()+"  "+tasp[i].getValor;
        }
        System.out.println("");
    }
}
