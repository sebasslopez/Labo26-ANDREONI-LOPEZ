package plataformas.residuos;

import utils.Posicion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PuntoDeRecoleccion {
    private String direccion;
    private Posicion posicion;
    private String barrio;
    private String nombre;
    private HashMap<Residuo,Integer> residuos;

    public PuntoDeRecoleccion(String direccion, float latitud, float longitud, String barrio, String nombre, HashMap<Residuo,Integer> residuos) {
        this.direccion = direccion;
        this.posicion = new Posicion(latitud,longitud);
        this.barrio = barrio;
        this.nombre = nombre;
        this.residuos = residuos;
    }

    public void aceptarResiduo(Residuo r,int cant){
        residuos.put(r,cant);
    }

    public void denegarResiduo(Residuo r){
        residuos.remove(r);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Posicion getPosicion(){
        return this.posicion;
    }

    public void setPosicion(Posicion posicion){
        this.posicion = posicion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<Residuo, Integer> getResiduos() {
        return residuos;
    }

    public void setResiduos(HashMap<Residuo, Integer> residuos) {
        this.residuos = residuos;
    }

    public boolean tieneEsaDireccion(String dir){
        return dir.equalsIgnoreCase(direccion);
    }

    public boolean recibeDeEseTipo(Residuo r){
        for(Residuo res : residuos.keySet()){
            if(res.esDelMismoTipo(r)) return true;
        }
        return false;
    }

    public boolean esDeEseBarrio(String barrio){
        return this.barrio.equalsIgnoreCase(barrio);
    }

    public void llenarConResiduos(HashMap<Residuo,Integer> map){
        for(Residuo r : residuos.keySet()) map.replace(r,map.get(r)+1);
    }

    public double calcularPesoDeResiduos(HashSet<Residuo> res){
        int peso = 0;
        for(Residuo r : res){
            peso += residuos.getOrDefault(r,0) * Residuo.peso;
        }
        return peso;
    }

    public void vaciar(HashSet<Residuo> res){
        for(Residuo r : res){
            residuos.replace(r,0);
        }
    }
}
