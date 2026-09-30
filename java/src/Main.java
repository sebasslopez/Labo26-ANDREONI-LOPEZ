import exeptions.NullNameExeption;

public class Main {
    static void main() {
        String nombre =null;

        try{
            System.out.println("el largo del nombre es: " + obtenerLargo(nombre));
        }
        catch (NullNameExeption e){
            System.out.println(e.getMessage());
        }
    }

    public static int obtenerLargo(String nombre) throws NullNameExeption {
        if(nombre == null) throw new NullNameExeption();
        return nombre.length();
    }
}
