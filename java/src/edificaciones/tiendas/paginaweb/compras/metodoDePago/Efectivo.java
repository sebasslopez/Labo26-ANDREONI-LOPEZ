package edificaciones.tiendas.paginaweb.compras.metodoDePago;

import personas.Cliente;

public class Efectivo extends MetodoDePago {
    public Efectivo() {}

    @Override
    public boolean pagar(Cliente c, double monto) {
       if(c.getPlata()>=monto){
           c.setPlata(c.getPlata()-monto);
           return true;
       }
       return false;
    }

}
