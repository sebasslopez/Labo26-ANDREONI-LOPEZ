package plataformas.hidratacion;

public class Bebida {
    private String nombre;
    private int coeficienteP;
    private int coeficienteN;

    public Bebida(int coeficienteP, String nombre, int coeficienteN) {
        this.coeficienteP = coeficienteP;
        this.nombre = nombre;
        this.coeficienteN = coeficienteN;
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
}
