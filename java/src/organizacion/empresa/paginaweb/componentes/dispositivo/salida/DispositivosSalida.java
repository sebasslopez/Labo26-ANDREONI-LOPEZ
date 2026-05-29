package organizacion.empresa.paginaweb.componentes.dispositivo.salida;

import organizacion.empresa.paginaweb.componentes.Componente;

public class DispositivosSalida extends Componente {
    private int cantpuertos;

    public DispositivosSalida(int stock, double precioventa, String modelo, String nomfab, int cantpuertos) {
        super(stock, precioventa, modelo, nomfab);
        this.cantpuertos = cantpuertos;
    }

    public int getCantpuertos() {
        return cantpuertos;
    }

    public void setCantpuertos(int cantpuertos) {
        this.cantpuertos = cantpuertos;
    }
}
