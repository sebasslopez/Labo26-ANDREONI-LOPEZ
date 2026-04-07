package vehiculos;

public class Submarino {
    private String nombre;
    private int profundidadmax;
    private int profundidadactual;
    public Submarino(String nombre, int profundidadmax) {
        this.nombre = nombre;
        this.profundidadmax = profundidadmax;
    }
    public void sumergir(int metros){
        if(profundidadactual + metros >= profundidadmax){
            System.out.println("ALERTA: Intento de sumerger más de lo permitido. No baje más de "+profundidadmax+" para proteger el casco.");
        }
        else{
            profundidadactual += metros;
        }
    }
    public void emerger(int metros){
        if(profundidadactual - metros <= 0){
            System.out.println("ALERTA: Intento de emerger más de la superficie. Se emergerá hasta la superficie");
            profundidadactual = 0;
        }
        else{
            profundidadactual -= metros;
        }
    }

    public static void main(String[] args) {

    }
}
