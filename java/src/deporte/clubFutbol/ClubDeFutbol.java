package deporte.clubFutbol;

import personas.Persona;

import java.util.HashSet;

public class ClubDeFutbol{
    private String nombre;
    private HashSet<IntegranteTecnico> tecnicos;
    private HashSet<JugadorFutbol> jugadores;
    private HashSet<Candidato> candidatos;

    public ClubDeFutbol(){
        tecnicos = new HashSet<>();
        jugadores = new HashSet<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public HashSet<IntegranteTecnico> getTecnicos() {
        return tecnicos;
    }

    public HashSet<JugadorFutbol> getJugadores() {
        return jugadores;
    }

    public HashSet<Candidato> getCandidatos() {
        return candidatos;
    }

    public void añadirCandidato(Candidato c){
        candidatos.add(c);
    }

    public void contratar(){
        for(Candidato c : candidatos){
            try {
                c.contratar(this);

                c.agregarse(tecnicos,jugadores);
                //if(c instanceof IntegranteTecnico i) tecnicos.add(i);
                //else jugadores.add((JugadorFutbol) c);
                System.out.println(((Persona) c).getNombreCompleto() + " fue contratado por "+nombre);
            } catch (NoPuedeContratarException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void renovar(){
        for(Candidato c : candidatos){
            try {
                c.renovar(this);
                System.out.println(((Persona) c).getNombreCompleto() + " renovó su contrato con "+nombre);
            } catch (NoPuedeRenovarException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public boolean trabajaAhi(Candidato c){
        if(c instanceof IntegranteTecnico i) return tecnicos.contains(i);
        return jugadores.contains((JugadorFutbol) c);
    }

    public void informacionPlantel(){
        for(IntegranteTecnico tecnico : tecnicos){
            System.out.println(tecnico);
        }
        for(JugadorFutbol jugador : jugadores){
            System.out.println(jugador);
        }
    }
}
