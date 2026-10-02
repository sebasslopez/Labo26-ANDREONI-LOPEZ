package exceptions;

public class DniYaRegistradoException extends Exception {
    public DniYaRegistradoException(int dni){
        super("ERROR: el dni " + dni + " ya esta registrado en el sistema");
    }

    public DniYaRegistradoException(int dni, String nombre){
        super("ERROR: el dni " + dni + " ya esta registrado en el sistema (pertenece a " + nombre + ")");
    }
}
