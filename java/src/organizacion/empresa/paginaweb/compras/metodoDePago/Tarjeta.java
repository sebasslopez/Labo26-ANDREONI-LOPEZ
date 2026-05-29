package organizacion.empresa.paginaweb.compras.metodoDePago;

import personas.Cliente;

public class Tarjeta extends MetodoDePago {
    private int numtarj;
    private String banco;

    public Tarjeta(int numtarj, String banco) {
        this.numtarj = numtarj;
        this.banco = banco;

    }

    public int getNumtarj() {
        return numtarj;
    }

    public void setNumtarj(int numtarj) {
        this.numtarj = numtarj;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public double calcularRecargo(double subtotal) {
        return subtotal*0.05;
    }

    @Override
    public boolean pagar(Cliente c, double monto) {
        monto = calcularTotal(monto);
        if(c.getPlata() >= monto){
            c.setPlata(c.getPlata()-monto);
            return true;
        }
        return false;
    }

}
