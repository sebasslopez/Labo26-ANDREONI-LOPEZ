package personas;

import utils.Fecha;

import java.time.LocalDate;

public abstract class Jugador extends Persona{
    private int numCamiseta;
    public Jugador(String nombre, String apellido, Fecha date,int numCamiseta) {
        super(nombre, apellido, date);
        this.numCamiseta = numCamiseta;
    }

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public void setNumCamiseta(int numCamiseta) {
        this.numCamiseta = numCamiseta;
    }
}
