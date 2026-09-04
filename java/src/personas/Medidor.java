package personas;

import plataformas.sistMedicion.Medicion;
import utils.Fecha;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Medidor extends Persona {
    private HashMap<LocalDate, Medicion> mediciones;

    public Medidor(String nombre, String apellido, LocalDate nac) {
        super(nombre,apellido,nac);
        HashMap<LocalDate, Medicion> mediciones = new HashMap<>();
    }

    public void registrarMedicion(Medicion m,LocalDate fecha){
        if(!tieneEsaFecha(fecha)) mediciones.put(fecha,m);
        else System.out.println("La persona ya posee una medición en esa fecha");
    }

    public Medicion getMedicion(LocalDate fecha) {
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

    public int crecimiento(LocalDate f, LocalDate fe){
        if (mediciones.containsKey(f) && mediciones.containsKey(fe)) {
            int a1 = mediciones.get(f).getAltura();
            int a2 = mediciones.get(fe).getAltura();
            return ((a1 - a2) / a1) * 100;
        }
        System.out.println("no contiene alguna de las fechas");
        return -1;
    }


    public LocalDate mayorPeso(){
        LocalDate f = null;
        for(Map.Entry<LocalDate,Medicion> e : mediciones.entrySet() ){
            if(f== null || mediciones.get(f).getPeso()<e.getValue().getPeso()){
                f=e.getKey();
            }
        }
        return f;
    }

    public LocalDate menorPeso(){
        LocalDate f = null;
        for(Map.Entry<LocalDate,Medicion> e : mediciones.entrySet() ){
            if(f== null || mediciones.get(f).getPeso()>e.getValue().getPeso()){
                f=e.getKey();
            }
        }
        return f;
    }

    public boolean tieneEsaFecha(LocalDate fecha){
        return mediciones.containsKey(fecha);
    }

    @Override
    public String datos() {
        return "";
    }
}
