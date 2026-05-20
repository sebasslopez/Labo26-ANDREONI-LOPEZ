package edificaciones.edificio;

import edificaciones.edificio.sistemaAlarmas.Elemento;
import edificaciones.edificio.sistemaAlarmas.GrupoDeElementos;

import java.util.ArrayList;

public class Edificio {
    private ArrayList<GrupoDeElementos> detesensor;

    public Edificio(){
        this.detesensor = new ArrayList<>();
    }

    public ArrayList<GrupoDeElementos> getDetesensor() {
        return detesensor;
    }

    public void setDetesensor(ArrayList<GrupoDeElementos> detesensor) {
        this.detesensor = detesensor;
    }

    public void addElemento(Elemento e){
        ArrayList<Elemento> elementos = new ArrayList<>();
        elementos.add(e);
        detesensor.add(new GrupoDeElementos());
    }

    public void addGrupoElementos(GrupoDeElementos e){
        detesensor.add(e);
    }

    public void removeGrupoElementos(GrupoDeElementos e){
        detesensor.remove(e);
    }
    public void hayQueDispararAlarmas(){
        for(GrupoDeElementos g : detesensor){
            for(Elemento e : g.getElementos()){
                e.dispararAlarma();
            }
        }
    }

    static void main() {

    }
}
