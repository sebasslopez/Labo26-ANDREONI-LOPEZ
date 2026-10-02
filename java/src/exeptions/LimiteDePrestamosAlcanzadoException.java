package exeptions;

public class LimiteDePrestamosAlcanzadoException extends Exception {
    public LimiteDePrestamosAlcanzadoException(String titulo){
        super("ERROR: el libro '" + titulo + "' ya alcanzo el limite de descargas disponibles");
    }

    public LimiteDePrestamosAlcanzadoException(String titulo, int descargasDisponibles){
        super("ERROR: el libro '" + titulo + "' ya alcanzo el limite de descargas disponibles (" + descargasDisponibles + ")");
    }
}
