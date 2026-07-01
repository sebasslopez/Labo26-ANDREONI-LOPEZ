package plataformas.recetas.platos;

import java.util.ArrayList;

public class Postre extends PlatoReceta {
    private int temperaturaHorno;
    private boolean esParaDiabeticos;

    public Postre(String nombre, NivelDeDificultad dificultad, ArrayList<String> pasos, int temperaturaHorno, boolean esParaDiabeticos) {
        super(nombre, dificultad, pasos);
        this.temperaturaHorno = temperaturaHorno;
        this.esParaDiabeticos = esParaDiabeticos;
    }

    @Override
    public void mostrarIntrucciones() {
        mostrarPasos();
    }

    @Override
    public void mostrarPasos(){
        for(String s : getPasos()){
            System.out.println(s + " Recuerda mantener la cocina limpia y el horno al minimo.");
        }
    }
    @Override
    public boolean esPostre(){
        return true;
    }

    @Override
    public ArrayList<PlatoReceta> platotipo(ArrayList<PlatoReceta> recetas) {
        ArrayList<PlatoReceta> recetaslpm = new ArrayList<>();
        for(PlatoReceta p : recetas){
            if(p.esPostre()){
                recetaslpm.add(p);
            }
        }
        return recetaslpm;
    }
}
