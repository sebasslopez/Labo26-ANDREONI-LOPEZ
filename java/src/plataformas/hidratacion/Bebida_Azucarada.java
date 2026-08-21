package plataformas.hidratacion;

public class Bebida_Azucarada extends Bebida {

    private int cantazucar;

    public Bebida_Azucarada(String nombre, int cantazucar) {
        super(1, nombre, cantazucar*10);
        this.cantazucar = cantazucar;
    }

    public int getCantazucar() {
        return cantazucar;
    }

    public void setCantazucar(int cantazucar) {
        this.cantazucar = cantazucar;
    }
}
