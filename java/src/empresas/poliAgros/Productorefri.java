package empresas.poliAgros;

import utils.Fecha;

public class Productorefri extends ProductosEnvasados{
    private int temp;

    public Productorefri(Fecha fechaven, Fecha fechaenv, PaisOG paisog, int codigo, String nombre, int nlote, int temp) {
        super(fechaven, fechaenv, paisog, codigo, nombre, nlote);
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
