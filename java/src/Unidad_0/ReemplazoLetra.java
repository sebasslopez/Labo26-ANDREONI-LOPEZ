package Unidad_0;

import java.util.Scanner;

public class ReemplazoLetra {
    public static void main(String[] args) {
        char letra;
        String frase= "Ayer me compré muñecos de la marca ‘ToyCo’ por internet.";
        Scanner scanner = new Scanner(System.in);
        System.out.print("ingresar letra: ");
        letra = scanner.nextLine().charAt(0);
        for(int i=0; i<frase.length(); i++){
            if(Character.toLowerCase(frase.charAt(i)) =='e'){
                frase = frase.replace(frase.charAt(i),letra);
            }
        }
    }
}
