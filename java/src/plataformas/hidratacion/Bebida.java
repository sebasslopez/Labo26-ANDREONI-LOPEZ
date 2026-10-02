package plataformas.hidratacion;

public class Bebida {
    private String nombre;
    private int coeficienteP;
    private int coeficienteN;
    private int cantidadDisponible;

    public Bebida(int coeficienteP, String nombre, int coeficienteN) {
        this(coeficienteP, nombre, coeficienteN, 0);
    }

    public Bebida(int coeficienteP, String nombre, int coeficienteN, int cantidadDisponible) {
        this.coeficienteP = coeficienteP;
        this.nombre = nombre;
        this.coeficienteN = coeficienteN;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoeficienteP() {
        return coeficienteP;
    }

    public void setCoeficienteP(int coeficienteP) {
        this.coeficienteP = coeficienteP;
    }

    public int getCoeficienteN() {
        return coeficienteN;
    }

    public void setCoeficienteN(int coeficienteN) {
        this.coeficienteN = coeficienteN;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public boolean tieneCantidad(int cantidad){
        return cantidad > 0 && cantidadDisponible >= cantidad;
    }

    public void descontar(int cantidad){
        if (cantidad > cantidadDisponible){
            cantidad = cantidadDisponible;
        }
        cantidadDisponible -= cantidad;
    }

    public void reponer(int cantidad){
        cantidadDisponible += cantidad;
    }

    @Override
    public String toString() {
        return nombre + " | coeficiente: " + coeficienteP + "/" + coeficienteN + " | disponible: " + cantidadDisponible;
    }
}
