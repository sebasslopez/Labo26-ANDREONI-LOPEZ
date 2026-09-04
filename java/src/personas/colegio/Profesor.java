package personas.colegio;

import personas.Persona;

public class Profesor extends Persona {
    private static int porcentajeDescu;

    public Profesor(String nombre, String apellido, int p) {
        super(nombre, apellido);
        porcentajeDescu = p;
    }

    public int getPorcentajeDescu() {
        return porcentajeDescu;
    }

    public void setPorcentajeDescu(int p) {
        porcentajeDescu = p;
    }
}
