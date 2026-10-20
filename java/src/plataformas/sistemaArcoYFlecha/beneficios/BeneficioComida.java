package plataformas.sistemaArcoYFlecha.beneficios;

import plataformas.sistema_de_alimentacion.PlatoComida;

import java.util.HashSet;

public class BeneficioComida extends BeneficioAcumulable{
    private HashSet<PlatoComida> comidas;

    public BeneficioComida(String nombre, String creador) {
        super(nombre, creador);
        comidas = new HashSet<>();
    }

    @Override
    public float calcularDescuentoExtra() {
        return 4500;
    }

    public HashSet<PlatoComida> getComidas() {
        return comidas;
    }

    public void setComidas(HashSet<PlatoComida> comidas) {
        this.comidas = comidas;
    }

    public void anadirComida(PlatoComida comida){
        comidas.add(comida);
    }

    public void eliminarComida(PlatoComida comida){
        comidas.remove(comida);
    }
}
