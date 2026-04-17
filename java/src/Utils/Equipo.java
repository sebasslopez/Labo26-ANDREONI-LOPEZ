package Utils;

import Gente.Jugador;

import java.util.ArrayList;

public class Equipo {
    private ArrayList<Jugador> jugadores;
    private String Turno;

    public Equipo(){
        this.jugadores = new ArrayList<>();
        this.Turno = "mañana";
    }
    public Equipo(ArrayList<Jugador> j,String t){
        this.Turno = t;
        this.jugadores =j;
    }
    public Equipo(String t){
        this.Turno = t;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador j){
        if(jugadores.contains(j)) return;
        jugadores.add(j);
    }
    public int cantidadJugadores(){
        return jugadores.size();
    }
    public boolean esValido(){
        if(jugadores.size() == 11 &&)
    }
}
