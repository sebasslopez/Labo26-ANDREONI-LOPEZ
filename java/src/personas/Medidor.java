package personas;

import plataformas.sistMedicion.Medicion;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Medidor extends Persona {
    private HashMap<LocalDate, Medicion> mediciones;

    public Medidor() {
        HashMap<LocalDate, Medicion> mediciones = new HashMap<>();
    }

    public Medicion mediciones(LocalDate fecha) {
        return mediciones.get(fecha);
    }

    public int promPeso(int anio){
        int p =0, cont =0;
        for(LocalDate f : mediciones.keySet()){
            if(f.getYear() == anio){
             p +=  mediciones.get(f).getPeso();
                cont ++;
            }
        }
        return p/cont;
    }

    public int promAltura(int anio){
        int p =0, cont =0;
        for(LocalDate f : mediciones.keySet()){
            if(f.getYear() == anio){
                p +=  mediciones.get(f).getAltura();
                cont ++;
            }
        }
        return p/cont;
    }

    public int variacion(LocalDate f, LocalDate fe){
        if(mediciones.containsKey(f) && mediciones.containsKey(fe)) {
            int p1 = mediciones.get(f).getPeso();
            int p2 = mediciones.get(fe).getPeso();

            return ((p1 - p2) / p1) * 100;
        }
        System.out.println("no contiene alguna de las 2 fechas");
        return -1;
    }

    public int porcentaje(LocalDate f, LocalDate fe){
        if (mediciones.containsKey(f) && mediciones.containsKey(fe)) {


            int a1 = mediciones.get(f).getAltura();
            int a2 = mediciones.get(fe).getAltura();

            return ((a1 - a2) / a1) * 100;
        }
        System.out.println("no contiene alguna de las fechas");
        return -1;
    }


    public LocalDate mayorP(){
        LocalDate f = null;
        for(Map.Entry<LocalDate,Medicion> e : mediciones.entrySet() ){
            if(f== null || mediciones.get(f).getPeso()<e.getValue().getPeso()){
                f=e.getKey();
            }
        }
        return f;
    }

    public LocalDate menorP(){
        LocalDate f = null;
        for(Map.Entry<LocalDate,Medicion> e : mediciones.entrySet() ){
            if(f== null || mediciones.get(f).getPeso()>e.getValue().getPeso()){
                f=e.getKey();
            }
        }
        return f;
    }


    @Override
    public String datos() {
        return "";
    }
}
