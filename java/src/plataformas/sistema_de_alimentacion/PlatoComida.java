package plataformas.sistema_de_alimentacion;

import java.util.HashSet;

public class PlatoComida {
    private String nombre;
    private HashSet<String> ingredientes;
    private int calorias;

    public PlatoComida(String nombre, HashSet<String> ingredientes, int calorias) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashSet<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(HashSet<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
}
