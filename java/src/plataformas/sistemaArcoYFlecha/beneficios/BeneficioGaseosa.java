package plataformas.sistemaArcoYFlecha.beneficios;

import plataformas.sistemaArcoYFlecha.Gaseosa;

import java.util.HashSet;

public class BeneficioGaseosa extends BeneficioAcumulable{
    private HashSet<Gaseosa> gaseosas;

    public BeneficioGaseosa(String nombre, String creador) {
        super(nombre, creador);
        gaseosas = new HashSet<>();
    }

    @Override
    public float calcularDescuentoExtra() {
        return 1000;
    }

    public HashSet<Gaseosa> getGaseosas() {
        return gaseosas;
    }

    public void setGaseosas(HashSet<Gaseosa> gaseosas) {
        this.gaseosas = gaseosas;
    }

    public void anadirGaseosa(Gaseosa g){
        gaseosas.add(g);
    }

    public void eliminarGaseosa(Gaseosa g){
        gaseosas.remove(g);
    }
}
