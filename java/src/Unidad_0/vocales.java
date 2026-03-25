package Unidad_0;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;

public class vocales {
    public static void main(String[] args) {
        String juan ="Ayer me compré muñecos de la marca ‘ToyCo’ por internet.";
        int vocales=0;
        for(int i=0; i<juan.length(); i++){
            if(esVocal(juan.charAt(i))){
               vocales ++;
            }
        }
        System.out.println(vocales);
    }

    public static Boolean esVocal(char caracter){
        ArrayList<Character> vocales = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
        return vocales.contains(Character.toLowerCase(caracter));
    }
}
