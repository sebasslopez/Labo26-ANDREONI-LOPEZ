package plataformas.appMascotas.Mascotas;

import personas.Persona;

public class Perro extends Mascota{

    public Perro(String nombre, Persona dueno) {
        super(nombre, dueno);
    }

    @Override
    public TipoMascota getTipo() {
        return TipoMascota.PERRO;
    }
}
