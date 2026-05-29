package organizacion.empresa.paginaweb.componentes;

import organizacion.empresa.paginaweb.componentes.dispositivo.entrada.DispositivosEntrada;
import organizacion.empresa.paginaweb.componentes.dispositivo.salida.DispositivosSalida;

public class Componente {
    private String nomfab;
    private String modelo;
    private Double precioventa;
    private int stock;


    public Componente(int stock, Double precioventa, String modelo, String nomfab) {
        this.stock = stock;
        this.precioventa = precioventa;
        this.modelo = modelo;
        this.nomfab = nomfab;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNomfab() {
        return nomfab;
    }

    public void setNomfab(String nomfab) {
        this.nomfab = nomfab;
    }

    public void actualizacionPrecio(float porcentaje){
        this.precioventa+=precioventa*porcentaje;
}

    public boolean esDispDeEntrada(){
        return this instanceof DispositivosEntrada;
    }

    public boolean esDispDeSalida(){
        return this instanceof DispositivosSalida;
    }

    public boolean hayStockSuficiente(){
        return stock>0;
    }

    public String mostrarNombreYModelo(){
        return nomfab + " " +modelo;
    }
}
