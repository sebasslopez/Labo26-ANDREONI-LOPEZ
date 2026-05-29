package organizacion.empresa.paginaweb.compras.metodoDePago;

public class Tarjeta extends MetodoDePago {

    private int numtarj;
    private String banco;


    public Tarjeta(double plata, int numtarj, String banco) {
        super(plata);
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
    public boolean pagar(double monto) {
        monto = calcularTotal(monto);
        if(getPlata() >= monto){
            setPlata(getPlata()-monto);
            return true;
        }
        return false;
    }

}
