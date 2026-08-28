package personas;

import plataformas.sistMedicion.Medicion;

import java.time.LocalDate;
import java.util.HashMap;

public class Medidor extends Persona {
    private HashMap<LocalDate, Medicion> mediciones;

    public Medidor() {
        HashMap<LocalDate, Medicion> mediciones = new HashMap<>();
    }

    public Medicion mediciones(LocalDate fecha) {
        return mediciones.get(fecha);
    }

    public double promPeso(LocalDate f) {
    }


}























    @Override
    public String datos() {
        return "";
    }
}
