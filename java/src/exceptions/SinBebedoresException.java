package exceptions;

public class SinBebedoresException extends Exception {
    public SinBebedoresException(){
        super("ERROR: no hay bebedores registrados en el sistema");
    }
}
