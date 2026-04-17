package Gente;

import Utils.Fecha;

public class Jugador {
    private String nombre;
    private String apellido;
    private Fecha fechaNac;
    private int numCamiseta;
    private boolean capitan;

    public Jugador(String n,String a,Fecha f,int camiseta,boolean b){
        this.nombre = n;
        this.apellido = a;
        this.fechaNac = f;
        this.numCamiseta = camiseta;
        this.capitan = b;
    }
    public Jugador(){
        this.nombre = "Lionel Andres";
        this.apellido = "Messi";
        this.fechaNac = new Fecha(24,6,1987);
        this.numCamiseta = 10;
        this.capitan = false;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public Fecha getFechaNac(){
        return this.fechaNac;
    }
    public int numCamiseta(){
        return this.numCamiseta;
    }
    public boolean esCapitan(){
        return this.capitan;
    }
    public void setCapitan(boolean capitan) {
        this.capitan = capitan;
    }
    public void setNumCamiseta(int num){
        this.numCamiseta = num;
    }
}
