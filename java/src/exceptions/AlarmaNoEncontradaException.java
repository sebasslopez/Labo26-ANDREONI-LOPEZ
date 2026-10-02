package exceptions;

public class AlarmaNoEncontradaException extends Exception {
    public AlarmaNoEncontradaException(int numero, int cantidad){
        super("ERROR: no existe la alarma " + numero + ", el edificio tiene " + cantidad + " alarma(s) (numeros validos de 0 a " + (cantidad - 1) + ")");
    }

    public AlarmaNoEncontradaException(String nombre){
        super("ERROR: no existe ninguna alarma llamada '" + nombre + "'");
    }
}
