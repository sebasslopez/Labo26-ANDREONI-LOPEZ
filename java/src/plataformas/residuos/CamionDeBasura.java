package plataformas.residuos;

import transporte.Camion;
import utils.Posicion;

import java.util.ArrayList;
import java.util.HashSet;

public class CamionDeBasura extends Camion {
    private HashSet<Residuo> residuosTransportar;
    static int autonomia = 45;

    public CamionDeBasura(String marca, String modelo, int patente, int capkg) {
        super(marca, modelo, patente, capkg);
    }

    public boolean viajar(ArrayList<PuntoDeRecoleccion> camino){
        if(viajeValido(camino)){
            vaciarPuntos(camino);
            return true;
        }
        return false;
    }

    private void vaciarPuntos(ArrayList<PuntoDeRecoleccion> camino){
        for(PuntoDeRecoleccion p : camino){
            p.vaciar(residuosTransportar);
        }
    }

    private boolean viajeValido(ArrayList<PuntoDeRecoleccion> camino){
        return distanciaValida(camino) && pesoValido(camino);
    }

    private double calcPeso(ArrayList<PuntoDeRecoleccion> camino){
        double peso = 0;
        for(PuntoDeRecoleccion p : camino){
            peso += p.calcularPesoDeResiduos(residuosTransportar);
        }
        return peso;
    }

    private boolean pesoValido(ArrayList<PuntoDeRecoleccion> camino){
        return calcPeso(camino) <= this.getCapkg();
    }


    private boolean distanciaValida(ArrayList<PuntoDeRecoleccion> camino){
        return calcDistancia(camino) < 45;
    }

    private double calcDistancia(ArrayList<PuntoDeRecoleccion> camino){
        double total = 0;
        for(int i = 0; i < camino.size()-1; i++){
            total += Posicion.calcularDistancia(camino.get(i).getPosicion(),camino.get(i+1).getPosicion());
        }
        return total;
    }
}
