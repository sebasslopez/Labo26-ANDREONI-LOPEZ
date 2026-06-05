package electro.sensores;

import edificaciones.edificio.sistemaAlarmas.Elemento;

public class SensorDePresion extends Elemento {
    public SensorDePresion(boolean conectado, float umbral, int anio){
        super(conectado,umbral,anio);
    }

    @Override
    public void dispararAlarma(){
        if(isConectado() && getMedida() >= getUmbral()){
            System.out.println("Sensor de presión activado");
        }
    }
}
