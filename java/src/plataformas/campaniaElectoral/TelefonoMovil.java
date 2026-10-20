package plataformas.campaniaElectoral;

public abstract class TelefonoMovil{
    private int numeroSerie;
    private String fabricante;
    private String Modelo;
    private int fono;

    public TelefonoMovil(int numeroSerie, String fabricante, String modelo, int fono) {
        this.numeroSerie = numeroSerie;
        this.fabricante = fabricante;
        Modelo = modelo;
        this.fono = fono;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(int numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getFono() {
        return fono;
    }

    public void setFono(int fono) {
        this.fono = fono;
    }
}
