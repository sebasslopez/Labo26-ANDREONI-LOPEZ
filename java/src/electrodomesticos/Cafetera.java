package electrodomesticos;

public class Cafetera {
    private int maxima;
    private int actual;
    public Cafetera(int maxima, int actual) {
        this.maxima = maxima;
        if(actual>maxima) actual=maxima;
        this.actual=actual;
    }
    public Cafetera() {
        this.maxima = 1000;
        this.actual = 0;
    }
    public Cafetera(int maxima) {
        this.maxima = maxima;
        this.actual = maxima;
    }
    public void llenarCafetera(){
        this.actual = maxima;
    }
    public void servirTaza(int capacidad){
        if(actual<capacidad) actual = 0;
        else actual -= capacidad;
    }
    public void vaciarCafetera(){
        this.actual = 0;
    }
    public void agregarCafe(int cantidad){
        actual+=cantidad;
    }

    public static void main(String[] args) {

    }
}
