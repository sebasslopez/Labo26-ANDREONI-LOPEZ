package plataformas.appMascotas.Mascotas;

import personas.Persona;

public class PajaroCantor extends Pajaro{
    private String canto;
    public PajaroCantor(String nombre, Persona dueno,String canto) {
        super(nombre, dueno);
        this.canto = canto;
    }

    public void agregarCanto(String canto){
        this.canto = canto;
    }

    @Override
    public String getSonido() {
        return canto;
    }

    @Override
    public boolean esCantor() {
        return true;
    }

    @Override
    public TipoMascota getTipo() {
        return TipoMascota.PAJAROCANTOR;
    }
}
