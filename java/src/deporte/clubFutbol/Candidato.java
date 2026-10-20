package deporte.clubFutbol;

public interface Candidato {
    void contratar(ClubDeFutbol club) throws NoPuedeContratarException;
    void renovar(ClubDeFutbol club) throws NoPuedeRenovarException;
}
