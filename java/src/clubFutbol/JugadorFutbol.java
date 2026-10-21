package clubFutbol;

import personas.Jugador;
import utils.Fecha;

import java.util.HashSet;

public abstract class JugadorFutbol extends Jugador implements Candidato {
    private Posicion posicion;
    private HashSet<ClubDeFutbol> clubesAnteriores;
    private String provincia;

    public JugadorFutbol(String nombre, String apellido, Fecha date, int numCamiseta, Posicion posicion, String provincia) {
        super(nombre, apellido, date, numCamiseta);
        this.posicion = posicion;
        this.clubesAnteriores = new HashSet<>();
        this.provincia = provincia;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public HashSet<ClubDeFutbol> getClubesAnteriores() {
        return clubesAnteriores;
    }

    public void setClubesAnteriores(HashSet<ClubDeFutbol> clubesAnteriores) {
        this.clubesAnteriores = clubesAnteriores;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public void contratar(ClubDeFutbol c) throws NoPuedeContratarException {
        if(clubesAnteriores.contains(c)) throw new NoPuedeContratarException("El jugador ya trabajó en ese club.");
    }

    @Override
    public void renovar(ClubDeFutbol club) throws NoPuedeRenovarException {
        if(!club.trabajaAhi(this) || this.getEdad() > 35) throw new NoPuedeRenovarException("El jugador no trabaja en el club.");
    }

    @Override
    public void agregarse(HashSet<IntegranteTecnico> tecnicos, HashSet<JugadorFutbol> jugadores) {
        jugadores.add(this);
    }
}
