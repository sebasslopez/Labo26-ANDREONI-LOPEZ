package plataformas.prestamos.ropa;

import plataformas.prestamos.Prestable;

public abstract class Ropa implements Prestable {
    private String color;
    private Materiales material;
    private String marca;
    private boolean dañado;

    public Ropa(String color, Materiales material, String marca, boolean dañado) {
        this.color = color;
        this.material = material;
        this.marca = marca;
        this.dañado = dañado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Materiales getMaterial() {
        return material;
    }

    public void setMaterial(Materiales material) {
        this.material = material;
    }

    public boolean getDañado() {
        return dañado;
    }

    public void setDañado(boolean dañado) {
        this.dañado = dañado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
