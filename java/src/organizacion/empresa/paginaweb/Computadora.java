package organizacion.empresa.paginaweb;

import organizacion.empresa.paginaweb.componentes.Componente;
import organizacion.empresa.paginaweb.compras.metodoDePago.MetodoDePago;

import java.util.ArrayList;

public class Computadora {
    private ArrayList<Componente> componentes;

    public Computadora(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }
    public Computadora(){
        componentes = new ArrayList<>();
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }
    public void addComponente(Componente c){
        componentes.add(c);
    }
    public void removeComponentes(Componente c){
        componentes.remove(c);
    }
}
