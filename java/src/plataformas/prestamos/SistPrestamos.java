package plataformas.prestamos;

import plataformas.prestamos.materialLectura.Material_de_lectura;
import plataformas.prestamos.ropa.Ropa;

import java.util.HashSet;

public class SistPrestamos {
    private HashSet<Prestable>ps;
    private  HashSet<Ropa>prendas;
    private HashSet<Material_de_lectura>leer;

    public void agregarropa( Ropa r){
        if(r instanceof Prestable){
            ps.add((Prestable) r);
        }
    }

    public void agregarlectura(Material_de_lectura l){
        if(l instanceof Prestable){
            ps.add((Prestable) l);
        }
    }

}
