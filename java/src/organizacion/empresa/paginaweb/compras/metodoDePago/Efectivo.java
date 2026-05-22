package organizacion.empresa.paginaweb.compras.metodoDePago;

public class Efectivo extends MetodoDePago {
    public Efectivo(float plata) {
        super(plata);
    }

    @Override
    public void pagar(double     monto) {
       if(getPlata()>=monto){
           setPlata(getPlata()-monto);
       }
    }
}
