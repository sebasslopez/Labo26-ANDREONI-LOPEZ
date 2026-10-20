package plataformas.campaniaElectoral;

import transporte.Color;

public abstract class Ave extends Animal{
    private Color color;
    private String nombre;
    private String especie;
    public Ave(Color c,String n,String especie){
        this.color = c;
        this.nombre = n;
        this.especie = especie;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
