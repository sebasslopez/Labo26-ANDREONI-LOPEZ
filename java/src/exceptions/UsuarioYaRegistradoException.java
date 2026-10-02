package exceptions;

public class UsuarioYaRegistradoException extends Exception {
    public UsuarioYaRegistradoException(int dni, String nombre){
        super("ERROR: el usuario '" + nombre + "' ya esta registrado en la plataforma (dni " + dni + ")");
    }
}
