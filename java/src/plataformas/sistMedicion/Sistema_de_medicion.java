package plataformas.sistMedicion;

import personas.Medidor;
import plataformas.appMascotas.Mascotas.Mascota;

import java.time.LocalDate;
import java.util.HashSet;

public class Sistema_de_medicion {

    private HashSet<Medidor> personas;

    public Sistema_de_medicion(){
        HashSet<Medidor>personas= new HashSet<>();
    }

    public void agregarMedidor(Medidor m){
        personas.add(m);
    }

    public void registrarMedicion(Medidor m, int altura,int peso,LocalDate fecha){
        if(!m.tieneEsaFecha(fecha)) m.registrarMedicion(new Medicion(peso,altura),fecha);
        else System.out.println("La persona ya posee una medición en esa fecha");
    }

    static void main(String[] args){

    }
}
