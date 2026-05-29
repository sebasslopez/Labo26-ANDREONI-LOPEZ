package personas;

import electrodomesticos.Computadora;
import organizacion.empresa.paginaweb.compras.Compra;
import organizacion.empresa.paginaweb.compras.metodoDePago.MetodoDePago;

public class Cliente extends Persona {
    private int tel;
    private double plata;
    public Cliente(){
        super();
        this.tel = 1123622201;
        this.plata = 50000;
    }

    public Cliente(int tel){
        super();
        this.tel = tel;
    }
    public Cliente(String nombre, String apellido, int tel,double plata) {
        super(nombre, apellido);
        this.tel = tel;

    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }

    public Compra comprar(MetodoDePago mdp, Computadora compu){
        return new Compra(this,mdp,compu);
    }
}
