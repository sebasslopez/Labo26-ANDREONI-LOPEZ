package plataformas.sistemaArcoYFlecha.dianas;

import plataformas.recetas.platos.NivelDeDificultad;

public class DianaCuadrada extends Diana{
    private int lado;

    public DianaCuadrada(String nombre, NivelDeDificultad dificultad, int lado) {
        super(nombre, dificultad);
        this.lado = lado;
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public float calcularRadio() {
        return (float) Math.pow(lado,2);
    }
}
