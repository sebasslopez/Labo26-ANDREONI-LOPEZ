package exceptions;

public class BebidaNoEncontradaException extends Exception {
    public BebidaNoEncontradaException(String nombre){
        super("ERROR: la bebida '" + nombre + "' no esta disponible en el sistema");
    }
}
