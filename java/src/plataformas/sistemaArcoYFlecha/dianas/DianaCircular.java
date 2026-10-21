package plataformas.sistemaArcoYFlecha.dianas;

import plataformas.recetas.platos.NivelDeDificultad;

public class DianaCircular extends Diana{
    static int radio = 13;

    public DianaCircular(String nombre, NivelDeDificultad dificultad) {
        super(nombre, dificultad);
    }

    @Override
    public float calcularRadio() {
        return (float) (Math.PI * Math.pow(radio,2));
    }
}
