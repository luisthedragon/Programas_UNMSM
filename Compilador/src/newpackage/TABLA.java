package newpackage;

class TABLA {
    static final int FIL = 32;
    static final int COL = 54;
    String M[][] = new String[FIL][COL];
    String produccion = "";

    TABLA() {          // se inicializa la tabla
        for (int i = 0; i < FIL; i++) {
            for (int j = 0; j < COL; j++) {
                M[i][j] = " ";// primero se llena de blancos
            }
        }
        M[0][1] = "#";
        M[0][2] = "$";
        M[0][3] = "publicus";
        M[0][4] = "privatus";
        M[0][5] = "munus";
        M[0][6] = "}";
        M[0][7] = "break";
        M[0][8] = "reditus";
        M[0][9] = "TOT";
        M[0][10] = "BOOL";
        M[0][11] = "VOLI";
        M[0][12] = "REALI";
        M[0][13] = "CAR";
        M[0][14] = "BIN";
        M[0][15] = "OCT";
        M[0][16] = "HEX";
        M[0][17] = "TORQ";
        M[0][18] = "vacuum";
        M[0][19] = "si";
        M[0][20] = "dum";
        M[0][21] = "per";
        M[0][22] = "id";
        M[0][23] = "*";
        M[0][24] = ",";
        M[0][25] = ";";
        M[0][26] = "=";
        M[0][27] = "autem";
        M[0][28] = "apud";
        M[0][29] = "default";
        M[0][30] = "letra";
        //M[0][31] = "N.Entero";
        M[0][32] = "quod";
        M[0][33] = "uel";
        M[0][34] = "(";
        M[0][35] = ")";
        M[0][36] = "N.Entero";
        M[0][37] = "N.Real";
        M[0][38]="+";
        M[0][39]="-";
        M[0][40]="^";
        M[0][41]="<";
        M[0][42]=">";
        M[0][43]="<=";
        M[0][44]=">=";
        M[0][45]="!=";
        M[0][46]="==";
        M[0][47]="/";
        //sin produccion
        M[0][48]="genus";
        M[0][49]="Principalem";
        M[0][50]="{";
        M[0][51]=":";
        M[0][52]="facio";
        M[0][53]="facite";
        
        
        M[1][0] = "S";
        M[1][1] = "clases } funciones } instrucciones { ) ( Principalem { id genus publicus #";
        
        M[2][0] = "clases";
        M[2][2] = "&";
        M[2][3] = "clases clase";
        M[2][4] = "clases clase";
        
        M[3][0] = "clase";
        M[3][3] = "} funciones atributos { id genus publicus";
        M[3][4] = "} funciones atributos { id genus privatus";
        
        M[4][0] = "funciones";
        M[4][5] = "funciones funcion";
        M[4][6] = "&";
        M[4][7] = "&";
        M[4][8] = "&";
        
        M[5][0] = "A";
        M[5][9] = "} ; id reditus instrucciones { ) declarar ( tipo_dato";
        M[5][10] = "} ; id reditus instrucciones { ) declarar ( tipo_dato";
        M[5][11] = "} ; id reditus instrucciones { ) declarar ( tipo_dato";
        M[5][12] = "} ; id reditus instrucciones { ) declarar ( tipo_dato";
        M[5][13] = "} ; id reditus instrucciones { ) declarar ( tipo_dato";
        M[5][14] = "} ; id reditus instrucciones { ) declarar ( tipo_dato";
        M[5][15] = "} ; id reditus instrucciones { ) declarar ( tipo_dato";
        M[5][16] = "} ; id reditus instrucciones { ) declarar ( tipo_dato";
        M[5][17] = "} ; id reditus instrucciones { ) declarar ( tipo_dato";
        M[5][18] = "} instrucciones { ) declarar ( vacuum";
        
        M[6][0] = "funcion";
        M[6][5] = "A id munus";
        
        M[7][0] = "instrucciones";
        M[7][5] = "instrucciones instruccion";
        M[7][6] = "&";
        M[7][7] = "&";
        M[7][8] = "&";
        M[7][19] = "instrucciones instruccion";
        M[7][20] = "instrucciones instruccion";
        M[7][21] = "instrucciones instruccion";
        M[7][22] = "instrucciones instruccion";
        M[7][23] = "instrucciones instruccion";
        
        M[8][0] = "instruccion";
        M[8][5] = "funcion";
        M[8][19] = "si_sino";
        M[8][20] = "mientras_hacer";
        M[8][21] = "segun_hacer";
        M[8][22] = "; asignar id";
        M[8][23] = "; declarar";
        
        M[9][0] = "declarar";
        M[9][23] = "mas asignar id M *";
        
        M[10][0] = "mas";
        M[10][24] = "mas asignar id ,";
        M[10][25] = "&";
        M[10][35] = "&";
        
        M[11][0] = "asignar";
        M[11][24] = "&";
        M[11][25] = "&";
        M[11][26] = "valor =";
        M[11][35] = "&";
        
        M[12][0] = "valor";
        M[12][5] = "funcion";
        M[12][22] = "E";
        M[12][34] = "E";
        M[12][36] = "E";
        M[12][37] = "E";

        M[13][0] = "mientras_hacer";
        M[13][20] = "} instrucciones { facite ) condicion id operador_relacional id ( dum";
        
        M[14][0] = "si_sino";
        M[14][19] = "C } instrucciones { ) condicion id operador_relacional id ( si";
        
        M[15][0] = "C";
        M[15][27] = "} instrucciones { autem";
        M[15][6] = "&";
        M[15][7] = "&";
        M[15][8] = "&";
        
        M[16][0] = "segun_hacer";
        M[16][21] = "} ; break } instrucciones { : default lista_case { facio ) id ( per";
        
        M[17][0] = "lista_case";
        M[17][28] = "lista_case case";
        M[17][29] = "&";
        
        M[18][0] = "case";
        M[18][28] = "; break instrucciones : D apud";
        
        M[19][0] = "D";
        M[19][30] = "letra";
        M[19][36] = "N.Entero";
        
        M[20][0] = "condicion";
        M[20][32] = "condicion_and";
        M[20][33] = "condicion_or";
        M[20][35] = "&";
        
        M[21][0] = "condicion_and";
        M[21][32] = "condicion id operador_relacional id quod";
        
        M[22][0] = "condicion_or";
        M[22][33] = "condicion id operador_relacional id uel";
        
        
        M[23][0] ="E";
        M[23][22] ="V Z";
        M[23][34] ="V H E (";
        M[23][36] ="V Z";
        M[23][37] ="V Z";
        
        M[24][0] = "V";        
        M[24][6] = "&";
        M[24][7] = "&";
        M[24][8] = "&";
        M[24][23] = "E *";
        M[24][25] = "&";
        M[24][35] = "&";
        //M[24][36] = "E operador_aritmetico";
        M[24][38] = "E +";
        M[24][39] = "E -";
        M[24][40] = "E ^";
        M[24][47] = "E /";        
        
        M[25][0] = "H";
        M[25][35] = ")";
        
        M[26][0] = "tipo_dato";
        M[26][9] = "TOT";
        M[26][10] = "BOOL";
        M[26][11] = "VOLI";
        M[26][12] = "REALI";
        M[26][13] = "CAR";
        M[26][14] = "BIN";
        M[26][15] = "OCT";
        M[26][16] = "HEX";
        M[26][17] = "TORQ"; 
        
        M[27][0] = "Z";
        M[27][22] = "id";
        M[27][36] = "N.Entero";
        M[27][37] = "N.Real";
        
        M[28][0] ="operador_aritmetico";
        M[28][23] ="*";
        M[28][38] = "+";
        M[28][39] = "-";
        M[28][40] = "^";
        M[28][47] = "/";
        
        M[29][0] = "operador_relacional";
        M[29][41] ="<";
        M[29][42] =">";
        M[29][43] ="<=";
        M[29][44] ="<=";
        M[29][45] ="!=";
        M[29][46] ="==";
        
        M[30][0] = "M";
        M[30][9] = "TOT";
        M[30][10] = "BOOL";
        M[30][11] = "VOLI";
        M[30][12] = "REALI";
        M[30][13] = "CAR";
        M[30][14] = "BIN";
        M[30][15] = "OCT";
        M[30][16] = "HEX";
        M[30][17] = "TORQ";
        M[30][22] = "id";
        
        M[31][0] = "atributos";
        M[31][5] = "&";
        M[31][6] = "&";
        M[31][23] = "atributos ; declarar";
    }

    boolean Terminal(String car) {
        for (int i = 1; i < COL; i++) {
            if (M[0][i].equals(car)) {
                return true;
            }
        }
        return false;
    }

    String RetProduccion() {
        return produccion;
    }

    boolean ExisteInterseccion(String XX, String ae) {
        int i, x = 0, y = 0;
        for (i = 1; i < COL; i++) {
            if (M[0][i].equals(ae)) {
                x = i;
            }
        }

        for (i = 1; i < FIL; i++) {
            if (M[i][0].equals(XX)) {
                y = i;
            }
        }
        if (x == 0 || y == 0) {
            return false;
        } else if (M[y][x].equals(" ")) {
            return false;
        } else {
            produccion = M[y][x];
            return true;
        }

    }
} // FIN DE CLASE TABLA

