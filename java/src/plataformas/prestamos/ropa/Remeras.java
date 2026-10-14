package plataformas.prestamos.ropa;

import plataformas.prestamos.Prestable;

public class Remeras extends Ropa implements Prestable {
    private int medidasesp;
    private int medidascont;
    private int medidaslart;

    public Remeras(String color, Materiales material, String marca, boolean dañado, int medidasesp, int medidascont, int medidaslart) {
        super(color, material, marca, dañado);
        this.medidasesp = medidasesp;
        this.medidascont = medidascont;
        this.medidaslart = medidaslart;
    }

    public int getMedidasesp() {
        return medidasesp;
    }

    public void setMedidasesp(int medidasesp) {
        this.medidasesp = medidasesp;
    }

    public int getMedidascont() {
        return medidascont;
    }

    public void setMedidascont(int medidascont) {
        this.medidascont = medidascont;
    }

    public int getMedidaslart() {
        return medidaslart;
    }

    public void setMedidaslart(int medidaslart) {
        this.medidaslart = medidaslart;
    }

    @Override
    public void prestar() {
        if(puedePrestarse()){
            System.out.println("el objeto se puede prestar");
        }
    }

    @Override
    public boolean puedePrestarse() {
        if(getDañado()){
            return false;
        }
       return true;
    }

    @Override
    public void devolver() {
        System.out.println("devolver");
    }

    @Override
    public String toString() {
        return medidascont+" " + medidasesp+ " " + medidaslart +"";
    }
}
