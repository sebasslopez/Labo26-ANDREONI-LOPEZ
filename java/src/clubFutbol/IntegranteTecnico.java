package clubFutbol;

import personas.Persona;
import utils.Fecha;

import java.util.HashSet;

public abstract class IntegranteTecnico extends Persona implements Candidato{
    private String titulo;
    private int experiencia;
    private HashSet<ClubDeFutbol> clubesAnteriores;

    public IntegranteTecnico(String nombre, String apellido, Fecha f, String titulo, int experiencia) {
        super(nombre, apellido, f);
        this.titulo = titulo;
        this.experiencia = experiencia;
        this.clubesAnteriores = new HashSet<>();
    }

    public HashSet<ClubDeFutbol> getClubesAnteriores() {
        return clubesAnteriores;
    }

    public void setClubesAnteriores(HashSet<ClubDeFutbol> clubesAnteriores) {
        this.clubesAnteriores = clubesAnteriores;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void contratar(ClubDeFutbol c) throws NoPuedeContratarException {
        if(clubesAnteriores.contains(c)) throw new NoPuedeContratarException("El Técnico ya trabajó en ese club.");
    }

    @Override
    public void renovar(ClubDeFutbol club) throws NoPuedeRenovarException {
        if(!club.trabajaAhi(this)) throw new NoPuedeRenovarException("El tecnico no trabaja en el club.");
    }
}

