package organizacion.empresa.paginaweb.componentes.dispositivo.entrada;

import organizacion.empresa.paginaweb.componentes.Componente;

public class DispositivosEntrada extends Componente {
    private String tipoconector;
    private int cantpuertos;

    public DispositivosEntrada(int stock, float precioventa, String modelo, String nomfab, int cantpuertos, String tipoconector) {
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
