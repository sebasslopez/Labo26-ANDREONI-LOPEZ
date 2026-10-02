package practica_examen;

import java.time.LocalDate;
import java.util.ArrayList;

public class jjsjs {
    private ArrayList<Integer> numeros;
    private edadRecomendada edadreco;

    public jjsjs(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }
    public void agregarNum(int num){
        numeros.add(num);
    }
    public int numeroMayor() {

        int masGrande = numeros.get(0);
        for (Integer numero : numeros) {
            if (masGrande < numero) {
                masGrande = numero;
            }
        }

    return masGrande;
    }

    static void main() {
        jjsjs j = new jjsjs(new ArrayList<>());


        System.out.println(j.numeroMayor());
    }








}
