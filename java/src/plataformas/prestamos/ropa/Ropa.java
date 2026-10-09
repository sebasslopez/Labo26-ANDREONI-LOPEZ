package plataformas.prestamos.ropa;

import plataformas.prestamos.Prestable;

public abstract class Ropa implements Prestable {
    private String color;
    private Materiales material;
    private String marca;
    private String estado;

    public Ropa(String color, Materiales material, String marca, String estado) {
        this.color = color;
        this.material = material;
        this.marca = marca;
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Materiales getMaterial() {
        return material;
    }

    public void setMaterial(Materiales material) {
        this.material = material;
    }
}
