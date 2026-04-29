package Gente;

import Utils.Fecha;

public class Jugador extends Persona{
    private int numCamiseta;

    public Jugador(String nombre, String apellido, Fecha fechaNacimiento, int numeroCamiseta) {
        super(nombre,apellido,fechaNacimiento);
        this.numCamiseta = numeroCamiseta;
    }

    public int getNumCamiseta() { return numCamiseta; }
}
