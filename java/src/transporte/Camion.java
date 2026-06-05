package transporte;

public class Camion extends Vehiculo {
    private int capkg;

    public Camion(String marca, String modelo, Color color, int patente, int anio, int cantruedas, int capkg) {
        super(marca, modelo, color, patente, anio, cantruedas);
        this.capkg = capkg;

    }

    public int getCapkg() {
        return capkg;
    }

    public void setCapkg(int capkg) {
        this.capkg = capkg;
    }
}
