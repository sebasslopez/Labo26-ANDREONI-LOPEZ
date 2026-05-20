package edificaciones.edificio.sistemaAlarmas.sensores;

import edificaciones.edificio.sistemaAlarmas.Elemento;

public class SensorDeTemperatura extends Elemento {
    public SensorDeTemperatura(boolean conectado, float umbral, int anio){
        super(conectado,umbral,anio);
    }

    @Override
    public void dispararAlarma(){
        if(isConectado() && getMedida() >= getUmbral()){
            System.out.println("¡Cuidado! La temperatura sube");
        }
    }
}
