package empresas.PoliEmpresa.llamada;

import personas.Empleado;

public class LlamadaInternacional extends Llamada {
    private String codigoPaisDestino;
    private FranjaHoraria franjaHoraria;
    private double costoPorMinuto;
    private double cargoInternacional;

    public LlamadaInternacional(Empleado origen, Empleado destino, int duracionMinutos) {
        super(origen, destino, duracionMinutos);
        this.codigoPaisDestino = destino.getCodigoPais();
        this.franjaHoraria = destino.getFranjaHoraria();
        this.costoPorMinuto = 50;
        this.cargoInternacional = 100;
    }

    public String getCodigoPaisDestino() {
        return codigoPaisDestino;
    }

    public FranjaHoraria getFranjaHoraria() {
        return franjaHoraria;
    }

    public double calcularCosto() {
        return cargoInternacional + getDuracionMinutos() * costoPorMinuto;
    }

    public boolean esInternacional() {
        return true;
    }

    public String obtenerDetalle() {
        return super.obtenerDetalle()
                + " | Codigo pais destino: " + codigoPaisDestino
                + " | Franja horaria destino: " + franjaHoraria.name()
                + " | Llamada internacional ";
    }
    public int obtenerMinutosAlExteriorDe(Empleado empleado) {
        if (fueRealizadaPor(empleado)) {
            return getDuracionMinutos();
        }

        return 0;
    }

}
