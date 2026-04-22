package Gente;

import Utils.Fecha;

public class Jugador {
    private String nombre;
    private String apellido;
    private Fecha fechaNac;
    private int numCamiseta;
    private boolean capitan;

    public Jugador(String nombre, String apellido, Fecha fechaNacimiento, int numeroCamiseta, boolean esCapitan) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNacimiento;
        this.numCamiseta = numeroCamiseta;
        this.capitan = esCapitan;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public Fecha getFechaNacimiento() { return fechaNac; }
    public int getNumCamiseta() { return numCamiseta; }
    public boolean isEsCapitan() { return capitan; }
}
