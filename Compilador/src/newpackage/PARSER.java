package newpackage;

import java.io.*;

class PARSER {

    TABLA t = new TABLA();
    String pila[] = new String[100];
    String ae;            //guarda un simbolo de la cadena de entrada
    int i;                     // indice de la pila
    String cad;          // guarda la cadena de entrada
    int p;                   // posicion de un simbolo de la cadena de entrada a leer
    int pos;

    static String leer(String m) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cadena = "";
        System.out.println(m);
        try {
            cadena = br.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return cadena;
    }

    int RetPos() {
        return pos;
    }

    String Lexico() {  // regresa un lexema
        char caracter;
        String tira = ""; //int k=0;
        //boolean sw = false;
        for (int i = p; i < cad.length(); i++) {
            if (cad.charAt(i) != ' ') {
                tira = tira + cad.charAt(i);  // se rellena otra cadena
                pos = i + 1;
                //System.out.println(tira);
                break;
            }
        }
        caracter = tira.charAt(0);
        if (Character.isLetter(caracter)  ) {
            tira = "i";
        }
        
        return tira.trim();
    }

    void lectura() {  // lee la cadena de entrada
        cad = leer("LEER CADENA: ");
        cad = cad + " $";
        sintactico();     // se llama al analizador
    }

    void mover(int pos) {
        p = pos;
    }

    PARSER() {
        pila[0] = "$";
        pila[1] = "S";
        i = 2;
        p = 0;
    }

    void Empilar(String produccion) {// mete en la pila
        String[] t;
        t = produccion.split(" ");
        for (int j = 0; j < t.length; j++) {
            pila[i] = t[j];
            i++;
        }
    }

    void error() {
        System.out.println("    error de sintaxis");
        System.exit(0);
    }

    String RetCad() {
        String temp = "";
        int j, k = 0;
        for (j = p; j < cad.length(); j++) {
            temp = temp + cad.charAt(j);
        }
        return temp;
    }

    String RetPila() {
        String CadPila = "";
        for (int j = 0; j < i; j++) {
            CadPila = CadPila + pila[j];
        }
        return CadPila;
    }

    void sintactico() {  // analizador sintactico
        InfijoAPosfijo iap = new InfijoAPosfijo();
        MATRIZ_DE_CLASES_EXISTENTES clasesExistentes = new MATRIZ_DE_CLASES_EXISTENTES();
        AMBITO ambitotmp = new AMBITO();
        SEM semantico = new SEM();
        String XX;
        Lexico lex = new Lexico();
        String produccion = "";
        int pos = 0;
        do {
            // se copian las cadenas retornadas en "ae" y "XX"
            //ae = Lexico();
            lex.ind=pos;
            ae=lex.interprete(cad);
            XX = pila[i - 1];
            System.out.println(ae+"\t"+XX); //(debug)
            //System.out.println(semantico.getEstado()); //(debug)
            //System.out.println(lex.ind); //(debug)
            if (t.Terminal(XX)) // retorna 1 si XX es terminal, sino 0
            {
                if (XX.equals(ae)) {
                    if(XX.equals("genus")){
                        if(ambitotmp.subzona!=null){
                            ambitotmp.mostrarSUBZONA();
                        }
                        if(!semantico.getEstado().equals("#")){
                           ambitotmp.mostrarAMBITO(); 
                        }
                        ambitotmp=new AMBITO();
                        //if(semantico.getEstado()!="&"){
                        semantico.setEstado("nueva clase");
                        //}
                    }
                    if(XX.equals("munus")){
                        if(ambitotmp.subzona!=null){
                            ambitotmp.mostrarSUBZONA();
                        }
                        ambitotmp.subzona = new AMBITO();
                        semantico.setEstado("nueva funcion");
                        
                    }
                    if(XX.equals("TOT")||XX.equals("VOLI")||XX.equals("TORQ")||XX.equals("CAR") || XX.equals("REALI")){
                        semantico.setTempTipo(XX);
                        semantico.setEstado("declaracion primitiva");
                    }
                    if(XX.equals("=")){
                        semantico.setEstado("asignacion");
                    }
                    if(XX.equals("{")){
                        semantico.setEstado("&");
                    }
                    if(XX.equals(";")){
                        if(semantico.getEstado().equals("asignacion")){
                            semantico.setTempValor(iap.resolverPosfijo(iap.pasarAPosfijo(semantico.getEntradaInfija())));
                            if(ambitotmp.subzona==null){
                                ambitotmp.tasprim.modificarValor(semantico.getTempNombre(),semantico.getTempValor());
                            }
                            else{
                                ambitotmp.subzona.tasprim.modificarValor(semantico.getTempNombre(),semantico.getTempValor());
                            }
                        }
                        semantico.setEntradaInfija(""); 
                        semantico.setEstado("&");
                    }
                    if(XX.equals("dum")||XX.equals("si")){
                        semantico.setEstado("leer condicion");
                    }
                    if(XX.equals("+")||XX.equals("-")||XX.equals("*")||XX.equals("/") || XX.equals("^") || XX.equals("(") || XX.equals(")")){
                        if(semantico.getEstado().equals("asignacion")){
                            semantico.setEntradaInfija(semantico.getEntradaInfija()+XX);
                        }
                    }
                    if (XX.equals("N.Entero") || XX.equals("N.Real")){
                        if(semantico.getEstado().equals("asignacion")){
                            semantico.setEntradaInfija(semantico.getEntradaInfija()+lex.buffer);
                        }
                    }
                    if(XX.equals("id")){
                        if(!semantico.getEstado().equals("nueva clase") && clasesExistentes.existeClase(lex.buffer)){
                            semantico.setTempTipo(lex.buffer);
                            semantico.setEstado("declaracion de objeto");
                        }
                        else{
                            switch(semantico.getEstado()){ 
                                case "asignacion":
                                    if(ambitotmp.subzona==null){
                                        semantico.setEntradaInfija(semantico.getEntradaInfija()+ambitotmp.tasprim.tasp[ambitotmp.tasprim.buscarID(lex.buffer)].getValor());
                                    }
                                    else{
                                        semantico.setEntradaInfija(semantico.getEntradaInfija()+ambitotmp.subzona.tasprim.tasp[ambitotmp.subzona.tasprim.buscarID(lex.buffer)].getValor());
                                    }
                                    break;
                                case "nueva clase":
                                    ambitotmp.setNombreClase(lex.buffer);
                                    clasesExistentes.nuevaClase(lex.buffer);
                                    //System.out.println(clasesExistentes.vecClases[clasesExistentes.n-1]); //debug
                                    break;
                                    //ej: genus tomate
                                case "nueva funcion":
                                    ambitotmp.setNombreFuncion(lex.buffer);
                                    clasesExistentes.nuevaFuncion(ambitotmp.getNombreClase(),ambitotmp.getNombreFuncion());
                                    break;
                                    //ej: munus papaya
                                case "declaracion primitiva":
                                    semantico.setTempNombre(lex.buffer);
                                    if(ambitotmp.subzona==null){
                                        ambitotmp.tasprim.nuevoID(lex.buffer, semantico.getTempTipo(), 0);
                                    }
                                    else{
                                        ambitotmp.subzona.tasprim.nuevoID(lex.buffer, semantico.getTempTipo(), 0);
                                    }
                                    break;
                                    //ej: *TOT a;
                                case "declaracion de objeto":
                                    if(ambitotmp.subzona==null){
                                        ambitotmp.tasobj.nuevoObjeto(lex.buffer, semantico.getTempTipo(),clasesExistentes);
                                        //System.out.println(ambitotmp.tasclas.tasc[ambitotmp.tasclas.n-1].getNombre());//debug
                                        //System.out.println(ambitotmp.tasclas.tasc[ambitotmp.tasclas.n-1].getTipo());//debug
                                    }
                                    else{
                                        ambitotmp.subzona.tasobj.nuevoObjeto(lex.buffer, semantico.getTempTipo(),clasesExistentes);
                                    }
                                    break;
                                case "&":
                                    semantico.setTempNombre(lex.buffer);
                                    if(ambitotmp.subzona!=null){
                                        if(!ambitotmp.subzona.tasprim.existeEnTAS(lex.buffer)){
                                            if (!ambitotmp.tasprim.existeEnTAS(lex.buffer)){
                                                System.out.println("\n\nError semantico: El identificador no ha sido declarado en la funcion==> "+lex.buffer+"\n\n");
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    else{
                                        if (!ambitotmp.tasprim.existeEnTAS(lex.buffer)){
                                            System.out.println("\n\nError semantico: El identificador no ha sido declarado en la clase ==> "+lex.buffer+"\n\n");
                                            System.exit(0);
                                        }
                                    }
                                    break;
                                case "leer condicion":
                                    if(ambitotmp.subzona!=null){
                                        if(!ambitotmp.subzona.tasprim.existeEnTAS(lex.buffer)){
                                            if (!ambitotmp.tasprim.existeEnTAS(lex.buffer)){
                                                System.out.println("\n\nError semantico: El identificador no ha sido declarado en la funcion==> "+lex.buffer+"\n\n");
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    else{
                                        if (!ambitotmp.tasprim.existeEnTAS(lex.buffer)){
                                            System.out.println("\n\nError semantico: El identificador no ha sido declarado en la clase ==> "+lex.buffer+"\n\n");
                                            System.exit(0);
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("\n\nError semantico\n\n");
                                    System.exit(0);
                            }    
                        }
                        
                    }
                    
                    
                    
                    i = i - 1;     // se descuenta un simbolo de la pila
                    pos=lex.ind;
                    mover(pos);  // se lee la cadena de entrada desde
                    // la posicion "pos"
                } else {
                    System.out.println("1");
                    error();
                }
            } else {
                if (t.ExisteInterseccion(XX, ae)) {
                    produccion = t.RetProduccion();
                    System.out.println("| " + RetPila() + " |    " + RetCad() + "    | " + XX + "-->" + produccion);
                    i = i - 1;   // se descuenta un simbolo de la pila
                    // si la produccion es & no se mete en la pila
                    if (!produccion.equals("&")) {
                        Empilar(produccion);
                    }
                } else {
                    System.out.println("2");
                    error();
                }
            }
        } while (!XX.equals("$"));
        if(ambitotmp.subzona!=null){
            ambitotmp.mostrarSUBZONA();
        }
        ambitotmp.mostrarAMBITO();
        clasesExistentes.mostrarClasesYFunciones();
    }
}
/***************
clase principal

clase joseff    imprime el smbito de la clase principal
f: papaya       no imprime nada
f: pera         imprime el ambito de papaya
f:arroz         imprime el ambito de pera

clase gosu      imprimir el ambito de arroz
                imprimir el ambito de joseff
*********************/
