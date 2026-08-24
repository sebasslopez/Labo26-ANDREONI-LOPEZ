package plataformas.appMascotas.Mascotas;

import personas.Persona;

public class Pez extends Mascota{
    private int vidas;

    public Pez(String nombre, Persona dueno) {
        super(nombre, dueno);
        vidas = 10;
    }

    @Override
    public TipoMascota getTipo() {
        return TipoMascota.PEZ;
    }

    @Override
    public void saludar(String dueno){
        if(esSuDueño(dueno)) vidas--;
        else vidas = 0;
    }

    @Override
    public boolean hayQueEliminar() {
        return vidas <= 0;
    }

    @Override
    public void alimentar() {
        vidas++;
    }
}
