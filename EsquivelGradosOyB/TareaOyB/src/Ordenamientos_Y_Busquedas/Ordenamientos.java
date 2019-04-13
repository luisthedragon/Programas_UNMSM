
package Ordenamientos_Y_Busquedas;

public class Ordenamientos {

    public void burbuja(int[] V, int n){
        for(int i=0;i<n-2;i++){
            for (int j=i+1; j<n;j++){
                if (V[i] > V[j]){
                    swap(V,i,j);
                }
            }
        }
    }
    
    void shell(int[] vector, int n) {
        int j,tmp;
        int aux=(int) (n/2);
        while(aux>0){
            for (int i=0;i<n-aux;i++){
                j=i+aux;
                tmp=vector[j];
                while(j>=aux && tmp < vector[j-aux]){
                    vector[j]=vector[j-aux];
                    j-=aux;
                }
                vector[j]=tmp;
            }
            if (aux==2){
                aux=1;
            }
            else{
                aux=(int)aux/2;
            }
        }
    }
    
    public void seleccion_menor(int[] V, int n){
        int menor;
        int k;
        for (int i=0;i<n-1;i++){
            menor=V[i];
            k=i;
            for (int j=i+1;j<n;j++){
                if (V[j]<menor){
                    menor = V[j];
                    k=j;
                }
            }
            V[k]=V[i];
            V[i]=menor;
        }
    }
    
    void insercion(int[] V, int n){
        int temp;
        int j;
        for (int i=1;i<n;i++){
            temp=V[i];
            j=i-1;
            while(j>=0 && V[j]>temp){
                V[j+1]=V[j];
                j=j-1;
            }
            V[j+1]=temp;
        }
    }
    
    
    //Inicio del agoritmo quicksort
    //*****************************
    void quicksort(int[] V,int izda, int dcha){
        int pivote;        
        if(izda<dcha){
            pivote=partir(V,izda,dcha);
            quicksort(V,izda,pivote-1);
            quicksort(V,pivote+1,dcha);
        }
    }
    
    int partir (int[] V, int primero, int ultimo){
        int pivote = V[primero];
        int temporal;
        int izda=primero+1;
        int dcha=ultimo;
        do{
            while(izda<=dcha && V[izda]<=pivote) izda++;
            while(izda<=dcha && V[dcha]>pivote) dcha--;
        
            if(izda<dcha){
                temporal=V[izda];
                V[izda]=V[dcha];
                V[dcha]=temporal;
                dcha--;
                izda++;
            }
        }while(izda <= dcha);
        
        temporal=V[primero];
        V[primero]=V[dcha];
        V[dcha]=temporal;
        return dcha;
    }
    //*****************************
    //Fin del agoritmo quicksort
    
    public void swap(int[] V, int a, int b){
        int aux=V[a];
        V[a]=V[b];
        V[b]=aux;
    }

    
    void desordenar(int[] V, int n){
        int[] tmp= new int[n];
        int k=0,pos;
        for (int i=0;i<n;i++){
            tmp[i]=V[i];
            V[i]=-99999;
        }
        while(k<n){
            pos = (int)(Math.random()*n);
            if(V[pos]==-99999){
                V[pos]=tmp[k];
                k++;
            }
        }
        
    }
    
    void merge(int arr[], int l, int m, int r) 
    { 
            
            int n1 = m - l + 1; 
            int n2 = r - m; 

            int L[] = new int [n1]; 
            int R[] = new int [n2]; 

            for (int i=0; i<n1; ++i) 
                L[i] = arr[l + i]; 
            for (int j=0; j<n2; ++j)
                R[j] = arr[m + 1+ j]; 

            int i = 0, j = 0; 
            int k = l; 
            while (i < n1 && j < n2) 
            { 
                    if (L[i] <= R[j]) 
                    { 
                        arr[k] = L[i]; 
                        i++; 
                    } 
                    else
                    { 
                        arr[k] = R[j]; 
                        j++; 
                    } 
                    k++; 
            } 
            while (i < n1) 
            { 
                    arr[k] = L[i]; 
                    i++; 
                    k++; 
            } 
            while (j < n2) 
            { 
                    arr[k] = R[j]; 
                    j++; 
                    k++; 
            } 
    }
    
    void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            mergeSort(arr, l, m); 
            mergeSort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    }
    
    public void heapSort(int arr[],int n) 
    {
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arr, n, i); 
        for (int i=n-1; i>=0; i--) 
        { 
            swap(arr,0,i);
            heapify(arr, i, 0); 
        } 
        
    }
    void heapify(int arr[], int n, int i) 
    { 
        int largest = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2; 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
        if (largest != i) 
        { 
            swap(arr,i,largest); 
            heapify(arr, n, largest); 
        } 
    } 
}
