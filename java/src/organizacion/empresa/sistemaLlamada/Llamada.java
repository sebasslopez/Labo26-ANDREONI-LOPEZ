package organizacion.empresa.sistemaLlamada;

import personas.Persona;

import java.time.LocalDate;

public class Llamada {
    private Persona personaOrigen;
    private Persona personaDestino;
    private LocalDate fecha;
    private double duracion;
    private double costo;

    public Llamada(Persona personaOrigen, Persona personaDestino) {
        this.personaOrigen = personaOrigen;
        this.personaDestino = personaDestino;
        this.fecha = LocalDate.now();
        this.duracion = 0;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Persona getPersonaOrigen() {
        return personaOrigen;
    }

    public void setPersonaOrigen(Persona personaOrigen) {
        this.personaOrigen = personaOrigen;
    }

    public Persona getPersonaDestino() {
        return personaDestino;
    }

    public void setPersonaDestino(Persona personaDestino) {
        this.personaDestino = personaDestino;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void calcCosto() {
    }
}
