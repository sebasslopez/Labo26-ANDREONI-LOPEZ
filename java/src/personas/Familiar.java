package personas;

import sistema_de_alimentacion.PlatoComida;
import utils.Fecha;

import java.util.HashMap;

public class Familiar extends Persona{

    private HashMap<PlatoComida, Integer> comidas;

    public Familiar(String nombre, String apellido, Fecha f) {
        super(nombre, apellido, f);
        this.comidas= new HashMap<>();
    }


    @Override
    public String datos() {
        return "";
    }
}
