package edificaciones.edificio.sistemaAlarmas;

import java.util.ArrayList;

public class GrupoDeElementos {
    private ArrayList<Elemento> elementos;

    public GrupoDeElementos(ArrayList<Elemento> elementos){
        this.elementos = elementos;
    }
    public GrupoDeElementos(){
        this.elementos = new ArrayList<>();
    }

    public void dispararAlarmas(){
        if(promedioMedida() > promedioUmbral()){
            System.out.println("¡Super sensor mega epico disparado!");
        }
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public void addElemento(Elemento e){
        elementos.add(e);
    }

    public void removeElemento(Elemento e){
        elementos.remove(e);
    }

    private float promedioMedida(){
        float total = 0;
        for(Elemento e : elementos){
            total += e.getMedida();
        }
        return total/elementos.size();
    }
    private float promedioUmbral(){
        float total = 0;
        for(Elemento e : elementos){
            total += e.getUmbral();
        }
        return total/elementos.size();
    }
}
