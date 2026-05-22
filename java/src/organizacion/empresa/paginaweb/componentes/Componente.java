package organizacion.empresa.paginaweb.componentes;

public class Componente {
    private String nomfab;
    private String modelo;
    private float precioventa;
    private int stock;


    public Componente(int stock, float precioventa, String modelo, String nomfab) {
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

    public float getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(float precioventa) {
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
}
