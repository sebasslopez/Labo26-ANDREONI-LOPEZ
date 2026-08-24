package plataformas.appMascotas.Mascotas;

import personas.Persona;

public class PajaroNoCantor extends Pajaro{
    public PajaroNoCantor(String nombre, Persona dueno) {
        super(nombre, dueno);
    }

    @Override
    public boolean esCantor() {
        return false;
    }

    @Override
    public TipoMascota getTipo() {
        return TipoMascota.PAJARONOCANTOR;
    }
}
