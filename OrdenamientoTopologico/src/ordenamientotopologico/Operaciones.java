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
public class Operaciones {
    private Integer[][] matAdy = null;
    private Nodo cab;
    private Nodo ult;
    private int vertices;
    
    public Operaciones(){
        
    }
    
    public String crearMatriz(int vertices){
        this.vertices=vertices;
        matAdy=new Integer[vertices][vertices];
        for (int i=0;i<vertices;i++){
            for (int j=0;j<vertices;j++){
                matAdy[i][j]=0;
            }
        }
        return "Matriz creada correctamente";
    }
    
    public String adicAri(int ori, int dest){
        if (matAdy[ori][dest]==0){
            matAdy[ori][dest]=1;
        }
        else{
            return "Error: La arista ya ha sido insertada";
        }
        return "Arista adicionada correctamente";
    }
    
    public String crearListaRegistros(){
        cab=new Nodo("0");
        ult=cab;
        for (int i=1;i<vertices;i++){
            Nodo n   = new Nodo();
            INFO inf = new INFO();
            inf.setGE(0);
            inf.setNombre(String.valueOf(i));
            n.setInfo(inf);
            ult.setSgte(n);
            ult=n;
        }
        
        return "Lista de Registros creada correctamente";
    }
    
    public String aumentarGE(int dest){
        Nodo aux=cab;
        for (int i=0;i<dest;i++){
            aux=aux.getSgte();
        }
        aux.getInfo().setGE(aux.getInfo().getGE()+1);
        return "Grado actualizado";
    }
    
    public String disminuirGE(int dest){
        Nodo aux=cab;
        while(!aux.getInfo().getNombre().equals(String.valueOf(dest))){
            aux=aux.getSgte();
        }
        aux.getInfo().setGE(aux.getInfo().getGE()-1);
        return "Grado actualizado";
    }
    
    public String OrdenamientoTopologico(){
        String orden="";
        while(cab!=null){
            int u = buscar();
            orden+="N"+String.valueOf(u+1)+"  ";
            for (int i=0;i<vertices;i++){
                if (matAdy[u][i]==1){
                    disminuirGE(i);
                }
            }
        }
        return orden;
    }
    
    public int buscar(){
        Nodo aux=cab;
        while(aux!=null){
            if (aux.getInfo().getGE()==0){
                int u=Integer.parseInt(aux.getInfo().getNombre());
                eliminarNodo(u);
                return u;
            }
            aux=aux.getSgte();
        }
        return -1;
    }
    
    public void eliminarNodo(int index){
        Nodo aux=cab;
        if (cab==null){
            System.out.println("NO HAY NODOS");
        }
        else{
            if(cab.getInfo().getNombre().equals(String.valueOf(index))){
                cab=cab.getSgte();
                return;
            }
            while(aux!=null){
                if(aux.getSgte()!=null){
                    if(aux.getSgte().getInfo().getNombre().equals(String.valueOf(index))){
                        aux.setSgte(aux.getSgte().getSgte());
                        return;
                    }
                }
                else{
                    if (aux.getInfo().getNombre().equals(String.valueOf(index))){
                        if(aux==cab){
                            if(aux==ult){
                                aux=null;
                                cab=null;
                                ult=null;
                            }
                            else{
                                cab=cab.getSgte();
                            }                            
                        }
                        return;
                    }
                }
                aux=aux.getSgte();
            }
        }
        
    }
    
    public void recorrer(){
        Nodo aux=cab;
        while(aux!=null){
            System.out.print(aux.getInfo().getNombre()+" ");
            aux=aux.getSgte();
        }
        System.out.println("");
    }
    
    public Integer[][] getMatAdy() {
        return matAdy;
    }

    public void setMatAdy(Integer[][] matAdy) {
        this.matAdy = matAdy;
    }
    
    
}
