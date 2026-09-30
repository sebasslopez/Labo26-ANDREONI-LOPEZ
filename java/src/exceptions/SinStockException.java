package exceptions;

public class SinStockException extends Exception{
    public SinStockException(){
        super("No hay stock suficiente");
    }
}
