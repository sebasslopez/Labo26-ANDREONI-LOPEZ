package plataformas.recetas;

import plataformas.recetas.platos.NivelDeDificultad;
import plataformas.recetas.platos.PlatoReceta;

import java.util.ArrayList;

public class plataformaDeRecetas {
    private ArrayList<PlatoReceta> recetas;

    public void agregarReceta(PlatoReceta plato){
        recetas.add(plato);
    }
    public void sacarReceta(PlatoReceta plato){
        recetas.remove(plato);
    }
    public void agregarReceta(int index,PlatoReceta platoNuevo){
        recetas.set(index,platoNuevo);
    }

    public void buscarRecetas(){
        for(NivelDeDificultad n : NivelDeDificultad.values()){
            for(PlatoReceta p : recetas){
                if(p.tieneEsaDificultad(n)) {
                    System.out.println(p);
                }
            }
        }
    }


    public ArrayList<PlatoReceta> filtrarRecetas(PlatoReceta p){
      return p.platotipo(recetas);
      //se puede hacer con un enum con principal,postre y entrada.
        // el metodo recibe un valor del enum, recorrer recetas y preguntar si el tipo es el mismo que el q pasaron.
        // a los que sean de ese tipo, los guarda en un arraylist.
        //recetas tendria un metodo que se sobrescribe en cada clase hija con el tipo q es.
    }


    public int cantRecetas(){return recetas.size(); }

    public PlatoReceta recetaConMasPasos (){
        PlatoReceta recetamaspasos = recetas.get(0);
        for(PlatoReceta p : recetas){
        }
        return null;
    }
}
