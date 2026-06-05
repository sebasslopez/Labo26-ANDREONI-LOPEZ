package edificaciones.tiendas.tiendaElectronica;

public class ProductoElectronico extends Producto {
    private Seccion seccion;

    public ProductoElectronico(String nombre, double precio, int stock, Seccion seccion) {
        super(nombre, precio, stock);
        this.seccion = seccion;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public boolean tieneLaMismaSeccion(ProductoElectronico p){
        return seccion.equals(p.seccion);
    }

    public boolean tieneLaMismaSeccion(Seccion s){
        return seccion.equals(s);
    }

    public boolean tieneMasStockQue(ProductoElectronico p){
        return p.getStock() < super.getStock();
    }

    public boolean tieneMenosStockQue(ProductoElectronico p){
        return p.getStock() > super.getStock();
    }
}
