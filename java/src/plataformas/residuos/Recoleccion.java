package plataformas.residuos;

import transporte.Camion;

import java.time.LocalDate;

public class Recoleccion {
    private LocalDate fecha;
    private CamionDeBasura camion;
    private boolean exito;

    public Recoleccion(LocalDate fecha, CamionDeBasura camion, boolean exito) {
        this.fecha = fecha;
        this.camion = camion;
        this.exito = exito;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Camion getCamion() {
        return camion;
    }

    public void setCamion(CamionDeBasura camion) {
        this.camion = camion;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public boolean esElMismoDia(LocalDate date){
        return this.fecha.isEqual(date);
    }

    public boolean esElMismoCamion(CamionDeBasura c){
        return camion.equals(c);
    }
}
