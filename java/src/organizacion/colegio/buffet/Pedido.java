package organizacion.colegio.buffet;

import personas.Persona;
import utils.Fecha;

public class Pedido {
    private Fecha fecha;
    private Plato plato;
    private Persona persona;
    private int hora;
    private boolean entregado;

    public Pedido(Fecha fecha, Plato plato, Persona persona, int hora, boolean entregado) {
        this.fecha = fecha;
        this.plato = plato;
        this.persona = persona;
        this.hora = hora;
        this.entregado = entregado;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public String mostrarDatos(){
        return "Fecha: "+fecha.corta()+" Plato: "+plato.getNombre()+" Persona: "+persona.getNombre()+" Hora: "+hora;
    }
}
