package personas;

import plataformas.sistema_de_alimentacion.PlatoComida;
import utils.Fecha;

import java.util.HashMap;

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

    public int calcularCal (){
        int cantcal=0;
        for(PlatoComida p : comidas.keySet()){
         cantcal+=comidas.get(p)* p.getCalorias();
        }
        return cantcal;
    }
}
