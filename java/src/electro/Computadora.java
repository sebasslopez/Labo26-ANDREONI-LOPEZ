package electro;

import electro.componentes.Componente;

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

    public double calcularTotal(){
        double total = 0;
        for(Componente c : componentes){
            total += c.getPrecio();
        }
        return total;
    }

    public int cantDispositivosDeEntrada(){
        int cant = 0;
        for(Componente c : componentes){
            if(c.esDispDeEntrada()) cant++;
        }
        return cant;
    }

    public int cantDispositivosDeSalida(){
        int cant = 0;
        for(Componente c : componentes){
            if(c.esDispDeSalida()) cant++;
        }
        return cant;
    }

    public int cantDispositivosDeES(){
        return cantDispositivosDeEntrada()+cantDispositivosDeSalida();
    }

    public void mostrarComponentes(){
        for(Componente c : componentes){
            System.out.println(c.mostrarNombreYModelo());
        }
    }

}
