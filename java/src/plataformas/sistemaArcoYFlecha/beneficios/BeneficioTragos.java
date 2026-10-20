package plataformas.sistemaArcoYFlecha.beneficios;

import plataformas.sistemaArcoYFlecha.Trago;

import java.util.HashSet;

public class BeneficioTragos extends BeneficioNoAcumulable{
    private HashSet<Trago> tragos;

    public BeneficioTragos(String nombre, String creador) {
        super(nombre, creador);
        tragos = new HashSet<>();
    }

    public HashSet<Trago> getTragos() {
        return tragos;
    }

    public void setTragos(HashSet<Trago> tragos) {
        this.tragos = tragos;
    }

    public void anadirTrago(Trago t){
        tragos.add(t);
    }

    public void eliminarTrago(Trago t){
        tragos.remove(t);
    }
}
