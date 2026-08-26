package plataformas.appMascotas;

import personas.Persona;
import plataformas.appMascotas.Mascotas.*;

import java.util.ArrayList;

public class App {
    private ArrayList<Mascota> mascotas;

    public App(){
        this.mascotas = new ArrayList<>();
    }

    public void agregarMascota(Mascota m){
        mascotas.add(m);
    }

    public void removerMascotas(Mascota m){
        mascotas.remove(m);
    }

    public void modificarMascota(Mascota m, Mascota mascotaModificada){
        if(mascotas.contains(m)) mascotas.set(mascotas.indexOf(m),mascotaModificada);
    }

    public Mascota darDeAlta(Persona dueno, String mascota, TipoMascota tipo){
        if(obtenerMacotaPorNombre(mascota) != null){
            System.out.println("Ya hay una mascota con ese nombre.");
            return null;
        }
        Mascota m = switch (tipo){
            case GATO -> new Gato(mascota,dueno);
            case PERRO -> new Perro(mascota,dueno);
            case PAJAROCANTOR -> new PajaroCantor(mascota,dueno,"");
            case PAJARONOCANTOR -> new PajaroNoCantor(mascota,dueno);
            case PEZ -> new Pez(mascota,dueno);
        };
        mascotas.add(m);
        return m;
    }

    public void saludar(String dueno,String mascota){
        Mascota m = obtenerMacotaPorNombre(mascota);
        if(m != null){
            m.saludar(dueno);
            if(m.hayQueEliminar()) mascotas.remove(m);
        }
    }

    private Mascota obtenerMacotaPorNombre(String n){
        for(Mascota m : mascotas){
            if(m.tieneEseNombre(n)) return m;
        }
        return null;
    }
}
