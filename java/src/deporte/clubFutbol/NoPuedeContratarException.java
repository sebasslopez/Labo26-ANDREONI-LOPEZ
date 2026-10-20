package deporte.clubFutbol;

public class NoPuedeContratarException extends Exception{
    public NoPuedeContratarException(String motivo){
        super("No se pudo contratar por: "+motivo);
    }
}
