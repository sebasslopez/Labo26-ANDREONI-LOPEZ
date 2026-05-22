package electrodomesticos;

import organizacion.empresa.paginaweb.componentes.DispositivosSalida;

public class Impresora extends DispositivosSalida {
private String metodoimpr;

    public Impresora(int stock, float precioventa, String modelo, String nomfab, int cantpuertos, String metodoimpr) {
        super(stock, precioventa, modelo, nomfab, cantpuertos);
        this.metodoimpr = metodoimpr;
    }

    public String getMetodoimpr() {
        return metodoimpr;
    }

    public void setMetodoimpr(String metodoimpr) {
        this.metodoimpr = metodoimpr;
    }

}
