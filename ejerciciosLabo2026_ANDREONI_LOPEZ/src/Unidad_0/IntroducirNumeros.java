package Unidad_0;

import java.util.Scanner;

public class IntroducirNumeros {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numero = s.nextInt();
        int contador = 0;
        while ( numero != -1){
            contador++;
            numero = s.nextInt();
        }
        System.out.println(contador);
    }
}
