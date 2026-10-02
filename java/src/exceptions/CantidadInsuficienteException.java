package exceptions;

public class CantidadInsuficienteException extends Exception {
    public CantidadInsuficienteException(String nombre, int solicitada, int disponible){
        super("ERROR: no hay cantidad suficiente de '" + nombre + "', se piden " + solicitada + " y solo hay " + disponible);
    }
}
