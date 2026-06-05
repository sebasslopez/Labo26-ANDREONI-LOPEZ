package electro.componentes.dispositivo.entrada;

import electro.componentes.Componente;

public class DispositivosEntrada extends Componente {
    private String tipoconector;
    private int cantpuertos;

    public DispositivosEntrada(int stock, double precioventa, String modelo, String nomfab, int cantpuertos, String tipoconector) {
        super(stock, precioventa, modelo, nomfab);
        this.cantpuertos = cantpuertos;
        this.tipoconector = tipoconector;
    }

    public String getTipoconector() {
        return tipoconector;
    }

    public void setTipoconector(String tipoconector) {
        this.tipoconector = tipoconector;
    }

    public int getCantpuertos() {
        return cantpuertos;
    }

    public void setCantpuertos(int cantpuertos) {
        this.cantpuertos = cantpuertos;
    }


}
