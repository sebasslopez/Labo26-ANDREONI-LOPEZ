package organizacion.empresa.paginaweb.compras.metodoDePago;

public class MetodoDePago {
private double plata;

    public MetodoDePago(double plata) {
        this.plata = plata;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public boolean pagar(double monto){
        return false;
    }

    public double calcularRecargo(double subtotal) {
        return 0;
    }

    public double calcularTotal(double subtotal) {
        return subtotal + calcularRecargo(subtotal);
    }

    public String pagaCon(){
        return this.getClass().getSimpleName();
    }
}
