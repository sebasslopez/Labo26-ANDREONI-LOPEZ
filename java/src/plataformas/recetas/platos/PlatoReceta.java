package plataformas.recetas.platos;

import java.util.ArrayList;

public abstract class PlatoReceta {
    private String nombre;
    private NivelDeDificultad dificultad;
    private ArrayList<String> pasos;


    public PlatoReceta(String nombre, NivelDeDificultad dificultad, ArrayList<String> pasos) {
        this.nombre = nombre;
        this.dificultad = dificultad;
        this.pasos = pasos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelDeDificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(NivelDeDificultad dificultad) {
        this.dificultad = dificultad;
    }

    public ArrayList<String> getPasos() {
        return pasos;
    }

    public void setPasos(ArrayList<String> pasos) {
        this.pasos = pasos;
    }

    public void agregarPaso(String paso){
        pasos.add(paso);
    }

    public abstract void mostrarIntrucciones();

    public void mostrarPasos(){
        for (String s : pasos){
            System.out.println(s);
        }
    }

    public boolean tieneEsaDificultad(NivelDeDificultad dificultad){
         return  this.dificultad.equals(dificultad);
    }

    public abstract ArrayList<PlatoReceta> platotipo (ArrayList<PlatoReceta> recetas);

public boolean esPrincipal(){
    return false;
}

public boolean esEntrada(){
    return false;
}

public boolean esPostre(){
        return false;
    }
}
