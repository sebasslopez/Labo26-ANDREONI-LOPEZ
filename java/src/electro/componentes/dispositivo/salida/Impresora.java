package electro.componentes.dispositivo.salida;

public class Impresora extends DispositivosSalida {
private String metodoimpr;

    public Impresora(int stock, double precioventa, String modelo, String nomfab, int cantpuertos, String metodoimpr) {
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
