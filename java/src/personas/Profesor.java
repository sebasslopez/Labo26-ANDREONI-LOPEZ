package personas;

public class Profesor extends Persona{
private int porcentajeDescu;

    public Profesor(String nombre, String apellido, int porcentajeDescu) {
        super(nombre, apellido);
        this.porcentajeDescu = porcentajeDescu;
    }

    public int getPorcentajeDescu() {
        return porcentajeDescu;
    }

    public void setPorcentajeDescu(int porcentajeDescu) {
        this.porcentajeDescu = porcentajeDescu;
    }
}
