package organizacion.empresa.sistemaLlamada;

import personas.Persona;

public class LlamadaNacional extends Llamada {
    public LlamadaNacional(Persona personaOrigen, Persona personaDestino) {
        super(personaOrigen, personaDestino);
    }

    @Override
    public void calcCosto() {
        super.setCosto(super.getDuracion());
    }
}
