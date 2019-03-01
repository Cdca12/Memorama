package utils;


import java.awt.*;
import java.util.Random;

import javax.swing.ImageIcon;

public class Rutinas {

    public static ImageIcon AjustarImagen(String ico, int Ancho, int Alto) {
        ImageIcon tmpIconAux = new ImageIcon(ico);
        //Escalar Imagen
        ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(Ancho,
                Alto, Image.SCALE_SMOOTH));//SCALE_DEFAULT
        return tmpIcon;
    }
    static Random R = new Random();
    static String[] VN = {"Alicia", "Maria", "Sofia", "Antonio", "Nereida", "Carolina",
        "Rebaca", "Javier", "Luis"};
    static String[] VA = {"Garcia", "Lopez", "Perez", "Urias", "Mendoza", "Coppel", "Diaz"};
    static boolean[] Sexo = {false, false, false, true, false, false,
        false, true, true};

    public static String PonBlancos(String Texto, int Tamaño) {
        while (Texto.length() < Tamaño) {
            Texto += " ";
        }
        return Texto;
    }

    public static String PonCeros(int Valor, int Tamaño) {
        String Texto = Valor + "";
        while (Texto.length() < Tamaño) {
            Texto = "0" + Texto;
        }
        return Texto;
    }

    public static int nextInt(int Valor) {
        return R.nextInt(Valor);
    }

    public static int nextInt(int Ini, int Fin) {
        return R.nextInt(Fin - Ini + 1) + Ini;
    }

    public static String nextNombre(int Numero) {
        String Nom = "", NomTra = "";
        int Pos;
        boolean Genero = true;;

        for (int i = 0; i < Numero; i++) {
            Pos = nextInt(VN.length);

            NomTra = VN[Pos] + " ";

            if (i == 0) {
                Genero = Sexo[Pos];
            }

            if (Genero != Sexo[Pos] || i > 0 && Nom.indexOf(NomTra) > -1) {
                i--;
                continue;
            }

            Nom += NomTra + " ";

        }
        for (byte i = 0; i < 0; i++) {
            Nom += VA[nextInt(VA.length)] + " ";
        }
        return Nom;
    }

    static int Contador;

    public static void Hanoi(char Inicial, char Central, char Final, int N) {
        if (N == 1) {
            Contador++;
            System.out.println(Contador + " Move disco " + N + " de la torre " + Inicial + " a la torre " + Final);
        } else {
            Hanoi(Inicial, Final, Central, N - 1);
            Contador++;
            System.out.println(Contador + " Move disco " + N
                    + " de la torre " + Inicial + " a la torre " + Final);
            Hanoi(Central, Inicial, Final, N - 1);
        }
    }

}
