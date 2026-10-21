package deporte.curling;

import personas.JugadorCurling;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<JugadorCurling> jugadores;
    private ArrayList<Turno> turnosDisponibles;
    private JugadorCurling capitan;
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.turnosDisponibles = new ArrayList<>();
    }
    public void agregarJugador(JugadorCurling jugador) {
        jugadores.add(jugador);
    }
    public int getCantidadJugadores() {
        return jugadores.size();
    }
    public ArrayList<JugadorCurling> getJugadores() {
        return jugadores;
    }
    public void agregarTurno(Turno turno) {
        if ((turno == Turno.MAÑANA || turno == Turno.TARDE || turno == Turno.NOCHE) && !turnosDisponibles.contains(turno)) {
            turnosDisponibles.add(turno);
        }
    }
    public ArrayList<Turno> getTurnosDisponibles() {
        return turnosDisponibles;
    }
    public boolean esValido() {
        if (jugadores.size() != 11) {
            return false;
        }
        if(!hayCapitan()) return false;
        for (JugadorCurling j : jugadores) {
            for (JugadorCurling j2 : jugadores) {
                if (j.getNumCamiseta() == j2.getNumCamiseta() && !j.equals(j2)) {
                    return false;
                }
            }
        }
        if (turnosDisponibles.isEmpty()) return false;
        return true;
    }
    public String getNombre() { return nombre; }

    public JugadorCurling getCapitan() {
        return capitan;
    }

    public void setCapitan(JugadorCurling capitan) {
        this.capitan = capitan;
    }
    public boolean hayCapitan(){
        return capitan != null;
    }
}
