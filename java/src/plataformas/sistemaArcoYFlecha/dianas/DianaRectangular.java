package plataformas.sistemaArcoYFlecha.dianas;

import plataformas.recetas.platos.NivelDeDificultad;

public class DianaRectangular extends Diana{
    private int altura;
    private int base;

    public DianaRectangular(String nombre, NivelDeDificultad dificultad, int altura, int base) {
        super(nombre, dificultad);
        this.altura = altura;
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public float calcularRadio() {
        return base*altura;
    }
}
