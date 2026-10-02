package exceptions;

public class SinCPUException extends SinComponenteException {
    public SinCPUException(){
        super("No hay una CPU en esta PC");
    }
}
