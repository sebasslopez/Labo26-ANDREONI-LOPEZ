package plataformas.residuos;

import plataformas.SistemaAsistencia;
import transporte.Camion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SistemaDeResiduos {
    private HashSet<Residuo> tipos;
    private HashSet<PuntoDeRecoleccion> puntos;
    private HashSet<CamionDeBasura> camiones;
    private HashSet<Recoleccion> recolecciones;

    public SistemaDeResiduos(){
        tipos = new HashSet<>();
        puntos = new HashSet<>();
    }

    public void agregarTipo(Residuo r){
        tipos.add(r);
    }

    public void agregarCamion(CamionDeBasura r){
        camiones.add(r);
    }

    public void removerTipo(Residuo r){
        tipos.remove(r);
    }

    public void removerCamion(CamionDeBasura r){
        camiones.remove(r);
    }

    public void removerTipo(Recoleccion r){
        recolecciones.remove(r);
    }

    public void modificarTipo(Residuo antiguo,Residuo nuevo){
        if(tipos.remove(antiguo)) tipos.add(nuevo);
    }

    public PuntoDeRecoleccion agregarPunto(String direccion, float latitud, float longitud, String barrio, String nombre, HashMap<Residuo,Integer> residuo){
        if(getPuntoDeRecoleccion(direccion) == null){
            PuntoDeRecoleccion p = new PuntoDeRecoleccion(direccion, latitud, longitud, barrio, nombre,residuo);
            puntos.add(p);
            return p;
        }
        return null;
    }

    public void removerPunto(PuntoDeRecoleccion p){
        puntos.remove(p);
    }

    public void modificarPunto(PuntoDeRecoleccion antiguo,PuntoDeRecoleccion nuevo){
        if(puntos.remove(antiguo)) puntos.add(nuevo);
    }

    public void aceptarResiduo(PuntoDeRecoleccion p,Residuo r,int cant){
        p.aceptarResiduo(r,cant);
    }

    public void denegarResiduo(PuntoDeRecoleccion p, Residuo r){
        p.denegarResiduo(r);
    }

    public PuntoDeRecoleccion getPuntoDeRecoleccion(String direccion){
        for(PuntoDeRecoleccion p : puntos){
            if(p.tieneEsaDireccion(direccion)) return p;
        }
        return null;
    }

    public ArrayList<PuntoDeRecoleccion> obtenerPuntosPorBarrio(String barrio){
        ArrayList<PuntoDeRecoleccion> arr = new ArrayList<>();
        for(PuntoDeRecoleccion p : puntos){
            if(p.esDeEseBarrio(barrio)) arr.add(p);
        }
        return arr;
    }

    public ArrayList<PuntoDeRecoleccion> obtenerPuntosPorResiduo(Residuo r){
        ArrayList<PuntoDeRecoleccion> arr = new ArrayList<>();
        for(PuntoDeRecoleccion p : puntos){
            if(p.recibeDeEseTipo(r)) arr.add(p);
        }
        return arr;
    }

    public HashMap<Residuo,Integer> obtenerCantidadPuntosConResiduoPorBarrio(String barrio){
        HashMap<Residuo,Integer> map = new HashMap<>();
        for(Residuo r : tipos) map.put(r,0);
        for(PuntoDeRecoleccion p : obtenerPuntosPorBarrio(barrio)) p.llenarConResiduos(map);
        return map;
    }

    public void viajar(CamionDeBasura c, ArrayList<PuntoDeRecoleccion> camino, LocalDate f){
        if(camiones.contains(c) && !yaViajo(f,c)) recolecciones.add(new Recoleccion(f,c,c.viajar(camino)));
    }

    public boolean yaViajo(LocalDate f,CamionDeBasura c) {
        for (Recoleccion r : recolecciones) {
            if (r.esElMismoCamion(c) && r.esElMismoDia(f)) return true;
        }
        return false;
    }
}
