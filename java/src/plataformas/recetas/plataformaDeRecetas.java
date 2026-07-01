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
    }


    public int cantRecetas(){return recetas.size(); }
}
