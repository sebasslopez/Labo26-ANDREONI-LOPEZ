package plataformas.appMascotas.Mascotas;

import personas.Persona;

public abstract class Pajaro extends Mascota{
    public Pajaro(String nombre, Persona dueno) {
        super(nombre, dueno);
    }

    @Override
    public void saludar(String dueno) {
        if(esSuDueño(dueno)) System.out.println(getSonido());
    }

    public abstract boolean esCantor();
}
