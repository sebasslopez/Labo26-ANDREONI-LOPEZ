package organizacion.empresa.sistemaLlamada;

import personas.Persona;

public class LlamadaInternacional extends Llamada {
    private String franjaHoraria;

    public LlamadaInternacional(Persona personaOrigen, Persona personaDestino, String franjaHoraria) {
        super(personaOrigen, personaDestino);
        this.franjaHoraria = franjaHoraria;
    }

    public String getFranjaHoraria() {
        return franjaHoraria;
    }

    public void setFranjaHoraria(String franjaHoraria) {
        this.franjaHoraria = franjaHoraria;
    }

    @Override
    public void calcCosto() {
        super.setCosto(super.getDuracion() * 10);
    }
}
