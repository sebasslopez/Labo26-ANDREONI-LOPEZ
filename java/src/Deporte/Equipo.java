package Deporte;

import Gente.Jugador;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores;
    private ArrayList<String> turnosDisponibles;
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
        this.turnosDisponibles = new ArrayList<>();
    }
    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }
    public int getCantidadJugadores() {
        return jugadores.size();
    }
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    public void agregarTurno(String turno) {
        if ((turno.equalsIgnoreCase("mañana") || turno.equalsIgnoreCase("tarde") || turno.equalsIgnoreCase("noche")) && !turnosDisponibles.contains(turno)) {
            turnosDisponibles.add(turno);
        }
    }
    public ArrayList<String> getTurnosDisponibles() {
        return turnosDisponibles;
    }
    public boolean esValido() {
        if (jugadores.size() != 11) {
            return false;
        }
        int cantCapitanes = 0;
        for (Jugador j : jugadores) {
            if (j.isEsCapitan()) {
                cantCapitanes++;
            }
        }
        if (cantCapitanes != 1) {
            return false;
        }
        for (Jugador j : jugadores) {
            for (Jugador j2 : jugadores) {
                if (j.getNumCamiseta() == j2.getNumCamiseta() && !j.equals(j2)) {
                    return false;
                }
            }
        }
        if (turnosDisponibles.isEmpty()) return false;
        return true;
    }
    public String getNombre() { return nombre; }
}
