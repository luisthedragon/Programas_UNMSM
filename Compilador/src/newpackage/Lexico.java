package newpackage;

public class Lexico{ 
    String PALABRA[] = {"per","facio","default","Principalem","publicus","genus","privatus","munus","CAR","TOT","VOLI","REALI","TORQ","BOOL","BIN","OCT","HEX","novum","adnotatione","scribo","read","si","dum", "facite","autem", "break","reditus","Çincludere","&constant","uel","vacuum","quod"}; //tam:32
    String OPERADORES[] = {"<",">","+","=","==",">=","<=","*","-","^","!=","(",")","/"}; //tam:14
    String SIMBOLOS[] = {";","#",",","{","}",":"}; //tam:6
    int ind;
    String car;
    String buffer;

    int BUSCAR(String x) {
        for (int k = 0; k < PALABRA.length; k++) {
            if (x.equals(PALABRA[k])) {
                return 400 + k;
            }
        }
        return 100;
    }
    int BUSCAR2(String x){
        for (int k = 0; k < OPERADORES.length; k++) {
            if (x.equals(OPERADORES[k])) {
                return 770+k;
            }
        }
        return 911;
    }
    int BUSCAR3(String x){
        for (int k = 0; k < SIMBOLOS.length; k++) {
            if (x.equals(SIMBOLOS[k])) {
                return 4000+k;
            }
        }
        return 911;
    }
    
    int SCANER() {
        buffer = "";
        Character c;
        int i = 0, e = 0;
        char a;
        for (;;) {
            a = car.charAt(ind);
            if (a == '$' && i == 0) {
                return 0;
            } else if (a == '$') {
                switch (e) {
                    case 1:
                        return BUSCAR(buffer); // identificador o pal resevada
                    case 3:
                        return 300; // entero
                    case 20:
                        return BUSCAR2(buffer); // operador de agrupacion: '('
                    case 23:
                        return 500; //Comentario t1
                    case 24:
                        return BUSCAR2(buffer);
                    case 26:
                        return 600; //Comentario T2
                    case 11:
                        return 700; //Reales
                    case 15:
                        return BUSCAR(buffer); //palabra reservada
                    case 100:
                        return 300;//entero
                    case 103:
                        return 222; //Binario
                    case 113:
                        return 888; //Octal
                    case 200:
                        return 300;//entero
                    case 124:
                        return 1616; //Hexadecimal
                    case 350:
                        return BUSCAR2(buffer); //operador
                    case 351:
                        return BUSCAR2(buffer); //operador
                    case 500:
                        return BUSCAR3(buffer); // simbolos
                    default:
                        return 911;
                } // fin del switch
            } else {

                buffer = buffer.trim();
                switch (e) {
                    case 0:
                        buffer = buffer + a;
                        if (Character.isLetter(a)) {
                            if (a == 'A' || a == 'B' || a == 'C' || a == 'D' || a == 'E' || a == 'F') {
                                e = 400;
                            } else {
                                e = 1;
                                i++;
                            }

                            i++;
                        } else if (Character.isDigit(a)) {
                            if (a == '1' || a=='0') {
                                e = 100;
                                i++;
                            } else if (a == '8' || a == '9') {
                                e = 3;
                                i++;
                            } else {
                                e = 200;
                                i++;
                            }
                            i++;
                        } else if (a == '(') {
                            e = 20;
                            i++;
                        } else if (a == '/') {
                            e = 24;
                            i++;
                        } else if (a == 'Ç' || a == '&') {
                            e = 15;
                            i++;
                        } else if (a=='+'||a=='<'||a=='>'||a=='*'||a=='-'||a=='='||a=='!'||a=='^'){
                            e=350;
                            i++;    
                        } 
                        else if(a==')'){
                            i++; 
                            e=351;
                        }else if(a=='#'||a=='{'||a=='}'||a==';'||a==','||a==':'){
                            i++;
                            e=500;
                        }else if (a != ' ') {
                            return 911;
                        }else {
                            e = 0;
                        }
                        break;
                    case 1:
                        if ((Character.isDigit(a)) || (Character.isLetter(a))) {
                            buffer = buffer + a;
                            e = 1;
                        } else {
                            return BUSCAR(buffer);  // identificador o reservada
                        }
                        i++;
                        break;
                    case 3:
                        if (Character.isDigit(a)) {
                            buffer = buffer + a;
                            e = 3;
                        } else if (a == '.') {
                            buffer = buffer + a;
                            e = 10;
                        } else if (a == 'A' || a == 'B' || a == 'C' || a == 'D' || a == 'E' || a == 'F') {
                            e = 400;
                        } else if (a == '(') {
                            e = 301;
                        } else {
                            return 300;
                        }  // numero
                        i++;
                        break;
                    //DEL 10 AL 11 ES PARA RECONOCER NUMEROS REALES
                    case 10:
                        if (Character.isDigit(a)) {
                            buffer = buffer + a;
                            i++;
                            e = 11;
                        } else {
                            return 911;
                        }
                        break;
                    case 11:
                        if (Character.isDigit(a)) {
                            buffer = buffer + a;
                            i++;
                            e = 11;
                        } else{
                            return 700;
                        }
                        break;                  
                        
                    //PARA RECONOCER PALABRAS RESERVADAS
                    case 15:
                        if (Character.isLetter(a)) {
                            buffer = buffer + a;
                            e = 15;
                            i++;
                        } else {
                            return BUSCAR(buffer);  // identificador o reservada
                        }
                        break;

                    //DEL 20 AL 23 ES PARA MANEJO DE COMENTARIOS
                    case 20:
                        if (a == '*') {
                            buffer = buffer + a;
                            e = 21;
                            i++;
                        } else {
                            return BUSCAR2(buffer);
                        }
                        break;
                    case 21:
                        buffer = buffer + a;
                        if (a == '*') {
                            e = 22;
                            i++;
                        } else {
                            e = 21;
                            i++;
                        }
                        break;
                    case 22:
                        if (a == ')') {
                            buffer = buffer + a;
                            i++;
                            e = 23;
                        } else {
                            return 911;
                        }
                        break;
                    case 23:
                        i++;
                        e = 23;
                        return 500;

                    //DEL 24 AL 26 ES MANEJO DE COMENTARIOS EN LINEA
                    case 24:
                        if (a == '/') {
                            buffer = buffer + a;
                            i++;
                            e = 25;
                        } else {
                            return BUSCAR2(buffer);
                        }
                        break;
                    case 25:
                        buffer = buffer + a;
                        if (a == '/') {
                            e = 26;
                        } else {
                            return 911;
                        }
                        break;
                    case 26:
                        buffer = buffer + a;
                        e = 26;
                        break;
                    // LECTURA DE NUMEROS EN BASE 2,8 Y 16
                    case 100:
                        if (Character.isDigit(a)) {
                            buffer = buffer + a;
                            if (a == '0' || a == '1') {
                                e = 100;
                                i++;
                            } else if (a == '8' || a == '9') {
                                e = 3;
                                i++;
                            } else {
                                e = 200;
                                i++;
                            }
                        } else if (a == '(') {
                            buffer = buffer + a;
                            e = 101;
                            i++;
                        } else if (a == 'A' || a == 'B' || a == 'C' || a == 'D' || a == 'E' || a == 'F') {
                            buffer = buffer + a;
                            e = 400;
                        } else if (a == '.') {
                            buffer = buffer + a;
                            e = 10;
                        } else{
                            return 300;
                        }
                        break;
                    case 101:
                        buffer = buffer + a;
                        if (a == '2') {
                            e = 102;
                        } else if (a == '8') {
                            e = 112;
                        } else if (a == '1') {
                            e = 122;
                        } else {
                            return 911;
                        }
                        break;
                    case 102:
                        buffer = buffer + a;
                        if (a == ')') {
                            e = 103;
                            i++;
                        } else {
                            return 911;
                        }
                        break;
                    case 103:
                        return 222;
                    case 112:
                        buffer = buffer + a;
                        if (a == ')') {
                            e = 113;
                        } else {
                            return 911;
                        }
                        break;
                    case 113:
                        return 888;
                        
                    case 122:
                        buffer = buffer + a;
                        if (a == '6') {
                            e = 123;
                        } else {
                            return 911;
                        }
                        break;
                    case 123:
                        buffer = buffer + a;
                        if (a == ')') {
                            e = 124;
                        } else {
                            return 911;
                        }
                        break;
                    case 124:
                        return 1616;
                    case 200:
                        if (Character.isDigit(a)) {
                            buffer = buffer + a;
                            if (a == '8' || a == '9') {
                                e = 3;
                                i++;
                            } else {
                                e = 200;
                                i++;
                            }
                        } else if (a == '(') {
                            buffer = buffer + a;
                            e = 201;
                            i++;
                        } else if (a == '.') {
                            buffer = buffer + a;
                            e = 10;
                        } else if (a == 'A' || a == 'B' || a == 'C' || a == 'D' || a == 'E' || a == 'F') {
                            buffer = buffer + a;
                            e = 400;
                        } else {
                            return 300;
                        }
                        break;
                    case 201:
                        buffer = buffer + a;
                        if (a == '8') {
                            e = 112;
                        } else if (a == '1') {
                            e = 122;
                        } else {
                            return 911;
                        }
                        break;
                    case 301:
                        buffer = buffer + a;
                        if (a == '1') {
                            e = 122;
                        } else {
                            return 911;
                        }
                        break;
                    //Operadores logicos & aritmeticos
                    case 350:                        
                        e=350;
                        if(a==' '||Character.isDigit(a)||Character.isLetter(a)||a=='('||a==')'){
                           return BUSCAR2(buffer);
                        }
                        else{
                            buffer= buffer+a;
                        }
                        
                       break;
                     case 351:
                        return BUSCAR2(buffer);
                    // Numeros Hexadecimales
                    case 400:
                        buffer = buffer + a;
                        if (Character.isDigit(a) || a == 'A' || a == 'B' || a == 'C' || a == 'D' || a == 'E' || a == 'F') {
                            e = 400;
                            i++;
                        } else if (a == '(') {
                            e = 301;
                        } else if (Character.isLetter(a)) {
                            e = 1;
                        } else {
                            return 911;
                        }
                        break;
                    //simbolos
                    case 500:
                        return BUSCAR3(buffer);
                } // fin del switch

                ind++;
                //System.out.println(a);
            } // fin del if
        } // fin del for
    } // fin de la funcion scanner
    
    String interprete(String cad){
        //Scanner sc = new Scanner(System.in);
        int t;
        //boolean salir = true;
        //System.out.print("Ingrese una cadena ===> ");
        //car = sc.next();
        //car = car + '°';
        this.car=cad;
        //do {
            t = SCANER();
            switch (t) {
                case 0:
                    return "$";
                case 100:
                    return "id";
                case 300:
                    return "N.Entero";
                case 400:
                case 401:
                case 402:
                case 403:
                case 404:
                case 405:
                case 406:
                case 407:
                case 408:
                case 409:
                case 410:
                case 411:
                case 412:
                case 413:
                case 414:
                case 415:
                case 416:
                case 417:
                case 418:
                case 419:
                case 420:
                case 421:
                case 422:
                case 423:
                case 424:
                case 425:
                case 426:
                case 427:
                case 428:
                case 429:
                case 430:
                case 431:  
                case 432:
                    return buffer;
                case 500:
                    return "Comentario";
                case 600:
                    return "Comentario2";
                case 700:
                    return "N.Real";
                case 222:
                    return "N.Binario";
                case 770:
                case 771:
                case 772:
                case 773:
                case 774:
                case 775:
                case 776:
                case 777:
                case 778:
                case 779:
                case 780:
                case 781:
                case 782:
                case 783:
                    return buffer;
                case 888:
                    return "N.Octal";
                case 1616:
                    return "N.Hexadecimal";
                case 4000:
                case 4001:
                case 4002:
                case 4003:
                case 4004:
                case 4005:
                    return buffer;
                default:
                    System.out.println(" finalizo por error ");
                    //salir = false;
                    return "ERROR";
            }
        //} while (/*salir*/true);
    }
}