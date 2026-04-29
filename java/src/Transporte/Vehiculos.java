package Transporte;

public class Vehiculos {
    private String marca;
    private String modelo;
    private String color;
    private int cantruedas;
    private int anio;
    private int patente;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantruedas() {
        return cantruedas;
    }

    public void setCantruedas(int cantruedas) {
        this.cantruedas = cantruedas;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getPatente() {
        return patente;
    }

    public void setPatente(int patente) {
        this.patente = patente;
    }

    public Vehiculos(String marca, String modelo, String color, int patente, int anio, int cantruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.patente = patente;
        this.anio = anio;
        this.cantruedas = cantruedas;
    }

    public Vehiculos(String modelo, String marca, String color, int cantruedas, int anio) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.cantruedas = cantruedas;
        this.anio = anio;
    }
}
