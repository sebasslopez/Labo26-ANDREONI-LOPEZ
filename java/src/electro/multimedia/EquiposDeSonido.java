package electro.multimedia;

import edificaciones.tiendas.tiendaElectronica.Producto;
import edificaciones.tiendas.tiendaElectronica.ProductoElectronico;
import edificaciones.tiendas.tiendaElectronica.Seccion;

public class EquiposDeSonido extends ProductoElectronico {
    private boolean bluetooth;

    public EquiposDeSonido(String nombre, double precio, int stock, Seccion s, boolean bluetooth) {
        super(nombre, precio, stock,s);
        this.bluetooth = bluetooth;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }
}
