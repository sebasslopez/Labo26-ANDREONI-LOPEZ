package plataformas.prestamos.ropa;

import plataformas.prestamos.Prestable;

public class Pantalon extends Ropa implements Prestable {
    private int medidascin;
    private int medidascad;
    private int medidaslar;

    public Pantalon(String color, Materiales material, String marca, String estado, int medidascad, int medidascin, int medidaslar) {
        super(color, material, marca, estado);
        this.medidascad = medidascad;
        this.medidascin = medidascin;
        this.medidaslar = medidaslar;
    }

    public int getMedidascin() {
        return medidascin;
    }

    public void setMedidascin(int medidascin) {
        this.medidascin = medidascin;
    }

    public int getMedidascad() {
        return medidascad;
    }

    public void setMedidascad(int medidascad) {
        this.medidascad = medidascad;
    }

    public int getMedidaslar() {
        return medidaslar;
    }

    public void setMedidaslar(int medidaslar) {
        this.medidaslar = medidaslar;
    }

    @Override
    public void prestar() {
        if(puedePrestarse()){
            System.out.println(" el pantalon se puede dar prestado");
        }
    }

    @Override
    public boolean puedePrestarse() {
        if(getEstado().equalsIgnoreCase("machado")){
            return false;
        }
        return true;
    }

    @Override
    public void devolver() {

    }
}
