package plataformas.appMascotas.Mascotas;

import personas.Persona;

public class Gato extends MascotaConAlegria{

    public Gato(String nombre, Persona dueno) {
        super(nombre, dueno);
    }

    @Override
    public TipoMascota getTipo() {
        return TipoMascota.GATO;
    }
}
