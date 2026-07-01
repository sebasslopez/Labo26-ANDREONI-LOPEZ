package edificaciones.tiendas.paginaweb.compras.metodoDePago;

import personas.Cliente;

public abstract class MetodoDePago {
    public MetodoDePago() {}

    public abstract boolean pagar(Cliente c, double monto);

    public abstract double calcularRecargo(double subtotal);

    public double calcularTotal(double subtotal) {
        return subtotal + calcularRecargo(subtotal);
    }

    public String pagaCon(){
        return this.getClass().getSimpleName();
    }
}
