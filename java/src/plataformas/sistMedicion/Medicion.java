package plataformas.sistMedicion;

public class Medicion {

    private int peso;
    private int altura;


    public Medicion (int peso, int altura){
        this.peso = peso;
        this.altura=altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
