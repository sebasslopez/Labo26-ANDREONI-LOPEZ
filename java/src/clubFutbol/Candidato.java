package clubFutbol;

import java.util.HashSet;

public interface Candidato {
    void contratar(ClubDeFutbol club) throws NoPuedeContratarException;
    void renovar(ClubDeFutbol club) throws NoPuedeRenovarException;

    void agregarse(HashSet<IntegranteTecnico> tecnicos, HashSet<JugadorFutbol> jugadores);
}
