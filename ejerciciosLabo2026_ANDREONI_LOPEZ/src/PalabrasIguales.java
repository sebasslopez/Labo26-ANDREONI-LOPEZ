import java.util.Scanner;

public class PalabrasIguales {

    public static void main(String[] args) {

        System.out.println("ingresar palabra 1");
        Scanner s = new Scanner(System.in);
        String pal = s.next();
        System.out.println("ingresar palabra 2");
        Scanner e = new Scanner(System.in);
        String palb = s.next();
        while(pal.length()==palb.length()){
            System.out.println("son iguales");
        }
    }
}
