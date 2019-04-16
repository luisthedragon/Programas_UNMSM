package newpackage;

import java.util.Stack;

public class InfijoAPosfijo {
    public String pasarAPosfijo(String expr){
        expr = depurar(expr);
        /*4         +         7         / 8
        ( 4 + 7 / 8 )
        0 (             
        1 4             
        2 +             
        3 7          
        4 /             
        5 8             
        */
        String[] arrayInfix = expr.split(" ");
        
        Stack < String > E = new Stack <> (); //Pila entrada
        Stack < String > T = new Stack <> (); //Pila temporal para operadores
        Stack < String > S = new Stack <> (); //Pila salida
        
        for (int i = arrayInfix.length - 1; i >= 0; i--) {
            E.push(arrayInfix[i]);
        }
        
        try {
          //Algoritmo Infijo a Postfijo
          while (!E.isEmpty()) {
              
            switch (pref(E.peek())){
              
              case 1:       // (
                T.push(E.pop());
                break;
              case 2:        //  )
                while(!T.peek().equals("(")) {
                  S.push(T.pop());
                }
                T.pop();
                E.pop();
                break; 
              case 3:       //  + -
              case 4:       //  * /
              case 5:       // ^
                while(pref(T.peek()) >= pref(E.peek())) {
                  S.push(T.pop());
                }
                T.push(E.pop());
                break; 
              
              default:
                S.push(E.pop()); 
            }
            //System.out.println();
          } 
          //Eliminacion de `impurezas´ en la expresiones algebraicas
          //String infix = expr.replace(" ", "");
          String postfix = S.toString().replaceAll("[\\]\\[,]", "");
          //Mostrar resultados:
          /*System.out.println("Expresion Infija: " + infix);
          System.out.println("Expresion Postfija: " + postfix);
           */return postfix;
        }catch(Exception ex){
            System.out.println("Error en la expresión algebraica");
          System.err.println(ex);
          System.exit(0);
        }
        return null;
        
        
    }
    
    public double resolverPosfijo(String exprP){
        Stack < String > E = new Stack <> ();
        Stack < String > S = new Stack <> ();
        
        String[] arrayPostfix = exprP.split(" ");
        double num1,num2,resul;
        
        for (int i = arrayPostfix.length - 1; i >= 0; i--) {
            E.push(arrayPostfix[i]);
        }
        
        try{
            while (!E.isEmpty()) {
                switch (E.peek()){
                  case "+":
                        E.pop();
                        num1 = Double.parseDouble(S.pop());
                        num2 = Double.parseDouble(S.pop());
                        resul = num1 + num2;
                        S.push(String.valueOf(resul));
                        break;
                  case "-":
                        E.pop();
                        num1 = Double.parseDouble(S.pop());
                        num2 = Double.parseDouble(S.pop());
                        resul = num2 - num1;
                        S.push(String.valueOf(resul));
                        break;
                  case "*":
                        E.pop();
                        num1 = Double.parseDouble(S.pop());
                        num2 = Double.parseDouble(S.pop());
                        resul = num2 * num1;
                        S.push(String.valueOf(resul));  
                        break; 
                  case "/":
                        E.pop();
                        num1 = Double.parseDouble(S.pop());
                        num2 = Double.parseDouble(S.pop());
                        resul = num2 / num1;
                        S.push(String.valueOf(resul));  
                        break;
                   case "^":
                        E.pop();
                        num1 = Double.parseDouble(S.pop());
                        num2 = Double.parseDouble(S.pop());
                        resul = Math.pow(num2,num1);
                        S.push(String.valueOf(resul));  
                        break;
                  default:
                    S.push(E.pop());
                }
            }
        }catch(Exception ex){ 
          System.out.println("Error en la expresión posfija");
          System.err.println(ex);
        }
        return Double.parseDouble(S.pop());
    }
    
   /* 
    public void probar(){
        //Entrada de datos
        System.out.println("*Escribe una expresión algebraica: ");
        Scanner leer = new Scanner(System.in);

        //Depurar la expresion algebraica
        String expr = depurar(leer.nextLine());
        String[] arrayInfix = expr.split(" ");

        //Declaración de las pilas
        Stack < String > E = new Stack < String > (); //Pila entrada
        Stack < String > P = new Stack < String > (); //Pila temporal para operadores
        Stack < String > S = new Stack < String > (); //Pila salida

        //Añadir la array a la Pila de entrada (E)
        for (int i = arrayInfix.length - 1; i >= 0; i--) {
          E.push(arrayInfix[i]);
        }

        try {
          //Algoritmo Infijo a Postfijo
          while (!E.isEmpty()) {
            switch (pref(E.peek())){
              case 1:
                P.push(E.pop());
                break;
              case 3:
              case 4:
                while(pref(P.peek()) >= pref(E.peek())) {
                  S.push(P.pop());
                }
                P.push(E.pop());
                break; 
              case 2:
                while(!P.peek().equals("(")) {
                  S.push(P.pop());
                }
                P.pop();
                E.pop();
                break; 
              default:
                S.push(E.pop()); 
            } 
          } 

          //Eliminacion de `impurezas´ en la expresiones algebraicas
          String infix = expr.replace(" ", "");
          String postfix = S.toString().replaceAll("[\\]\\[,]", "");

          //Mostrar resultados:
          System.out.println("Expresion Infija: " + infix);
          System.out.println("Expresion Postfija: " + postfix);

        }catch(Exception ex){ 
          System.out.println("Error en la expresión algebraica");
          System.err.println(ex);
        }
    }
    */
    
    public String depurar(String s) {
    s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
    s = "(" + s + ")";
    String simbols = "+-*/()^";
    String str = "";
    //Deja espacios entre operadores
    for (int i = 0; i < s.length(); i++) {
      if (simbols.contains("" + s.charAt(i))) {
        str += " " + s.charAt(i) + " ";
      }else str += s.charAt(i);
    }
    return str.replaceAll("\\s+", " ").trim();
  } 

    //Jerarquia de los operadores
    public int pref(String op) {
    int prf = 99;
    if (op.equals("^")) prf = 5;
    if (op.equals("*") || op.equals("/")) prf = 4;
    if (op.equals("+") || op.equals("-")) prf = 3;
    if (op.equals(")")) prf = 2;
    if (op.equals("(")) prf = 1;
    return prf;
  }
}
