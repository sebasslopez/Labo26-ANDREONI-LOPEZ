package edificaciones.tiendas.tiendaElectronica;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean aumentarStock(int cant){
        if(cant > 0){
            stock =+ cant;
            return true;
        }
        return false;
    }

    public boolean reducirStock(int cant){
        if(hayStockSuficiente(cant)){
            stock =- cant;
            return true;
        }
        return false;
    }

    public void actualizacionPrecio(float porcentaje){
        this.precio+=precio*porcentaje;
    }

    public boolean hayStockSuficiente(int cant){
        return (stock-cant) >= 0;
    }

    public String mostrarNombre(){
        return nombre;
    }

    public String mostrarDatos(){
        return "Nombre: " + nombre + " | Precio: "+ precio + " | Stock: " + stock;
    }
}
