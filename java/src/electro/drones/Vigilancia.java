package electro.drones;

import utils.Fecha;

public class Vigilancia extends Dron{
    private int memoria;

    public Vigilancia(String modelo, Fecha fechaad, Estado estado, int bateria, double latituddest, double longituddest, int memoria) {
        super(modelo, fechaad, estado, bateria, latituddest, longituddest);
        this.memoria = memoria;
    }

    @Override
    public void  sepuede(){
        double cuenta= (calculardist()/2)*12;
        if(cuenta<=memoria){
            memoria-=cuenta;
        }
    }
}
