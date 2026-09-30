package exceptions;

public class SinDispositivoIOException extends SinComponenteException {
    public SinDispositivoIOException(){
        super("Falta uno o ambos de los dispositivos de Entrada/Salida");
    }
}
