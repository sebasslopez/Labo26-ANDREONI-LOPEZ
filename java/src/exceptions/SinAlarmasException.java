package exceptions;

public class SinAlarmasException extends Exception {
    public SinAlarmasException(){
        super("ERROR: el edificio no tiene ningun dispositivo instalado");
    }
}
