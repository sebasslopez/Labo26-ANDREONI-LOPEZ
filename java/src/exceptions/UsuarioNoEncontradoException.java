package exceptions;

public class UsuarioNoEncontradoException extends Exception {
    public UsuarioNoEncontradoException(int dni){
        super("ERROR: no hay ningun usuario registrado con el dni " + dni);
    }
}
