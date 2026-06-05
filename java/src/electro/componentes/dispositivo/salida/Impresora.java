package electro.componentes.dispositivo.salida;

public class Impresora extends DispositivosSalida {
private MetodoDeImpresion metodoimpr;

    public Impresora(int stock, double precioventa, String modelo, String nomfab, int cantpuertos, MetodoDeImpresion metodoimpr) {
        super(stock, precioventa, modelo, nomfab, cantpuertos);
        this.metodoimpr = metodoimpr;
    }

    public MetodoDeImpresion getMetodoimpr() {
        return metodoimpr;
    }

    public void setMetodoimpr(MetodoDeImpresion metodoimpr) {
        this.metodoimpr = metodoimpr;
    }

}
