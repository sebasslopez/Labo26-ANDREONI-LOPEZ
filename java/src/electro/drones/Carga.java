package electro.drones;

import utils.Fecha;

public class Carga extends Dron{
public int carga;

    public Carga(String modelo, Fecha fechaad, Estado estado, int bateria, int carga, double latituddest, double longituddest) {
        super(modelo, fechaad, estado, bateria, latituddest,longituddest);
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public void sepuede(){
        if(calculardist()>30){
            System.out.println("no se pudo realizar la mision");
        }
        else{
            if(getBateria()>=48){
                System.out.println("si se pudo realizar la mision");
                setBateria(getBateria()-48);
            }
        }
    }
}

