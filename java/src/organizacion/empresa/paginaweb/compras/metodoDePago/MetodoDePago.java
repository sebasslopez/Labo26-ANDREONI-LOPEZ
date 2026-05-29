package organizacion.empresa.paginaweb.compras.metodoDePago;

import personas.Cliente;

public class MetodoDePago {
    public MetodoDePago() {}

    public boolean pagar(Cliente c, double monto){
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
