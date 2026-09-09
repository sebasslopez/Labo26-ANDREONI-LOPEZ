package personas;

import plataformas.sistema_de_alimentacion.PlatoComida;
import utils.Fecha;

import java.util.HashMap;
import java.util.Map;

public class Familiar extends Persona{

    private HashMap<PlatoComida, Integer> comidas;

    public Familiar(String nombre, String apellido, Fecha f) {
        super(nombre, apellido, f);
        this.comidas= new HashMap<>();
    }

    public HashMap<PlatoComida, Integer> getComidas() {
        return comidas;
    }

    public void setComidas(HashMap<PlatoComida, Integer> comidas) {
        this.comidas = comidas;
    }

    public void agregarPlato (PlatoComida p, int cant){
        comidas.put(p,cant);
    }

    public int calcularCalorias (){
        int cantcal=0;
        for(PlatoComida p : comidas.keySet()){
            cantcal+=comidas.get(p)* p.getCalorias();
        }
        return cantcal;
    }
    
    public int promedioCalorias(){
        return calcularCalorias() / comidas.size();
    }

    public boolean comioEstePlato(PlatoComida p){
        return comidas.containsKey(p);
    }

    public PlatoComida getPlatoPreferido(){
        PlatoComida p = null;
        for(Map.Entry<PlatoComida,Integer> e : comidas.entrySet()){
            if(p == null || e.getValue() > comidas.get(p)) p = e.getKey();
        }
        return p;
    }

}
