package plataformas.recetas.platos;

import java.util.ArrayList;

public class Entrada extends PlatoReceta {
    private Temperatura temperatura;

    public Entrada(String nombre, NivelDeDificultad dificultad, ArrayList<String> pasos, Temperatura temperatura) {
        super(nombre, dificultad, pasos);
        this.temperatura = temperatura;
    }

    private boolean esCaliente(){
        return temperatura.equals(Temperatura.CALIENTE);
    }
    private boolean esFria(){
        return temperatura.equals(Temperatura.FRIO);
    }

    @Override
    public void mostrarIntrucciones() {
        if(esCaliente()) System.out.println("Recuerda prender el horno antes de empezar.");
        mostrarPasos();
        if(esFria()) System.out.println("Recuerda guardar la preparacion en la heladera.");
    }

    public boolean esEntrada(){
        return true;
    }
    @Override
    public ArrayList<PlatoReceta> platotipo(ArrayList<PlatoReceta> recetas) {
        ArrayList<PlatoReceta> recetaslpm = new ArrayList<>();
        for(PlatoReceta p : recetas){
            if(p.esEntrada()){
                recetaslpm.add(p);
            }
        }
        return recetaslpm;
    }
}
