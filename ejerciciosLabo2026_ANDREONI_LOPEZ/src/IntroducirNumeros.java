import java.util.Scanner;

public class IntroducirNumeros {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int numero = s.nextInt();
        int numMayor=0;
        int numMenor=0;
        int suma=0;
        int contador = 0;
        while ( numero != -1){
            contador++;
            numero = s.nextInt();
            suma= suma+numero;
            System.out.println(suma);
            if(numero > numMayor){
            numMayor= numero;
                System.out.println(numMayor);
        }else if(numero < numMenor){
                numMenor=numero;
                System.out.println(numMenor);
            }

        }
        System.out.println(contador);

    }
}
