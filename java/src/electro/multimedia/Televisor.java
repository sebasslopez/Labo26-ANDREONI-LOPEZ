package electro.multimedia;

import edificaciones.tiendas.tiendaElectronica.Producto;
import edificaciones.tiendas.tiendaElectronica.ProductoElectronico;
import edificaciones.tiendas.tiendaElectronica.Seccion;

public class Televisor extends ProductoElectronico {
    private Calidad calidad;

    public Televisor(String nombre, double precio, int stock, Seccion s, Calidad calidad) {
        super(nombre, precio, stock,s);
        this.calidad = calidad;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    public void setCalidad(Calidad calidad) {
        this.calidad = calidad;
    }
}
