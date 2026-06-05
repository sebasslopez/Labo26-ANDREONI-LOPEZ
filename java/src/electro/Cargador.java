package electro;

import edificaciones.tiendas.tiendaElectronica.Producto;
import edificaciones.tiendas.tiendaElectronica.ProductoElectronico;
import edificaciones.tiendas.tiendaElectronica.Seccion;

public class Cargador extends ProductoElectronico {
    private int cantidadCarga;

    public Cargador(String nombre, double precio, int stock, Seccion s, int cantidadCarga) {
        super(nombre, precio, stock,s);
        this.cantidadCarga = cantidadCarga;
    }

    public int getCantidadCarga() {
        return cantidadCarga;
    }

    public void setCantidadCarga(int cantidadCarga) {
        this.cantidadCarga = cantidadCarga;
    }
}
