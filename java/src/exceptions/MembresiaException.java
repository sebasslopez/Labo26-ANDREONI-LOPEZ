package exceptions;

public class MembresiaException extends Exception {
    public MembresiaException(String nombre){
        super("ERROR: " + nombre + " ya alcanzo su cupo de prestamos simultaneos segun su membresia");
    }

    public MembresiaException(String nombre, String membresia, int cupo){
        super("ERROR: " + nombre + " ya alcanzo su cupo de prestamos simultaneos de la membresia " + membresia + " (" + cupo + ")");
    }
}
