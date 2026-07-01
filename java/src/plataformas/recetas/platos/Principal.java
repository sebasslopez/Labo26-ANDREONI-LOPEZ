package plataformas.recetas.platos;

import java.util.ArrayList;

public class Principal extends PlatoReceta {
    private int tiempoDeCoccion;
    private int numeroComensales;

    public Principal(String nombre, NivelDeDificultad dificultad, ArrayList<String> pasos, int tiempoDeCoccion, int numeroComensales) {
        super(nombre, dificultad, pasos);
        this.tiempoDeCoccion = tiempoDeCoccion;
        this.numeroComensales = numeroComensales;
    }

    @Override
    public void mostrarIntrucciones() {
        System.out.println("Esta receta tarda en cocinarse " + tiempoDeCoccion + " de coccion y los pasos son: ");
        mostrarPasos();
    }
    @Override
    public boolean esPrincipal(){
        return true;
    }

    @Override
    public ArrayList<PlatoReceta> platotipo(ArrayList<PlatoReceta> recetas) {
       ArrayList<PlatoReceta> recetaslpm = new ArrayList<>();
        for(PlatoReceta p : recetas){
            if(p.esPrincipal()){
                recetaslpm.add(p);
            }
        }
        return recetaslpm;
    }

}
