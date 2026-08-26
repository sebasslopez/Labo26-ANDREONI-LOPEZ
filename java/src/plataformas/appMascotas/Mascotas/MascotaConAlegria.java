package plataformas.appMascotas.Mascotas;

import personas.Persona;

public abstract class MascotaConAlegria extends Mascota{
    private int alegria;

    public MascotaConAlegria(String nombre, Persona dueno){
        super(nombre,dueno);
        alegria = 0;
    }

    public boolean hayQueEliminar(){
        return false;
    }

    public void alimentar(){
        alegria++;
    }

    public void saludar(String dueno){
        for(int i = 0;i<alegria;i++){
            System.out.println(esSuDueño(dueno)? getSonido() : getSonido().toUpperCase()+"!" );
        }
        if(alegria > 1){
            alegria--;
        }
    }
}
