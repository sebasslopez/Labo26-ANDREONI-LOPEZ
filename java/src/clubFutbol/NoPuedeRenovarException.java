package clubFutbol;

public class NoPuedeRenovarException extends Exception{
    public NoPuedeRenovarException(String motivo){
        super("No se pudo renovar por: "+motivo);
    }
}
