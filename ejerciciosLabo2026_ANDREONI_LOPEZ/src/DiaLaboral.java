import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DiaLaboral {
    public static void main(String[] args) {
        ArrayList<String> dias = new ArrayList<>(Arrays.asList("lunes","martes","miercoles","jueves","viernes"));
        Scanner scanner = new Scanner(System.in);
        System.out.print("ingresar dia laborable: ");
        String dia = scanner.nextLine();
        if (dias.contains(dia.toLowerCase())){
            System.out.println("es dia laborable");
        }else{
            System.out.println("hoy no se labura");
        }
    }
}
