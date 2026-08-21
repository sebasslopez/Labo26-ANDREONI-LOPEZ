package personas;

import plataformas.hidratacion.Bebida;

import java.util.ArrayList;

public class Bebedor extends Persona{

private  ArrayList<Bebida> bebidas;
private ArrayList<Integer> cantidad;

    public Bebedor(String nombre, String apellido, int dni, ArrayList<Bebida> bebidas, ArrayList<Integer> cantidad) {
        super(nombre, apellido, dni);
        this.bebidas = bebidas;
        this.cantidad = cantidad;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String datos() {
        return "";
    }
}
