package plataformas.hidratacion;

import personas.Bebedor;

import java.util.ArrayList;

public class sistema_de_hidratacion {

    private ArrayList<Bebedor> bebedores;

    public sistema_de_hidratacion() {
        this.bebedores = new ArrayList<>();
    }

    public void anadirBebedor(Bebedor b){
        bebedores.add(b);
    }

    public void removerBebedor(Bebedor b){
        bebedores.remove(b);
    }

    public Bebedor obtenerMejorCoef(){
        Bebedor mayor = bebedores.getFirst();
        for(Bebedor b : bebedores){
            if(mayor.calcularCoefHidratacion() < b.calcularCoefHidratacion()) mayor = b;
        }
        return mayor;
    }

    public Bebedor obtenerPeorCoef(){
        Bebedor menor = bebedores.getFirst();
        for(Bebedor b : bebedores){
            if(b.calcularCoefHidratacion() < menor.calcularCoefHidratacion()) menor = b;
        }
        return menor;
    }

}
