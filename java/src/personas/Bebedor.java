package personas;

import plataformas.hidratacion.Bebida;

import java.util.ArrayList;

public class Bebedor extends Persona{

    private ArrayList<Bebida> bebidas;
    private ArrayList<Integer> cantidad;

    public Bebedor(String nombre, String apellido, int dni) {
        super(nombre, apellido, dni);
        this.bebidas = new ArrayList<>();
        this.cantidad = new ArrayList<>();
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

    public int calcularCoefHidratacion(){
        int coef = 0;
        for(Bebida b : bebidas){
            coef += cantidad.get(bebidas.indexOf(b)) * (b.getCoeficienteP() - b.getCoeficienteN());
        }
        return coef;
    }

    public void anadirBebida(Bebida b, int cant){
        if(bebidas.contains(b)){
            int idx = bebidas.indexOf(b);
            cantidad.set(idx,cantidad.get(idx) + cant);
        }
        else{
            bebidas.add(b);
            cantidad.add(cant);
        }
    }

    public void removerBebida(Bebida b){
        int idx = bebidas.indexOf(b);
        if(idx == -1) return;
        bebidas.remove(idx);
        cantidad.remove(idx);
    }

    @Override
    public String datos() {
        return "";
    }
}
