package plataformas.sistemaArcoYFlecha.dianas;

import plataformas.recetas.platos.NivelDeDificultad;

import java.util.HashMap;

public abstract class Diana {
    private String nombre;
    private NivelDeDificultad dificultad;
    private HashMap<Integer, ColorDiana> puntaje;

    public Diana(String nombre, NivelDeDificultad dificultad) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        puntaje = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelDeDificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(NivelDeDificultad dificultad) {
        this.dificultad = dificultad;
    }

    public HashMap<Integer, ColorDiana> getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(HashMap<Integer, ColorDiana> puntaje) {
        this.puntaje = puntaje;
    }

    public abstract float calcularRadio();

    public int getCantPuntajes(){
        return puntaje.size();
    }
}
