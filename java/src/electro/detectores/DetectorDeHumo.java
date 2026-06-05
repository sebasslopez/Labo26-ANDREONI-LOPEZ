package electro.detectores;

import edificaciones.edificio.sistemaAlarmas.Elemento;

public class DetectorDeHumo extends Elemento {

    public DetectorDeHumo(boolean conectado, float umbral, int anio){
        super(conectado,umbral,anio);
    }

    @Override
    public void dispararAlarma(){
        if(isConectado() && getMedida() >= getUmbral()){
            System.out.println("Llamando a los bomberos...");
        }
    }
}
