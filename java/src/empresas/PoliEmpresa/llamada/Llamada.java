package empresas.PoliEmpresa.llamada;

import personas.empleados.EmpleadoSinAsistencia;

import java.time.LocalDateTime;

public abstract class Llamada {
    private EmpleadoSinAsistencia origen;
    private EmpleadoSinAsistencia destino;
    private LocalDateTime fecha;
    private int duracionMinutos;

    public Llamada(EmpleadoSinAsistencia origen, EmpleadoSinAsistencia destino, int duracionMinutos) {
        this.origen = origen;
        this.destino = destino;
        this.duracionMinutos = duracionMinutos;
        this.fecha = LocalDateTime.now();
    }

    public EmpleadoSinAsistencia getOrigen() {
        return origen;
    }

    public EmpleadoSinAsistencia getDestino() {
        return destino;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public double calcularCosto() {
        return 0;
    }

    public boolean esInternacional() {
        return false;
    }

    public boolean fueRealizadaPor(EmpleadoSinAsistencia empleado) {
        return origen.tieneMismoDniQue(empleado.getDni());
    }

    public String obtenerDetalle() {

        return " | Origen: " + origen.getNombreCompleto()
                + " | Destino: " + destino.getNombreCompleto()
                + " | Fecha: " + fecha
                + " | Duracion: " + duracionMinutos + " minutos"
                + " | Costo: $" + calcularCosto();
    }

    public int obtenerMinutosAlExteriorDe(EmpleadoSinAsistencia empleado) {
        return 0;
    }
}
